import org.junit.Test;
import ru.d10xa.testio.TestIO;

public class Task3Test extends TestIO {

    @Test
    public void test(){
        setIn("yv66vgAAADMANQoADAAeCQALAB8KAAkAIAkAIQAiCgAjACQHACUIACYKAAYAJwcA\n" +
                "KAoACQApBwAqBwArAQAVb25seU9uZUV4ZWN1dGlvbkd1YXJkAQArTGphdmEvdXRp\n" +
                "bC9jb25jdXJyZW50L2F0b21pYy9BdG9taWNCb29sZWFuOwEABjxpbml0PgEAAygp\n" +
                "VgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBABJMb2NhbFZhcmlhYmxlVGFibGUB\n" +
                "AAR0aGlzAQAfTHJ1L2NmdC9vbHltcC9wcm9ibGVtMy9TYW1wbGUxOwEABG1haW4B\n" +
                "ABYoW0xqYXZhL2xhbmcvU3RyaW5nOylWAQAEYXJncwEAE1tMamF2YS9sYW5nL1N0\n" +
                "cmluZzsBAA1TdGFja01hcFRhYmxlAQAIPGNsaW5pdD4BAApTb3VyY2VGaWxlAQAM\n" +
                "U2FtcGxlMS5qYXZhDAAPABAMAA0ADgwALAAtBwAuDAAvADAHADEMADIAMwEAGmph\n" +
                "dmEvbGFuZy9SdW50aW1lRXhjZXB0aW9uAQAaT25seSBvbmUgZXhlY3V0aW9uIGFs\n" +
                "bG93ZWQMAA8AMwEAKWphdmEvdXRpbC9jb25jdXJyZW50L2F0b21pYy9BdG9taWNC\n" +
                "b29sZWFuDAAPADQBAB1ydS9jZnQvb2x5bXAvcHJvYmxlbTMvU2FtcGxlMQEAEGph\n" +
                "dmEvbGFuZy9PYmplY3QBAA1jb21wYXJlQW5kU2V0AQAFKFpaKVoBABBqYXZhL2xh\n" +
                "bmcvU3lzdGVtAQADb3V0AQAVTGphdmEvaW8vUHJpbnRTdHJlYW07AQATamF2YS9p\n" +
                "by9QcmludFN0cmVhbQEAB3ByaW50bG4BABUoTGphdmEvbGFuZy9TdHJpbmc7KVYB\n" +
                "AAQoWilWACEACwAMAAAAAQAKAA0ADgAAAAMAAQAPABAAAQARAAAALwABAAEAAAAF\n" +
                "KrcAAbEAAAACABIAAAAGAAEAAAAPABMAAAAMAAEAAAAFABQAFQAAAAkAFgAXAAEA\n" +
                "EQAAAGIAAwABAAAAIrIAAgMEtgADmQAPsgAEKgMytgAFpwANuwAGWRIHtwAIv7EA\n" +
                "AAADABIAAAASAAQAAAATAAsAFAAXABYAIQAYABMAAAAMAAEAAAAiABgAGQAAABoA\n" +
                "AAAEAAIXCQAIABsAEAABABEAAAAkAAMAAAAAAAy7AAlZA7cACrMAArEAAAABABIA\n" +
                "AAAGAAEAAAAQAAEAHAAAAAIAHQ==\n");
        Task3.main(new String[]{"param1","param2"});
        assertOutput("param1","param2");
    }
//   @Test
//   public void inputStream_one_line(){
//      setIn("hello\nworld");
//      Task3Test.main(null);
//      assertOutput("hello","world");
//   }
//
//   @Test
//   public void inputStream_array(){
//      setIn("hello","world");
//      Task3Test.main(new String[]{});
//      assertOutput("hello","world");
//   }
//
//   @Test(expected = ComparisonFailure.class)
//   public void fail(){
//      setIn("HELLO","WORLD");
//      Task3Test.main(new String[]{});
//      assertOutput("hello","world");
//   }

}
