
import junit.framework.TestSuite;
import junit.framework.TestCase;

import java.io.*;

public class LibTest extends TestCase {
	static String programmeATester = "Lib";
	Process executionProgrammeATester;
	BufferedReader ecranProgrammeATester;
	BufferedWriter clavierProgrammeATester;

	String finDeLigne = System.getProperty("line.separator");

	public static void main(String[] args) {
		if (args.length > 0) {
			programmeATester = args[0];
		}
		System.out.println("Tests du programme : " + programmeATester);
		junit.textui.TestRunner.run(new TestSuite(LibTest.class));
	}

	protected void setUp() throws IOException {
		executionProgrammeATester = Runtime.getRuntime().exec("java.exe -cp .;bin " + programmeATester);
		ecranProgrammeATester = new BufferedReader(new InputStreamReader(executionProgrammeATester.getInputStream()));
		clavierProgrammeATester = new BufferedWriter(new OutputStreamWriter(executionProgrammeATester.getOutputStream()));
	}

	public void test_ligne1() throws IOException {
		String expected = "Coucou monde";
		assertEquals("Affiche : ",expected, Lib.coucou());
	}

} // fin class