
import org.math.plot.*;

import javax.swing.*;


public class Main {
    public final static int N = 1000000;


    public static void main(String[] args) {
        Plot2DPanel plot = new Plot2DPanel();
        JFrame frame = new JFrame("Probabilite");

        Simulation[] s = new Simulation[1];


        double xmin = -5.00;
        double xmax = 5.0;

        double dx = 0.1;

        int n = (int) Math.round((Math.abs(xmin)+Math.abs(xmax))/dx)+1;

        //System.out.println(n);
        double[] x = new double[n];
        double[] y = new double[n];

        //s[0] = new PoissonSimulation(3);
        //s[1] = new BinomialSimulation(30,0.2);
        //s[2] = new ExponentialSimulation(0.5);
        s[0] = new NormalRejectionSimulation(1.0,2.0);
        //s[4] = new BinomialSimulation(150, 0.35);
        //s[0] = new SquareUniformSimulation();

        for (int i = 0; i<x.length; i++){
            x[i] = xmin + dx * i;
            //y[i] = 1.0/(2.0*Math.sqrt(x[i]));
        }

        for (int i = 0; i<s.length; i++) {
            plot.addLinePlot(s[i].getName()+ " Repartition", x, s[i].repartition(N, x));
            plot.addLinePlot(s[i].getName()+ " Density", x, s[i].density(N, x, 0.05));
        }
        //plot.addLinePlot(s[0].getName(), x, s[0].density(N, x, 0.001));
        //plot.addLinePlot("Théo", x, y);

        plot.setAxisLabels("x", "F(x)");
        plot.addLegend("SOUTH");

        frame.setContentPane(plot);
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
