package correction_text.jdbc;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CorrectionTextFile {
    static String url = "jdbc:postgresql://localhost:5432/correction";
    static String sql = "select incorrect, correct from correction_words WHERE id = ?";

    private static List<String> readFile(File source) throws SQLException {
        try (Connection conn = DriverManager.getConnection(url, "root", "root");
             Statement stm = conn.createStatement()) {
            List<String> incorrectWords = getIncorrectWordsFromDB();
            List<String> correctWords = getCorrectWordsFromDB();
            List<Integer> id = getId(stm);
            List<String> data = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
                String s;

                while ((s = reader.readLine()) != null) {
                    for (int i = 0; i < id.size(); i++) {
                        s = s.replace(incorrectWords.get(i), correctWords.get(i));
                    }
                    data.add(s);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return data;
        }
    }

    private static void writeFile(List<String> data, File destination) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
            for (String s : data) {
                writer.write(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)  {
        File source = new File("e:\\\\in.txt");
        File destination = new File("e:\\\\out.txt");
        List<String> data = null;
        try {
            data = readFile(source);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (data != null) {
            for (String record : data) {
                System.out.print(record);
            }
            writeFile(data, destination);
        }

    }

    private static List<String> getIncorrectWordsFromDB() throws SQLException {
        try (Connection conn = DriverManager.getConnection(url, "root", "root");
             PreparedStatement stmt = conn.prepareStatement(sql);
             Statement stm = conn.createStatement()) {
            List<Integer> arrId = getId(stm);
            List<String> incorrectWords = new ArrayList<>();

            for (Integer id : arrId) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    incorrectWords.add(rs.getString(1));
                }
            }
            return incorrectWords;
        }
    }

    private static List<String> getCorrectWordsFromDB() throws SQLException {
        try (Connection conn = DriverManager.getConnection(url, "root", "root");
             PreparedStatement stmt = conn.prepareStatement(sql);
             Statement stm = conn.createStatement()) {
            List<Integer> arr = getId(stm);
            List<String> correctWords = new ArrayList<>();

            for (Integer id : arr) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    correctWords.add(rs.getString(2));
                }
            }
            return correctWords;
        }
    }

    private static List<Integer> getId(Statement stm) throws SQLException {
        ResultSet resultSet = stm.executeQuery("select id from correction_words");
        List<Integer> arr = new ArrayList<>();

        while (resultSet.next()) {
            arr.add(resultSet.getInt(1));
        }
        return arr;
    }
}