package correction_text.swing.view;

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

    public JTextArea getResultText() {
        return resultText;
    }

    public void setResultText(JTextArea resultText) {
        this.resultText = resultText;
    }
}
