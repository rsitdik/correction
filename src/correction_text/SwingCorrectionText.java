package correction_text;

import javax.swing.*;
import java.awt.*;

class SwingCorrectionText extends JFrame {

    SwingCorrectionText() {
        super("Correction text");
        NorthJPanel northJPanel = new NorthJPanel();
        SouthJPanel southJPanel = new SouthJPanel();
        CenterJPanel centerJPanel = new CenterJPanel(northJPanel, southJPanel);

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
}
