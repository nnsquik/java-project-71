package hexlet.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Differ {
    public static List<DiffNode> buildDiff(Map<String, Object> data1, Map<String, Object> data2) {
        List<String> allKeys = new ArrayList<>();

        for (String key : data1.keySet()) {
            allKeys.add(key);
        }

        for (String key : data2.keySet()) {
            if (!allKeys.contains(key)) {
                allKeys.add(key);
            }
        }

        Collections.sort(allKeys);
        List<DiffNode> diffNodes = new ArrayList<>();

        for (String key : allKeys) {
            boolean isFirstFile = data1.containsKey(key);
            boolean isSecondFile = data2.containsKey(key);

            if (isFirstFile && isSecondFile) {
                if (Objects.equals(data1.get(key), data2.get(key))) {
                    // ключ и значения одинаковы
                    diffNodes.add(new DiffNode(key, data1.get(key), data2.get(key), "unchanged"));
                } else {
                    // ключ и значения разные
                    diffNodes.add(new DiffNode(key, data1.get(key), data2.get(key), "changed"));
                }
            } else if (isFirstFile) {
                // ключ удален
                diffNodes.add(new DiffNode(key, data1.get(key), null, "removed"));
            } else {
                // ключ добавлен
                diffNodes.add(new DiffNode(key, null, data2.get(key), "added"));
            }
        }

        return diffNodes;
    }

    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        Map<String, Object> data1 = Parser.parse(filepath1);
        Map<String, Object> data2 = Parser.parse(filepath2);
        List<DiffNode> diff = buildDiff(data1, data2);
        return Formatter.format(diff, format);
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }
}
