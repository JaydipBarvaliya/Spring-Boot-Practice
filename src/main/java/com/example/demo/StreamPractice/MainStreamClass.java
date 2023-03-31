package com.example.demo.StreamPractice;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainStreamClass {

    public static void main(String[] args) {


        List<Employee1> empList = new ArrayList<>();
        empList.add(new Employee1(101, "Jaydip", 101, "active", 2000));
        empList.add(new Employee1(102, "John", 101, "active", 5000));
        empList.add(new Employee1(103, "James", 102, "inactive", 6000));
        empList.add(new Employee1(104, "Harry", 102, "inactive", 4000));
        empList.add(new Employee1(105, "Hanz", 103, "active", 3500));
        empList.add(new Employee1(106, "Bond", 103, "inactive", 3500));
        empList.add(new Employee1(107, "Michal", 104, "active", 3500));


//        Print employee details based on department
        Map<Integer, List<PracticeEmployee>> empListBasedOnDep = empList.stream().collect(Collectors.groupingBy(PracticeEmployee::getDepId, Collectors.toList()));
        empListBasedOnDep.entrySet().forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()) );



//        Print employee count working in each department
        Map<Integer, Long>  empCountBasedOnDep = empList.stream().collect(Collectors.groupingBy(PracticeEmployee::getDepId, Collectors.counting()));
        empCountBasedOnDep.entrySet().forEach(entry -> System.out.println(entry.getKey() +" : "+entry.getValue()));



//        Print active and inactive employees in given collection
        Map<String, List<PracticeEmployee>> empListBasedOnStatus = empList.stream().collect(Collectors.groupingBy(PracticeEmployee::getStatus, Collectors.toList()));
        empListBasedOnStatus.entrySet().forEach( entry -> System.out.println(entry.getKey() + " : "+ entry.getValue()) );



//        Print only count of active and inactive employees
        Long activeEmployees = empList.stream().filter(emp -> emp.getStatus().equals("active")).count();
        Long inactiveEmployees = empList.stream().filter(emp -> emp.getStatus().equals("inactive")).count();
        System.out.println("activeEmployees : " + activeEmployees );
        System.out.println("InActiveEmployees : " + inactiveEmployees);



//        Print Max/Min Employee salary from given collection
        Optional<PracticeEmployee> empWithMinSalary = empList.stream().min(Comparator.comparing(PracticeEmployee::getSalary));
        Optional<PracticeEmployee> empWithMaxSalary = empList.stream().max(Comparator.comparing(PracticeEmployee::getSalary));
        System.out.println("Min Salary Employee : " + empWithMinSalary.get());
        System.out.println("Max Salary Employee : " + empWithMaxSalary.get());



//        Print Max salary of an employee from each department
        Map<Integer, List<PracticeEmployee>> empBasedOnDep = empList.stream().collect(Collectors.groupingBy(PracticeEmployee::getDepId, Collectors.toList()));
        empBasedOnDep.entrySet().forEach(entry ->
                System.out.println(entry.getValue().stream().max(Comparator.comparing(PracticeEmployee::getSalary)).get()));


//        Using MaxBy Function
        Map<Integer, Optional<Employee1>> empBasedOnDeps = employees.stream().collect(Collectors.groupingBy(Employee1::getDepId, Collectors.maxBy(Comparator.comparing(Employee1::getSalary))));
        empBasedOnDeps.entrySet().forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));


//        Print Max salary of an employee from each department -- same as above but in different way
        Map<Integer, Optional<PracticeEmployee>> empBasedOnDepWithReducing = empList.stream().collect(Collectors.groupingBy(PracticeEmployee::getDepId, Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(PracticeEmployee::getSalary)))));
        empBasedOnDepWithReducing.entrySet().forEach(entry ->
                        System.out.println(entry.getKey() + " : " + entry.getValue()));

//        Total salary given by organization to all the employees
        int totalSalaryOfAllEmp = empList.stream()
                                         .map(emp -> emp.getSalary())
                                         .reduce(0, Integer::sum);
        System.out.println(totalSalaryOfAllEmp);

//        Sum of salary given by each department
        Map<Integer, List<Employee1>> emps = employees.stream().collect(Collectors.groupingBy(Employee1::getDepId, Collectors.toList()));
        emps.entrySet().forEach(entry -> System.out.println(entry.getKey() +  " : "+ entry.getValue().stream().map(emp -> emp.getSalary()).reduce(0, Integer::sum)));



//        Sum of all elements
        Integer sumResult = Stream.of(1,2,10,3,4,5,6).reduce(0, (a, b) -> a+b); //Best way us ==> reduce(0, Integer::sum);
        System.out.println(sumResult);

//        Max of all elements
        Integer sumResult1 = Stream.of(1,2,10,3,4,5,6).reduce(0, (a, b) -> a>b?a:b);  //Best way ==> reduce(0, Integer::max)
        System.out.println(sumResult1);


//        Longest string in List
        List<String> words = Arrays.asList("core-java", "spring","hibernate");
        String longestStr =  words.stream().reduce((s1, s2) -> s1.length() > s2.length() ? s1 : s2).get();
        System.out.println(longestStr);



        List<Employee2> empList2 = new ArrayList<>();

        empList2.add(new Employee2(101,"john","A",60000));
        empList2.add(new Employee2(109,"peter","B",30000));
        empList2.add( new Employee2(102,"mak","A",80000));
        empList2.add(new Employee2(103,"kim","A",90000));
        empList2.add(new Employee2(104,"json","C",15000));



//        Grade wise printing
        Map<String, List<Employee2>> employeesWithGradeA = empList2.stream().collect(Collectors.groupingBy(Employee2::getGrade, Collectors.toList()));
        employeesWithGradeA.entrySet().forEach(entry -> System.out.println(entry));


//        Average salary of Grade A Employee
        OptionalDouble averageSalary = empList2.stream()
                .filter(emp -> emp.getGrade().equalsIgnoreCase("A"))
                .map(emp -> emp.getSalary())
                .mapToDouble(i -> i)
                .average();
        System.out.println(averageSalary);



//        Print the square of each element in list
        List<Integer> integerList = Arrays.asList(1,2,3,4,5);
        integerList.stream().map(ele -> ele*ele).forEach(System.out::println);



//        Print Even & Odd
        List<Integer> integerList = Arrays.asList(1,2,3,4,5);
        integerList.stream().filter(ele -> ele%2==0).forEach(System.out::println);
        integerList.stream().filter(ele -> ele%2!=0).forEach(System.out::println);

//        Print Numbers starting with Prefix 2 even if it's negative
        List<Integer> integerList = Arrays.asList(2, -2, 22, 234, 567, 890, 432, 234, 211, 22);
        integerList.stream()
                  .map(String ::valueOf)
                  .filter(ele -> ele.startsWith("2") || ele.startsWith("-2"))
                  .map(Integer::valueOf)
                  .forEach(System.out::println);



//        Check the frequency of the given integer in the given list
        List<Integer> integerList = Arrays.asList(1,2,3,4,5,2,3,4,5);
        System.out.println(Collections.frequency(integerList, 3));


//        Check the frequency of the given string in the given list
        List<String> words = Arrays.asList("Hello", "World", "This", "is", "Stream", "API", "This", "THis", "this", "This");
        System.out.println(Collections.frequency(words, "This"));



//        Check the frequency of the given string in the given MIX-list
        List mixOfIntAndStrings = new ArrayList();
        mixOfIntAndStrings.add("Hello");
        mixOfIntAndStrings.add(1);
        mixOfIntAndStrings.add("World");
        mixOfIntAndStrings.add(2);
        System.out.println(Collections.frequency(mixOfIntAndStrings, "Hello"));;



//        print single copy of each element which are duplicates
        List<Integer> integerList = Arrays.asList(1,2,3,4,5,2,3,4,5);
        Set<Integer> duplicates = integerList.stream().filter(ele -> Collections.frequency(integerList, ele) > 1).collect(Collectors.toSet());
        System.out.println(duplicates);


//        Find Max & Min number in given list
        List<Integer> integerList = Arrays.asList(-1,0,1,2,3,4,5,2,3,4,5);
        System.out.println(integerList.stream().max(Comparator.comparing(Integer::valueOf)).get());
        System.out.println(integerList.stream().min(Comparator.comparing(Integer::valueOf)).get());

//        Find Max & Min using lambda function instead of method references
        System.out.println(integerList.stream().min((e1,e2) -> e2-e1).get());
        System.out.println(integerList.stream().min((e1,e2) -> e1-e2).get());

//        Find Max & Min using Reduce method of stream
        System.out.println( integerList.stream().reduce(1, (a, b) -> a > b ? a : b));
        System.out.println( integerList.stream().reduce(1, (a, b) -> a < b ? a : b));


//        Sort the given list using stream
        List<Integer> integerList = Arrays.asList(50,40,30,20,-1,0,1,2,3,4,5,2,3,4,5);
//        ASC
        integerList.stream().sorted().forEach(num -> System.out.println(num));
//        DES
        integerList.stream().sorted((a,b) -> a>b?a:b).forEach(num -> System.out.println(num));
        integerList.stream().sorted(Collections.reverseOrder()).forEach(num -> System.out.println(num));



//        Get/ignore first 5 numbers using Limit & Skip in Streams
        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6,7,8,9);
//        Get first 5
        integerList.stream().limit(5).forEach(System.out::println);
//        Ignore first 5
        integerList.stream().skip(5).forEach(System.out::println);


//        Get Second Highest/Lowest Number using Streams
        List<Integer> integerList = Arrays.asList(2,1,2,6,4,5,10,7,8,9,10);
//      Second Lowest
        integerList.stream().sorted().distinct().limit(2).skip(1).forEach(System.out::println);
//      Second Highest
        integerList.stream().sorted(Collections.reverseOrder()).distinct().limit(2).skip(1).forEach(System.out::println);


//         Lambda with/without curly bracket
        List<Integer> integerList = Arrays.asList(2,1,2,6,4,5,10,7,8,9,10);
        integerList.forEach(num -> System.out.println("SINGLE STATEMENT without { Brackets"));
        integerList.forEach(num -> {
            System.out.println("MULTIPLE STATEMENT with { Brackets");
            System.out.println("MULTIPLE STATEMENT with { Brackets");
        });

    }
}