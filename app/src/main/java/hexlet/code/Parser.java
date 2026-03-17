package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String content, String format) throws Exception {
        if (format.equals("json")) {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(content, new TypeReference<Map<String, Object>>() {

            });
        } else if (format.equals("yml") || format.equals("yaml")) {
            YAMLMapper mapper = new YAMLMapper();
            return mapper.readValue(content, new TypeReference<Map<String, Object>>() {
            });
        } else {
            throw new RuntimeException("Unsupported format: " + format + ". Supported formats: json, yaml, yml");
        }
    }
}
