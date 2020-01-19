package correction_text.swing.controller;

import correction_text.swing.model.TextModel;
import java.util.Map;

public class TextController {
    private TextModel textModel;
    Map<String, String> words;

    public TextController(TextModel textModel, Map<String, String> words) {
        this.textModel = textModel;
        this.words = words;
    }

    public String getCorrectedText(String text) {
        textModel.createTable();
        return  textModel.handleText(text, words);
    }

    public void addNewWord(String keyWord, String valueWord) {
        words.put(keyWord, valueWord);
    }
}
