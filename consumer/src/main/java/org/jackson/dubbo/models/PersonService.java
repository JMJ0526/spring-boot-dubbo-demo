package org.jackson.dubbo.models;

import java.util.List;

public interface PersonService {

    Person create(String name,String address);

    void delete(String id);

    Person update(Person person);

    List<Person> findAll();
}
