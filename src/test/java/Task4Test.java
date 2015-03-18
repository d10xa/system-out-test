import org.junit.Test;
import ru.d10xa.testio.TestIO;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class Task4Test extends TestIO {

    File file = new File("src/test/resources/task4_input.txt");

    @Test(timeout = 60L)
    public void test60() throws Exception {
        System.setIn(new BufferedInputStream(new FileInputStream(file), 10000));
        Task4.main(null);
        assertOutput("3533");
    }

    @Test(timeout = 66L)
    public void test66() throws Exception {
        System.setIn(new BufferedInputStream(new FileInputStream(file), 10000));
        Task4.main(null);
        assertOutput("3533");
    }

    @Test(timeout = 50)
    public void test50() throws Exception {
        System.setIn(new BufferedInputStream(new FileInputStream(file), 10000));
        Task4.main(null);
        assertOutput("3533");
    }

    @Test(timeout = 55)
    public void test55() throws Exception {
        System.setIn(new BufferedInputStream(new FileInputStream(file), 10000));
        Task4.main(null);
        assertOutput("3533");
    }

    @Test(timeout = 52)
    public void test52() throws Exception {
        System.setIn(new BufferedInputStream(new FileInputStream(file), 10000));
        Task4.main(null);
        assertOutput("3533");
    }


}
