package org.androw.proba.simulation.normal;

/**
 * Project: Probabilite
 * User: Androw
 * Date: 27/09/13
 * Time: 17:09
 * Created with IntelliJ IDEA.
 */
public class NormalTCLSimulation extends NormalSimulation {
    private double mu;
    private double sigma2;
    private int n;

    public NormalTCLSimulation(int n) {
        super("Normal TCL");
        this.mu = 0;
        this.sigma2 = 1;
        this.n = n;
    }

    public NormalTCLSimulation(double mu, double sigma2, int n) {
        super("Normal TCL");
        this.mu = mu;
        this.sigma2 = sigma2;
        this.n = n;
    }

    public double simulate() {
        double emp = 0;
        for (int j = 0; j < n; j++) {
            emp += Math.random() / n;
        }
        double y = (emp - (1 / 2.0)) * Math.sqrt(12) * Math.sqrt(n);
        return y * Math.sqrt(sigma2) + mu;
    }
}
