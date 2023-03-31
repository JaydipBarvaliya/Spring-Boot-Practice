package com.example.demo.MethodReference;

import com.example.demo.StreamPractice.Employee2;

import java.util.ArrayList;
import java.util.List;

public class MainMethodReference {

    public static void main(String[] args) {


        List<Employee2> empList2 = new ArrayList<>();
        empList2.add(new Employee2(101,"john","A",60000));
        empList2.add(new Employee2(109,"peter","B",30000));

//        empList2
//                .stream()
//                .map(Employee2::emp2To1Converter)
//                .forEach(employee1 -> {
//                    System.out.println(employee1.getDepId());
//                    System.out.println(employee1.getStatus());
//                });;


        empList2
                .stream()
                .map(Employee2::getId)
                .map(ArrayList::new)
                        .forEach(System.out::println);


    }
}
