package rcc2015;

import org.junit.Test;
import ru.d10xa.testio.TestIO;


public class RCC1Test extends TestIO {

   @Test
   public void test() throws Exception {
      setIn("2" ,
            "3 1" ,
            "2 4 6" ,
            "1 3 5" ,
            "2 2" ,
            "1 6" ,
            "2 3");
      RCC1.main(new String[]{});
      assertOutput("NO" ,
            "YES");
   }

   @Test
   public void test2() throws Exception {
      setIn("4\n" +
            "3 1\n" +
            "2 4 6\n" +
            "1 3 5\n" +
            "3 1\n" +
            "2 4 6\n" +
            "1 3 5\n" +
            "3 1\n" +
            "2 4 6\n" +
            "1 3 5\n" +
            "2 2\n" +
            "1 6\n" +
            "2 3");
      RCC1.main(new String[]{});
      assertOutput("NO" +
            "YES");
   }

}
