package ru.d10xa.testio;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import java.io.*;
import java.nio.charset.StandardCharsets;

public abstract class TestIO {

   final PrintStream systemOut;
   final InputStream systemIn;

   ByteArrayOutputStream baos;

   public TestIO() {
      this.systemOut = System.out;
      this.systemIn = System.in;
   }

   @Before
   public void init(){
      baos = new ByteArrayOutputStream();
      System.setOut(new PrintStream(baos));
   }

   @After
   public void after(){
      System.out.flush();
      restoreSystemStreams();
      systemOut.println(baos.toString());
   }

   protected void setIn(String... in){
      StringBuilder sb = new StringBuilder();
      for (String s : in) {
         sb.append(s).append(String.format("%n"));
      }
      System.setIn(toInputStream(sb.toString()));
   }

   public void assertOutput(String... string) {
      StringBuilder sb = new StringBuilder();
      for (String s : string) {
         sb.append(s).append("%n");
      }
      String expected = String.format(sb.toString());
      String actual = null;
      try {
          actual = baos.toString("UTF-8");
      } catch (UnsupportedEncodingException e) {
          throw new RuntimeException(e);
      }
      Assert.assertEquals(expected, actual);
   }

   public InputStream toInputStream(String str){
      return new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
   }

   private void restoreSystemStreams(){
      System.setIn(systemIn);
      System.setOut(systemOut);
   }

}
