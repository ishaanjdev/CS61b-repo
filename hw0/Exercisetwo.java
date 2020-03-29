public class Exercisetwo {
    /** Returns the maximum value from m. */
    public static int max(int[] m) {
        int l = m.length;
        int counter = 1;
        int highest = m[0];
        while (l>+ counter){
        	if (m[counter]>highest) {
        		highest = m[counter];
        	}
        	counter = counter + 1;
        }
    return highest;
    } 
    public static void main(String[] args) {
       int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
       System.out.println(max(numbers));
    }
}