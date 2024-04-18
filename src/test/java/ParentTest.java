import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ParentTest{
   
   public static ParentTest test;
   
   
   
   public static void main(String[] args) {

       int n = 4;
       for (int i = 5; i >=0; i--) {

       for (int j=1;j<=i;j++){
           
           System.out.print(" ");
           if(j==i){

               System.out.print("*"); }
       }
       
                   System.out.println();
       }
   }
      
    
    
}
