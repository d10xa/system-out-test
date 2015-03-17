import org.junit.ComparisonFailure;
import org.junit.Test;
import ru.d10xa.testio.TestIO;

public class StaticMethodArgsTest extends TestIO {

   private static void main(String... args) {
      for (String arg : args) {
         System.out.println(">"+arg+"<");
      }
   }

   @Test
   public void method_arguments_test() throws Exception {
      StaticMethodArgsTest.main("hello","world");
      assertOutput(">hello<",">world<");
   }

   @Test(expected = ComparisonFailure.class)
   public void fail() throws Exception {
      StaticMethodArgsTest.main("hello","world");
      assertOutput("hello","world");
   }

}
