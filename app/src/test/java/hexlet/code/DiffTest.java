package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiffTest {
    private String getFilePath(String fileName) {
        return "src/test/resources/" + fileName;
    }

    private String readExpected(String fileName) throws Exception {
        return Files.readString(Paths.get("src/test/resources/expected/" + fileName))
                .trim();
    }

    @Test
    public void testGenerateJson() throws Exception {
        assertEquals(readExpected("expected-stylish-flat.txt"),
                Differ.generate(getFilePath("file1.json"), getFilePath("file2.json")));
    }

    @Test
    public void testGenerateYaml() throws Exception {
        assertEquals(readExpected("expected-stylish-flat.txt"),
                Differ.generate(getFilePath("file1.yml"), getFilePath("file2.yml")));
    }

    @Test
    public void testJsonToStylishDefault() throws Exception {
        assertEquals(readExpected("expected-stylish.txt"),
                Differ.generate(getFilePath("file1-nested.json"), getFilePath("file2-nested.json")));
    }

    @Test
    public void testJsonToStylish() throws Exception {
        assertEquals(readExpected("expected-stylish.txt"),
                Differ.generate(getFilePath("file1-nested.json"), getFilePath("file2-nested.json"), "stylish"));
    }

    @Test
    public void testJsonToPlain() throws Exception {
        assertEquals(readExpected("expected-plain.txt"),
                Differ.generate(getFilePath("file1-nested.json"), getFilePath("file2-nested.json"), "plain"));
    }

    @Test
    public void testJsonToJson() throws Exception {
        assertEquals(readExpected("expected-json.txt"),
                Differ.generate(getFilePath("file1-nested.json"), getFilePath("file2-nested.json"), "json"));
    }

    @Test
    public void testYamlToStylishDefault() throws Exception {
        assertEquals(readExpected("expected-stylish.txt"),
                Differ.generate(getFilePath("file1-nested.yml"), getFilePath("file2-nested.yml")));
    }

    @Test
    public void testYamlToStylish() throws Exception {
        assertEquals(readExpected("expected-stylish.txt"),
                Differ.generate(getFilePath("file1-nested.yml"), getFilePath("file2-nested.yml"), "stylish"));
    }

    @Test
    public void testYamlToPlain() throws Exception {
        assertEquals(readExpected("expected-plain.txt"),
                Differ.generate(getFilePath("file1-nested.yml"), getFilePath("file2-nested.yml"), "plain"));
    }

    @Test
    public void testYamlToJson() throws Exception {
        assertEquals(readExpected("expected-json.txt"),
                Differ.generate(getFilePath("file1-nested.yml"), getFilePath("file2-nested.yml"), "json"));
    }
}
