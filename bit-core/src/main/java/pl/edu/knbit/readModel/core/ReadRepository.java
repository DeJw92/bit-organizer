package pl.edu.knbit.readModel.core;

import java.util.List;

/**
 * @author mciolek
 */
public interface ReadRepository<K, V extends AbstractReadObject> {

    List<V> getAll();

    void add(V entity);
}
