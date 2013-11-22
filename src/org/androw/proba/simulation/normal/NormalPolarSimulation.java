package org.androw.proba.simulation.normal;

/**
 * Project: Probabilite
 * User: Androw
 * Date: 27/09/13
 * Time: 17:18
 * Created with IntelliJ IDEA.
 */
public class NormalPolarSimulation extends NormalSimulation {
    private double mu;
    private double sigma2;

    public NormalPolarSimulation() {
        super("Normal Polar");
        this.mu = 0;
        this.sigma2 = 1;
    }

    public NormalPolarSimulation(double mu, double sigma2) {
        super("Normal Polar");
        this.mu = mu;
        this.sigma2 = sigma2;
    }

    public double simulate() {
        double s;

        double v1;
        double v2;
        do {
            double u1 = Math.random();
            double u2 = Math.random();

            v1 = 2 * u1 - 1;
            v2 = 2 * u2 - 1;
            s = v1 * v1 + v2 * v2;
        } while (s > 1);

        double xCR = Math.sqrt(-2 * Math.log(s) / s) * v1;
        double yCR = Math.sqrt(-2 * Math.log(s) / s) * v2;

        double x = xCR * Math.sqrt(sigma2) + mu;
        double y = yCR * Math.sqrt(sigma2) + mu;

        return x;
    }
}
