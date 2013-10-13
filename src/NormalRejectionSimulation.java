/**
 * Project: Probabilite
 * User: Androw
 * Date: 27/09/13
 * Time: 17:22
 * Created with IntelliJ IDEA.
 */
public class NormalRejectionSimulation extends Simulation {
    private double mu = 0;
    private double sigma2 = 1;

    public NormalRejectionSimulation(double mu, double sigma2) {
        super("Normal Rejection");
        this.mu = mu;
        this.sigma2 = sigma2;
    }

    public double simulate() {
        double u;
        double y;
        do {
            y = simExp();
            u = Math.random();
        } while (u >= densf(y) / (densg(y)));
        return (y * Math.sqrt(sigma2) + mu);
    }

    public static double simExp() {
        double u = Math.random() - 1.0 / 2.0;
        return -Math.signum(u) * Math.log(1.0 - 2.0 * Math.abs(u));
    }

    public static double densg(double x) {
        return (1.0 / 2.0 * Math.exp(-Math.abs(x)));
    }

    public static double densf(double x) {
        return 1.0 / Math.sqrt(2 * Math.PI) * Math.exp(-0.5 * x * x);
    }
}
