package correction_text.swing.controller;

import correction_text.swing.model.TextModel;

import java.util.HashMap;
import java.util.Map;

public class TextController {
    public String getCorrectedText(String text) {
        TextModel textModel = new TextModel();
        Map<String, String> mapWords = textModel.initMap(new HashMap<>());
        return textModel.handleText(text, mapWords);
    }
}
