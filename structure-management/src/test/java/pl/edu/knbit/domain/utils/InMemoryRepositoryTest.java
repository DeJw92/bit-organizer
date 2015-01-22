package pl.edu.knbit.domain.utils;

import org.axonframework.repository.Repository;
import org.junit.Before;
import org.junit.Test;
import pl.edu.knbit.domain.group.valueobjects.GroupId;
import pl.edu.knbit.domain.group.aggregates.Group;

import java.util.UUID;

import static org.junit.Assert.*;

public class InMemoryRepositoryTest {
    private Repository<Group> repository;
    private Group group;
    private GroupId groupId;

    @Before
    public void setUp() throws Exception {
        repository = new InMemoryRepository<Group>();

        groupId = new GroupId(UUID.randomUUID());
        group = new Group(groupId, "name", "description");
    }

    @Test
    public void name() throws Exception {
        //given
        repository.add(group);

        //when
        Group loadedGroup = repository.load(groupId);

        //then
        assertEquals(group, loadedGroup);

    }
}