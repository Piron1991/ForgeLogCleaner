package com.Piro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;


public class eventHandler implements ActionListener,ItemListener {


    private JFileChooser fc = screen.getFileChooser();


    private static File file;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == screen.getOpenButton()) {
            int returnVal = fc.showOpenDialog(fc);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                file = fc.getSelectedFile();
                //TODO stuff
                System.out.println(file.getName());
            }

        }
        if (e.getSource() == screen.getRunButton()) {
            if (file!=null) {
                try {
                    fileConversionHandler.runConversion(file);
                } catch (IOException exc) {
                    exc.fillInStackTrace();
                }
            }else{
                //TODO throw msg
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
       /* JCheckBox[] cb = screen.getCheckBox();

        Object source =e.getSource();
          //  System.out.print(e.getStateChange()+"\n");
        System.out.println(cb[1].getSelectedObjects()[0]);
        if (source == cb) {//TODO clean this

        }*/
    }

    public static File getFile() {
        return file;
    }

}
