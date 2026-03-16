package hexlet.code.formatters;

import hexlet.code.DiffNode;

import java.util.List;

public class Stylish {
    public static String format(List<DiffNode> diffNodes) throws Exception {
        StringBuilder result = new StringBuilder();
        result.append("{\n");

        for (DiffNode diffNode : diffNodes) {
            switch (diffNode.getType()) {
                case "unchanged":
                    result.append("    " + diffNode.getKey() + ": " + diffNode.getOldValue() + "\n");
                    break;
                case "changed":
                    result.append("  - " + diffNode.getKey() + ": " + diffNode.getOldValue() + "\n");
                    result.append("  + " + diffNode.getKey() + ": " + diffNode.getNewValue() + "\n");
                    break;
                case "removed":
                    result.append("  - " + diffNode.getKey() + ": " + diffNode.getOldValue() + "\n");
                    break;
                case "added":
                    result.append("  + " + diffNode.getKey() + ": " + diffNode.getNewValue() + "\n");
                    break;
                default:
                    throw new RuntimeException("Unknown node type: " + diffNode.getType());
            }
        }

        result.append("}");
        return result.toString();
    }
}
