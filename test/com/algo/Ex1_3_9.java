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
 * @date 2021/4/610:21 上午
 */
public class Ex1_3_9 {

    @Test
    public void run() {
        String input = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
        String output = "( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )";
        Assert.assertEquals(output, appendBrace(input));
    }

    protected String appendBrace(String input) {
        Stack<String> pieces = new Stack<>();
        Arrays.stream(input.split(" ")).forEach(str -> {
            if (str.equals(")")) {
                String back = pieces.pop();
                String operator = pieces.pop();
                String front = pieces.pop();
                pieces.push("( " + front + " " + operator + " " + back + " )");
            } else {
                pieces.push(str);
            }
        });
        return pieces.pop();
    }
}
