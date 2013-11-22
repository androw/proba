package org.androw.proba;

import org.androw.proba.simulation.Simulation;
import org.math.plot.Plot2DPanel;

import javax.swing.*;

/**
 * Project: proba
 * User: Androw
 * Date: 15/11/2013
 * Time: 09:25
 * Created with IntelliJ IDEA.
 */


public class SimulationPlots {
    private int N;

    private Simulation[] s;
    private Plot2DPanel plot;
    private JFrame frame;

    private double xmin;
    private double xmax;

    private double dx;

    public SimulationPlots(int N, Simulation[] s, double xmin, double xmax, double dx) {
        this.frame = new JFrame("Probabilite");
        this.plot = new Plot2DPanel();

        this.N = N;
        this.s = s;
        this.xmin = xmin;
        this.xmax = xmax;
        this.dx = dx;
    }

    public void draw() {
        int n = (int) Math.round((Math.abs(xmin) + Math.abs(xmax)) / dx) + 1;
        double[] x = new double[n];

        for (int i = 0; i < x.length; i++) {
            x[i] = this.xmin + this.dx * i;
        }

        for (int i = 0; i < this.s.length; i++) {
            this.plot.addLinePlot(this.s[i].getName() + " Repartition", x, this.s[i].repartition(this.N, x));
            this.plot.addLinePlot(this.s[i].getName() + " Density", x, this.s[i].density(this.N, x, dx / 4.0));
        }

        this.plot.setAxisLabels("x", "F(x)");

    }

    public void draw(double[] x, double[] y, String name) {
        this.plot.addLinePlot(name, x, y);
    }

    public void show() {
        this.plot.addLegend("SOUTH");
        frame.setContentPane(plot);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
