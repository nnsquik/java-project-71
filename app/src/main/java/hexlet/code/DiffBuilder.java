package hexlet.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import java.util.Objects;

public class DiffBuilder {
    public static List<DiffNode> build(Map<String, Object> data1, Map<String, Object> data2) {
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
}
