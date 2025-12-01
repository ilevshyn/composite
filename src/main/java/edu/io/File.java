package edu.io;

import java.nio.file.Path;

public class File implements FileSystemObject {
    private Path path;
    private String fileName;

    @Override
    public String getPath() {
        return path.toString();
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public File(Path path) {
        this.path = path;
    }
}
