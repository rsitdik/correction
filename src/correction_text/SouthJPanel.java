package correction_text;

import javax.swing.*;
import java.awt.*;

class SouthJPanel extends JPanel {
    JTextArea resultText;

    SouthJPanel(){
        resultText = new JTextArea(15, 44);
        resultText.setLineWrap(true); // вкл. перенос текста;
        resultText.setEditable(false);

        final JScrollPane southJScrollPane = new JScrollPane(resultText);
        add(southJScrollPane, BorderLayout.CENTER);
    }
}
