package edu.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class CompositeTreeGenerator {
    public static Folder generate(Path path){
        Folder pf = new Folder(path);

        ArrayList<Path> files = new ArrayList<>();

        Folder result = new Folder(path);

        try(var fileTree = Files.walk(path)) {
            files = fileTree.collect(Collectors.toCollection(ArrayList::new));

            for(Path file : files){
                if(file.equals(path)){ continue; }
                if (Files.isDirectory(file)) {
                    result.addChild(CompositeTreeGenerator.generate(file));
                } else {
                    result.addChild(new File(file));
                }
            }

        return result;
    } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
