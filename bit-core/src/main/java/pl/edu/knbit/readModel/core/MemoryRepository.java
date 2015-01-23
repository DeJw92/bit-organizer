package pl.edu.knbit.readModel.core;

import com.google.common.collect.Lists;
import org.apache.commons.collections.map.HashedMap;

import java.util.List;
import java.util.Map;

/**
 * @author mciolek
 */
public class MemoryRepository<K, V extends AbstractReadObject<K>> implements ReadRepository<K, V> {
    private final Map<K, V> repository = new HashedMap();


    @Override
    public List<V> getAll() {
        return Lists.newArrayList(repository.values());
    }

    @Override
    public void add(V entity) {
        repository.put(entity.getId(), entity);
    }


}
