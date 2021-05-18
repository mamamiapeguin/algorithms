package com.algo;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author argomarz
 * @date 2021/5/185:28 下午
 */
public class MSDTest {

    @Test
    public void run() {
        String[] a = {"she", "sells", "seashells", "by", "the", "seashore", "the", "shells", "she", "sells", "are", "surely", "seashells"};
        MSD.sort(a);
    }

}