package lab1.solvers;

import lab1.functions.OneArgumentFunction;

import java.util.ArrayList;
import java.util.List;

public class ParabolicSolver implements Solver{
    private OneArgumentFunction function;

    public ParabolicSolver(OneArgumentFunction function) {
        this.function = function;
    }

    public List<Double> solve(double x1, double x3, double eps) {
        double x2 = 2; // fix
        double X2 = next(x1, x2, x3);
        List<Double> steps = new ArrayList<>(List.of(X2));
        while (X2 < x2 - eps || X2 > x2 + eps) {
            if (X2 < x2) {
                x3 = x2;
            } else {
                x1 = x2;
            }
            x2 = X2;
            X2 = next(x1, x2, x3);
            steps.add(X2);
        }
        return steps;
    }

    private double next(double x1, double x2, double x3) {
        double f1 = function.eval(x1), f2 = function.eval(x2), f3 = function.eval(x3);
        return x2 -
                ((Math.pow(x2 - x1, 2) * (f2 - f3) - Math.pow(x2 - x3, 2) * (f2 - f1))
                 / (2 * ((x2 - x1) * (f2 - f3) - (x2 - x3) * (f2 - f1))));
    }
}
