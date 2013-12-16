package org.androw.proba.simulation.brownian;

import org.androw.proba.SimulationPlots;
import org.androw.proba.simulation.Simulation;
import org.androw.proba.simulation.normal.NormalSimulation;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: proba
 * User: Androw
 * Date: 15/11/2013
 * Time: 09:41
 * Created with IntelliJ IDEA.
 */
public class BrownianMotionNormal extends Simulation {
    private int N;
    private double tmax;
    private NormalSimulation n;
    private List<Double> x;

    public BrownianMotionNormal(int N, double tmax, NormalSimulation n) throws Exception {
        super("Brownian " + n.getName());
        this.N = N;
        this.tmax = tmax;
        this.n = n;
        this.x = new ArrayList<Double>();
    }

    public void calcX() {
        for (int i = 1; i < Math.floor(this.N * this.tmax); i++) {
            double a = this.n.simulate();
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
        System.out.println("Simulated average: " + esp);
        System.out.println("Simulated variance: " + (var - esp * esp));
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
        //System.out.println(this.n.getName() +" "+ (stop-start));
        p.draw(x, y, "Brownian " + this.n.getName());
    }


}
