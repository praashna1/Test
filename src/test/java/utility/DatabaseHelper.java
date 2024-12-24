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
        String query = "SELECT otp FROM users WHERE email = ? ORDER BY created_at DESC LIMIT 1"; //returns single data from resultset fetch recent otp

        try (Connection connection = DriverManager.getConnection(url,user,password); //connection
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();  //execute query
            if (resultSet.next()) {
                otp = resultSet.getString("otp");  //fetching
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return otp;
    }
}
