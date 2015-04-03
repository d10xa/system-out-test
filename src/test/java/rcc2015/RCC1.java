package rcc2015;

import java.util.*;

public class RCC1 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      int games = sc.nextInt();

      for (int i = 0; i < games; i++) {
         int n = sc.nextInt();
         int l = sc.nextInt();
         SortedSet<Integer> p1 = readList(sc, n,false);
         SortedSet<Integer> p2 = readList(sc, n,true);
         boolean result = check(l, p1, p2);
         System.out.println(result ? "YES" : "NO");
      }
   }

   private static SortedSet<Integer> readList(Scanner scanner, int count, boolean reversed) {
      SortedSet<Integer> ints = reversed?new TreeSet<Integer>(Collections.reverseOrder()):new TreeSet<Integer>();
      for (int i = 0; i < count; i++) ints.add(scanner.nextInt());
      return ints;
   }

   private static boolean check(int l, SortedSet<Integer> p1, SortedSet<Integer> p2) {
      int count1 = count(l, p1);
      int count2 = count(l,p2);
      return count1>count2;
   }

   private static int count(int l, SortedSet<Integer> set) {
      int count = 0;
      Iterator<Integer> iterator = set.iterator();
      for (int i = 0; i < l; i++) count += iterator.next();
      return count;
   }

}
