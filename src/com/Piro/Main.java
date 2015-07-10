package com.Piro;


import javax.swing.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Config.init();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                JFrame frame = new JFrame("Forge Log Cleaner");
                frame.add(new Screen());
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
