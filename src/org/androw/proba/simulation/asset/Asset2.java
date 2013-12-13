package org.androw.proba.simulation.asset;

import org.androw.proba.SimulationPlots;
import org.androw.proba.simulation.Simulation;
import org.androw.proba.simulation.normal.NormalRejectionSimulation;

/**
 * Project: proba
 * User: Androw
 * Date: 03/12/2013
 * Time: 16:52
 * Created with IntelliJ IDEA.
 */
public class Asset2 extends Simulation {
    private double dt;
    private double r;
    private double T;
    private double sigma;
    private double S0;

    private double[] S;

    public Asset2(double dt, double T, double r, double sigma, double S0) {
        super("Asset2");
        this.T = T;
        this.r = r;
        this.sigma = sigma;
        this.S0 = S0;
        this.dt = dt;

    }

    public double simulate() {
        Simulation normal = new NormalRejectionSimulation(0.0,1.0);
        S = new double[(int)Math.floor(this.T/this.dt)];
        S[0] = this.S0;
        for (int i=1; i<S.length; i++) {
            S[i] = S[i-1]*Math.exp(this.dt*(this.r-this.sigma*this.sigma/2.0)+Math.sqrt(this.dt)*this.sigma*normal.simulate());
            System.out.println(this.dt*(this.r-this.sigma*this.sigma/2.0));
        }
        return S[S.length-1];
    }

    public void draw(SimulationPlots p) {
        double[] y = new double[this.S.length];
        for (int i = 0; i < this.S.length; i++) {
            y[i] = dt * i;
        }
        p.draw(y, S, "Asset2 price");
    }
}
