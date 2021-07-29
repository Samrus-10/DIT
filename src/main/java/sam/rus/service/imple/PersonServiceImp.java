package sam.rus.service.imple;

import sam.rus.model.Person;
import sam.rus.utli.exception.MuchArgsException;
import sam.rus.utli.exception.NotArgsException;
import sam.rus.utli.classs.PersonComparator;

import java.io.*;
import java.util.*;

public class PersonServiceImp {
    private List<Person> listPerson;

    private PersonServiceImp() {
        listPerson = new ArrayList<>();
    }

    public static PersonServiceImp getInstance() {
        return new PersonServiceImp();
    }

    public Person getPerson(String[] args) {
        if (args.length < 2) {
            throw new NotArgsException("Отсутствуют аргументы для создание класса");
        } else if (args.length > 2) {
            throw new MuchArgsException("Аргументов слишком много для создание класса");
        }
        return Person.newBuilder()
                .setFirstName(args[0])
                .setSecondName(args[1])
                .build();
    }

    public Person getPerson() {
        System.out.println("Write firstname and secondname:");
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.next();
        String secondName = scanner.next();
        return Person.newBuilder()
                .setFirstName(firstName)
                .setSecondName(secondName)
                .build();
    }

    public List<Person> getListPerson(boolean sort) {
        List<Person> listPerson = new ArrayList<>();
        while (true) {
            System.out.println("Write firstname and secondname Person(for exit write 'exit' wishout firsname): ");
            Scanner scanner = new Scanner(System.in);
            String firstName = scanner.next();
            if (firstName.equals("exit")) {
                break;
            }
            String secondName = scanner.next();
            listPerson.add(Person.newBuilder()
                    .setFirstName(firstName)
                    .setSecondName(secondName)
                    .build());
        }
        if (sort) {
            listPerson.sort(new PersonComparator());
        }
        return listPerson;
    }

    public void getMenu() {
        boolean exit = true;
        Scanner scanner = new Scanner(System.in);
        do {
            drawMenu();
            Integer choose = checkInput(scanner);
            if (choose != null) {
                exit = processingChoose(choose, scanner);
            }
        }
        while (exit);

    }

    private void drawMenu() {
        System.out.println("Menu");
        System.out.println("1. Add");
        System.out.println("2. Show");
        System.out.println("3. Show sorted unique");
        System.out.println("4. Save to file");
        System.out.println("5. Read from file");
        System.out.println("6. Clear data in memory");
        System.out.println("7. Exit");
    }

    private Integer checkInput(Scanner scanner) {
        Integer result = null;
        try {
            result = scanner.nextInt();
        } catch (Exception exception) {
            System.out.println("Not correct input");
            scanner.next();
        }
        return result;
    }

    private boolean processingChoose(int choose, Scanner scanner) {
        boolean result = true;
        if (choose >= 1 && choose <= 7) {
            if (choose == 1) {
                addNewPerson(scanner);
            } else if (choose == 2) {
                show();
            } else if (choose == 3) {
                showSortUnique();
            } else if (choose == 4) {
                writeInFile();
            } else if (choose == 5) {
                readFromFile();
            } else if (choose == 6) {
                clearList();
            } else {
                result = false;
            }

        } else {
            System.out.println("Not correct input");
        }
        return result;
    }

    private void addNewPerson(Scanner scanner) {
        System.out.println("write firstName: ");
        String firstName = scanner.next();
        System.out.println("write secondName:");
        String secondName = scanner.next();

        this.listPerson.add(Person.newBuilder()
                .setFirstName(firstName)
                .setSecondName(secondName)
                .build());
    }

    private void show() {
        System.out.println("----------------------------------------");
        System.out.println("|            all Person in list         |");
        System.out.println("----------------------------------------");
        if (this.listPerson.size() == 0) {
            System.out.println("Empty");
        } else {
            this.listPerson.forEach(System.out::println);
        }
        System.out.println("----------------------------------------");
    }

    private void showSortUnique() {
        System.out.println("----------------------------------------");
        System.out.println("|       all Person in list (sort)       |");
        System.out.println("----------------------------------------");
        if (this.listPerson.size() == 0) {
            System.out.println("Empty");
        } else {
            Set<Person> setPerson = new TreeSet<Person>(new PersonComparator());
            setPerson.addAll(this.listPerson);
            List<Person> list = new ArrayList<>(setPerson);
            list.sort(new PersonComparator());
            list.forEach(System.out::println);
        }
        System.out.println("----------------------------------------");
    }

    private void writeInFile() {
        try (
                FileOutputStream fos = new FileOutputStream(getPathFile().get("write"));
                PrintStream printStream = new PrintStream(fos)
        ) {
            this.listPerson.forEach((item) -> {
                printStream.println(item);
            });
            System.out.println("----------------------------------------");
            System.out.println(String.format("Save in file: %s", getPathFile().get("write")));
            System.out.println("----------------------------------------");

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private void readFromFile() {
        try (
                FileReader reader = new FileReader(getPathFile().get("read"))
        ) {
            System.out.println("----------------------------------------");
            int c;
            String text = "";
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
                text += (char) c;
            }

            System.out.println();
            String[] split = text.split("\n");
            Arrays.stream(split).forEach((item) -> {
                String[] s = item.split(" ");
                this.listPerson.add(Person.newBuilder()
                        .setFirstName(s[0])
                        .setSecondName(s[1])
                        .build());
            });
            System.out.println(String.format("Read from file: %s", getPathFile().get("read")));
            System.out.println("----------------------------------------");

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private Map<String, String> getPathFile() throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream(new File("/Users/u19305165/Desktop/DIT/src/main/resources/property.property ")));
        String path_file_write = props.getProperty("PATH_FILE_WRITE");
        String path_file_read = props.getProperty("PATH_FILE_READ");
        HashMap<String, String> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("write", path_file_write);
        objectObjectHashMap.put("read", path_file_read);
        return objectObjectHashMap;
    }

    private void clearList() {
        this.listPerson.clear();
        System.out.println("----------------------------------------");
        System.out.println("Clear list for Persnon");
        System.out.println("----------------------------------------");
    }
}
