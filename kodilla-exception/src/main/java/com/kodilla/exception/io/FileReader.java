package com.kodilla.exception.io;

public class FileReader {
    private static FileReader ourInstance = new FileReader();

    public static FileReader getInstance() {
        return ourInstance;
    }

    private FileReader() {
    }
}
