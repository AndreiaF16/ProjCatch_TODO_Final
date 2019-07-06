package ga.geneticOperators;

import ga.GeneticAlgorithm;
import ga.IntVectorIndividual;
import ga.Problem;


public class Mutation3<I extends IntVectorIndividual, P extends Problem<I>> extends Mutation<I, P> {

    public Mutation3(double probability) {
        super(probability);
    }

    @Override
    public void mutate(I ind) {
        //TODO
       // throw new IllegalArgumentException();
        //swap mutation
        int random1= GeneticAlgorithm.random.nextInt(ind.getNumGenes());
        int random2= GeneticAlgorithm.random.nextInt(ind.getNumGenes());

       // while(random1 ==random2){
          //  random2= GeneticAlgorithm.random.nextInt(ind.getNumGenes());
     //   }

            int aux = ind.getGene(random1);
            ind.setGene(random1, ind.getGene(random2));
            ind.setGene(random2, aux);


    }

    @Override
    public String toString() {
        //TODO
        return "Swap Mutation ";
    }
}