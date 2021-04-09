/*
 * Copyright 2021 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.algo;

import org.junit.Test;

/**
 * @author argomarz
 * @date 2021/4/811:18 上午
 */
public class Ex2_2_2 {

    @Test
    public void run() {
        String input = "EASYQUESTION";
        Character[] characters = new Character[input.length()];
        for (int i = 0; i < input.length(); i++) {
            characters[i] = new Character(input.toCharArray()[i]);
        }
        Merge.sort(characters);
    }
}
