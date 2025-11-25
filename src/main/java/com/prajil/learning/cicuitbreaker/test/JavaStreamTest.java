package com.prajil.learning.cicuitbreaker.test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class JavaStreamTest {

    public static void main (String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie", "David", "Eve");

      Optional<String> result=  names.stream().filter(a-> a.startsWith("C") ).findFirst();
        result.ifPresent(System.out::println);


        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        List<Integer> newNumbers = numbers.
                stream().
                peek(System.out::println).
                map( a -> a * a ).toList();

        System.out.println("Squared Numbers: " + newNumbers);

        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);

        List<List<String>> nameLists = List.of(
            List.of("Alice", "Bob"),
            List.of("Charlie", "David"),
            List.of("Eve")
        );

        nameLists.stream()
            .flatMap(List::stream)
            .forEach(System.out::println);


        List<Integer> duplicateNumbers = List.of(1, 2, 3, 4, 5,7,3,2,1);

        duplicateNumbers.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        List<Employee> employeeList = List.of(
            new Employee("John", "HR", 50000),
            new Employee("Jane", "IT", 60000),
                new Employee("Prajil", "IT", 60000),
            new Employee("Doe", "Finance", 55000)
        );

       Map<String,List<Employee>> groupedEMployee= employeeList.stream().
               collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(groupedEMployee);

        Map<Boolean,List<Employee>> partitionedEmployee= employeeList.stream().
                collect(Collectors.partitioningBy (e -> e.getSalary() > 5000 ));

        System.out.println("Partitioned Employee"+partitionedEmployee.get(true));
    }
}
