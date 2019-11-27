package correction_text.notswing;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CorrectionTextFile {
    private static List<String> readFile(File source) {
        List<String> data = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String s;
            while ((s = reader.readLine()) != null) {
                s = s.replace("�", "\"")
                        .replaceAll("don\"t", "don\'t")
                        .replaceAll("specifc", "specific")
                        .replaceAll("Ta B le", "TABLE")
                        .replaceAll("fle", "file")
                        .replaceAll("f le", "file");
                data.add(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
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

    public static void main(String[] args) {
        File source = new File("e:\\\\in.txt");
        File destination = new File("e:\\\\out.txt");
        List<String> data = readFile(source);
        for (String record : data) {
            System.out.print(record);
        }
        writeFile(data, destination);
    }
}

