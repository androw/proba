package org.androw.proba.simulation;

import org.androw.proba.simulation.normal.NormalRejectionSimulation;

/**
 * Project: proba
 * User: Androw
 * Date: 03/12/2013
 * Time: 16:52
 * Created with IntelliJ IDEA.
 */
public class Asset extends Simulation {
    private int N;
    private double dt;
    private double r;
    private double T;
    private double sigma;
    private double S0;
    public Asset(int N, double T, double r, double sigma, double S0) {
        super("Asset");
        this.N = N;
        this.T = T;
        this.r = r;
        this.sigma = sigma;
        this.S0 = S0;
        this.dt = T/((double) N);

    }

    public double simulate() {
        Simulation normal = new NormalRejectionSimulation(0.0,1.0);
        double[] W = new double[this.N];
        W[0] = 0;
        for (int i=1; i<N; i++) {
            W[i] = W[i-1] + Math.sqrt(this.dt)*normal.simulate();
        }
        double[] S = new double[this.N];
        S[0] = this.S0;
        for (int i=1; i<N; i++) {
            S[i] = S[i-1]*(1+this.r*this.dt) + sigma*(W[i]-W[i-1]);
        }
        return S[this.N-1];
    }
}
