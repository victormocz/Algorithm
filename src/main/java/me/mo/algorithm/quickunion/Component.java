package me.mo.algorithm.quickunion;

/**
 * Created by victorm on 4/17/17.
 */
public class Component {
    private int weight;
    private int index;
    public Component(int index, int weight) {
        this.index = index;
        this.weight = weight;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public String toString() {
        return String.format("Index: %d Weight: %d",index,weight);
    }
}
