package java9.diff.app1;

import static org.junit.Assert.*;
import org.junit.Test;
import static java9.diff.app1.TestUtils.*;

public class MainTest {
	@Test
	public void testSalesTaxCalculation() throws Exception{
		String value=Main.salesTaxCalculation(9315.00);
		yakshaAssert(currentTest(),(value.equals("886.12")?"true":"false"),businessTestFile);
	}
	@Test
    public void testExceptionConditon() throws Exception{
	 yakshaAssert(currentTest(),true,boundaryTestFile);
      }

	@Test
	public void testBoundaryCondition() throws Exception {
	  yakshaAssert(currentTest(),true,exceptionTestFile);
   }


}
