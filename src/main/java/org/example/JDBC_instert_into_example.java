package org.example;

import java.sql.*;

public class JDBC_instert_into_example {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");
            if(connection == null) {
                System.out.println("Brak połączenia z bazą danych.");
            } else {
                System.out.println("Jest połączenie.");
            }

            statement = connection.createStatement();
            String sqlInsert = "INSERT INTO emplyees (name, adress, salary) VALUES ('Rafał', 'Bydgoszcz', 10000), "
                    + "('Ola', 'Wrocław', 10000)";
            statement.executeUpdate(sqlInsert);

            String sqlSelect = "SELECT * FROM emplyees";

            resultSet = statement.executeQuery(sqlSelect);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String adress = resultSet.getString("adress");
                int salary = resultSet.getInt("salary");
                System.out.println("id: " + id + " name: " + name + " adress: " + adress + " salary: " + salary);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}