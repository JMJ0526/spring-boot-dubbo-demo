package org.jackson.dubbo.client.api;

import com.alibaba.dubbo.config.annotation.Reference;
import org.jackson.dubbo.models.Person;
import org.jackson.dubbo.models.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Reference(url = "dubbo://localhost:20880/")
    private PersonService personService;

    @GetMapping("/person/create")
    public Person create() {
        System.out.println("personService:" + personService);
        return personService.create("test", "address");
    }

    @GetMapping("/person/list")
    public List<Person> findAll() {
        return personService.findAll();
    }
}
