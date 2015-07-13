package com.Piro;


import javax.swing.*;

public class Main {
private static JFrame frame;

    public static void main(String[] args) {

        Config.init();

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                frame = new JFrame("Forge Log Cleaner");
                frame.add(new Screen());
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
                LogCleanerLogger.init();
            }
        });
    }
    public static JFrame getFrame(){return frame;}
}
