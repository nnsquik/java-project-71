package hexlet.code.formatters;

import hexlet.code.DiffNode;

import java.util.List;
import java.util.Map;

public class Plain {

    private  static String formatValue(Object value) {
        if (value == null) {
            return "null";
        } else if (value instanceof List || value instanceof Map) {
            return "[complex value]";
        } else if (value instanceof String) {
            return "'" + value + "'";
        } else {
            return value.toString();
        }
    }

    public static String format(List<DiffNode> diffNodes) throws Exception {
        StringBuilder result = new StringBuilder();

        for (DiffNode diffNode : diffNodes) {
            String key = diffNode.getKey();
            switch (diffNode.getType()) {
                case "changed":
                    result.append("Property '" + key + "' was updated. From "
                            + formatValue(diffNode.getOldValue()) + " to "
                            + formatValue(diffNode.getNewValue()) + "\n");
                    break;
                case "removed":
                    result.append("Property '" + key + "' was removed\n");
                    break;
                case "added":
                    result.append("Property '" + key + "' was added with value: "
                            + formatValue(diffNode.getNewValue()) + "\n");
                    break;
                case "unchanged":
                    break;
                default:
                    throw new RuntimeException("Unknown node type: " + diffNode.getType());
            }
        }
        return result.toString().trim();
    }
}
