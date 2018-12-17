package com.yishuailuo.mywebproject.demo.codingguidelines.specification;

public class Person {
    
    private String name;
    
    private Integer age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
/*    @Override
    public boolean equals(Object obj) {
        Person person = (Person) obj;
        return this.name.equals(person.name) && this.age.equals(person.age);
    }*/
    
    @Override
    public int hashCode() {
        return name.hashCode() + age;
    }
}
