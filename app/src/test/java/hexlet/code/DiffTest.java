package hexlet.code;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiffTest {
    private String getFilePath(String fileName) {
        return "src/test/resources/" + fileName;
    }

    @Test
    public void testGenerateJson() throws Exception {
        Map<String, Object> data1 = Parser.parse(getFilePath("file1.json"));
        Map<String, Object> data2 = Parser.parse(getFilePath("file2.json"));

        String excepted = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";

        assertEquals(excepted, Differ.generate(data1, data2));
    }

    @Test
    public void testGenerateYaml() throws Exception {
        Map<String, Object> data1 = Parser.parse(getFilePath("file1.yml"));
        Map<String, Object> data2 = Parser.parse(getFilePath("file2.yml"));

        String excepted = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";

        assertEquals(excepted, Differ.generate(data1, data2));
    }
}
