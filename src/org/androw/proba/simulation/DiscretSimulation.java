package org.androw.proba.simulation;

/**
 * Project: Probabilite
 * User: Androw
 * Date: 27/09/13
 * Time: 18:39
 * Created with IntelliJ IDEA.
 */
public class DiscretSimulation extends Simulation {
    private double[] p;
    private double[] x;

    public DiscretSimulation(double[] p, double[] x) throws Exception {
        super("Discret");
        if (x.length != p.length)
            throw new Exception(
                    "Erreur : Les deux tableaux n'ont pas la même taille.");
        double pAcc = 0;
        for (int i = 0; i < p.length; i++) {
            pAcc += p[i];
        }
        if (pAcc != 1)
            throw new Exception(
                    "Erreur : La probabilité totale n'est pas égale à 1.");
        this.p = p;
        this.x = x;
    }

    public double simulate() {
        double z = 0;
        double u = Math.random();
        double pAcc = 0;
        for (int j = 0; j < p.length; j++) {
            pAcc += p[j];
            if (u < pAcc) {
                z = x[j];
                break;
            }
        }
        return z;
    }
}
