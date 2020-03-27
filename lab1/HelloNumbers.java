public class HelloNumbers {
    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        System.out.print(x + " ");
        while (x < 10) {
            y = y + x;
            System.out.print(y + " ");
            x = x + 1;
        }
    }
}