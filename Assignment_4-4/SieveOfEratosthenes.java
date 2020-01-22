import java.util.ArrayList;
public class SieveOfEratosthenes {
    public static void main(String [] args) {
        System.out.println(allPsMost(100));
        System.out.println(allPsMost(1000));
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