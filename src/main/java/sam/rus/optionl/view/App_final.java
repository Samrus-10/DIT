package sam.rus.optionl.view;

import sam.rus.optionl.model.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;


public class App_final {

    private interface Exec {
        void exec(List<Person> data) throws Exception;
    }

    private static class MenuItem {
        private String name;
        private Exec exec;

        MenuItem(String name, Exec exec) {
            this.name = name;
            this.exec = exec;
        }

    }

    private static class Menu {
        private Scanner scanner;
        private List<MenuItem> items;

        private Menu(Scanner scanner) {
            this.scanner = scanner;
        }

        public void getItem(List<Person> personList) throws Exception {
            boolean run = true;
            while (run) {
                System.out.println("Menu");
                System.out.println("1. Add");
                System.out.println("2. Show");
                System.out.println("3. Show sorted unique");
                System.out.println("4. Save to file");
                System.out.println("5. Read from file");
                System.out.println("6. Clear data in memory");
                System.out.println("7. Exit");
                switch (scanner.nextLine()) {
                    case "1":
                        items.get(0).exec.exec(personList);
                        break;
                    case "2":
                        items.get(1).exec.exec(personList);
                        break;
                    case "3":
                        items.get(2).exec.exec(personList);
                        break;
                    case "4":
                        items.get(3).exec.exec(personList);
                        break;
                    case "5":
                        items.get(4).exec.exec(personList);
                        break;
                    case "6":
                        items.get(5).exec.exec(personList);
                        break;
                    case "7":
                        run = false;
                        break;
                }
            }
        }

        public void setItems(List<MenuItem> items) {
            this.items = items;
        }
    }

    private static List<MenuItem> getItem(Scanner scanner) {
        List<MenuItem> result = new ArrayList<>();
        result.add(new MenuItem("add", (personList) -> {
            System.out.println("write firstName: ");
            String firstName = scanner.next();
            System.out.println("write secondName:");
            String secondName = scanner.next();
            personList.add(Person.newBuilder()
                    .setFirstName(firstName)
                    .setSecondName(secondName)
                    .build());
        }));

        result.add(new MenuItem("show", (personList) -> {
            if (personList.size() == 0) System.out.println("List is empty");
            else personList.forEach(System.out::println);
        }));

        result.add(new MenuItem("sort", (personList) -> {
            personList.stream()
                    .sorted((s1, s2) -> s1.getSecondName().compareTo(s2.getSecondName()))
                    .collect(Collectors.toMap(Person::getSecondName, Function.identity(), (existing, replacement) -> existing))
                    .values()
                    .stream()
                    .collect(Collectors.toList())
                    .forEach(System.out::println);
        }));

        result.add(new MenuItem("save", (personList) -> {
            if (personList.size() != 0) {
                try (
                        FileOutputStream fos = new FileOutputStream("/Users/u19305165/Desktop/DIT/src/main/resources/ListPerson");
                        PrintStream printStream = new PrintStream(fos)
                ) {
                    personList.forEach((item) -> {
                        printStream.println(item);
                    });
                    System.out.println("----------------------------------------");
                    System.out.println(String.format("Save in file"));
                    System.out.println("----------------------------------------");

                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        }));

        result.add(new MenuItem("read", (personList) -> {
            try (
                    FileReader reader = new FileReader("/Users/u19305165/Desktop/DIT/src/main/resources/ListPerson");
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
                    personList.add(Person.newBuilder()
                            .setFirstName(s[0])
                            .setSecondName(s[1])
                            .build());
                });
                System.out.println(String.format("Read from file"));
                System.out.println("----------------------------------------");

            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }));

        result.add(new MenuItem("clear", (personList) -> {
            personList.clear();
            System.out.println("List was clear");
        }));
        return result;
    }

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
        menu.setItems(getItem(scanner));
        try {
            menu.getItem(personList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}