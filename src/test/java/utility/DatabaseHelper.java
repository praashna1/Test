package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseHelper {
    private static final String url = "jdbc:postgresql://localhost:5432/SamasyaSewa";
    private static final String user = "postgres";
    private static final String password = "postgres";

    public static String fetch(String email) {
        String otp = null;
        String query = "SELECT otp FROM users WHERE email = ? ORDER BY created_at DESC LIMIT 1"; //recent otp
        String updateQuery = "UPDATE users SET is_verified = true WHERE email = ?"; //mark true

        try (Connection connection = DriverManager.getConnection(url, user, password); //making connection
             PreparedStatement fetchStatement = connection.prepareStatement(query);
             PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {

            fetchStatement.setString(1, email); //fetch otp
            ResultSet resultSet = fetchStatement.executeQuery();
            if (resultSet.next()) {
                otp = resultSet.getString("otp");
            }

            if (otp != null) {
                updateStatement.setString(1, email);
                updateStatement.executeUpdate(); // Perform update
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return otp;
    }
}
