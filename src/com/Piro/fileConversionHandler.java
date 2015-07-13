package com.Piro;

import javax.swing.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileConversionHandler {

    private static ArrayList <String> processedList=new ArrayList<String>();


    public static void runConversion(Path file, Path directory) throws IOException{
        BufferedWriter bw;
        BufferedReader br;
        processCheckbox();
        Path convertedFile=Paths.get(Config.outDir.toString());
        String name = (file.toString().substring(file.toString().lastIndexOf(File.separatorChar),file.toString().indexOf(".log")))+"-converted.log";
        Path f=Paths.get(convertedFile + name);
        try{
            Files.deleteIfExists(f);
            f = Files.createFile(f);

            br  = Files.newBufferedReader(file);
            bw = Files.newBufferedWriter(f, StandardOpenOption.DSYNC,StandardOpenOption.WRITE);

            boolean finish=true;
            while(finish) {
                String tempLine = br.readLine();
                if (CheckStringValid(tempLine)) {
                    //System.out.println(tempLine);
                    bw.write(tempLine);
                    bw.newLine();
                }
            if (tempLine==null) finish=false;
            }

            bw.flush();
            bw.close();
        }
        catch(Exception exc){
            LogCleanerLogger.addToLog(exc);
        }
        //TODO stuff

    }

    public static void processCheckbox(){
        JCheckBox[] cb = Screen.getCheckBox();

        for (JCheckBox c :cb) {
            if(c.getSelectedObjects()!=null){
                Object word = c.getSelectedObjects()[0];
                //System.out.println(word)
                processedList.add(word.toString());
            }

        }


        //TODO stuff
    }


    private static boolean CheckStringValid(String s) {
        if (s != null) {
            for (String iter : processedList) {
                if (s.contains(iter)) {
                    //return false;
                   return !s.contains(iter);
                }else if(s.equals("")){
                    return false;

                }
            }
        }

    return s!=null;
    }


}
