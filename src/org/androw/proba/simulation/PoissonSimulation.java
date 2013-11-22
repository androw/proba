package org.androw.proba.simulation;

/**
 * Project: Probabilite
 * User: Androw
 * Date: 27/09/13
 * Time: 18:51
 * Created with IntelliJ IDEA.
 */
public class PoissonSimulation extends Simulation {
    private double lambda;

    public PoissonSimulation(double lambda) {
        super("Poisson");
        this.lambda = lambda;
    }

    public double simulate() {
        double valeur = 0;
        double cumul = Math.exp(-lambda);
        double ajout = cumul;
        double rand = Math.random();

        while (cumul < rand) {
            valeur++;
            ajout = ajout * lambda / valeur;
            cumul += ajout;
        }
        return valeur;
    }
}
