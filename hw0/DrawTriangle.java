
public class DrawTriangle {
      public static void drawtriangle(int N) {
        int col = 0;
        
           while (col != N) {
                System.out.print('*');
                col = col + 1;
           }
        System.out.println();
     } 
      public static void main(String[] args) {
          int test = 10;
          int counter = 1;
          while (counter < test){
            drawtriangle(counter);
            counter = counter + 1;

          }
      }
 
}
