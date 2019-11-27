package correction_text;

import javax.swing.*;
import java.awt.*;

class NorthJPanel extends JPanel {
    JTextArea enterText;

    NorthJPanel() {
        enterText = new JTextArea(15, 44);
        enterText.setLineWrap(true); // вкл. перенос текста
        JScrollPane northJScrollPane = new JScrollPane(enterText);
        add(northJScrollPane, BorderLayout.CENTER);
    }

}
