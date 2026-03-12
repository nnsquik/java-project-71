package hexlet.code;

public class DiffNode {
    private final String key;
    private final Object oldValue;
    private final Object newValue;
    private final String type;

    public DiffNode(String key, Object oldValue, Object newValue, String value) {
        this.key = key;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.type = value;
    }

    public String getKey() {
        return key;
    }
    public Object getOldValue() {
        return oldValue;
    }
    public Object getNewValue() {
        return newValue;
    }
    public String getType() {
        return type;
    }
}
