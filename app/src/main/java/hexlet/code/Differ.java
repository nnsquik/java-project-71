package hexlet.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(Map<String, Object> data1, Map<String, Object> data2) {
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
        StringBuilder result = new StringBuilder();
        result.append("{\n");

        for (String key : allKeys) {
            boolean isFirstFile = data1.containsKey(key);
            boolean isSecondFile = data2.containsKey(key);

            if (isFirstFile && isSecondFile) {
                if (data1.get(key).equals(data2.get(key))) {
                    // ключ в обоих файлах и значения одинаковы
                    result.append("    " + key + ": " + data1.get(key) + "\n");
                } else {
                    // ключ в обоих файлах и значения разные
                    result.append("  - " + key + ": " + data1.get(key) + "\n");
                    result.append("  + " + key + ": " + data2.get(key) + "\n");
                }
            } else if (isFirstFile) {
                // ключ удален только в 1 файле
                result.append("  - " + key + ": " + data1.get(key) + "\n");
            } else {
                // ключ добавлен только во 2 файле
                result.append("  + " + key + ": " + data2.get(key) + "\n");
            }
        }

        result.append("}");
        return result.toString();
    }
}
