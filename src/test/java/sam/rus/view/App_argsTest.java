package sam.rus.view;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sam.rus.model.Person;
import sam.rus.service.imple.PersonServiceImp;
import sam.rus.utli.exception.MuchArgsException;
import sam.rus.utli.exception.NotArgsException;

import static org.junit.jupiter.api.Assertions.*;

public class App_argsTest {
    private PersonServiceImp personServiceImp;

    @BeforeEach
    public void initService() {
        personServiceImp = PersonServiceImp.getInstance();
    }

    @Test
    public void NotArgsCreatePerson(){
        String[] emptyArgs = new String[]{};
        Throwable throwable = assertThrows(NotArgsException.class, ()->{
            Person person = personServiceImp.getPerson(emptyArgs);
        });
        assertNotNull(throwable.getMessage());
    }

    @Test
    public void MuchArgsCreatePerson(){
        String[] emptyArgs = new String[]{"Sam", "Rusanov", "Dany"};
        Throwable throwable = assertThrows(MuchArgsException.class, ()->{
            Person person = personServiceImp.getPerson(emptyArgs);
        });
        assertNotNull(throwable.getMessage());
    }

    @Test
    public void CreatePerson(){
        String[] emptyArgs = new String[]{"Sam", "Rusanov"};
        Person person = personServiceImp.getPerson(emptyArgs);
        Person person1 = Person.newBuilder()
                .setFirstName("Sam")
                .setSecondName("Rusanov")
                .build();
        assertEquals(person, person1);
    }
}
