package hexlet.code;

public final class DiffNode {
    private final String key;
    private final Object oldValue;
    private final Object newValue;
    private final String type;

    public DiffNode(String keyParm, Object oldValueParam, Object newValueParam, String typeParam) {
        this.key = keyParm;
        this.oldValue = oldValueParam;
        this.newValue = newValueParam;
        this.type = typeParam;
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
