package com.Piro;

import javax.swing.*;
import java.util.logging.*;

public class LogCleanerLogger {

    private static JFrame mainFrame = Main.getFrame();

    private static final Logger MYLOGGER = Logger.getLogger(LogCleanerLogger.class.getName());
    private static Handler fhandler;
    private static JTextAreaLoggerHandler shandler;
    //TODO implement logger capabilities in config.java and mylogger.java

   public static void init(){
       try {
           fhandler=Config.getHandler();
           shandler = new JTextAreaLoggerHandler();
           shandler.setTextArea(Screen.getLog());
           MYLOGGER.addHandler(fhandler);
           MYLOGGER.addHandler(shandler);
       }catch(Exception e){
           e.printStackTrace();
       }
       }

    public static <T> void addToLog(T t){
        MYLOGGER.log(Level.SEVERE, t.toString(),t);

    }

    public static void ThrowMsgDialog(String s){
        JOptionPane.showMessageDialog(mainFrame,s);
    }

}
