package com.Piro;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class LogFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return false;
        }
        for (String s: ReferenceStrings.FMLLOGFILES) {
            if (f.getName().equals(s)) return true;
        }
        return false;
    }

    @Override
    public String getDescription() {
        return "Forge log files";
    }


}
