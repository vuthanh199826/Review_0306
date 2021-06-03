import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    private final String MASINHVIEN_REGEX = "^[C][G]{1}[0-9]{4}[GHIK]{1}[0-9]{1}$";
    private final String NAMSINH_REGEX = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$";
    private final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    public Validate() {
    }

    public boolean validateMSV(String MASINHVIEN) {
        Pattern pattern = Pattern.compile(MASINHVIEN_REGEX);
        Matcher matcher = pattern.matcher(MASINHVIEN);
        return matcher.matches();
    }

    public boolean validateNamSinh(String dob) {
        Pattern pattern = Pattern.compile(NAMSINH_REGEX);
        Matcher matcher = pattern.matcher(dob);
        return matcher.matches();
    }

    public boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
