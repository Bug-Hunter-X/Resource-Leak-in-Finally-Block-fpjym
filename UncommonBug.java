public class UncommonBug {
    public static void main(String[] args) {
        int x = 5;
        int y = 0;
        try {
            int z = x / y; //Potential ArithmeticException
            System.out.println(z);
        } catch (ArithmeticException e) {
            System.out.println("Exception caught: " + e.getMessage());
        } finally {
            System.out.println("This always executes");
            //Hidden Bug: Incorrect resource handling
            //If a resource (like a file or network connection) was opened before the try block,
            //it should be closed within the finally block to avoid resource leaks. 
            //Failure to do so can lead to unexpected behavior and system instability.
        }
    }
}