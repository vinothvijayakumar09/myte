package VinothVijayakumar;

import org.testng.TestNG;

public class Testrunner {
	
	static TestNG tesng;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		tesng= new TestNG() ;
		tesng.setTestClasses(new Class[] {Myte.class});
		tesng.run();
		

	}

}
