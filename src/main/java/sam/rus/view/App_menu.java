package sam.rus.view;

import sam.rus.service.imple.PersonServiceImp;

public class App_menu {
    public static void main(String[] args) {
        PersonServiceImp service = PersonServiceImp.getInstance();
        service.getMenu();
    }
}
