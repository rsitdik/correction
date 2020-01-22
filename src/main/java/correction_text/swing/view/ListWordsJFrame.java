package correction_text.swing.view;

import correction_text.swing.controller.TextController;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ListWordsJFrame extends JFrame {

    public ListWordsJFrame(TextController textController) {
        super();

        JPanel jPanel = new JPanel();
        Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 18);

        Map<String, String> map = textController.getMapWords();
        AtomicInteger count = new AtomicInteger();

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            JButton jButton = new JButton();
            jButton.setText(key + " : " + value);
            count.getAndIncrement();
            jButton.setBackground(Color.WHITE);
            jButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            jButton.setFont(font);
            jButton.setToolTipText("Click for delete.");
            jButton.addActionListener((e) -> {
                textController.deleteWord(key);
                map.remove(key);
                jPanel.remove(jButton);
                count.getAndDecrement();
            });
            jPanel.setLayout(new GridLayout(0, 1));
            jPanel.add(jButton);
        }

        JScrollPane scrollPane = new JScrollPane(jPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane);
        setPreferredSize(new Dimension(350, 550));
        setTitle("Всего слов: " + count);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
