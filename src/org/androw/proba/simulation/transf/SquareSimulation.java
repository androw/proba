package org.androw.proba.simulation.transf;

import org.androw.proba.simulation.Simulation;

/**
 * Project: proba
 * User: Androw
 * Date: 15/11/2013
 * Time: 11:07
 * Created with IntelliJ IDEA.
 */
public class SquareSimulation extends Simulation {
    Simulation s;

    public SquareSimulation(Simulation s) {
        super("Square of " + s.getName());
        this.s = s;
    }

    public double simulate() {
        double r = this.s.simulate();
        return r * r;
    }
}
