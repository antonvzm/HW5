import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class oneTask {
    public static void main(String[] args) {
        Map<String, List<String>> phoneBook = new HashMap<>();
        String str = "";
        while (!str.equals("exit")) {
            System.out.println("--------------------------------------------" +
                    "\nМеню\n add: добавить номер в справочник\n print: печать справочника\n search: найти запись\n exit: выход"
                    + "\n--------------------------------------------");
            System.out.println("");
            Scanner in = new Scanner(System.in);
            str = in.nextLine();
            if (str.equals("print")) {
                for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
                    System.out.println(entry.getKey() + " - " + entry.getValue());
                }
                ;
            } else if (str.equals("add")) {
                addPhone(phoneBook, in);
            } else if (str.equals("search")) {
                System.out.println("Введите имя для поиска: ");
                String nameSearch = in.nextLine();
                if (phoneBook.get(nameSearch) == null) {
                    System.out.println("Такой записи в справочнике нет");
                } else {
                    System.out.println(phoneBook.get(nameSearch));
                }
            } else if (str.equals("exit")) {
                in.close();
                System.out.println("\nПока!");

            } else {
                System.out.println("\nОшибка ввода, попробуй еще...");
            }
        }
    }

    public static Map<String, List<String>> addPhone(Map<String, List<String>> phoneBook, Scanner in) {
        List<String> phone = new ArrayList<>();
        System.out.println("Введите имя: ");
        String name = in.nextLine();
        System.out.println("Введите номер телефона: ");
        String num = in.nextLine();
        phone.add(num);
        System.out.println("Введите второй номер телефона. Если номер только один нажмите ENTER...");
        String secondNum = in.nextLine();
        if (secondNum != "") {
            phone.add(secondNum);
        }
        phoneBook.put(name, phone);
        return phoneBook;

    }

}