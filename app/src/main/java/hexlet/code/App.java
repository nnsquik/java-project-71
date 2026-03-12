package hexlet.code;

import picocli.CommandLine;

import java.util.List;
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
            Map<String, Object> data1 = Parser.parse(filepath1);
            Map<String, Object> data2 = Parser.parse(filepath2);
            List<DiffNode> diffNodes = Differ.generate(data1, data2);
            System.out.println(Formatter.stylish(diffNodes));
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
