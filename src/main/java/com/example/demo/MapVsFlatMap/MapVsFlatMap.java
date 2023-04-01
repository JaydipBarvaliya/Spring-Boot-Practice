package com.example.demo.MapVsFlatMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapVsFlatMap {
    public static void main(String[] args) {

        List<Customer> customers = EkartDataBase.getAll();

        //List<Customer>  convert List<String> -> Data Transformation
        //mapping : customer -> customer.getEmail()
        //customer -> customer.getEmail()  one to one mapping
        List<String> emails = customers.stream()
                .map(customer -> customer.getEmail())
                .collect(Collectors.toList());
//        System.out.println(emails);

//customer -> customer.getPhoneNumbers()  ->> one to many mapping
        //customer -> customer.getPhoneNumbers()  ->> one to many mapping
        List<List<String>> phoneNumbers = customers.
                stream().map(customer -> customer.getPhoneNumbers())
                .collect(Collectors.toList());
//        System.out.println(phoneNumbers);

        //List<Customer>  convert List<String> -> Data Transformation
        //mapping : customer -> phone Numbers
        //customer -> customer.getPhoneNumbers()  ->> one to many mapping
        Optional<String> any = customers.stream()
                .flatMap(customer -> customer.getPhoneNumbers().stream())
                .filter(phoneNo -> phoneNo.equals("32"))
                .findAny();

//        System.out.println(any);


        List<Integer> even = Arrays.asList( 2, 4, 6, 8, 10);
        List<Integer> odd = Arrays.asList( 3, 5, 7, 9, 11);
        List<Integer> primes = Arrays.asList(17, 19, 23, 29, 31);

        List<List<Integer>> listOfNumbers = new ArrayList<>();
        listOfNumbers.add(even);
        listOfNumbers.add(odd);
        listOfNumbers.add(primes);

        System.out.println("list of numbers: " + listOfNumbers);


        List<Integer> collect = listOfNumbers
                .stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());

        System.out.println(collect);


    }

}
