package correction_text.swing.view;

import correction_text.swing.controller.TextController;

import javax.swing.*;
import java.awt.*;

public class NewWordFrame extends JFrame {

    public NewWordFrame(TextController textController) {
        super("Добавить слово");

        JPanel panelKey = new JPanel();
        JPanel panelValue = new JPanel();
        JTextField key = new JTextField(20);
        JTextField value = new JTextField(20);
        JLabel labelKey = new JLabel("Incorrect word:");
        JLabel labelValue = new JLabel("Correct word:   ");

        panelKey.add(labelKey);
        panelKey.add(key);
        panelValue.add(labelValue);
        panelValue.add(value);
        add(panelKey);
        add(panelValue);

        JButton addBtn = new JButton("Добавить");
        addBtn.setBackground(Color.WHITE);
        addBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addBtn.addActionListener(e -> {
            String keyWord = key.getText();
            String valueWord = value.getText();
            textController.addNewWord(keyWord, valueWord);

            System.out.println(keyWord + " : " + valueWord);
            dispose();
        });
        add(addBtn);

        setLayout(new GridLayout(3, 1));
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
