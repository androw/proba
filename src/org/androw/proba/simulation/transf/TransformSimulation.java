package org.androw.proba.simulation.transf;

import bsh.Interpreter;
import org.androw.proba.simulation.Simulation;

/**
 * Project: proba
 * User: Androw
 * Date: 15/11/2013
 * Time: 10:38
 * Created with IntelliJ IDEA.
 */
public class TransformSimulation extends Simulation {
    Interpreter in;
    Simulation s;
    String t;

    public TransformSimulation(Simulation s, String t) {
        super(t + " Transform of " + s.getName());
        this.s = s;
        this.t = t;

        this.in = new Interpreter();
    }

    public double simulate() {
        double r = s.simulate();
        try {
            this.in.eval("X = " + Double.toString(r));
            this.in.eval("result = " + t);
            double sol = Double.parseDouble(this.in.get("result").toString());
            return sol;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
