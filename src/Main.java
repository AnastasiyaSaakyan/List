import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<String> listGoods = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите операцию: \n" +
                    "1.Добавить покупку;\n" +
                    "2.Удалить покупку;\n" +
                    "3.Список покупок;\n" +
                    "4.Выход из программы.");

            String line = scanner.nextLine();

            switch (line) {
                case "1":
                    System.out.println("Какую покупку хотите добавить?");
                    String good = scanner.nextLine();
                    listGoods.add(good);

                    System.out.println(good + " Успешно добавленно в вашу корзину. ");

                    break;
                case "2":
                    boolean list = listGoods.isEmpty();
                    if (list) {
                        System.out.println("Ваш список пуст");
                        System.out.println();
                    } else {
                        System.out.println("Список покупок:");
                        for (int i = 0; i < listGoods.size(); i++) {
                            System.out.println((i + 1) + ". " + listGoods.get(i));
                        }
                    }
                    System.out.println();
                    break;
                case "3":
                    System.out.println("Список покупок:");
                    for (int i = 0; i < listGoods.size(); i++) {
                        System.out.println((i + 1) + ". " + listGoods.get(i));
                    }
                    System.out.println();
                    System.out.println("Какую хотите удалить? Введите номер или название");
                    String removeGoods = scanner.nextLine();
                    try {
                        int numGoods = Integer.parseInt(removeGoods) - 1;
                        listGoods.remove(numGoods);
                    } catch (NumberFormatException e) {
                        listGoods.remove(removeGoods);
                    }
                    System.out.println();
                    break;
                case "4":
                    System.out.println("Введите текст для поиска");
                    String query = scanner.nextLine();
                    String queryLower = query.toLowerCase();
                    for (int i = 0; i < listGoods.size(); i++) {
                        String item = listGoods.get(i);
                        String itemLower = item.toLowerCase();
                        if (itemLower.contains(queryLower)) {
                            System.out.println((i + 1) + ". " + item);
                        }
                    }
                    System.out.println();
                    break;
            }
        }
    }
}
