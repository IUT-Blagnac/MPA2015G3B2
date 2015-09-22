import java.io.FileInputStream;
import java.io.IOException;
import java.util.Vector;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class LibCSVTest extends TestCase {

	String finDeLigne = System.getProperty("line.separator");
	String file = "csv/test.txt";

	public static void main(String[] args) {
	    junit.textui.TestRunner.run(new TestSuite(LibCSVTest.class));
	}

	public void test_read_preconditions() throws IOException {
	    
		try {
			FileInputStream fw = new FileInputStream(file);
			fw.close();
		}catch (Exception e){}

	    boolean exception = false ;
	    try { LibCSV.read(file) ; }
	    catch (Exception e) { exception = true ; };

	    assertTrue("LibCSV.read("+file+") leve une exception", exception);
	}

	public void test_save_preconditions() throws IOException {
	    
	    boolean exception = false ;
	    try { LibCSV.save(null,file) ; }
	    catch (Exception e) { exception = true ; };

	    assertTrue("LibCSV.save(null, file) leve une exception", exception);

	    file = "test.txt";
		Vector<String[]> vec = new Vector<String[]>();

	    exception = false ;
	    try { LibCSV.save(vec,file) ; }
	    catch (Exception e) { exception = true ; };

	    assertTrue("LibCSV.save(vec, "+file+") leve une exception", exception);
	}
}
