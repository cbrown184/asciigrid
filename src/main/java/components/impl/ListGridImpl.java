package components.impl;


import components.ListGrid;

import java.util.ArrayList;
import java.util.List;

public class ListGridImpl<T> implements ListGrid<T> {

    private List<List<T>> grid = new ArrayList<>();

    @Override
    public  List<List<T>> getGrid(){
        return grid;
    }


    @Override
    public void setNewGrid(int sizeX, int sizeY, T defaultValue) {
        grid = new ArrayList<>();
        for(int x = 0; x < sizeX; x++){
            grid.add(new ArrayList<T>());
            for(int y = 0; y < sizeY; y++)
                grid.get(x).add(defaultValue);
        }
    }


    @Override
    public T getGridSquare(int x, int y) {
        return grid.get(x).get(y);
    }

    @Override
    public void setGridSquare(int x, int y, T t) {
        grid.get(x).set(y, t);
    }

    @Override
    public int noGridSquares() {
        return (int) grid.stream().mapToLong(List::size).sum();
    }


}
