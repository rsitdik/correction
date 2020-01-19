package correction_text.swing.controller;

import correction_text.swing.model.TextModel;

import java.util.HashMap;
import java.util.Map;

public class TextController {
    private TextModel textModel;
    Map<String, String> mapWords = new HashMap<>();

    public TextController(TextModel textModel) {
        this.textModel = textModel;
        textModel.createTable();
    }

    public String getCorrectedText(String text) {
        return  textModel.handleText(text, mapWords);
    }

    public void addNewWord(String keyWord, String valueWord) {
        mapWords.put(keyWord, valueWord);
    }
}
