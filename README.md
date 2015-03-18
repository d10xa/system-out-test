# system-out-test

## test with method arguments

```java
public static void main(String... args) {
  for (String arg : args) {
     System.out.println(">"+arg+"<");
  }
}

@Test
public void test_with_method_arguments() {
  Foo.main("hello","world");
  assertOutput(">hello<",">world<");
}
```
## test with System.in

```java
public static void main(String[] args) {
   Scanner scanner = new Scanner(System.in);
   while (scanner.hasNext()){
      System.out.println(scanner.nextLine());
   }
}

@Test
public test_with_system_in(){
   setIn("hello","world");
   Bar.main(null);
   assertOutput("hello","world");
}
```
