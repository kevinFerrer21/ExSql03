import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement;

        try {
            String DB_URL = "jdbc:mysql://localhost:3306/newdb";
            String USER = "developer";
            String PASSWORD = "passwordhere";

            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            statement = connection.createStatement();

            List<String> surnamesStudent = new ArrayList<>();

            ResultSet resultSet = statement.executeQuery("SELECT first_name,last_name FROM newdb.student ");

            while (resultSet.next()) {

                String name = resultSet.getNString("first_name");
                String surname = resultSet.getNString("last_name");

                System.out.println(name);
                surnamesStudent.add(surname);

            }

            surnamesStudent.forEach(System.out::println);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

