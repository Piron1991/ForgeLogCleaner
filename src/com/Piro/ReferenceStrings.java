package com.Piro;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ReferenceStrings {

    static final String NAME="Forge Log Cleaner";
    static final String AUTHOR="Piro";
    static final String VERSION="1.0";
    static final String INFO="some info";
    static final Path CURRENTPATH = Paths.get("").toAbsolutePath();


    static final String[] FMLLOGFILES = {"fml-client-1.log","fml-client-2.log","fml-client-3.log","fml-client-latest.log","fml-server-1.log","fml-server-3.log","fml-server-latest.log","fml-server-2.log"};
    static final String[] LOGTYPES={"FML","FORGE","FastCraft-core/","AE2-CORE/appliedenergistics2","TEST3","TEST4","TEST5","TEST6","TEST7","TEST8"};
}
