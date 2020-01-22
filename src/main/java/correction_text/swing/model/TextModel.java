package correction_text.swing.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TextModel {
    static String selectAll = "SELECT incorrect, correct FROM words WHERE id=?";

    public void createTable() {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS words (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, incorrect TEXT UNIQUE, correct TEXT );");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Map<String, String> getWords(Map<String, String> words) {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(selectAll)) {
            List<Integer> arrId = getId();

            for (Integer id : arrId) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    words.put(rs.getString("incorrect"), rs.getString("correct"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return words;
    }

    private List<Integer> getId() throws SQLException {
        Connection conn = getConnection();
        Statement stm = conn.createStatement();
        ResultSet resultSet = stm.executeQuery("SELECT id FROM words");
        List<Integer> arr = new ArrayList<>();

        while (resultSet.next()) {
            arr.add(resultSet.getInt(1));
        }
        return arr;
    }

    public String handleText(String text, Map<String, String> words) {
        getWords(words);
        for (Map.Entry<String, String> entry : words.entrySet()) {
            String incorrectWord = entry.getKey();
            String correctWord = entry.getValue();
            text = text.replaceAll(incorrectWord, correctWord);
        }
        return text;
    }

    public void addWord(String incorrect, String correct) {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            String putWord = "INSERT INTO words (incorrect, correct) VALUES ('" + incorrect + "', '" + correct + "');";
            stmt.executeUpdate(putWord);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteWord(String word) {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            String deleteWord = "DELETE FROM words WHERE incorrect = '" + word + "'";
            stmt.executeUpdate(deleteWord);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:corr.db");
    }
}
