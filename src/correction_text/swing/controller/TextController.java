package correction_text.swing.controller;

import correction_text.swing.model.TextModel;

import java.util.HashMap;
import java.util.Map;

public class TextController {
    private TextModel textModel;

    public TextController(TextModel textModel) {
        this.textModel = textModel;
    }

    public String getCorrectedText(String text) {
        Map<String, String> mapWords = textModel.initMap(new HashMap<>());
        return  textModel.handleText(text, mapWords);
    }
}
