package ga.geneticOperators;

import ga.GeneticAlgorithm;
import ga.IntVectorIndividual;
import ga.Problem;


public class Mutation2<I extends IntVectorIndividual, P extends Problem<I>> extends Mutation<I, P> {

    public Mutation2(double probability) {
        super(probability);
    }

    @Override
    public void mutate(I ind) {
        //TODO
        // throw new IllegalArgumentException();
        //inversion Mutation
        //ja foi corrigido, esta bem

        int random1 = GeneticAlgorithm.random.nextInt(ind.getNumGenes());
        int random2 = GeneticAlgorithm.random.nextInt(ind.getNumGenes());
        while (random1 >= random2) {
            random1 = GeneticAlgorithm.random.nextInt(ind.getNumGenes());
            random2 = GeneticAlgorithm.random.nextInt(ind.getNumGenes());
        }
        int meio = (random1 + random2 + 1) / 2;
        int endCount = random2;
        for (int j = random1; j < meio; j++) {
            int auxiliar = ind.getGene(j);

            ind.setGene(j, ind.getGene(endCount));
            ind.setGene(endCount, auxiliar);
            endCount--;

        }

    }

    @Override
    public String toString() {
        //TODO
        return "Mutation 2 - Inversion Mutation ";
    }
}