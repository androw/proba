package org.androw.proba.simulation;

/**
 * Project: proba
 * User: Androw
 * Date: 15/11/2013
 * Time: 11:46
 * Created with IntelliJ IDEA.
 */
public class UniformSimulation extends Simulation {
    private double a;
    private double b;

    public UniformSimulation() {
        super("Uniform");
        this.a = 0;
        this.b = 1;
    }

    public UniformSimulation(double a, double b) {
        super("Uniform");
        this.a = a;
        this.b = b;
    }

    public double simulate() {
        return Math.random() * Math.abs(b - a) + a;
    }
}
