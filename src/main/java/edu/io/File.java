package edu.io;

import java.nio.file.Path;

public class File implements FileSystemObject {
    private Path path;

    @Override
    public String getPath() {
        return path.toString();
    }
}
