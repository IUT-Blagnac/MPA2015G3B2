import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class LibCSVTest extends TestCase {
	static int totalAssertions = 0;
	static int bilanAssertions = 0;
	
	String finDeLigne = System.getProperty("line.separator");
	
	public static void main(String[] args) {
	    junit.textui.TestRunner.run(new TestSuite(LibCSVTest.class));
	    if (bilanAssertions == totalAssertions) { System.out.print("Bravo !"); }
	    else  { System.out.print("OUPS !"); }
	    System.out.println(" "+bilanAssertions+"/"+totalAssertions+" assertions verifiees");
	}
	
	public void test_read_preconditions() throws IOException {
	    String file = "test.txt";
	    
		try {
			FileInputStream fw = new FileInputStream(file);
			fw.close();
		}catch (Exception e){}
		
	    boolean exception = false ;
	    try { LibCSV.read(file) ; }
	    catch (Exception e) { exception = true ; };
	    
	    totalAssertions++ ;
	    assertTrue("LibCSV.read("+file+") leve une exception", exception);
	    bilanAssertions++ ;
	}
	
	public void test_save_preconditions() throws IOException {
	    String file = "test.csv";
	    
	    boolean exception = false ;
	    try { LibCSV.save(null,file) ; }
	    catch (Exception e) { exception = true ; };
	    
	    totalAssertions++ ;
	    assertTrue("LibCSV.save(null, file) leve une exception", exception);
	    bilanAssertions++ ;
	    
	    file = "test.txt";
		ArrayList<String[]> al = new ArrayList<String[]>();
		
	    exception = false ;
	    try { LibCSV.save(al,file) ; }
	    catch (Exception e) { exception = true ; };
	    
	    totalAssertions++ ;
	    assertTrue("LibCSV.save(al, "+file+") leve une exception", exception);
	    bilanAssertions++ ;
	}
	
}
