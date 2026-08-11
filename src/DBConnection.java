/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // Local development defaults; the password always comes from the environment.
    // Set TEAMAKER_DB_URL / TEAMAKER_DB_USER / TEAMAKER_DB_PASSWORD before running.
    private static final String URL = System.getenv().getOrDefault(
            "TEAMAKER_DB_URL",
            "jdbc:mysql://localhost:3306/teaMakerDB?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Europe/Istanbul");

    private static final String USER = System.getenv().getOrDefault("TEAMAKER_DB_USER", "root");

    private static final String PASSWORD = System.getenv().getOrDefault("TEAMAKER_DB_PASSWORD", "");

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
