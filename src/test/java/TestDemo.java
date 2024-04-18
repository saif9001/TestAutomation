import org.openqa.selenium.JavascriptExecutor;

public class TestDemo {
 
    public void  printSum(int ny) {
        
        if(ny<100) {
           ny = ny + 1;
           System.out.println(ny);
           printSum(ny);
       }
    }


    public static void main(String[] args) {
      
        TestDemo testDemo = new TestDemo();
        int ny = 0;
         testDemo.printSum(ny); 
    }
}
