package com.assignment;

public class IdGenerator {
    static int min = 10000;
    static int max = 99999;
    static int generate(){
        return (int)Math.floor(Math.random()*(IdGenerator.max-IdGenerator.min+1)+IdGenerator.min);
    }
}
