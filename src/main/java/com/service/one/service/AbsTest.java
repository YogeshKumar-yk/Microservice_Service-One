package com.service.one.service;

import org.apache.logging.log4j.util.TriConsumer;
import org.springframework.data.web.querydsl.QuerydslPredicateArgumentResolverSupport;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;
import java.util.function.*;
@ControllerAdvice
@RestControllerAdvice
public class AbsTest {

//    AbsTest a = new AbsTest() ;

    int a;
    int b = 10;

    static int p = 10;
//    AbsTest abs  = new AbsTest();

//    public void test(){
//
//    }

//    public abstract void test(int x);

    public void test2() {
    String s = "sss";

        Comparable comparable = new Comparable() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };

        List<Integer> list = Arrays.asList(1, 2, 3, 0, -5);

        list.stream().sorted(Comparator.reverseOrder());
        Collections.sort(list);



    }

    public void test() {
    }


    public void test(int x) {
    }

    public void test(String x) {
    }


    static int s = 10;
    int r = 7;

    void run() {

    }

    static void test3() {

    }

    void change() {
        AbsTest abs = new AbsTest();

        int s1 = AbsTest.s;
        AbsTest.test3();

        int s2 = abs.s;
        int r1 = abs.r;

        abs.run();
        abs.test3();

    }

    public static void test1() {
    }

    public static void test1(int x) {
    }

    public static void test1(int x, int y){

    }

    public static void staticTest(){
        AbsTest.test1(1,5);
        AbsTest.test1();
        AbsTest.test1(1);

    }



}