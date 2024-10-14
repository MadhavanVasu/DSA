package IQns;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DirectoryTree {

    public static void main(String[] args) {
        Path path = Paths.get("C:\\Maddy\\Client Project\\Verizon\\Easy-Peasy-Builder\\main\\Stride-HTML-Bootstrap-Template-main"); // Change this to your folder path
        try {
            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                private final Deque<String> indentation = new ArrayDeque<>();

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    printIndented(dir, false);
                    indentation.push("│   ");
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    printIndented(file, true);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    indentation.pop();
                    return FileVisitResult.CONTINUE;
                }

                private void printIndented(Path path, boolean isFile) {
                    StringBuilder indents = new StringBuilder();
                    for (String indent : indentation) {
                        indents.append(indent);
                    }
                    if (isFile) {
                        indents.append("├── ");
                    } else {
                        indents.append("└── ");
                    }
                    System.out.println(indents.toString() + path.getFileName().toString());
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

