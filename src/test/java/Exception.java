public class Exception extends Throwable {
    
    public static  int a;
    public static void main(String[] args){

        try{
            int a[]=new int[5];
            a[5]=30/0;
        }
        
//        catch(ArrayIndexOutOfBoundsException e)
//        {
//            System.out.println("ArrayIndexOutOfBounds Exception occurs");
//        }
//        catch(ArithmeticException e)
//        {
//            System.out.println("Arithmetic Exception occurs");
//        }
        finally {
            System.out.println("Arthmetic Eception");
        }
        System.out.println("rest of the code");
    }
}
