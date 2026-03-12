package hexlet.code;

import picocli.CommandLine;

@CommandLine.Command(name = "gendiff", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public class App implements Runnable {

    public static void main(String[] args) {
        new CommandLine(new App()).execute(args);
    }

    public void run() {
        System.out.println("Hello World!");
    }
}
