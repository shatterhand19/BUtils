package com.bozho.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Bozhidar Ganev on 04.12.17.
 */
public class IO {
    public static String readFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
    }

    public static byte[] readBytes(String filePath) throws IOException {
        return Files.readAllBytes(Paths.get(filePath));
    }

    public static void writeFile(String text, String filePath) throws IOException {
        Files.write(Paths.get(filePath), text.getBytes(StandardCharsets.UTF_8));
    }

    public static void writeBytes(byte[] bytes, String filePath) throws IOException {
        Files.write(Paths.get(filePath), bytes);
    }
}
