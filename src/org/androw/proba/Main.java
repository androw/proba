package org.androw.proba;

import org.androw.proba.simulation.Option;
import org.androw.proba.simulation.Simulation;
import org.androw.proba.simulation.asset.Asset1;
import org.androw.proba.simulation.asset.Asset2;

public class Main {


    public static void main(String[] args) throws Exception {

        Simulation[] s = new Simulation[1];
        //s[0] = new org.androw.proba.simulation.PoissonSimulation(3);
        //s[1] = new org.androw.proba.simulation.BinomialSimulation(30,0.2);
        //s[2] = new org.androw.proba.simulation.ExponentialSimulation(0.5);
        //s[3] = new org.androw.proba.simulation.normal.NormalRejectionSimulation(1.0,2.0);
        //s[4] = new org.androw.proba.simulation.BinomialSimulation(150, 0.35);
        //s[5] = new org.androw.proba.simulation.transf.SquareSimulation(new org.androw.proba.simulation.UniformSimulation());
        //s[0] = new org.androw.proba.simulation.transf.SquareSimulation(new org.androw.proba.simulation.normal.NormalRejectionSimulation(0.0, 1.0));
        //s[0] = new NormalPolarSimulation(0,1);

        SimulationPlots p = new SimulationPlots(100000, s, 0.00, 2.00, 0.05);
        Asset1 a = new Asset1(100, 0.5, 0.1, 0.5, 10);
        a.simulate();
        a.draw(p);

        Asset2 b = new Asset2(0.005, 0.5, 0.1, 0.5, 10);
        b.simulate();
        b.draw(p);

        Option o = new Option(1000, 0.5, 0.1, 0.5, 199, 20, 10, 10);
        //.simulate();
        //o.draw(p);

        //BrownianMotion b1 = new BrownianMotion(10000, 100);
        //BrownianMotionNormal b2 = new BrownianMotionNormal(10000, 100, new NormalTCLSimulation(0,1.0/10000.0, 1000));
        //BrownianMotionNormal b3 = new BrownianMotionNormal(10000, 100, new NormalRejectionSimulation(0,1.0/10000.0));
        //BrownianMotionNormal b4 = new BrownianMotionNormal(10000, 100, new NormalPolarSimulation(0,1.0/10000.0));
        //bm.verify(1);
        //b1.draw(p);
        //b2.draw(p);
        //b3.draw(p);
        //b4.draw(p);
        //p.draw();
        p.show();

    }
}
