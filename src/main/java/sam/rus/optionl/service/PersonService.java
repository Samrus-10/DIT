package sam.rus.optionl.service;

import sam.rus.optionl.model.Person;

import java.util.List;

public interface PersonService {

    Person getPerson(String[] args);

    Person getPerson();

    List<Person> getListPerson(boolean sort);

    void getMenu();

}
