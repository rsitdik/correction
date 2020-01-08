package correction_text.swing.view;

import correction_text.swing.controller.TextController;

import javax.swing.*;
import java.awt.*;

public class MainJFrame extends JFrame {

    public MainJFrame(TextController textController) {
        super("Correction Text");
        NorthJPanel northJPanel = new NorthJPanel(new JTextArea(15, 44));
        SouthJPanel southJPanel = new SouthJPanel(new JTextArea(15, 44));
        CenterJPanel centerJPanel = new CenterJPanel();
        centerJPanel.setNorthJPanel(northJPanel);
        centerJPanel.setSouthJPanel(southJPanel);
        centerJPanel.setPasteButton(new JButton("Paste"));
        centerJPanel.setCopyButton(new JButton("Copy"));
        centerJPanel.setClearButton(new JButton("Clear"));
        centerJPanel.setExitButton(new JButton("Exit"));
        centerJPanel.init(textController);

        add(northJPanel, BorderLayout.NORTH);
        add(centerJPanel, BorderLayout.CENTER);
        add(southJPanel, BorderLayout.SOUTH);

        setSize(500, 580);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
