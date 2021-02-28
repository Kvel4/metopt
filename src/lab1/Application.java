package lab1;

import lab1.functions.OneArgumentFunction;
import lab1.solvers.ParabolicSolver;
import lab1.solvers.Solver;

import java.util.List;

public class Application {
    private static OneArgumentFunction function = (x) -> 0.2 * x * Math.log(x) + Math.pow(x - 2.3, 2);
    private static final double X1 = 0.5;
    private static final double X3 = 2.5;
    private static final double EPS = 1e-5;

    public static void main(String[] args) {
        System.out.println(parabolic());
    }

    private static List<Double> parabolic() {
        Solver parabolicSolver = new ParabolicSolver(function);
        return parabolicSolver.solve(X1, X3, EPS);
    }

}
