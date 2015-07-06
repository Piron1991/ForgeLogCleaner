package com.Piro;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public  class Config {

    static Path outDir,configFile,inDir,logFile;

    static BufferedWriter logWriter;

    public static BufferedWriter getLogWriter() {
        return logWriter;
    }

    public static Path getOutDir() {
        return outDir;
    }

    public static Path getConfigFile() {
        return configFile;
    }

    public static Path getInDir() {
        return inDir;
    }

    public static Path getLogFile() {
        return logFile;
    }



    public static void init(){

        try{
            inDir =Paths.get(ReferenceStrings.CURRENTPATH+File.separator+"logs");
            outDir = Paths.get(ReferenceStrings.CURRENTPATH+File.separator+"output");
            configFile = Paths.get(ReferenceStrings.CURRENTPATH + File.separator + "config.cfg");
            logFile = Paths.get(ReferenceStrings.CURRENTPATH+ File.separator+"Control Log.log");
           if (!Files.exists(inDir)) {
               Files.createDirectory(inDir);
           }
            if (!Files.exists(outDir)) {
                Files.createDirectory(outDir);
            }
            if (!Files.exists(configFile)) {
                Files.createFile(configFile);
            }
            if (!Files.exists(logFile)) {
                Files.createFile(logFile);
                logWriter=Files.newBufferedWriter(logFile,StandardOpenOption.APPEND,StandardOpenOption.WRITE);
            }


        }
        catch (IOException e){e.printStackTrace();}

    }

}
