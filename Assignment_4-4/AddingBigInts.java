import java.util.ArrayList;
public class AddingBigInts {
    public static void main(String [] args) {
        ArrayList<Integer> addend1 = new ArrayList();
        ArrayList<Integer> addend2 = new ArrayList();
        addend1.add(9);
        addend1.add(8);
        addend1.add(0);
        addend1.add(1);
        addend2.add(0);
        addend2.add(0);
        addend2.add(9);
        addend2.add(9);
        addend2.add(9);
        addend2.add(1);
        addend2.add(2);
        addend2.add(3);
        addend2.add(4);
        for (int i = 0; i < addend1.size(); i ++) {
            System.out.print(addend1.get(i));
        }
        System.out.print(" + ");
        for (int i = 0; i < addend2.size(); i ++) {
            System.out.print(addend2.get(i));
        }
        System.out.print(" = ");
        ArrayList<Integer> sum = add(addend1, addend2);
        for (int i = 0; i < sum.size(); i ++) {
            System.out.print(sum.get(i));
        }
    }

    public static ArrayList<Integer> add(ArrayList<Integer> addend1, ArrayList<Integer> addend2) {
        int addend1Size = addend1.size();
        int addend2Size = addend2.size();
        int maxSizesPlus = Math.max(addend1Size, addend2Size) + 1;
        ArrayList<Integer> addend1Reversed = new ArrayList<Integer>(maxSizesPlus);
        ArrayList<Integer> addend2Reversed = new ArrayList<Integer>(maxSizesPlus);
        for (int i = addend1Size - 1; i >= 0; i --) {
            addend1Reversed.add(addend1.get(i));
        }
        for (int i = addend1Size - 1; i >= 0; i --) {
            if (addend1Reversed.get(i) == 0) {
                addend1Reversed.remove(i);
            } else {
                i = 0;
            }
        }
        for (int i = addend2Size - 1; i >= 0; i --) {
            addend2Reversed.add(addend2.get(i));
        }
        for (int i = addend2Size - 1; i >= 0; i --) {
            if (addend2Reversed.get(i) == 0) {
                addend2Reversed.remove(i);
            } else {
                i = 0;
            }
        }
        int twoReversedSize = addend2Reversed.size();  
        while (addend1Reversed.size() < twoReversedSize) {
            addend1Reversed.add(0);
        }
        int oneReversedSize = addend1Reversed.size();
        while (oneReversedSize > addend2Reversed.size()) {
            addend2Reversed.add(0);
        }
        oneReversedSize ++;
        addend1Reversed.add(0);
        addend2Reversed.add(0);
        twoReversedSize = addend2Reversed.size();
        ArrayList<Integer> outputReversed = new ArrayList<Integer>(oneReversedSize);
        for (int i = 0; i < oneReversedSize; i ++) {
            outputReversed.add(0);
        }
        for (int i = 0; i < oneReversedSize; i ++) {
            outputReversed.set(i, addend1Reversed.get(i) + addend2Reversed.get(i));
            if (outputReversed.get(i) >= 10) {
                addend1Reversed.set(i + 1, addend1Reversed.get(i + 1) + 1);
                outputReversed.set(i, outputReversed.get(i) - 10);
            }
        }
        if (outputReversed.get(oneReversedSize - 1) == 0) {
            outputReversed.remove(oneReversedSize - 1);
        }
        ArrayList<Integer> output = new ArrayList<Integer>(oneReversedSize);
        for (int i = oneReversedSize - 1; i >= 0; i --) {
            output.add(outputReversed.get(i));
        }
        return output;
    }
}