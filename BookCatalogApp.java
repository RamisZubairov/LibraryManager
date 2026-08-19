import java.util.ArrayList;
import java.util.Scanner;

public class BookCatalogApp {

    public static double avg(ArrayList<Book> catalog) {
        if (catalog == null || catalog.isEmpty()) {
            return 0.0;
        }
        double sum = 0.0;
        double avgsum = 0.0;
        for (Book book : catalog) {
            sum += book.price;
        }
        avgsum = sum / catalog.size();
        return avgsum;
    }

    public static void addBook(ArrayList<Book> catalog, String title, String author, double price, int pages) {
        catalog.add(new Book(title, author, price, pages));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> catalog = new ArrayList<>();

        while (true) {
            System.out.println("1) Добавить книгу");
            System.out.println("2) Показать все книги");
            System.out.println("3) Найти по названию книгу");
            System.out.println("4) Средняя цена книг");
            System.out.println("5) Выход");
            System.out.print("Выберите опцию: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите название: ");
                    String title = scanner.nextLine();
                    System.out.print("Введите автора: ");
                    String author = scanner.nextLine();
                    System.out.print("Введите цену: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Введите количество страниц: ");
                    int pages = scanner.nextInt();
                    scanner.nextLine();

                    addBook(catalog, title, author, price, pages);
                    System.out.println("Книга добавлена!");
                    break;
                case 2:
                    if (catalog.isEmpty()) {
                        System.out.println("Каталог пуст.");
                    } else {
                        for (Book b : catalog) {
                            System.out.println(b.toString());
                        }
                    }
                    break;
                case 3:
                    System.out.print("Введите название для поиска: ");
                    String searchTitle = scanner.nextLine();
                    boolean found = false;
                    for (Book b : catalog) {
                        if (b.title.equalsIgnoreCase(searchTitle)) {
                            System.out.println(b.toString());
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Книга не найдена.");
                    }
                        break;
                case 4:
                    System.out.println("Средняя сумма всех книг: " + avg(catalog));
                    break;
                case 5:
                    System.out.println("До свидания!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор, попробуйте снова.");
            }
        }
    }
}
