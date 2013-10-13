
import org.math.plot.*;

import javax.swing.*;


public class Main {
    public final static int N = 10000;


    public static void main(String[] args) {
        Plot2DPanel plot = new Plot2DPanel();
        JFrame frame = new JFrame("Probabilite");

        Simulation[] s = new Simulation[6];

        double[] x = new double[100];

        s[0] = new PoissonSimulation(5);
        s[1] = new NormalSimulation(0,1,100);
        s[2] = new NormalPolarSimulation(0,1);
        s[3] = new NormalRejectionSimulation(0,1);
        s[4] = new BinomialSimulation(5,0.5);
        s[5] = new ExponentialSimulation(0.5);

        for (int i = 0; i<x.length; i++){
            x[i] = (i-50)/(double)10;
        }

        for (int i = 0; i<s.length; i++) {
            plot.addLinePlot(s[i].getName(), x, s[i].repartition(N, x));
        }

        plot.setAxisLabels("x", "F(x)");
        plot.addLegend("SOUTH");

        frame.setContentPane(plot);
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
