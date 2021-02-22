package Junit;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;


public class MainTest {

   @Test
   public void testAdd() {
      String str = "JUnit is working fine";
      assertEquals("JUnit is working fine",str);
   }
}