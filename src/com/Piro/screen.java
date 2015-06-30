package com.Piro;

import javax.jnlp.FileContents;
import javax.jnlp.FileOpenService;
import javax.jnlp.ServiceManager;
import javax.jnlp.UnavailableServiceException;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class screen extends JPanel{

    private static int typeLength = reference.LOGTYPES.length;
    private static JCheckBox[] checkBox=new JCheckBox[typeLength];
    private static JLabel name,author,version,info;
    private static JButton openButton,runButton;
    private static JFileChooser fileChooser;
    private static JPanel openPanel,topPanel,bottomPanel,checkboxPanel;
    private static JFrame frame;


    public screen(){
        super(new GridLayout(4,0));

        //Create instances for all variables
        fileChooser = new JFileChooser();
        name=new JLabel(reference.NAME);
        author=new JLabel(reference.AUTHOR);
        version=new JLabel(reference.VERSION);
        info=new JLabel(reference.INFO);
        openButton= new JButton("...");
        runButton = new JButton("Convert");
        for (int i=0;i<typeLength;i++){
            checkBox[i]=new JCheckBox(reference.LOGTYPES[i],true);
            checkBox[i].addItemListener(new eventHandler());
        }

        fileChooser.setFileFilter(new logFilter());
        fileChooser.setMultiSelectionEnabled(false);
        openButton.addActionListener(new eventHandler());
        runButton.addActionListener(new eventHandler());

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
    }

    public static void setupGUI(){
        frame = new JFrame("Forge Log Cleaner");
        //Add content to the window.
        frame.add(new screen());


        //Display the window.
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
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
}
