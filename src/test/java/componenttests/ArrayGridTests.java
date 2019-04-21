package componenttests;

import components.impl.ListGridImpl;
import exceptions.GridOutOfBoundsException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class ArrayGridTests {


  @Test
  public void createArrayHasExpectedNumberOfElements() {
    ListGridImpl grid = new ListGridImpl();
    Assert.assertEquals(0, grid.noGridSquares());
    grid.setNewGrid(1, 1, false);
    Assert.assertEquals(1, grid.noGridSquares());
    grid.setNewGrid(1, 100, false);
    Assert.assertEquals(100, grid.noGridSquares());
    grid.setNewGrid(100, 1, false);
    Assert.assertEquals(100, grid.noGridSquares());
    grid.setNewGrid(100, 100, false);
    Assert.assertEquals(10000, grid.noGridSquares());
    grid.setNewGrid(0, 1, false);
    Assert.assertEquals(0, grid.noGridSquares());
    grid.setNewGrid(1, 0, false);
    Assert.assertEquals(0, grid.noGridSquares());
  }

  @Test
  public void listGridDefaultElementsAreCorrect() {
    //Given a type and default value
    ListGridImpl<Integer> grid = new ListGridImpl<>();
    grid.setNewGrid(100, 100, 1);
    //Then there should be 10,000 grid squares which are equal to 1
    Assert.assertEquals(10000, grid.noGridSquares());
    grid.getGrid().stream().flatMap(List::stream).forEach(
        integer -> Assert.assertEquals(Integer.valueOf(1), integer));
  }

  @Test(expected = java.lang.IndexOutOfBoundsException.class)
  public void gridOutOfBounceExceptionisThrownXAxis() throws GridOutOfBoundsException {
    ListGridImpl grid = new ListGridImpl();
    grid.setNewGrid(1, 1, null);
    grid.getGridSquare(1, 0);
  }

  @Test(expected = java.lang.IndexOutOfBoundsException.class)
  public void gridOutOfBounceExceptionisThrownYAxis() throws GridOutOfBoundsException {
    ListGridImpl grid = new ListGridImpl();
    grid.setNewGrid(1, 1, null);
    grid.getGridSquare(0, 1);
  }
}
