package correction_text.swing.view;

import correction_text.swing.controller.TextController;

import javax.swing.*;
import java.awt.*;

public class CenterJPanel extends JPanel {
    private JButton pasteButton;
    private JButton copyButton;
    private JButton clearButton;
    private JButton exitButton;
    private NorthJPanel northJPanel;
    private SouthJPanel southJPanel;

    void init(TextController textController) {
        pasteButton.addActionListener(actionEvent -> {
            this.northJPanel.getEnterText().paste();
            this.southJPanel.getResultText().setText(getCorrectedText(textController));
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

    public JButton getPasteButton() {
        return pasteButton;
    }

    public void setPasteButton(JButton pasteButton) {
        this.pasteButton = pasteButton;
    }

    public JButton getCopyButton() {
        return copyButton;
    }

    public void setCopyButton(JButton copyButton) {
        this.copyButton = copyButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public void setClearButton(JButton clearButton) {
        this.clearButton = clearButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public void setExitButton(JButton exitButton) {
        this.exitButton = exitButton;
    }

    public NorthJPanel getNorthJPanel() {
        return northJPanel;
    }

    public void setNorthJPanel(NorthJPanel northJPanel) {
        this.northJPanel = northJPanel;
    }

    public SouthJPanel getSouthJPanel() {
        return southJPanel;
    }

    public void setSouthJPanel(SouthJPanel southJPanel) {
        this.southJPanel = southJPanel;
    }

    private String getCorrectedText(TextController textController) {
        String text = northJPanel.getEnterText().getText();
        return textController.getCorrectedText(text);
    }
}
