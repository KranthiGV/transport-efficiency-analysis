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

    public static long calculateRideDurationInSeconds(String startedAt, String endedAt) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate = sdf.parse(startedAt);
        Date endDate = sdf.parse(endedAt);

        // Convert milliseconds to seconds
        return (endDate.getTime() - startDate.getTime()) / 1000;
    }

    public static double calculateDistance(double startLat, double startLng, double endLat, double endLng) {
        // Using the Haversine formula for calculating the great-circle distance between two points on a sphere
        // Earth's radius in km
        final int R = 6371;

        double latDistance = Math.toRadians(endLat - startLat);
        double lngDistance = Math.toRadians(endLng - startLng);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(startLat)) * Math.cos(Math.toRadians(endLat))
                * Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Distance in km
        return R * c;
    }
}
