package me.mo.algorithm.quickunion;

/**
 * Created by victorm on 4/17/17.
 */
public class QuickUnion {
    private Component[] components;
    private static final int INITIAL_WEIGHT = 1;

    public QuickUnion(int numberOfComponent) throws IllegalArgumentException{
        if (numberOfComponent <= 0) {
            throw new IllegalArgumentException("Number Of Component must be greater than 0");
        }
        components = new Component[numberOfComponent];
        for (int idx = 0; idx < components.length; idx++) {
            components[idx] = new Component(idx, INITIAL_WEIGHT);
        }
    }

    public void union(int firstIdx, int secondIdx) throws IndexOutOfBoundsException{
        if (firstIdx < 0 || firstIdx > components.length || secondIdx < 0 || secondIdx > components.length) {
            throw new IndexOutOfBoundsException(String.format("Index shoud between 0 to %d",components.length));
        }
        int firstRootIdx = findRootIdx(firstIdx);
        int secondRootIdx = findRootIdx(secondIdx);
        if (firstRootIdx == secondRootIdx) {
            return;
        }
        if (components[firstRootIdx].getWeight() > components[secondIdx].getWeight()) {
            components[secondRootIdx].setIndex(firstIdx);
            components[firstRootIdx].setWeight(components[firstRootIdx].getWeight() + components[secondRootIdx].getWeight());
        } else {
            components[firstRootIdx].setIndex(secondRootIdx);
            components[secondRootIdx].setWeight(components[secondRootIdx].getWeight() + components[firstRootIdx].getWeight());
        }
    }

    public boolean isConnected(int firstIdx, int secondIdx) {
        return findRootIdx(firstIdx) == findRootIdx(secondIdx);
    }

    private int findRootIdx(int idx) {
        while(components[idx].getIndex() != idx) {
            components[idx].setIndex(components[idx].getIndex());
            idx = components[idx].getIndex();
        }
        return idx;
    }

    public void debug() {
        for (Component component : components) {
            System.out.println(component);
        }
    }
}
