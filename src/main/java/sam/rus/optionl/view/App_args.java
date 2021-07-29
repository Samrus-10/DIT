package sam.rus.optionl.view;

import sam.rus.optionl.model.Person;
import sam.rus.optionl.service.imple.PersonServiceImp;

public class App_args {
    public static void main(String[] args) {
        PersonServiceImp personServiceImp = PersonServiceImp.getInstance();
        Person person = personServiceImp.getPerson(args);
        System.out.println(person);
    }
}
