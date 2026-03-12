package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String filePath) throws Exception {
        String content = Files.readString(Paths.get(filePath).toAbsolutePath().normalize());

        if (filePath.endsWith(".json")) {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(content, Map.class);
        } else if (filePath.endsWith(".yml") || filePath.endsWith(".yaml")) {
            YAMLMapper mapper = new YAMLMapper();
            return mapper.readValue(content, Map.class);
        } else {
            throw new Exception("Unsupported file format: " + filePath);
        }
    }
}
