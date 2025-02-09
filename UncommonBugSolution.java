public class UncommonBugSolution {
    public static void main(String[] args) {
        int x = 5;
        int y = 0;
        java.io.BufferedReader br = null; //Simulate Resource
        try {
            br = new java.io.BufferedReader(new java.io.FileReader("test.txt")); //Open resource
            int z = x / y; //Potential ArithmeticException
            System.out.println(z);
        } catch (ArithmeticException | java.io.IOException e) {
            System.out.println("Exception caught: " + e.getMessage());
        } finally {
            System.out.println("This always executes");
            if (br != null) { //Avoid nullpointerException
                try {
                    br.close(); //Proper Resource Closure
                } catch (java.io.IOException e) {
                    System.err.println("Error closing resource: " + e.getMessage());
                }
            }
        }
    }
}