package hus.oop.sorteddatastructure;

import java.util.Random;

public class TestSortedDataStructure {
    public static void main(String[] args) {
        testSortedArrayList();
        testSortedLinkedList();
    }

    public static void testSortedArrayList() {
        Random rand = new Random();
        int n = rand.nextInt(11) + 20; // Random number between 20 and 30
        MySortedArrayList list = new MySortedArrayList();
        for (int i = 0; i < n; i++) {
            list.add(rand.nextInt(91) + 10); // Random number between 10 and 100
            System.out.println(list);
        }
        int testValue = rand.nextInt(91) + 10;
        System.out.println("Searching for " + testValue + ": " + list.contains(testValue));
    }

    public static void testSortedLinkedList() {
        Random rand = new Random();
        int n = rand.nextInt(11) + 20; // Random number between 20 and 30
        MySortedLinkedList list = new MySortedLinkedList();
        for (int i = 0; i < n; i++) {
            list.add(rand.nextInt(91) + 10); // Random number between 10 and 100
            System.out.println(list);
        }
        int testValue = rand.nextInt(91) + 10;
        System.out.println("Searching for " + testValue + ": " + list.contains(testValue));
    }
}
