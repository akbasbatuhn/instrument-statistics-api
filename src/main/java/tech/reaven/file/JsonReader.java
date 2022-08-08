package tech.reaven.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonReader {
    public String ReadJson() throws IOException {
        Path path = Paths.get("src/main/resources/stockInfo.json");
        Path absolutePath = path.toAbsolutePath();
        return Files.readString(absolutePath);
    }
}
