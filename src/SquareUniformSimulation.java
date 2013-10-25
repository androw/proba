/**
 * Project: proba
 * User: Androw
 * Date: 25/10/2013
 * Time: 10:53
 * Created with IntelliJ IDEA.
 */
public class SquareUniformSimulation extends Simulation {

    public SquareUniformSimulation(){
        super("SquareUniform");
    }

    public double simulate() {
        double rand = Math.random();
        return rand*rand;
    }
}
