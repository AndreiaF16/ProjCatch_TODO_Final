package ga.geneticOperators;

import ga.GeneticAlgorithm;
import ga.IntVectorIndividual;
import ga.Problem;

public class Recombination2<I extends IntVectorIndividual, P extends Problem<I>> extends Recombination<I, P> {

    //TODO this class might require the definition of additional methods and/or attributes

    public Recombination2(double probability) {
        super(probability);
    }

    private int[] segment1,segment2,child1,child2;

    @Override
    public void recombine(I ind1, I ind2) {
        //TODO
        //throw new IllegalArgumentException();
         child1 = new int[ind2.getNumGenes()];
         child2 = new int[ind2.getNumGenes()];
        int  crossoverPoint1 = GeneticAlgorithm.random.nextInt(ind1.getNumGenes());
        criar_childs(crossoverPoint1,ind1,ind2);


        for (int i = 0; i < child1.length; i++) {
            ind1.setGene(i, child1[i]);
            ind2.setGene(i, child2[i]);
        }

    }


    private void criar_childs (int cut, I ind1,I ind2){
        for (int i = 0; i <= cut; i++) {
            child1[i]=ind1.getGene(i);
            child2[i]=ind2.getGene(i);
        }
        for (int i = cut+1; i < ind1.getNumGenes(); i++) {
            child1[i]=-1;
            child2[i]=-1;
        }

        int genCurrent;
        boolean listo;
        int auxinx=cut+1;

        for (int i = cut+1; i <ind2.getNumGenes() ; i++) {
            genCurrent=ind2.getGene(i);
            if(exists(cut,genCurrent,1)) {
                auxinx--;
            }else{
                child1[auxinx]=genCurrent;
            }
            auxinx++;
        }
        if(!isReady(1)){
            for (int i = 0; i <=cut ; i++) {
                genCurrent=child2[i];
                if(exists(cut,genCurrent,1)){
                    auxinx--;
                }
                else {
                    child1[auxinx]=genCurrent;
                }
                auxinx++;
            }
        }
        auxinx=cut+1;

        for (int i = cut+1; i <ind2.getNumGenes() ; i++) {
            genCurrent=ind1.getGene(i);
            if(exists(cut,genCurrent,2)) {
                auxinx--;
            }else{
                child2[auxinx]=genCurrent;
            }
            auxinx++;
        }
        if(!isReady(2)){
            for (int i = 0; i <=cut ; i++) {
                genCurrent=child1[i];
                if(exists(cut,genCurrent,2)){
                    auxinx--;
                }
                else {
                    child2[auxinx]=genCurrent;
                }
                auxinx++;
            }
        }
    }


    private boolean exists(int cut,int gen,int child){
        switch (child){
            case 1:
                for (int i = 0; i <=cut; i++) {
                    if(gen==child1[i]){
                        return true;
                    }
                }
                break;
            case 2:
                for (int i = 0; i <=cut; i++) {
                    if(gen==child2[i]){
                        return true;
                    }
                }
                break;

        }
        return false;
    }

    private boolean isReady(int child){
        switch (child){
            case 1:
                for (int i = 0; i < child1.length; i++) {
                    if(child1[i]==-1){
                        return false;
                    }
                }
                break;
            case 2:
                for (int i = 0; i < child1.length; i++) {
                    if(child2[i]==-1){
                        return false;
                    }
                }
                break;
        }
        return true;
    }

    @Override
    public String toString(){
        //TODO
        return  "Recombination 2 - One cute";

        //throw new IllegalArgumentException();
    }


}