public class Exercise2 {
    /** Returns the maximum value from m. */
    public static int max(int[] m) {
        int l = m.length
        int counter = 1
        int highest = m[0]
        while (length >= counter){
        	if m[counter]>m[0]{
        		highest = m[counter]
        	}
        	counter = counter + 1
        }
    return highest
    } 
    public static void main(String[] args) {
       int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
       max(numbers)      
    }
}