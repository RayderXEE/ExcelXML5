package com.example.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Configer {

    String config;

    public Configer(String path) throws IOException {
        config = new String ( Files.readAllBytes( Paths.get(path) ) );
    }

    String getParam(String paramName) {
        int pos = config.indexOf(paramName);
        int pos2 = config.indexOf(";", pos);
        String value = config.substring(pos, pos2).split(" ")[1];
        return value;
    }

}
