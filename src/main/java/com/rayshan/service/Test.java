package com.rayshan.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Test {
    public static void main(String[] args) {
        //Sayable sayable = Test::saySomething;
        //sayable.say("Johm");

        Test test = new Test();
//        Sayable sayable = test::saySomething2;
//        sayable.say("JJJ");

//        List<String> all = new ArrayList<>();
//        all.add("A");
//        all.add("B");
//        all.add("C");
//
//        all.forEach(System.out::println);

//        Predicate<String> isMale = sex -> sex.equals("Male");
//        Predicate<Integer> isAdult = age -> age > 18;
//        System.out.println("Result:" + isMale.test("Female"));
//        System.out.println("Result2:" + isAdult.test(20));

//        Function<String, Integer> getLength = (str) -> str.length();
//        Function<Integer, Integer> x10 = (length) -> length * 10;
//        test.printResult("abcd", getLength, x10);
//        test.printResult("111", getLength, x10);
//        test.printResult("12asdfgh", getLength, x10);

        BiFunction<String, String, String> concat = (a, b) -> a + b;
        System.out.println("====>" + concat.apply("Hello ", "World"));
    }

    public void printResult(String value, Function<String, Integer> fn, Function<Integer, Integer> x10) {
        System.out.println("Length:" + fn.andThen(x10).apply(value));
    }

    public static void saySomething(String input){
        System.out.println("Hello "+ input +" this is static method.");
    }

    public void saySomething2(String input){
        System.out.println("Hello "+ input +" this is static method.");
    }
}

interface Sayable{
    void say(String name);
}
