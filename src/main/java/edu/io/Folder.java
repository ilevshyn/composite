package edu.io;

import java.nio.file.Path;
import java.util.ArrayList;

public class Folder implements FileSystemObject {
    private Path path;
    private String folderName;
    private ArrayList<FileSystemObject> children;

    public Folder(Path path, String folderName) {
        this.path = path;
        this.folderName = folderName;
        this.children = new ArrayList<>();
    }

    public Folder(Path path) {
        this.path = path;
        this.children = new ArrayList<>();
    }

    public void addChild(FileSystemObject child){
        children.add(child);
    }

    public ArrayList<FileSystemObject> getChildren(){
        return children;
    }

    @Override
    public String getPath() {
        return path.toString();
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }
}
