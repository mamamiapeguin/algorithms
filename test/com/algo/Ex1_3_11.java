/*
 * Copyright 2021 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.algo;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author argomarz
 * @date 2021/4/611:27 上午
 */
public class Ex1_3_11 {

    @Test
    public void run() {
        String input = "( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )";
        String postfix = Ex1_3_10.infixToPostfix(input);
        Assert.assertEquals(Integer.valueOf(3), evaluatePostfix(postfix));
    }

    protected Integer evaluatePostfix(String input) {
        Stack<Integer> numbers = new Stack();
        Stack<String> operators = new Stack<>();
        Arrays.stream(input.split(" ")).forEach(str -> {
            if (Arrays.asList("+", "-", "*", "/").contains(str)) {
                Integer back = numbers.pop();
                Integer front = numbers.pop();
                switch (str) {
                    case "+":
                        numbers.push(front + back);
                        break;
                    case "-":
                        numbers.push(front - back);
                        break;
                    case "*":
                        numbers.push(front * back);
                        break;
                    case "/":
                        numbers.push( front / back);
                }
            } else {
                numbers.push(Integer.parseInt(str));
            }
        });
        return numbers.pop();
    }
}
