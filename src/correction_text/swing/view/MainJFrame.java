package correction_text.swing.view;

import javax.swing.*;
import java.awt.*;

public class MainJFrame extends JFrame {

    public MainJFrame() {
        super("Correction Text");
        NorthJPanel northJPanel = new NorthJPanel();
        SouthJPanel southJPanel = new SouthJPanel();
        CenterJPanel centerJPanel = new CenterJPanel(northJPanel, southJPanel);

        add(northJPanel, BorderLayout.NORTH);
        add(southJPanel, BorderLayout.SOUTH);
        add(centerJPanel, BorderLayout.CENTER);

        setSize(500, 580);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
