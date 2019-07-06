package catchBox;

import agentSearch.Heuristic;


public class HeuristicCatch extends Heuristic<CatchProblemSearch, CatchState> {

    @Override
    public double compute(CatchState state) {
        //TODO
       return state.distancia(problem.getGoalPos().getLine(),problem.getGoalPos().getColumn() );

     // throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        //TODO
        return "Distancia entre o carrinho e o objetivo" + "\n";
      //  throw new IllegalArgumentException();
    }
}