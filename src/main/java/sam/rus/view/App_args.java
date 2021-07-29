package sam.rus.view;

import sam.rus.model.Person;
import sam.rus.service.imple.PersonServiceImp;

public class App_args {
    public static void main(String[] args) {
        PersonServiceImp personServiceImp = PersonServiceImp.getInstance();
        Person person = personServiceImp.getPerson(args);
        System.out.println(person);
    }
}
