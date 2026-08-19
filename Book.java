public class Book {

    String title;
    String author;
    double price;
    int pages;

    Book(String title, String author, double price, int pages) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Название: " + title + " | Автор: " + author + " | Цена: " + price + " | Кол-во страниц: " + pages;
    }
}
