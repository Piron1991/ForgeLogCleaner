package com.Piro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


public class EventHandler implements ActionListener,ItemListener {


    private JFileChooser fc = Screen.getFileChooser();


    private static File file,curDir;
    private static Path pFile,pCurDir;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Screen.getOpenButton()) {
            int returnVal = fc.showOpenDialog(fc);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                file = fc.getSelectedFile();
                curDir=fc.getCurrentDirectory();
                pFile=Paths.get(file.getPath());
                pCurDir=Paths.get(curDir.getPath());

                //TODO stuff
            }

        }
        if (e.getSource() == Screen.getRunButton()) {
            if (file!=null) {
                try {
                    FileConversionHandler.runConversion(pFile,pCurDir);
                } catch (IOException exc) {
                    LogCleanerLogger.addToLog(exc);
                }
            }else{
                LogCleanerLogger.ThrowMsgDialog("File was not choosen! Please select a file.");
                //TODO throw msg
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }

    public static File getFile() {
        return file;
    }

}
