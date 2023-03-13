package com.example.demo;

import com.example.demo.Entities.Employee;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {



//        List<Integer> list = List.of(1,2,3,4,5);

//        list = null;



        List<Integer> list = new ArrayList<>();

        list.stream().forEach(System.out::println);

    }
}
