package correction_text.swing.model;

import java.util.Map;

public class TextModel {
    public Map<String, String> initMap(Map<String, String> mapWords) {
        mapWords.put("�", "\"");
        mapWords.put("\n", " ");
        mapWords.put(" <", "<");
        mapWords.put("specifc", "specific");
        mapWords.put("don\"t", "don't");
        mapWords.put("specifed", "specified");
        mapWords.put("Ta B le", "TABLE");
        mapWords.put("fle", "file");
        mapWords.put("f le", "file");
        mapWords.put("flter", "filter");
        mapWords.put("identifer", "identifier");
        mapWords.put("reltivize ", "relativize");
        mapWords.put("resol ", "resolve");
        mapWords.put("fnal", "final");
        mapWords.put("f rst", "first");
        mapWords.put("frst", "first");
        mapWords.put("f nding", "finding");
        mapWords.put("modifed", "modified");
        mapWords.put("modif ed", "modified");
        mapWords.put(" \\(", "(");
        mapWords.put(" \\\\ ", "\\\\");
        mapWords.put(" / ", "/");
        mapWords.put("j ava", "java");
        mapWords.put("ut i l", "util");
        mapWords.put("uti l", "util");
        mapWords.put("Condi t ion", "Condition");
        mapWords.put("ReadWri teLock", "ReadWriteLock");
        mapWords.put("Obj ect", "Object");
        mapWords.put("wai t", "wait");
        mapWords.put("awai t", "await");
        mapWords.put("not i fy", "notify");
        return mapWords;
    }

    public String handleText(String text, Map<String, String> mapWords) {
        for (Map.Entry<String, String> entry : mapWords.entrySet()) {
            text = text.replaceAll(entry.getKey(), entry.getValue());
        }
        return text;
    }
}
