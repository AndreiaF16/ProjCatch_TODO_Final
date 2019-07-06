package catchBox;

import ga.Problem;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CatchProblemForGA implements Problem<CatchIndividual> {
    //TODO this class might require the definition of additional methods and/or attributes
    public CatchProblemForGA problem;
    public LinkedList<Cell> cellsBoxes;
    public LinkedList<Pair> pairs;
    public Cell cellCatch;
    public Cell door;
    public int size;
    public double probls;

    public CatchProblemForGA(LinkedList<Cell> cellsBoxes,LinkedList<Pair> pairs, Cell cellCatch, Cell door) {
        //TODO
        this.cellsBoxes=cellsBoxes;
        this.pairs=pairs;
        this.cellCatch=cellCatch;
        this.door=door;
    }

    @Override
    public CatchIndividual getNewIndividual() {
        //TODO
      //  throw new IllegalArgumentException();
        return new CatchIndividual(this, cellsBoxes.size());
    }

    @Override
    public String toString() {
        //TODO
       // throw new IllegalArgumentException();
        return "Problema: " + problem + "\n";
    }

    public LinkedList<Cell> getCellsBoxes() {
        return cellsBoxes;
    }

    public void setCellsBoxes(LinkedList<Cell> cellsBoxes) {
        this.cellsBoxes = cellsBoxes;
    }

    public LinkedList<Pair> getPairs() {
        return pairs;
    }

    public void setPairs(LinkedList<Pair> pairs) {
        this.pairs = pairs;
    }

    public Cell getCellCatch() {
        return cellCatch;
    }

    public void setCellCatch(Cell cellCatch) {
        this.cellCatch = cellCatch;
    }

    public Cell getDoor() {
        return door;
    }

    public LinkedList<Cell> getGetcellsBoxes() {
        return cellsBoxes;
    }

    public void setDoor(Cell door) {
        this.door = door;
    }

    public List<Cell> getCellBoxes() {
        return cellsBoxes;
    }
}
