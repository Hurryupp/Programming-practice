package MiroSoftTest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Xci {

    public static void main(String[] args) {
        int[] a = {1,1,1,1,3,3,4,4,4,4,4};
        System.out.println(minMoves(a));
    }
    public static int minMoves(int[] data) {
        int minOperations = 0;
        for(int i = 0, j = 0; i < data.length; i = j) {
            while (j < data.length && data[i] == data[j]) j++;
            int frequency = j - i;
            minOperations += Math.min(Math.abs(data[i] - frequency), frequency);
        }
        return minOperations;


    }
}
