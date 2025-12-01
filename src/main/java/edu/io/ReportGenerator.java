package edu.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ReportGenerator {
    public static void generate(Path path){
        ArrayList<Path> files;
        int len = path.toString().length();
        int subdirectories = -1;
        int numOfFiles = 0;
        int subLevel = 0;
        String ind = "    ";
        Path tmppath;
        var parent = path;
        try(var fileTree = Files.walk(path)) {
            files = fileTree.collect(Collectors.toCollection(ArrayList::new));
//          files.forEach(System.out::println);

            for (var file : files) {
                if (Files.isDirectory(file)) {
                    subdirectories++;
                } else if (Files.isRegularFile(file)) {
                    numOfFiles++;
                }
            }

            IO.println("# General info:");
            IO.println("-path: " + path.toString());
            IO.println("-subdirectory count: " + subdirectories);
            IO.println("-total file count: " + numOfFiles);

            IO.println("-----------------------------------");
            for(var file : files){
                if(file.getParent().equals(path)){
                    IO.println(file.toString());
                } else {
                    if (Files.isDirectory(file)) {
                        for (int i = 0; i < subLevel; i++) {
                            IO.print(ind);
                        }
                        parent = parent.resolve(file);
                        System.out.println(parent.toString());
                        subLevel++;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
