package sam.rus.optionl.view;

import sam.rus.optionl.service.imple.PersonServiceImp;

public class App_menu {
    public static void main(String[] args) {
        PersonServiceImp service = PersonServiceImp.getInstance();
        service.getMenu();
    }
}
