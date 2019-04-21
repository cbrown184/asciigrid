package servicetests;

import com.google.inject.Guice;
import com.google.inject.Injector;
import model.Point;
import org.junit.Test;
import services.GridService;
import wiring.AsciiGridModule;

public class GridServiceTests {
  @Test
  public void drawPattern() {
    //pattern made from rectangles
    Injector injector = Guice.createInjector(new AsciiGridModule());
    GridService gridService = injector.getInstance(GridService.class);
    gridService.createGrid(100, 50);
    for (int i = 0; i < 50; i += 2) {
      gridService.drawRec(new Point(0 + i, 0 + i), new Point(99 - i, 49 - i));
    }
    System.out.println(gridService.gridToString());
  }

  @Test
  public void drawOK() {
    Injector injector = Guice.createInjector(new AsciiGridModule());
    GridService gridService = injector.getInstance(GridService.class);
    //Print the word OK
    gridService.createGrid(40, 14);
    gridService.drawSqaure(new Point(10, 1), 10);
    gridService.drawLine(new Point(22, 1), new Point(22, 10));
    gridService.drawLine(new Point(22, 6), new Point(31, 10));
    gridService.drawLine(new Point(22, 6), new Point(31, 1));
    String answer = gridService.gridToString();
    System.out.println(answer);
  }

}
