import java.io.Serializable;

public class Student implements Serializable {
    private final String MASINHVIEN;
    private String name;
    private String dob;
    private boolean gender;
    private String address;
    private String email;
    private double diemTrungBinh;

    public Student(String MASINHVIEN, String name, String dob, boolean gender, String address, String email, double diemTrungBinh) {
        this.MASINHVIEN = MASINHVIEN;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.diemTrungBinh = diemTrungBinh;
    }

    public String getMASINHVIEN() {
        return MASINHVIEN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int displayDob() {
        String[] arr = dob.split("/");
        return 2021 - Integer.parseInt(arr[2]);
    }

    public boolean getGender() {
        return gender;
    }

    public String displayGender() {
        if (gender) {
            return "Nam";
        } else {
            return "Nu";
        }
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getDiemTrungBinh() {
        return diemTrungBinh;
    }

    public void setDiemTrungBinh(double diemTrungBinh) {
        this.diemTrungBinh = diemTrungBinh;
    }

    @Override
    public String toString() {
        return "Student{" +
                "MASINHVIEN='" + MASINHVIEN + '\'' +
                ", name='" + name + '\'' +
                ", dob='" + displayDob() + '\'' +
                ", gender=" + displayGender() +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", diemTrungBinh=" + diemTrungBinh +
                '}';
    }
}
