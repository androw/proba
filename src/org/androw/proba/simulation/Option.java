package org.androw.proba.simulation;

/**
 * Project: proba
 * User: Androw
 * Date: 03/12/2013
 * Time: 17:15
 * Created with IntelliJ IDEA.
 */
public class Option extends Simulation {
    public Option() {

    }

    public simulate() {
        double[] N = new double [Nmc+1];
        double V = 0;
        for (int i = 1 < Nmc+1 i++) {
            V = V + Math.exp(-r*T)*Math.max(S0*Math.exp(())-K,0)/Nmc;
        }
    }
}
