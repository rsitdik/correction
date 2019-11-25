import javax.swing.*;
import java.awt.*;

class SwingCorrectionText extends JFrame {
    public static final int COLUMNS = 45;
    private JTextArea enterText;
    private JTextArea resultText;

    SwingCorrectionText() {
        super("Correction text");
        JPanel northJPanel = new JPanel();

        enterText = new JTextArea(15, 44);
        enterText.setLineWrap(true); // вкл. перенос текста

        final JScrollPane northJScrollPane = new JScrollPane(enterText);
        northJPanel.add(northJScrollPane, BorderLayout.CENTER);

        resultText = new JTextArea(15, 44);
        resultText.setLineWrap(true); // вкл. перенос текста;
        resultText.setEditable(false);

        JPanel southJPanel = new JPanel();
        final JScrollPane southJScrollPane = new JScrollPane(resultText);
        southJPanel.add(southJScrollPane, BorderLayout.CENTER);

        JButton pasteButton = new JButton("Paste");
        JButton copyButton = new JButton("Copy");
        JButton clearButton = new JButton("Clear");
        JButton exitButton = new JButton("Exit");

        pasteButton.addActionListener(actionEvent -> {
            enterText.paste();
            resultText.setText(outText());
        });

        copyButton.addActionListener(actionEvent -> {
            resultText.selectAll();
            resultText.copy();
        });

        clearButton.addActionListener(actionEvent -> {
            enterText.setText("");
            resultText.setText("");
        });

        exitButton.addActionListener(actionEvent -> System.exit(0));
        JLabel enterLabel = new JLabel();
        enterLabel.setLayout(new BoxLayout(enterLabel, BoxLayout.Y_AXIS));

        JPanel centerJPanel = new JPanel();
        centerJPanel.setLayout(new GridLayout(1, 4));
        centerJPanel.add(pasteButton);
        centerJPanel.add(copyButton);
        centerJPanel.add(clearButton);
        centerJPanel.add(exitButton);
        add(centerJPanel, BorderLayout.CENTER);

        getContentPane().add(BorderLayout.NORTH, northJPanel);
        getContentPane().add(BorderLayout.CENTER, centerJPanel);
        getContentPane().add(BorderLayout.SOUTH, southJPanel);

        setSize(500, 580);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private String outText() {
        return enterText.getText()
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
                .replaceAll(" / ", "/");
    }
}
