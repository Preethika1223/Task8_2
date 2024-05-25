package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcInsert {
	Connection connection=null;
    public static void main(String[] args) {
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "Preethika@1223");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employees (empcode, empname, empage, esalary) VALUES (?, ?, ?, ?)");

            // Employee data
            Object[][] employeeData = {
                {101, "Jenny", 30, 10000},
                {102, "Jacky", 20, 20000},
                {103, "Joe", 25, 40000},
                {104, "John", 40, 80000},
                {105, "Shameer", 25, 90000}
            };

            // Insert each employee record
            for (Object[] employee : employeeData) {
                preparedStatement.setInt(1, (Integer) employee[0]);
                preparedStatement.setString(2, (String) employee[1]);
                preparedStatement.setInt(3, (Integer) employee[2]);
                preparedStatement.setDouble(4, (Integer) employee[3]);
                preparedStatement.executeUpdate();
            }

            System.out.println("Employee data inserted successfully!");
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
