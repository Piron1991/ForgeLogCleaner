package com.Piro;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class fileConversionHandler {

    private static ArrayList <String> processedList=new ArrayList<String>();


    public static void runConversion(File file) throws IOException{
    BufferedWriter bw = null;
        BufferedReader br=null;
        processCheckbox();
    String name = file.getName().substring(0,file.getName().indexOf(".log"))+"_converted.log";
        try{
            bw = new BufferedWriter(new FileWriter(new File(file.getAbsolutePath(),name)));
            br =new  BufferedReader(new FileReader(file));

        }
        catch(FileNotFoundException e){
            e.fillInStackTrace();
        }catch(Exception e){ e.fillInStackTrace();}


        //TODO stuff
    }

    public static void processCheckbox(){
        JCheckBox[] cb = screen.getCheckBox();

        for (JCheckBox c :cb) {
            if(c.getSelectedObjects()!=null){
                Object word = c.getSelectedObjects()[0];
                System.out.println(word);
                processedList.add(word.toString());
            }

        }


        //TODO stuff
    }
}
