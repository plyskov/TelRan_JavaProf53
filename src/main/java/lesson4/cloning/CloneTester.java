package lesson4.cloning;

public class CloneTester {

    public static void main(String[] args) throws CloneNotSupportedException {

        Author leo = new Author("Leo Tolstoy");

        Book warAndPeace = new Book("War and Peace", 1825, leo);
        Book someBook = warAndPeace;

        //someBook.setYear(1924);
        //System.out.println(warAndPeace);

        Book anotherBook = warAndPeace.clone();
        System.out.println(anotherBook);
        anotherBook.setYear(2023);

        //Author orwell = new Author("George Orwell");
        //anotherBook.setAuthor(orwell);
        Author author = anotherBook.getAuthor();
        author.setName("George Orwell");
        anotherBook.setAuthor(author);

        //anotherBook.setName("Another");

        System.out.println(anotherBook);
        System.out.println(warAndPeace);

    }

}
