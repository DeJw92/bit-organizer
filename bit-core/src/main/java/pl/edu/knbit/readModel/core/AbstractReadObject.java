package pl.edu.knbit.readModel.core;

/**
 * @author mciolek
 */
public class AbstractReadObject<K> {
    private final K id;

    public AbstractReadObject(K id) {
        this.id = id;
    }

    public K getId() {
        return id;
    }
}
