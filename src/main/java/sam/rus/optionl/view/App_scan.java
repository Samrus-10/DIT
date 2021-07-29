package sam.rus.optionl.view;

import sam.rus.optionl.model.Person;
import sam.rus.optionl.service.imple.PersonServiceImp;

public class App_scan {
    public static void main(String[] args) {
        PersonServiceImp personServiceImp = PersonServiceImp.getInstance();
        Person person = personServiceImp.getPerson();
        System.out.println(person);
    }
}
