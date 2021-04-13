package com.algo;

import edu.princeton.cs.algs4.StdOut;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author argomarz
 * @date 2021/4/132:19 下午
 */
public class Ex3_1_2 {

    @Test
    public void put() {
        String input = "EASYQUESTION";
        Character[] characters = new Character[input.length()];
        for (int i = 0; i < input.length(); i++) {
            characters[i] = new Character(input.toCharArray()[i]);
        }
        ArrayST<Character, Integer> arrayST = new ArrayST<>();
        for (int i = 0; i < input.length(); i++) {
            arrayST.put(characters[i], i);
        }
        arrayST.keys().forEach(key -> {
            StdOut.printf("%s: %s\n", key, arrayST.get(key));
        });
    }

    @Test
    public void delete() {
        String input = "EASYQUESTION";
        Character[] characters = new Character[input.length()];
        for (int i = 0; i < input.length(); i++) {
            characters[i] = new Character(input.toCharArray()[i]);
        }
        ArrayST<Character, Integer> arrayST = new ArrayST<>();
        for (int i = 0; i < input.length(); i++) {
            arrayST.put(characters[i], i);
        }
        arrayST.delete(characters[0]);
        arrayST.delete(characters[2]);
        arrayST.keys().forEach(key -> {
            StdOut.printf("%s: %s\n", key, arrayST.get(key));
        });
    }

    @Test
    public void isEmpty() {
        ArrayST<Character, Integer> arrayST = new ArrayST<>();
        Assert.assertTrue(arrayST.isEmpty());
    }

    @Test
    public void contains() {
        String input = "EASYQUESTION";
        Character[] characters = new Character[input.length()];
        for (int i = 0; i < input.length(); i++) {
            characters[i] = new Character(input.toCharArray()[i]);
        }
        ArrayST<Character, Integer> arrayST = new ArrayST<>();
        for (int i = 0; i < input.length(); i++) {
            arrayST.put(characters[i], i);
        }
        Assert.assertTrue(arrayST.contains(characters[0]));
        Assert.assertTrue(arrayST.contains(characters[2]));
        arrayST.delete(characters[0]);
        arrayST.delete(characters[2]);
        Assert.assertFalse(arrayST.contains(characters[0]));
        Assert.assertFalse(arrayST.contains(characters[2]));
    }
}