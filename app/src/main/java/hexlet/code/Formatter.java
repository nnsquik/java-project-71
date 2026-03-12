package hexlet.code;

import java.util.List;

public class Formatter {
    public static String stylish(List<DiffNode> diffNodes) {
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
                    break;
            }
        }

        result.append("}");
        return result.toString();
    }
}
