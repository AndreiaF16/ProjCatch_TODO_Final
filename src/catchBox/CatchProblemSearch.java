package catchBox;

import agentSearch.Problem;
import agentSearch.Action;

import java.util.LinkedList;
import java.util.List;

public class CatchProblemSearch<S extends CatchState> extends Problem<S> {
    //TODO this class might require the definition of additional methods and/or attributes
    private Cell goalPos;
    private List<Action> actions;

    public CatchProblemSearch(S initialCatchState, Cell goalPosition) {
        super(initialCatchState);
        actions = new LinkedList<Action>() {{
            add(new ActionDown());
            add(new ActionUp());
            add(new ActionRight());
            add(new ActionLeft());
        }};
        this.goalPos = goalPosition;


        //TODO
       // throw new IllegalArgumentException();
    }

    @Override
    public List<S> executeActions(S state) {
        //TODO
       // throw new IllegalArgumentException();
        List<S> successors  = new LinkedList<>();
        for(Action action: actions){
            if(action.isValid(state)){
                S sucessor = (S) state.clone();
                action.execute(sucessor);
                successors.add(sucessor);
            }

        }
        return successors;
    }

    public boolean isGoal(S state) {
        //TODO
      // throw new IllegalArgumentException();
        int line = state.getLineCatch();
        int column = state.getColumnCatch();
        if(line == goalPos.getLine() && column==goalPos.getColumn()){
            return true;
        }
       return false;


    }

    public double computePathCost(List<Action> path) {
        return path.size();
    }

    public Cell getGoalPos() {
        return goalPos;
    }
}

