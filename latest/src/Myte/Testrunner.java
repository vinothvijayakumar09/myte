package Myte;

import org.testng.TestNG;

public class Testrunner {
  static TestNG tesng;
  
  public static void main(String[] args) {
    tesng = new TestNG();
    tesng.setTestClasses(new Class[] { MyteFinal.class });
    tesng.run();
  }
}
