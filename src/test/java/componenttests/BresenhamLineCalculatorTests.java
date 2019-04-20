package componenttests;

import components.impl.BresenhamLineCalculator;
import model.Point;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class BresenhamLineCalculatorTests {

    BresenhamLineCalculator bresenhamLineCalculator = new BresenhamLineCalculator();

    @Test
    public void horizontalLineTestRight(){
        Point a = new Point(0,0);
        Point b = new Point(3, 0);
        List<Point> line = bresenhamLineCalculator.calculateLine(a, b);
        Assert.assertEquals(4, line.size());
        Assert.assertEquals(new Point(0, 0), line.get(0));
        Assert.assertEquals(new Point(1, 0), line.get(1));
        Assert.assertEquals(new Point(2, 0), line.get(2));
        Assert.assertEquals(new Point(3, 0), line.get(3));
    }

    @Test
    public void horizontalLineTestLeft(){
        Point a = new Point(0,0);
        Point b = new Point(-3, 0);
        List<Point> line = bresenhamLineCalculator.calculateLine(a, b);
        Assert.assertEquals(4, line.size());
        Assert.assertEquals(new Point(0, 0), line.get(0));
        Assert.assertEquals(new Point(-1, 0), line.get(1));
        Assert.assertEquals(new Point(-2, 0), line.get(2));
        Assert.assertEquals(new Point(-3, 0), line.get(3));
    }

    @Test
    public void verticalLinetestUp(){
        Point a = new Point(0,0);
        Point b = new Point(0, 3);
        List<Point> line = bresenhamLineCalculator.calculateLine(a, b);
        Assert.assertEquals(4, line.size());
        Assert.assertEquals(new Point(0, 0), line.get(0));
        Assert.assertEquals(new Point(0, 1), line.get(1));
        Assert.assertEquals(new Point(0, 2), line.get(2));
        Assert.assertEquals(new Point(0, 3), line.get(3));
    }

    @Test
    public void verticalLinetestDown(){
        Point a = new Point(0,0);
        Point b = new Point(0, -3);
        List<Point> line = bresenhamLineCalculator.calculateLine(a, b);
        Assert.assertEquals(4, line.size());
        Assert.assertEquals(new Point(0, 0), line.get(0));
        Assert.assertEquals(new Point(0, -1), line.get(1));
        Assert.assertEquals(new Point(0, -2), line.get(2));
        Assert.assertEquals(new Point(0, -3), line.get(3));
    }

}
