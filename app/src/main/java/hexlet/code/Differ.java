package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Differ {

    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        String content1 = Files.readString(Paths.get(filepath1).toAbsolutePath().normalize());
        String content2 = Files.readString(Paths.get(filepath2).toAbsolutePath().normalize());

        String format1 = getFormat(filepath1);
        String format2 = getFormat(filepath2);

        Map<String, Object> data1 = Parser.parse(content1, format1);
        Map<String, Object> data2 = Parser.parse(content2, format2);

        List<DiffNode> diff = DiffBuilder.build(data1, data2);
        return Formatter.format(diff, format);
    }

    private static String getFormat(String filepath) throws Exception {
        if (filepath.endsWith(".json")) {
            return "json";
        } else if (filepath.endsWith(".yml") || filepath.endsWith(".yaml")) {
            return "yaml";
        } else {
            throw new RuntimeException("Invalid format: " + filepath + ". Supported formats: .json, .yaml, .yml");
        }
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }
}
