package org.androw.proba.simulation;

/**
 * Project: Probabilite
 * User: Androw
 * Date: 27/09/13
 * Time: 18:56
 * Created with IntelliJ IDEA.
 */
public class BinomialSimulation extends Simulation {
    private double p;
    private int n;
    private double[][] binome;

    public BinomialSimulation(int n, double p) {
        super("Binomial");
        this.n = n;
        this.p = p;

        binome = new double[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                binome[i][j] = 0;
            }
        }
        binome[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            binome[i][0] = binome[i - 1][0];
            for (int j = 1; j <= n; j++) {
                binome[i][j] = binome[i - 1][j - 1] + binome[i - 1][j];
            }
        }
    }

    public double simulate() {
        double rand = Math.random();
        int valeur = -1;
        double cumul = 0;

        while (rand > cumul) {
            valeur++;
            cumul += binome[n][valeur] * Math.pow(p, valeur) * Math.pow(1 - p, n - valeur);
        }
        return valeur;
    }
}
