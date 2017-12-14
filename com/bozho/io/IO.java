package com.bozho.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Bozhidar Ganev on 04.12.17.
 *
 * This class provides wrappers around the standard Files methods for reading
 * and writing files. The purpose is to make the code shorter and clearer.
 */
public class IO {
    /**
     * Reads a file to String. The default charset is UTF8.
     *
     * @param filePath is the path to the file
     * @return the String representation of the data in the file
     * @throws IOException if the file does not exist
     */
    public static String readFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
    }

    /**
     * Reads a file to a byte array.
     *
     * @param filePath is the path to the file
     * @return a byte array with the bytes in the file
     * @throws IOException if the file does not exist
     */
    public static byte[] readBytes(String filePath) throws IOException {
        return Files.readAllBytes(Paths.get(filePath));
    }

    /**
     * Writes a String to a file.
     * This method will create the file if it does not exist.
     *
     * @param text is the text to be written in the file
     * @param filePath is the path to the file
     * @throws IOException if there is a problem writing to or creating the file.
     */
    public static void writeFile(String text, String filePath) throws IOException {
        Files.write(Paths.get(filePath), text.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Writes a byte array to a file.
     * This method will create the file if it does not exist.
     *
     * @param bytes is the byte array to be written in the file
     * @param filePath is the path to the file
     * @throws IOException if there is a problem writing to or creating the file.
     */
    public static void writeBytes(byte[] bytes, String filePath) throws IOException {
        Files.write(Paths.get(filePath), bytes);
    }
}
