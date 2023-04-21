import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CitibikeUtils {

    public static boolean isValidDateTime(String dateString) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            format.parse(dateString);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static boolean isValidLatitude(double latitude) {
        return latitude >= -90 && latitude <= 90;
    }

    public static boolean isValidLongitude(double longitude) {
        return longitude >= -180 && longitude <= 180;
    }
}
