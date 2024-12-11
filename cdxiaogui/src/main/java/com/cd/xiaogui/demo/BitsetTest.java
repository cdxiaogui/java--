package com.cd.xiaogui.demo;

import java.util.BitSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * TODO
 *
 * @author sunyawei3
 * @date 2023/10/18 5:28 PM
 */
public class BitsetTest {

    public static void main(String[] args) {
        BitSet bitSet = new BitSet(10);

        bitSet.set(3);
        bitSet.set(6);
        bitSet.set(8);
        System.out.println(bitSet.size());
        System.out.println(bitSet.length());
        for (int i = 0; i < bitSet.length(); i++) {
            boolean bit = bitSet.get(i);
            System.out.print(bit ? "1" : "0");
        }

    }

}
