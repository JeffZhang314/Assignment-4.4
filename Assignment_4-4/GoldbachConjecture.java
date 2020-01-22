import java.util.ArrayList;
public class GoldbachConjecture {
    public static void main(String [] args) {
        sum2P(4);
        sum2P(6);
        sum2P(10);
        sum2P(120);
    }

    public static void sum2P(int input) {
        if (input > 4) {
            ArrayList<Integer> psMostInput = allPsMost(input);
            for (int i = input - 1; i >= input/2; i -= 2) {
                int inputMinusI = input - i;
                if (psMostInput.contains(i) && psMostInput.contains(inputMinusI)) {
                    System.out.println(input + " = " + i + " + " + inputMinusI);
                    i = input/2 - 1;
                }
            }
        } else {
            System.out.println("4 = 2 + 2");
        }
    }

    public static ArrayList<Integer> allPsMost(int n) {
        ArrayList<Integer> output = new ArrayList<Integer>(n);
        for (int i = 2; i <= n; i ++) {
            output.add(i);
        }
        for (int i = 0; i < output.size(); i ++) {
            int p = output.get(i);
            for (int multipleP = 2 * p; multipleP <= n; multipleP += p) {
                if (output.contains(multipleP)) {
                    output.remove(output.indexOf(multipleP));
                }
            }
        }
        return output;
    }
}
