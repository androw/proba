/**
 * Project: Probabilite
 * User: Androw
 * Date: 27/09/13
 * Time: 17:02
 * Created with IntelliJ IDEA.
 */
public abstract class Simulation {
    public abstract double simulate();
    private String name;

    public Simulation(String name) {
        this.name = name;
    }

    public double density(int N, double x, double d) {
        double rep = 0;
        for (int i = 0; i<N; i++) {
            double xsim = simulate();
            if (x <= xsim && xsim <= x + d) rep += 1.0/(double) N;
        }
        return rep/d;
    }

    public double[] density(int N, double[] x, double d) {
        double[] y = new double[x.length];
        double[] s = new double[N];
        for (int i = 0; i<N; i++){
            s[i] = simulate();
        }

        for (int i = 0; i<x.length; i++){
            double rep = 0;
            for (int j = 0; j<N; j++) {
                if (x[i] <= s[j] && s[j] <= x[i] + d) rep += 1.0/(double) N;
            }
            y[i] = rep/d;
        }
        return y;
    }

    public double repartition(int N, double x) {
        double rep = 0;
        for (int i = 0; i<N; i++) {
            if (simulate() <= x) rep += 1.0/(double) N;
        }
        return rep;
    }

    public double[] repartition(int N, double[] x) {
        double[] y = new double[x.length];
        double[] s = new double[N];
        for (int i = 0; i<N; i++){
            s[i] = simulate();
        }

        for (int i = 0; i<x.length; i++){
            double rep = 0;
            for (int j = 0; j<N; j++) {
                if (s[j] <= x[i]) rep += 1.0/(double) N;
            }
            y[i] = rep;
        }
        return y;
    }

    public double mean(int N) {
        double mean = 0;
        for (int i = 0; i<N; i++) {
            mean += simulate()/(double) N;
        }
        return mean;
    }

    public double variance(int N) {
        double var = 0;
        double mean = 0;
        for (int i = 0; i<N; i++) {
            double sim = simulate();
            mean += sim/(double) N;
            var += sim*sim/(double) N;
        }
        return var-mean*mean;
    }

    public String getName() {
        return this.name;
    }
}
