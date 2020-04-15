package application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;



/**
 * This class tests the Matrix
 * 
 * @author Houming Chen
 *
 */
public class MatrixTest {
  
  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }
  
  
  /**
   * Test the constructor and getEntry
   */
  @Test
  public void test000_constructor_and_getEntry() {
    try {
      MatrixADT matrix = new Matrix(new int[][] {{-1, 0, 1}, {2, 3, 4}});
      assertEquals(-1, matrix.getEntry(0, 0).toInteger());
      assertEquals(0, matrix.getEntry(0, 1).toInteger());
      assertEquals(1, matrix.getEntry(0, 2).toInteger());
      assertEquals(2, matrix.getEntry(1, 0).toInteger());
      assertEquals(3, matrix.getEntry(1, 1).toInteger());
      assertEquals(4, matrix.getEntry(1, 2).toInteger());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  /**
   * Test addition
   */
  @Test
  public void test001_addition() {
    try {
      MatrixADT matrix1 = new Matrix(new int[][] {{-1, 0, 1}, {2, 3, 4}});
      MatrixADT matrix2 = new Matrix(new int[][] {{-1, 0, -1}, {-4, 0, 10}});
      MatrixADT expectedMatrix = new Matrix(new int[][] {{-2, 0, 0}, {-2, 3, 14}});
      MatrixADT sumMatrix = matrix1.add(matrix2);
      assertEquals(expectedMatrix.toString(), sumMatrix.toString());
      sumMatrix = matrix1.add(matrix2);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Test subtraction
   */
  @Test
  public void test002_subtraction() {
    try {
      MatrixADT matrix1 = new Matrix(new int[][] {{-1, 0, 1}, {2, 3, 4}});
      MatrixADT matrix2 = new Matrix(new int[][] {{-1, 0, -1}, {-4, 0, 10}});
      MatrixADT expectedMatrix = new Matrix(new int[][] {{0, 0, 2}, {6, 3, -6}});
      MatrixADT differenceMatrix = matrix1.subtract(matrix2);
      assertEquals(expectedMatrix.toString(), differenceMatrix.toString());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  /**
   * Test multiplication
   */
  @Test
  public void test003_multiplication() {
    try {
      MatrixADT matrix1 = new Matrix(new int[][] {{1, 2}, {-4, 0}, {0, -6}});
      MatrixADT matrix2 = new Matrix(new int[][] {{4, 3, 0}, {-2, 0, -5}});
      MatrixADT expectedMatrix = new Matrix(new int[][] {{0, 3, -10}, {-16, -12, 0}, {12, 0, 30}});
      MatrixADT productMatrix = matrix1.multiply(matrix2);
      assertEquals(expectedMatrix.toString(), productMatrix.toString());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}