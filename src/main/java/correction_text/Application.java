package correction_text;

import correction_text.swing.controller.TextController;
import correction_text.swing.model.TextModel;
import correction_text.swing.view.MainJFrame;

import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainJFrame(new TextController(new TextModel())));
    }
}