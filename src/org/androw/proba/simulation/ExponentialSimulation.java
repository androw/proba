package org.androw.proba.simulation;

/**
 * Project: Probabilite
 * User: Androw
 * Date: 27/09/13
 * Time: 17:02
 * Created with IntelliJ IDEA.
 */
public class ExponentialSimulation extends Simulation {
    private double lambda;

    public ExponentialSimulation(double lambda) {
        super("Exponential");
        this.lambda = lambda;
    }

    public double simulate() {
        return Math.log(1 - Math.random()) / (-lambda);
    }
}
