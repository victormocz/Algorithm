package me.mo.algorithm.quickunion;

/**
 * Created by victorm on 4/17/17.
 */
public class MainApp {
    public static void main(String[] args) {
        QuickUnion quickUnion = new QuickUnion(10);
        quickUnion.union(0,1);
        System.out.println(quickUnion.isConnected(0,1));
        quickUnion.union(0,2);
        quickUnion.union(3,2);
        quickUnion.union(3,4);
        System.out.println(quickUnion.isConnected(1,2));
        quickUnion.debug();
    }
}
