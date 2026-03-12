package hexlet.code;

import org.junit.jupiter.api.Test;

import java.util.List;
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

        String expected = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";

        List<DiffNode> diff = Differ.generate(data1, data2);
        assertEquals(expected, Formatter.stylish(diff));
    }

    @Test
    public void testGenerateYaml() throws Exception {
        Map<String, Object> data1 = Parser.parse(getFilePath("file1.yml"));
        Map<String, Object> data2 = Parser.parse(getFilePath("file2.yml"));

        String expected = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";

        List<DiffNode> diff = Differ.generate(data1, data2);
        assertEquals(expected, Formatter.stylish(diff));
    }

    @Test
    public void testGenerateNested() throws Exception {
        Map<String, Object> data1 = Parser.parse(getFilePath("file1-nested.json"));
        Map<String, Object> data2 = Parser.parse(getFilePath("file2-nested.json"));

        String expected = "{\n"
                + "    chars1: [a, b, c]\n"
                + "  - chars2: [d, e, f]\n"
                + "  + chars2: false\n"
                + "  - checked: false\n"
                + "  + checked: true\n"
                + "  - default: null\n"
                + "  + default: [value1, value2]\n"
                + "  - id: 45\n"
                + "  + id: null\n"
                + "  - key1: value1\n"
                + "  + key2: value2\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "  - numbers2: [2, 3, 4, 5]\n"
                + "  + numbers2: [22, 33, 44, 55]\n"
                + "  - numbers3: [3, 4, 5]\n"
                + "  + numbers4: [4, 5, 6]\n"
                + "  + obj1: {nestedKey=value, isNested=true}\n"
                + "  - setting1: Some value\n"
                + "  + setting1: Another value\n"
                + "  - setting2: 200\n"
                + "  + setting2: 300\n"
                + "  - setting3: true\n"
                + "  + setting3: none\n"
                + "}";

        List<DiffNode> diff = Differ.generate(data1, data2);
        assertEquals(expected, Formatter.stylish(diff));
    }

    @Test
    public void testGenerateNestedYaml() throws Exception {
        Map<String, Object> data1 = Parser.parse(getFilePath("file1-nested.yml"));
        Map<String, Object> data2 = Parser.parse(getFilePath("file2-nested.yml"));

        String expected = "{\n"
                + "    chars1: [a, b, c]\n"
                + "  - chars2: [d, e, f]\n"
                + "  + chars2: false\n"
                + "  - checked: false\n"
                + "  + checked: true\n"
                + "  - default: null\n"
                + "  + default: [value1, value2]\n"
                + "  - id: 45\n"
                + "  + id: null\n"
                + "  - key1: value1\n"
                + "  + key2: value2\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "  - numbers2: [2, 3, 4, 5]\n"
                + "  + numbers2: [22, 33, 44, 55]\n"
                + "  - numbers3: [3, 4, 5]\n"
                + "  + numbers4: [4, 5, 6]\n"
                + "  + obj1: {nestedKey=value, isNested=true}\n"
                + "  - setting1: Some value\n"
                + "  + setting1: Another value\n"
                + "  - setting2: 200\n"
                + "  + setting2: 300\n"
                + "  - setting3: true\n"
                + "  + setting3: none\n"
                + "}";

        List<DiffNode> diff = Differ.generate(data1, data2);
        assertEquals(expected, Formatter.stylish(diff));
    }
}
