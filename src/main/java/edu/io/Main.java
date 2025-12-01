package edu.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    static void main() {
        //String folder;
        //folder = IO.readln("Enter folder name:");
        Path path = Paths.get("C:\\emu8086");
        ReportGenerator.generate(path);
    }
}
