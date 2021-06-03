import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Manage {
    private List<Student> students;

    public Manage() {
        students = new ArrayList<>();
    }

    public void add(Student student) throws IOException {
        students.add(student);
        writeToFileBin("test.dat", students);
        writeToFileCSV("test.csv", students);
    }

    public void delete(int index) throws IOException {
        students.remove(index);
        writeToFileBin("test.dat", students);
        writeToFileCSV("test.csv", students);
    }

    public int indexOfStudent(String MASINHVIEN) {
        for (Student student : students) {
            if (student.getMASINHVIEN().equals(MASINHVIEN)) {
                return students.indexOf(student);
            }
        }
        return -1;
    }

    public void display() throws IOException, ClassNotFoundException {
        System.out.println("FILE BIN");
        for (Student student : readFileBin("test.dat")) {
            System.out.println(student);
        }
        System.out.println("FILE CSV");
        for (Student student : readFileCSV("test.csv")) {
            System.out.println(student);
        }

    }

    public void edit(String MASINHVIEN, Student newStudent) throws IOException {
        for (Student student : students) {
            if (student.getMASINHVIEN().equals(MASINHVIEN)) {
                student.setName(newStudent.getName());
                student.setDob(newStudent.getDob());
                student.setGender(newStudent.getGender());
                student.setAddress(newStudent.getAddress());
                student.setEmail(newStudent.getEmail());
                student.setDiemTrungBinh(newStudent.getDiemTrungBinh());
            }
        }
        writeToFileCSV("test.csv", students);
        writeToFileBin("test.dat", students);
    }

    public void searchByMASINHVIEN(String MASINHVIEN) throws IOException, ClassNotFoundException {
        List<Student> list = new ArrayList<>();
        for (Student student : students) {
            if (student.getMASINHVIEN().equals(MASINHVIEN)) {
                list.add(student);
            }
        }
        writeToFileBin("searchBin.dat", list);
        if (readFileBin("searchBin.dat").size() != 0) {
            for (Student student : readFileBin("searchBin.dat")) {
                System.out.println(student);
            }
        } else {
            System.out.println("Invalid");
        }
    }

    public void searchByName(String name) throws IOException, ClassNotFoundException {
        List<Student> list = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().equals(name)) {
                list.add(student);
            }
        }
        writeToFileBin("searchBin.dat", list);
        if (readFileBin("searchBin.dat").size() != 0) {
            for (Student student : readFileBin("searchBin.dat")) {
                System.out.println(student);
            }
        } else {
            System.out.println("Invalid");
        }
    }

    public void sort(int choice) throws IOException {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                switch (choice) {
                    case 1:
                        return o1.getMASINHVIEN().compareTo(o2.getMASINHVIEN());
                    case 2:
                        return Double.compare(o2.getDiemTrungBinh(), o1.getDiemTrungBinh());
                    default:
                        return o1.getName().compareTo(o2.getName());
                }
            }
        });
        writeToFileBin("test.dat", students);
        writeToFileCSV("test.csv", students);
    }

    public void writeToFileBin(String path, List<Student> list) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(list);
        objectOutputStream.close();
        fileOutputStream.close();
    }

    public void writeToFileCSV(String path, List<Student> list) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (Student student : list) {
            bufferedWriter.write(student.getMASINHVIEN() + "," + student.getName() + "," + student.getDob() + "," + student.getGender() + "," + student.getAddress() + "," + student.getEmail() + "," + student.getDiemTrungBinh() + "\n");
        }
        bufferedWriter.close();
        fileWriter.close();
    }

    public List<Student> readFileBin(String path) throws IOException, ClassNotFoundException {
        List<Student> list = new ArrayList<>();
        FileInputStream fileInputStream = new FileInputStream(path);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        list = (List<Student>) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return list;
    }

    public List<Student> readFileCSV(String path) throws IOException {
        List<Student> list = new ArrayList<>();
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] arr = line.split(",");
            String msv = arr[0];
            String name = arr[1];
            String dob = arr[2];
            boolean gender = Boolean.parseBoolean(arr[3]);
            String address = arr[4];
            String email = arr[5];
            double diemTrungBinh = Double.parseDouble(arr[6]);
            list.add(new Student(msv, name, dob, gender, address, email, diemTrungBinh));
        }
        return list;
    }
}

