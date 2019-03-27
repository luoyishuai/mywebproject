package com.yishuailuo.mywebproject.mytest.designpattern.singleton;

import lombok.Getter;

import javax.annotation.concurrent.ThreadSafe;

@Getter
@ThreadSafe
public class Triple {
    
    private final static Integer NUM = 3;
    
    private Triple() {
    }
    
    private static class TripleResource {
        private static Triple[] triples = new Triple[NUM];
        static {
            for (int i = 0; i < NUM; i++) {
                triples[i] = new Triple();
            }
        }
    }
    
    public static Triple getTriple(int i) {
        return TripleResource.triples[i % NUM];
    }
    
    public static void main(String[] args) {
        Triple triple0 = Triple.getTriple(0);
        Triple triple1 = Triple.getTriple(1);
        Triple triple2 = Triple.getTriple(2);
        Triple triple3 = Triple.getTriple(3);
        Triple triple4 = Triple.getTriple(4);
        Triple triple5 = Triple.getTriple(5);
        System.out.println(triple0);
        System.out.println(triple1);
        System.out.println(triple2);
        System.out.println(triple3);
        System.out.println(triple4);
        System.out.println(triple5);
    }
}
