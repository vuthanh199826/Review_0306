import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        Manage manage = new Manage();
        addData(manage);
        int option;
        while (true) {
            displayMENU();
            System.out.println("Nhap lua chon");
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    manage.add(inputStudent());
                    System.out.println("Success !!!");
                    break;
                case 2:
                    String MASINHVIEN = inputMSV();
                    if (manage.indexOfStudent(MASINHVIEN) != -1) {
                        manage.edit(MASINHVIEN, inputStudent());
                        System.out.println("Success !!!");
                    } else {
                        System.out.println("invalid");
                    }
                    break;
                case 3:
                    MASINHVIEN = inputMSV();
                    if (manage.indexOfStudent(MASINHVIEN) != -1) {
                        if (checkDelete()) {
                            manage.delete(manage.indexOfStudent(MASINHVIEN));
                            System.out.println("Success !!!");
                        }
                    } else {
                        System.out.println("Invalid");
                    }
                    break;
                case 4:
                    System.out.println("1. Sort by MASINHVIEN   2. Sort by diemTrungBinh");
                    int sortOption = sc.nextInt();
                    sc.nextLine();
                    manage.sort(sortOption);
                    manage.display();
                    break;
                case 5:
                    System.out.println("1. Tim kiem theo MSV   2. Tim kiem theo ten");
                    int choice = sc.nextInt();
                    sc.nextLine();
                    switch (choice) {
                        case 1:
                            MASINHVIEN = inputMSV();
                            manage.searchByMASINHVIEN(MASINHVIEN);
                            break;
                        case 2:
                            System.out.println("Nhap ten sinh vien");
                            String name = sc.nextLine();
                            manage.searchByName(name);
                            break;
                        default:
                            System.out.println("invalid");
                    }
                    break;
                case 6:
                    manage.display();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("invalid");
            }
        }


    }

    public static void displayMENU() {
        System.out.println("==================MENU==================");
        System.out.println("1.ADD");
        System.out.println("2.EDIT");
        System.out.println("3.DELETE");
        System.out.println("4.SORT");
        System.out.println("5.SEARCH");
        System.out.println("6.DISPLAY");
        System.out.println("0.EXIT");
        System.out.println("----------------------------------------");
    }

    public static void addData(Manage manage) throws IOException {
        manage.add(new Student("CG0004K1", "Hoang", "20/2/2000", true, "Nam Dinh", "hoang@.com", 8.3));
        manage.add(new Student("CG0002K2", "Thuy", "27/2/1997", false, "Thanh Hoa", "thuy@.com", 7.2));
        manage.add(new Student("CG0006H3", "Minh", "25/2/2003", true, "Ha Noi", "minh@.com", 9.3));
        manage.add(new Student("CG0001I1", "Mai", "21/2/1998", false, "Thai Binh", "mai@.com", 5.9));
        manage.add(new Student("CG0009G1", "Dung", "29/2/2001", true, "Hai Phong", "dung@.com", 8.3));
        manage.add(new Student("CG0009H1", "Dung", "29/2/2000", true, "Da Nang", "dung@.com", 8.3));
    }

    public static Student inputStudent() {
        Validate validate = new Validate();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap MA SINH VIEN (CG1234K1)");
        String MASINHVIEN = sc.nextLine();
        if (validate.validateMSV(MASINHVIEN)) {
            System.out.println("Nhap ten");
            String name = sc.nextLine();
            System.out.println("Nhap nam sinh");
            String dob = sc.nextLine();
            if (validate.validateNamSinh(dob)) {
                System.out.println("Chon gioi tinh ( Nam: true , Nu : false");
                boolean gender = sc.nextBoolean();
                sc.nextLine();
                System.out.println("Nhap dia chi");
                String address = sc.nextLine();
                System.out.println("Nhap email");
                String email = sc.nextLine();
                if (validate.validateEmail(email)) {
                    System.out.println("Nhap diem trung binh");
                    double diemTrungBinh = sc.nextDouble();
                    sc.nextLine();
                    return new Student(MASINHVIEN, name, dob, gender, address, email, diemTrungBinh);
                } else {
                    return inputStudent();
                }
            } else {
                return inputStudent();
            }
        } else {
            return inputStudent();
        }
    }

    public static boolean checkDelete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ban co muon xoa ???");
        System.out.println("1. Yes   2. No");
        int choice = sc.nextInt();
        return choice == 1;
    }

    public static String inputMSV() {
        Validate validate = new Validate();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap MA SINH VIEN vao day ");
        String MASINHVIEN = sc.nextLine();
        if (validate.validateMSV(MASINHVIEN)) {
            return MASINHVIEN;
        } else {
            return inputMSV();
        }
    }
}
