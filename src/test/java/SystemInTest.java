import org.junit.ComparisonFailure;
import org.junit.Test;
import ru.d10xa.testio.TestIO;

import java.util.Scanner;

public class SystemInTest extends TestIO {

   private static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      while (scanner.hasNext()){
         System.out.println(scanner.nextLine());
      }
   }

   @Test
   public void inputStream_one_line() throws Exception {
      setIn("hello\nworld");
      SystemInTest.main(null);
      assertOutput("hello","world");
   }

   @Test
   public void inputStream_array() throws Exception {
      setIn("hello","world");
      SystemInTest.main(new String[]{});
      assertOutput("hello","world");
   }

   @Test(expected = ComparisonFailure.class)
   public void fail() throws Exception {
      setIn("HELLO","WORLD");
      SystemInTest.main(new String[]{});
      assertOutput("hello","world");
   }

}
