package com.finetunecode.java.streams;

import com.finetunecode.java.streams.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilter {
    public static void main(String[] args) {
        var employees = new ArrayList<Employee>();

        employees.add(new Employee(1, "John", 45, 45000));
        employees.add(new Employee(2, "Joe", 23, 67850));
        employees.add(new Employee(3, "Chris", 34, 46000));
        employees.add(new Employee(4, "Peter", 52, 56000));
        employees.add(new Employee(5, "Loges", 10, 20000));
        employees.add(new Employee(6, "Annie", 43, 25700));
        employees.add(new Employee(7, "Boris", 29, 75000));
        employees.add(new Employee(8, "Emmie", 50, 90000));

        //filter by age >= 40
        var filteredList = filterByAge(employees);
        System.out.println(filteredList);
        System.out.println(filterByAgeInJava8(employees));

    }

    private static List<Employee> filterByAge(List<Employee> employees){

        List<Employee> filteredEmployees = new ArrayList<>();
        for(Employee employee: employees){
            if(employee.age() >= 40) {
                filteredEmployees.add(employee);
            }
        }
        return filteredEmployees;
    }

    private static List<Employee> filterByAgeInJava8(List<Employee> employees){

        return employees
                .stream()
                .filter(employee -> employee.age() >= 40)
                .collect(Collectors.toList());
    }
}
