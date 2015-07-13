package com.Piro;

import javax.swing.*;
import java.awt.*;

public class Screen extends JPanel{

    private static int typeLength = ReferenceStrings.LOGTYPES.length;
    private static JCheckBox[] checkBox=new JCheckBox[typeLength];
    private static JLabel name,author,version,info;
    private static JButton openButton,runButton;
    private static JFileChooser fileChooser;
    private static JPanel openPanel,topPanel,bottomPanel,checkboxPanel;
    private static JFrame frame;



    private static JTextArea log;


    public Screen(){
        super(new GridLayout(4,0));

        //logger copy
        log = new JTextArea(5,20);
        log.setMargin(new Insets(5,5,5,5));
        log.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(log);
        


        //Create instances for all variables
        fileChooser = new JFileChooser(ReferenceStrings.CURRENTPATH+"/logs");
        name=new JLabel(ReferenceStrings.NAME);
        author=new JLabel(ReferenceStrings.AUTHOR);
        version=new JLabel(ReferenceStrings.VERSION);
        info=new JLabel(ReferenceStrings.INFO);
        openButton= new JButton("...");
        runButton = new JButton("Convert");
        for (int i=0;i<typeLength;i++){
            if (!ReferenceStrings.LOGTYPES[i].contains("/")){
                checkBox[i]=new JCheckBox(ReferenceStrings.LOGTYPES[i]+"/",true);

            }else{
                checkBox[i]=new JCheckBox(ReferenceStrings.LOGTYPES[i],true);

            }
            checkBox[i].addItemListener(new EventHandler());
        }

        //set modifiers and action listeners
        fileChooser.setFileFilter(new LogFilter());
        fileChooser.setMultiSelectionEnabled(false);
        openButton.addActionListener(new EventHandler());
        runButton.addActionListener(new EventHandler());

        //layout
        //TODO fix layout crap
        topPanel = new JPanel(new GridLayout(4, 0));
        openPanel = new JPanel();
        bottomPanel = new JPanel();
        checkboxPanel = new JPanel(new GridLayout(typeLength<3?1:typeLength/3, 3));

        topPanel.add(name);
        topPanel.add(version);
        topPanel.add(author);
        openPanel.add(new JLabel("Choose file: "));
        openPanel.add(openButton);
        bottomPanel.add(runButton);
        bottomPanel.add(info);
        for (int i=0;i<typeLength;i++){
            checkboxPanel.add(checkBox[i]);
        }
        add(topPanel);
        add(openPanel);
        add(checkboxPanel);
        add(bottomPanel);
        add(logScrollPane,BorderLayout.PAGE_END);



    }


    public static JButton getOpenButton() {
        return openButton;
    }

    public static JButton getRunButton() {
        return runButton;
    }

    public static JCheckBox[] getCheckBox() {
        return checkBox;
    }

    public static JFileChooser getFileChooser() {
        return fileChooser;
    }

    public static JTextArea getLog() {
        return log;
    }
}
