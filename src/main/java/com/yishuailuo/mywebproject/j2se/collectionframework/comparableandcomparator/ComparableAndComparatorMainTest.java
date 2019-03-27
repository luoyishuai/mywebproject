package com.yishuailuo.mywebproject.j2se.collectionframework.comparableandcomparator;

import java.util.Arrays;

public class ComparableAndComparatorMainTest {
    
    public static void main(String[] args) {
        Employee[] employees = new Employee[3];
        Employee employee1 = Employee.builder().id(1).name("111").salary(1000).build();
        Employee employee2 = Employee.builder().id(2).name("222").salary(200).build();
        Employee employee3 = Employee.builder().id(3).name("333").salary(300).build();
        employees[0] = employee1;
        employees[1] = employee2;
        employees[2] = employee3;
        Arrays.sort(employees);
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    
        System.out.println("salaryComparator");
        
        Arrays.sort(employees, Employee.salaryComparator);
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }
}
