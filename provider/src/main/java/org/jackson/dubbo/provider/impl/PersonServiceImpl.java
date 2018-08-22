package org.jackson.dubbo.provider.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.jackson.dubbo.models.Person;
import org.jackson.dubbo.models.PersonService;

import java.util.*;

@Service
public class PersonServiceImpl implements PersonService {

    private HashMap<String, Person> map = new HashMap<>();

    @Override
    public Person create(String name, String address) {
        String id = generatorId();
        Person person = new Person(id, name, address);
        map.put(id, person);
        return person;
    }

    @Override
    public void delete(String id) {
        map.remove(id);
    }

    @Override
    public Person update(Person person) {
        Person _person = map.get(person.getId());
        if (_person != null) {
            _person.setName(person.getName());
            _person.setAddress(person.getAddress());
        }
        return _person;
    }

    @Override
    public List<Person> findAll() {
        return new ArrayList<>(map.values());
    }


    private String generatorId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
