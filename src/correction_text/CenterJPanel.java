package correction_text;

import javax.swing.*;
import java.awt.*;

class CenterJPanel extends JPanel {
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
            this.northJPanel.enterText.paste();
            this.southJPanel.resultText.setText(getCorrectedText());
        });

        copyButton.addActionListener(actionEvent -> {
            this.southJPanel.resultText.selectAll();
            this.southJPanel.resultText.copy();
        });

        clearButton.addActionListener(actionEvent -> {
            this.northJPanel.enterText.setText("");
            this.southJPanel.resultText.setText("");
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
        return northJPanel.enterText.getText()
                .replace("�", "\"")
                .replace("\n", " ")
                .replace(" <", "<")
                .replaceAll("don\"t", "don\'t")
                .replaceAll("specifc", "specific")
                .replaceAll("specifed", "specified")
                .replaceAll("Ta B le", "TABLE")
                .replaceAll("fle", "file")
                .replaceAll("f le", "file")
                .replaceAll("flter", "filter")
                .replaceAll("identifer", "identifier")
                .replaceAll("reltivize ", "relativize")
                .replaceAll("resol ", "resolve")
                .replaceAll("fnal", "final")
                .replaceAll("f rst", "first")
                .replaceAll("frst", "first")
                .replaceAll("f nding", "finding")
                .replaceAll("modifed", "modified")
                .replaceAll("modif ed", "modified")
                .replaceAll(" \\(", "(")
                .replaceAll(" \\\\ ", "\\\\")
                .replaceAll(" / ", "/")
                .replaceAll("j ava", "java")
                .replaceAll("ut i l", "util")
                .replaceAll("uti l", "util")
                .replaceAll("Condi t ion", "Condition")
                .replaceAll("ReadWri teLock", "ReadWriteLock")
                .replaceAll("Obj ect", "Object")
                .replaceAll("wai t", "wait")
                .replaceAll("awai t", "await")
                .replaceAll("not i fy", "notify");
    }
}
