package org.androw.proba.simulation;

import org.androw.proba.SimulationPlots;
import org.androw.proba.simulation.normal.NormalRejectionSimulation;

/**
 * Project: proba
 * User: Androw
 * Date: 03/12/2013
 * Time: 17:15
 * Created with IntelliJ IDEA.
 */
public class Option extends Simulation {
    private int Nmc;
    private double T;
    private double r;
    private double sigma;
    private double L;
    private int N;
    private double K;
    private double S0;

    public Option(int Nmc, double T, double r, double sigma, int N, double L, double K, double S0) {
        super("Option pricing");
        this.Nmc = Nmc;
        this.T = T;
        this.r = r;
        this.sigma = sigma;
        this.L = L;
        this.N = N;
        this.K = K;
        this.S0 = S0;
    }

    public double simulate(double S0) {
        Simulation normal = new NormalRejectionSimulation(0.0,1.0);
        double[] N = new double [Nmc+1];
        for (int i = 1; i< Nmc+1; i++) {
            N[i] = normal.simulate();
        }
        double V = 0;
        for (int i = 1; i < Nmc+1; i++) {
            V = V + Math.exp(-r*T)*Math.max(S0*Math.exp((r-sigma*sigma/2.0)*T+sigma*Math.sqrt(T)*N[i])-K,0)/Nmc;
        }
        return V;
    }

    public double simulate() {
        Simulation normal = new NormalRejectionSimulation(0.0,1.0);
        double[] N = new double [Nmc+1];
        for (int i = 1; i< Nmc+1; i++) {
            N[i] = normal.simulate();
        }
        double V = 0;
        for (int i = 1; i < Nmc+1; i++) {
            V = V + Math.exp(-r*T)*Math.max(this.S0*Math.exp((r-sigma*sigma/2.0)*T+sigma*Math.sqrt(T)*N[i])-K,0)/Nmc;
        }
        return V;
    }

    public void draw(SimulationPlots p) {
        double[] x = new double[this.N+1];
        double[] y = new double[this.N+1];
        for (int i = 0; i < x.length; i++) {
            x[i] = simulate(this.L/(this.N+1) * i);
            y[i] = this.L/(this.N+1)* i;
        }
        p.draw(y, x, "Option price");
    }
}
