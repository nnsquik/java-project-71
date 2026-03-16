package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;

public class Formatter {
    public static String format(List<DiffNode> diff, String formatName) throws Exception {
        switch (formatName) {
            case "stylish":
                return Stylish.format(diff);
            case "plain":
                return Plain.format(diff);
            case "json":
                return Json.format(diff);
            default:
                throw new RuntimeException("Unknown format: " + formatName
                        + ". Supported formats: stylish, plain, json");
        }
    }
}
