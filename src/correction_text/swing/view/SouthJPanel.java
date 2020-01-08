package correction_text.swing.view;

import javax.swing.*;
import java.awt.*;

public class SouthJPanel extends JPanel {
    JTextArea resultText;

    public SouthJPanel(JTextArea resultText) {
        this.resultText = resultText;
        resultText.setLineWrap(true); // вкл. перенос текста;
        resultText.setEditable(false);

        final JScrollPane southJScrollPane = new JScrollPane(resultText);
        add(southJScrollPane, BorderLayout.CENTER);
    }

    public JTextArea getResultText() {
        return resultText;
    }
}
