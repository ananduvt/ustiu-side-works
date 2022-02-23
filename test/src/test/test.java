/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author u55369
 */
public class test {

    public static void main(String[] args) throws InterruptedException {

        List<String> list = new ArrayList<>();

        list.add("hello");

        System.out.println(list);
        list.add(0, "world");
        System.out.println(list);
        list.add(0, "tests");
        System.out.println(list);
    }

}
