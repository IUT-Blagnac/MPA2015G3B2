package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class HelloMondeTest extends TestCase {
  static String programmeATester = "lib.HelloMonde" ;
  Process executionProgrammeATester ;
  BufferedReader ecranProgrammeATester ;
  BufferedWriter clavierProgrammeATester ;

  String finDeLigne = System.getProperty("line.separator") ;

  public static void main(String[] args) {
    if ( args.length > 0 ) { programmeATester = args[0] ; }
    System.out.println("Tests du programme : " + programmeATester);
    junit.textui.TestRunner.run(new TestSuite(HelloMondeTest.class));
  }

  protected void setUp() throws IOException {
        //executionProgrammeATester = Runtime.getRuntime().exec("\"c:\\Program Files\\Java\\jre7\\bin\\java.exe\" -cp U:\\E\\MPA\\projet\\workspace\\G0A1\\bin "+programmeATester);
        //executionProgrammeATester = Runtime.getRuntime().exec("java.exe -cp U:\\E\\MPA\\projet\\workspace\\G0A1\\bin "+programmeATester);
        executionProgrammeATester = Runtime.getRuntime().exec("java.exe -cp .;bin "+programmeATester);
    ecranProgrammeATester = new BufferedReader(new  InputStreamReader( executionProgrammeATester.getInputStream() ));
    clavierProgrammeATester  = new BufferedWriter(new OutputStreamWriter( executionProgrammeATester.getOutputStream() ));
  }

  public void test_ligne1() throws IOException {
      String expected = "[DUT/INFO/S3]";
      assertEquals("Affiche : "+expected,expected,ecranProgrammeATester.readLine());
      assertTrue("Seconde ligne'",ecranProgrammeATester.readLine() instanceof String);
      assertTrue("Troisi�me ligne'",ecranProgrammeATester.readLine()instanceof String);
      assertTrue("Quatri�me ligne'",ecranProgrammeATester.readLine()instanceof String);
  }

  public void test_ligne2() throws IOException {
      assertTrue("Seconde ligne'",ecranProgrammeATester.readLine() instanceof String);
      String expected = "Hello Monde !";
      assertEquals("Affiche : "+expected,expected,ecranProgrammeATester.readLine());
      assertTrue("Troisi�me ligne'",ecranProgrammeATester.readLine()instanceof String);
      assertTrue("Quatri�me ligne'",ecranProgrammeATester.readLine()instanceof String);
  }

  public void test_ligne3() throws IOException {
      assertTrue("Seconde ligne'",ecranProgrammeATester.readLine() instanceof String);
      assertTrue("Troisi�me ligne'",ecranProgrammeATester.readLine()instanceof String);
      String expected = "depuis Blagnac.";
      assertEquals("Affiche : "+expected,expected,ecranProgrammeATester.readLine());
      assertTrue("Quatri�me ligne'",ecranProgrammeATester.readLine()instanceof String);
  }
  
  public void test_ligne4() throws IOException {
      assertTrue("Seconde ligne'",ecranProgrammeATester.readLine() instanceof String);
      assertTrue("Troisi�me ligne'",ecranProgrammeATester.readLine()instanceof String);
      assertTrue("Quatri�me ligne'",ecranProgrammeATester.readLine()instanceof String);
      String expected = "Coucou monde";
      assertEquals("Affiche : "+expected,expected,ecranProgrammeATester.readLine());
      
  }

} // fin class