package sam.rus.service;

import sam.rus.model.Person;

import java.util.List;

public interface PersonService {

    Person getPerson(String[] args);

    Person getPerson();

    List<Person> getListPerson(boolean sort);

    void getMenu();

}
