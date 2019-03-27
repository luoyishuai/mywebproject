package com.yishuailuo.mywebproject.j2se.collectionframework.comparableandcomparator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Comparable<Employee> {
    
    private int id;
    private String name;
    private int salary;
    
    @Override
    public int compareTo(Employee o) {
        return id - o.id;
    }
    
    static Comparator<Employee> salaryComparator = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o2.getSalary() - o1.getSalary();
        }
    };
}
