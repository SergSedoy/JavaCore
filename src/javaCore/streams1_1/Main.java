package javaCore.streams1_1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        List<Integer> intListTwo = new ArrayList<>();
        List<Integer> intListThree = new ArrayList<>();

        System.out.println(intList);

        for (int i = 0; i < intList.size(); i++) {
            if (intList.get(i) > 0) {
                intListTwo.add(intList.get(i));
            }
        }
        System.out.println(intListTwo);

        for (int i = 0; i < intListTwo.size(); i++) {
            if (intListTwo.get(i) % 2 == 0) {
                intListThree.add(intListTwo.get(i));
            }
        }
        System.out.println(intListThree);

        for(int i = 0; i < intListThree.size(); i++) {
            for (int j = i + 1; j < intListThree.size(); j++) {
                if (intListThree.get(i) > intListThree.get(j)) {
                    int tmp = intListThree.get(i);
                    intListThree.set(i, intListThree.get(j));
                    intListThree.set(j, tmp);
                }
            }
        }
        System.out.println(intListThree);
    }
}
