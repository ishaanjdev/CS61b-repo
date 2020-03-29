
public class ClassNameHere {
     public static void drawtriangle(int N) {
      int col = 0;
      int row = 0;
      while (row != N + 1) {
         while (col != row + 1){
              System.out.print('*');
              col = col + 1;
         }
         row = row + 1;
      }
   }
   public static void main(String[] args) {
      System.out.println(drawtriangle(int 5));
      
   }
 
}
