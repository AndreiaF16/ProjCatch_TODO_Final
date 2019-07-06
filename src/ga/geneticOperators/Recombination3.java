package ga.geneticOperators;

import ga.GeneticAlgorithm;
import ga.IntVectorIndividual;
import ga.Problem;

import java.util.Arrays;


public class Recombination3<I extends IntVectorIndividual, P extends Problem<I>> extends Recombination<I, P> {

    //TODO this class might require the definition of additional methods and/or attributes

    public Recombination3(double probability) {
        super(probability);
    }

    @Override
    public void recombine(I ind1, I ind2) {
        //TODO
        //order 1

        int[] child1=new int[ind1.getNumGenes()];
        int[] child2=new int[ind2.getNumGenes()];

        int crossoverPoint1=GeneticAlgorithm.random.nextInt(ind1.getNumGenes()/2);
        int crossoverPoint2=GeneticAlgorithm.random.nextInt(ind2.getNumGenes());

      //  System.out.println(crossoverPoint1);
       // System.out.println(crossoverPoint2);
        while (crossoverPoint2<=crossoverPoint1){
            crossoverPoint2=GeneticAlgorithm.random.nextInt(ind2.getNumGenes());
        }

        for (int i = 0; i <ind1.getNumGenes(); i++) {
            child1[i]=0;
            child2[i]=0;

        }


        for (int i = crossoverPoint1; i <=crossoverPoint2 ; i++) {
            child1[i]=ind2.getGene(i);
            child2[i]=ind1.getGene(i);
        }

        for (int i = 0; i <ind1.getNumGenes(); i++) {
            int aux=EncontrarZero(child1,crossoverPoint2,crossoverPoint1);
            if(aux!=-1) {
                if (!find(child1, ind1.getGene(i))) {
                    child1[aux] = ind1.getGene(i);
                }
            }else{
                break;
            }

        }
        for (int i = 0; i <ind1.getNumGenes(); i++) {
            int aux=EncontrarZero(child2,crossoverPoint2,crossoverPoint1);
            if(aux!=-1) {
                if (!find(child2, ind2.getGene(i))) {
                    child2[aux] = ind2.getGene(i);
                }
            }else{
                break;
            }
        }

        for (int i = 0; i < ind1.getNumGenes(); i++) {
            ind1.setGene(i,child1[i]);
            ind2.setGene(i,child2[i]);
        }


    }
    public boolean find(int[] child,int value){
        for (int i = 0; i <child.length; i++) {
            if (child[i] == value)
                return true;
        }
        return false;
    }
    public int EncontrarZero(int[] child,int cut2,int cut1){
        for (int i = cut2; i <child.length ; i++) {
            if(child[i]==0)
                return i;
        }
        for (int i = 0; i <cut1 ; i++) {
            if(child[i]==0)
                return i;
        }
        return -1;
    }

    @Override
    public String toString(){
        //TODO
        return  "Recombination 3 - order 1";
//        throw new UnsupportedOperationException();
    }
}