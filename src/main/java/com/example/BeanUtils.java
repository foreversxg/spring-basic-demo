package com.example;


import com.atilika.kuromoji.ipadic.Token;
import com.atilika.kuromoji.ipadic.Tokenizer;

import java.io.IOException;
import java.util.List;


/**
 * @Author shaoxiangen
 * @Date create in 2019/8/16
 */
public class BeanUtils {

    public static void main(String[] args) throws IOException {
        Tokenizer tokenizer = new Tokenizer();
        List<Token> tokens = tokenizer.tokenize("昨日までの私は、もうどこにもいない");
        tokens.forEach(token -> System.out.println(token.getBaseForm()));
    }
}
