package sam.rus.optionl.view;

import sam.rus.optionl.model.Person;
import sam.rus.optionl.service.imple.PersonServiceImp;

import java.util.List;

public class App_list {
    public static void main(String[] args) {
        PersonServiceImp personServiceImp = PersonServiceImp.getInstance();
        List<Person> listPerson = personServiceImp.getListPerson(false);
        listPerson.forEach(System.out::println);
    }
}
