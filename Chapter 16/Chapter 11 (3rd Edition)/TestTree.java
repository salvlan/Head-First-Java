import java.util.*;

public class TestTree {

    public static void main(String[] args) {
        new TestTree().go();
    }

    public void go(){
        Book book1 = new Book ("How Cats Work");
        Book book2 = new Book ("Remix your body");
        Book book3 = new Book ("Finding Emo");

        Set<Book> tree = new TreeSet<>((one,two)->one.title.compareTo(two.title));
        tree.add(book1);
        tree.add(book2);
        tree.add(book3);

        System.out.println(tree);
    }

    public class Book {
        private String title;
        public Book (String title){
            this.title = title;
        }
        public String toString(){
            return title;
        }
    }

}


