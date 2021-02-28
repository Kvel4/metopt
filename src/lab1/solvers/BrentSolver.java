package lab1.solvers;

import lab1.functions.OneArgumentFunction;

import java.util.ArrayList;
import java.util.List;

public class BrentSolver implements Solver{
    private OneArgumentFunction function;

    public BrentSolver(OneArgumentFunction function) {
        this.function = function;
    }

    public List<Double> solve(double x1, double x2, double x3, double eps) {


        return new ArrayList<>();
    }

    private double next(double x1, double x2, double x3) {
        double f1 = function.eval(x1), f2 = function.eval(x2), f3 = function.eval(x3);
        return x2 -
                ((Math.pow(x2 - x1, 2) * (f2 - f3) - Math.pow(x2 - x3, 2) * (f2 - f1))
                        / (2 * ((x2 - x1) * (f2 - f3) - (x2 - x3) * (f2 - f1))));
    }
}
