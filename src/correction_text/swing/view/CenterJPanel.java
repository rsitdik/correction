package correction_text.swing.view;

import correction_text.swing.controller.TextController;

import javax.swing.*;
import java.awt.*;

public class CenterJPanel extends JPanel {
    private NorthJPanel northJPanel;
    private SouthJPanel southJPanel;

    CenterJPanel(NorthJPanel northJPanel, SouthJPanel southJPanel) {
        this.northJPanel = northJPanel;
        this.southJPanel = southJPanel;
        JButton pasteButton = new JButton("Paste");
        JButton copyButton = new JButton("Copy");
        JButton clearButton = new JButton("Clear");
        JButton exitButton = new JButton("Exit");

        pasteButton.addActionListener(actionEvent -> {
            this.northJPanel.getEnterText().paste();
            this.southJPanel.getResultText().setText(getCorrectedText());
        });

        copyButton.addActionListener(actionEvent -> {
            this.southJPanel.getResultText().selectAll();
            this.southJPanel.getResultText().copy();
        });

        clearButton.addActionListener(actionEvent -> {
            this.northJPanel.getEnterText().setText("");
            this.southJPanel.getResultText().setText("");
        });

        exitButton.addActionListener(actionEvent -> System.exit(0));
        JLabel enterLabel = new JLabel();
        enterLabel.setLayout(new BoxLayout(enterLabel, BoxLayout.Y_AXIS));

        setLayout(new GridLayout(1, 4));
        add(pasteButton);
        add(copyButton);
        add(clearButton);
        add(exitButton);
    }

    private String getCorrectedText() {
        TextController controller = new TextController();
        String text = northJPanel.getEnterText().getText();
        return controller.getCorrectedText(text);
    }
}
