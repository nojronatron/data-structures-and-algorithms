package stack.and.queue;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

 class BalancedBracketsTest {
   @Test
   void testPairedBracketsReturnsTrue() {
     Boolean expectedResult = true;
     BalancedBrackets sut = new BalancedBrackets();
     Boolean actualResult = sut.IsBalanced("[]");
     assertEquals(expectedResult, actualResult);
   }

   @Test
   void testUnPairedBracketsReturnsFalse() {
     Boolean expectedResult = false;
     BalancedBrackets sut = new BalancedBrackets();
     Boolean actualResult = sut.IsBalanced("[[]");
     assertEquals(expectedResult, actualResult);
   }

   @Test
   void testPairedMixedTypesReturnsTrue() {
     Boolean expectedResult = true;
     BalancedBrackets sut = new BalancedBrackets();
     Boolean actualResult = sut.IsBalanced("[{}]");
     assertEquals(expectedResult, actualResult);
   }

   @Test
   void testUnPairedMixedTypesReturnsTrue() {
     Boolean expectedResult = false;
     BalancedBrackets sut = new BalancedBrackets();
     Boolean actualResult = sut.IsBalanced("[{()]");
     assertEquals(expectedResult, actualResult);
   }

   @Test
   void testPairedAllMixedTypesReturnsTrue() {
     Boolean expectedResult = true;
     BalancedBrackets sut = new BalancedBrackets();
     Boolean actualResult = sut.IsBalanced("[{()}]");
     assertEquals(expectedResult, actualResult);
   }

   @Test
   void testPairedAllMixedTypesInterlacedReturnsTrue() {
     Boolean expectedResult = true;
     BalancedBrackets sut = new BalancedBrackets();
     Boolean actualResult = sut.IsBalanced("[{(})]");
     assertEquals(expectedResult, actualResult);
   }

   @Test
   void testNoInputsEmptyStringReturns() {
     Boolean expectedResult = false;
     BalancedBrackets sut = new BalancedBrackets();
     Boolean actualResult = sut.IsBalanced("");
     assertEquals(expectedResult, actualResult);
   }

 }
