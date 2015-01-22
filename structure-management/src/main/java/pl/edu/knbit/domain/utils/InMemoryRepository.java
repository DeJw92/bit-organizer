package pl.edu.knbit.domain.utils;

import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.axonframework.repository.AggregateNotFoundException;
import org.axonframework.repository.Repository;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class InMemoryRepository<T> implements Repository<T> {
    private Map<Object, T> map = new HashMap<>();

    @Override
    public T load(Object aggregateIdentifier, Long expectedVersion) {
        return load(aggregateIdentifier);
    }

    @Override
    public T load(Object aggregateIdentifier) {
        T t = map.get(aggregateIdentifier);
        if (t!=null) {
            return t;
        }
        else {
            throw new AggregateNotFoundException(aggregateIdentifier, "InMemoryRepository - not found aggregate identifier!");
        }
    }

    @Override
    public void add(T aggregate) {
        Field[] declaredFields = aggregate.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if(declaredField.isAnnotationPresent(AggregateIdentifier.class)) {
                declaredField.setAccessible(true);
                try {
                    Object identifier = declaredField.get(aggregate);
                    map.put(identifier, aggregate);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
