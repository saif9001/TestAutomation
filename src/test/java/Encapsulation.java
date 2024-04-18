import org.testng.reporters.jq.Main;

public class Encapsulation {
    
    public  int age;
    public String name;
    
    Encapsulation(int age, String name){
        this.age=age;
        this.name=name;
        System.out.println("Inside encapsulation ");
    }
    
    @Override
    public String toString() {
        return "Encapsulation{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
       class Tight extends Encapsulation {
           Tight(){
               super(10,"Saif");
               System.out.println("Inside Child Constructor ");
               
           }
           public int rollNumber = 100;
           
           public void printDetails() {
               System.out.println("Cool Bro Tight");
           }
           
}
   class Test{
    
    public static void main(String[] args){
        Encapsulation tight=new Tight();
        System.out.println(tight.toString());
    }
    
}
       
        

    
    
    

    
    
    
