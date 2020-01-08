package correction_text.swing.controller;

import correction_text.swing.model.TextModel;

import java.util.HashMap;
import java.util.Map;

public class TextController {
    public String getCorrectedText(String text) {
        TextModel textModel = new TextModel();
        textModel.initMap(new HashMap<>());
        Map<String, String> mapWords = textModel.getMapWords();

        return textModel.handleText(text, mapWords);
    }
}
