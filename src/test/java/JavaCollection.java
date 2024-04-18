import java.util.ArrayList;
import java.util.List;

public class JavaCollection {

    public static void main(String[] args) {

        Book b1 = new Book("GOT", 1, 1);
        Book b2 = new Book("House of Dragon", 2, 2);

        List<Book> sampleBooks=new ArrayList<Book>();
        sampleBooks.add(b1);
        sampleBooks.add(b2);
//        List<String> fruits=new ArrayList<String>();
//        //List<Integer> numbers=new ArrayList<Integer>();
//        
//        fruits.add("Apple");
//        fruits.add("Mulbbery");
//        fruits.add("XYX");
//        
////        for(String s: fruits){
////            System.out.println(s);
////        }
//        fruits.set(0,"Saif");
//        System.out.println(fruits.get(0));
        
        for(Book test: sampleBooks){
            System.out.println(test.bookName + "," +test.bookId+","+ test.bookQuantity);
        }
    }
}
    
     class Book{
        
       public String bookName;
       public int bookId;
       public int bookQuantity;
        
        public Book(String bookName, int bookId,int bookQuantity){
           this.bookName=bookName;
           this.bookId=bookId;
           this.bookQuantity=bookQuantity;
        }
    }

