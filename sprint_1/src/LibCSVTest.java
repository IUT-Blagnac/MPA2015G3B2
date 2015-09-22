import java.io.IOException;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class LibCSVTest extends TestCase {

	String finDeLigne = System.getProperty("line.separator");

	public static void main(String[] args) {
	    junit.textui.TestRunner.run(new TestSuite(LibCSVTest.class));
	}

	public void test_read_preconditions() throws IOException {
		String file = "csv/test.txt";
		
	    boolean exception = false ;
	    try { LibCSV.readAll(file) ; }
	    catch (Exception e) { exception = true ; };

	    assertTrue("LibCSV.read("+file+") leve une exception", exception);
	}

	public void test_save_preconditions() throws IOException {
		String file = "csv/test.csv";
	    boolean exception = false ;
	    try { LibCSV.save(null,file) ; }
	    catch (Exception e) { exception = true ; };

	    assertTrue("LibCSV.save(null, file) leve une exception", exception);
	    
	    file = "csv/test.txt";
		Object[][] ob = new Object[0][0];

	    exception = false ;
	    try { LibCSV.save(ob,file) ; }
	    catch (Exception e) { exception = true ; };

	    assertTrue("LibCSV.save(vec, "+file+") leve une exception", exception);
	}
}
