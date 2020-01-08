package correction_text.swing.view;

import javax.swing.*;
import java.awt.*;

public class NorthJPanel extends JPanel {
    JTextArea enterText;

    public NorthJPanel(JTextArea enterText) {
        this.enterText = enterText;
        enterText.setLineWrap(true); // вкл. перенос текста
        JScrollPane northJScrollPane = new JScrollPane(enterText);
        add(northJScrollPane, BorderLayout.CENTER);
    }

    public JTextArea getEnterText() {
        return enterText;
    }
}
