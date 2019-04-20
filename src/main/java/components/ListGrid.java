package components;


import java.util.List;

public interface ListGrid <T>{
    public void setNewGrid(int sizeX, int sizeY, T defaultValue);
    public T getGridSquare(int x, int y);
    public void setGridSquare(int x, int y, T t);
    public int noGridSquares();
    public List<List<T>> getGrid();
}
