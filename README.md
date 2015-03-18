# system-out-test
```java
public static void main(String... args) {
  for (String arg : args) {
     System.out.println(">"+arg+"<");
  }
}

@Test
public void test() {
  ClassWithMainMethod.main("hello","world");
  assertOutput(">hello<",">world<");
}
```
