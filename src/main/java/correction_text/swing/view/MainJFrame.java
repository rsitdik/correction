package correction_text.swing.view;

import correction_text.swing.controller.TextController;
import correction_text.swing.view.CenterJPanel;

import javax.swing.*;
import java.awt.*;

public class MainJFrame extends JFrame {

    public MainJFrame(TextController textController) {
        super("Correction Text");

        //-------Menu-----------------------
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        file.setCursor(getHandCursor());
        JMenu about = new JMenu("About");
        about.setCursor(getHandCursor());
        JMenuItem addWord = new JMenuItem("Add new word");
        JMenuItem allWords = new JMenuItem("List all words");
        addWord.setCursor(getHandCursor());
        addWord.addActionListener((e -> {
            new correction_text.swing.view.NewWordFrame(textController);
        }));
        JMenuItem exit = new JMenuItem("Exit");
        exit.setCursor(getHandCursor());
        exit.addActionListener(e -> { System.exit(0); });
        file.add(addWord);
        file.add(allWords);
        file.addSeparator();
        file.add(exit);
        menuBar.add(file);
        menuBar.add(about);
        setJMenuBar(menuBar);
        //-----------------------------------

        correction_text.swing.view.NorthJPanel northJPanel = new correction_text.swing.view.NorthJPanel(new JTextArea(15, 44));
        correction_text.swing.view.SouthJPanel southJPanel = new correction_text.swing.view.SouthJPanel(new JTextArea(15, 44));
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

    private Cursor getHandCursor() {
        return Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
    }
}
