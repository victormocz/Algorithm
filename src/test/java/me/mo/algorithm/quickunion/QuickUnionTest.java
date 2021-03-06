package me.mo.algorithm.quickunion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by victorm on 4/17/17.
 */
public class QuickUnionTest {
    private QuickUnion quickUnion;
    @Before
    public void initialize() {
        quickUnion = new QuickUnion(100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void union_initializeWithInvalidNumberOfComponents_throwsIllegalArgumentException() {
        quickUnion = new QuickUnion(-100);
    }

    @Test
    public void union_unionTwoIdx_shouldReturnTrue() {
        quickUnion.union(0,1);
        quickUnion.union(1,2);
        quickUnion.union(2,3);
        assertTrue(quickUnion.isConnected(0,1));
        assertTrue(quickUnion.isConnected(1,0));
        assertTrue(quickUnion.isConnected(0,2));
        assertTrue(quickUnion.isConnected(0,3));
        assertTrue(quickUnion.isConnected(3,0));
    }

    @Test
    public void union_checkComponentThatNotConnected_shouldReturnFalse() {
        assertFalse(quickUnion.isConnected(5,2));
        assertFalse(quickUnion.isConnected(2,5));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void union_withInvalidIndex_throwIndexOutOfBoundsException() {
        quickUnion.union(200,300);
    }

    @After
    public void destroy() {
        quickUnion = null;
    }
}
