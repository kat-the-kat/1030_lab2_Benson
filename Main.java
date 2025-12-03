import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      
      boolean[] chptList = new boolean[16]; // Valid chapters are 1-15. Element 0 unused.
      int includeChpt;
      int i, j;
      
      // Get the chapter selections
      for (i = 1; i <= 15; ++i) {
         includeChpt = scnr.nextInt(); 
         chptList[i] = (includeChpt == 1);
      }
      
      /* Type your code here. */
      
      boolean anySelected = false;
      
      i = 1;
      while (i <= 15) {
         if (chptList[i]) {
            anySelected = true;

            // Check if a range of 3+ begins at i
            if (i <= 13 && chptList[i] && chptList[i+1] && chptList[i+2]) {
               // We found at least 3 in a row; extend the range
               int start = i;
               int end = i + 2;

               // Extend the range as far as consecutive trues go
               while (end + 1 <= 15 && chptList[end + 1]) {
                  end++;
               }

               System.out.print(start + "-" + end + " ");

               // Skip i ahead to end of the range
               i = end + 1;
            }
            else {
               // Single chapter
               System.out.print(i + " ");
               i++;
            }
         }
         else {
            i++;
         }
      }

      if (!anySelected) {
         System.out.print("None ");
      }

      System.out.println();
   }
}
