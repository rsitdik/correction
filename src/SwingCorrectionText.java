import javax.swing.*;
import java.awt.*;

class SwingCorrectionText extends JFrame {
    public static final int COLUMNS = 45;
    private JTextArea enterText;
    private JTextArea resultText;

    SwingCorrectionText() {
        super("Correction text");
        JPanel jPanel = new JPanel();
        JPanel jPanel_center = new JPanel();
        JPanel jPanel_south = new JPanel();

        enterText = new JTextArea(15, 44);
        enterText.setLineWrap(true); // вкл. перенос текста
        setLayout(new BorderLayout());

        JLabel enterLabel = new JLabel();
        JScrollPane aScroller = new JScrollPane(enterLabel);

        JButton pasteButton = new JButton("Paste");
        JButton copyButton = new JButton("Copy");
        JButton clearButton = new JButton("Clear");
        JButton exitButton = new JButton("Exit");

        resultText = new JTextArea(15, 44);
        resultText.setLineWrap(true); // вкл. перенос текста;
        resultText.setEditable(false);

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
        enterLabel.setLayout(new BoxLayout(enterLabel, BoxLayout.Y_AXIS));

        jPanel_center.setLayout(new GridLayout(1, 4));
        jPanel_center.add(pasteButton);
        jPanel_center.add(copyButton);
        jPanel_center.add(clearButton);
        jPanel_center.add(exitButton);
        add(jPanel_center, BorderLayout.CENTER);

        jPanel.add(enterLabel);
        jPanel.add(enterText, BorderLayout.NORTH);
        jPanel.add(aScroller);
        jPanel_south.add(resultText, BorderLayout.SOUTH);
        add(jPanel, BorderLayout.NORTH);

        getContentPane().add(BorderLayout.NORTH, jPanel);
        getContentPane().add(BorderLayout.CENTER, jPanel_center);
        getContentPane().add(BorderLayout.SOUTH, jPanel_south);
        setSize(500, 580);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private String outText() {
        return enterText.getText().replace("�", "\"")
                .replace("\n", " ")
                .replaceAll("don\"t", "don\'t")
                .replaceAll("specifc", "specific")
                .replaceAll("Ta B le", "TABLE")
                .replaceAll("fle", "file")
                .replaceAll("f le", "file")
                .replaceAll("identifer", "identifier")
                .replaceAll("reltivize ", "relativize")
                .replaceAll("resol ", "resolve")
                .replaceAll("fnal", "final")
                .replaceAll("modifed", "modified")
                .replaceAll(" \\(", "(")
                .replaceAll(" \\\\ ", "\\\\");
    }
}
