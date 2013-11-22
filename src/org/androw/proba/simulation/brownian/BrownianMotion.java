package org.androw.proba.simulation.brownian;

import org.androw.proba.SimulationPlots;
import org.androw.proba.simulation.DiscretSimulation;
import org.androw.proba.simulation.Simulation;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: proba
 * User: Androw
 * Date: 15/11/2013
 * Time: 09:41
 * Created with IntelliJ IDEA.
 */
public class BrownianMotion extends Simulation {
    private int N;
    private double tmax;
    private DiscretSimulation s;
    private List<Double> x;

    public BrownianMotion(int N, double tmax) throws Exception {
        super("Brownian Random Walk");
        double[] p = {0.5, 0.5};
        double[] r = {1.0, -1.0};
        this.N = N;
        this.tmax = tmax;
        this.s = new DiscretSimulation(p, r);
        this.x = new ArrayList<Double>();
    }

    public void calcX() {
        for (int i = 1; i < Math.floor(this.N * this.tmax); i++) {
            double a = this.s.simulate() / Math.sqrt(this.N);
            this.x.add(a);
        }
    }

    public void reset() {
        this.x = new ArrayList<Double>();
    }

    public double simulate() {
        return this.simulate(this.tmax);
    }

    public double simulate(double t) {
        if (t <= 0) {
            return 0;
        } else {
            double acc = 0;
            for (int i = 1; i < Math.floor(this.N * t); i++) {
                acc = acc + this.x.get(i - 1);
            }
            return acc;
        }
    }

    public void verify(double t) {
        double esp = 0;
        double var = 0;
        for (int i = 0; i < 1000; i++) {
            calcX();

            esp = esp + simulate(t) / 1000.0;
            var = var + simulate(t) * simulate(t) / 1000.0;
            reset();
        }
        System.out.println("Simulated average: "+esp);
        System.out.println("Simulated variance: "+(var - esp * esp));
    }

    public void draw(SimulationPlots p) {
        //long start = System.currentTimeMillis();
        calcX();
        //bm.verify();
        double dx = 0.1;
        int n = (int) Math.round(Math.abs(100) / dx) + 1;
        double[] x = new double[n];
        double[] y = new double[n];
        for (int i = 0; i < x.length; i++) {
            x[i] = dx * i;
            y[i] = simulate(x[i]);
        }
        //long stop = System.currentTimeMillis();
        //System.out.println(" "+ (stop-start));
        p.draw(x, y, "Brownian Random Walk");
    }


}
