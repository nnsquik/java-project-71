package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import picocli.CommandLine;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

@CommandLine.Command(name = "gendiff", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public final class App implements Runnable {
    @CommandLine.Parameters(index = "0", paramLabel = "filepath1", description = "path to first file")
    private String filepath1;

    @CommandLine.Parameters(index = "1", paramLabel = "filepath2", description = "path to second file")
    private String filepath2;

    @CommandLine.Option(names = {"-f", "--format"}, paramLabel = "format",
            description = "output format [default: stylish]", defaultValue = "stylish")
    private String format;

    public static void main(String[] args) {
        new CommandLine(new App()).execute(args);
    }

    @Override
    public void run() {
        try {
            Map<String, Object> data1 = parseJson(filepath1);
            Map<String, Object> data2 = parseJson(filepath2);
            System.out.println("File 1: " + data1);
            System.out.println("File 2: " + data2);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static Map<String, Object> parseJson(String filepath) throws Exception {
        String content = Files.readString(Paths.get(filepath).toAbsolutePath().normalize());
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(content, Map.class);
    }
}
