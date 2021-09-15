package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book warAndPeace = new Book("Война и мир", 12324);
        Book capitanDaughter = new Book("Капитанская дочь", 233);
        Book harryPotter = new Book("Гарри Поттер", 4546);
        Book cleanCode = new Book("Чистый Код", 244);
        Book[] books = new Book[4];
        books[0] = warAndPeace;
        books[1] = capitanDaughter;
        books[2] = harryPotter;
        books[3] = cleanCode;
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " - " + book.getPage());
        }
        System.out.println("Заменить войну и мир на Чистый код.");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " - " + book.getPage());
        }
        System.out.println("Показать только Чистый код.");
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            if ("Чистый Код".equals(book.getName())) {
                System.out.println(book.getName() + " - " + book.getPage());
            }
        }
    }
}
