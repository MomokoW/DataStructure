package com.momoko.test;

/**
 * Created by momoko on 2021/6/3.
 */
public class TestValue {
    public void changeObject(Person p) {
        p = new Person();
        p.setName("李四");
        p.setAge(15);
    }

    public static void main(String[] args) {
        TestValue test = new TestValue();
        Person p1 = new Person();
        p1.setName("张山");
        p1.setAge(13);
        System.out.println("*****改变对象之前:*****");
        System.out.println(p1);
        System.out.println("*****改变对象之后:*****");
        test.changeObject(p1);
        System.out.println(p1);
    }
}