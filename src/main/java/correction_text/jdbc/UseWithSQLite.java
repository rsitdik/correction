package correction_text.jdbc;

import java.sql.*;

public class UseWithSQLite {
    public static final String URL = "jdbc:sqlite:corr.db";
    static String sql = "select correct from words WHERE incorrect = ?";
    static String selectAll = "select incorrect, correct from words";

    public static void main(String[] args) {
        createTable();
        readFRomDB();

        String incorrect = "\'fne\'";
        String correct = "\'fine\'";
        addToDb(incorrect, correct);
    }

    private static void addToDb(String incorrect, String correct) {
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("INSERT INTO words (incorrect, correct) VALUES (" + incorrect + ", " + correct + ");");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void readFRomDB() {
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            String word = "fle";
            stmt.setString(1, word);
            ResultSet rs = stmt.executeQuery();
            System.out.println(rs.getString(1));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTable() {
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS words (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, incorrect TEXT UNIQUE, correct TEXT );");
//            stmt.executeUpdate("INSERT INTO words (incorrect, correct) VALUES ('fle', 'file');");
//            stmt.executeUpdate("INSERT INTO words (incorrect, correct) VALUES ('feld', 'field');");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
