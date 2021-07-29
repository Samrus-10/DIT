package sam.rus.view;

import sam.rus.model.Person;
import sam.rus.service.imple.PersonServiceImp;

import java.util.List;

public class App_list {
    public static void main(String[] args) {
        PersonServiceImp personServiceImp = PersonServiceImp.getInstance();
        List<Person> listPerson = personServiceImp.getListPerson(false);
        listPerson.forEach(System.out::println);
    }
}
