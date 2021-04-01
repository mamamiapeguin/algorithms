package com.algo;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author argomarz
 * @date 2021/4/12:30 下午
 */
public class FixCapacityStackTest {

    @Test
    public void testIsFull() {
        FixCapacityStack<String> s;
        s = new FixCapacityStack<String>(10);
        Arrays.asList(new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"}).forEach(c -> {
            s.push(c);
        });
        Assert.assertTrue(s.isFull());
    }

    @Test
    public void testIsEmpty() {
        FixCapacityStack<String> s;
        s = new FixCapacityStack<String>(10);
        Assert.assertTrue(s.isEmpty());
    }
}