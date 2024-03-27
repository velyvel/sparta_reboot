package com.company.day0;

public interface Animal {
    String sound();
}

class Dog implements Animal {
    public String sound() {
        return "멍멍";
    }
}

class Cat implements Animal {
    public String sound() {
        return "야옹";
    }
}

class Testdd {
    public static void main(String[] args) {
        Animal[] animals = {new Dog(), new Cat()};
        for(Animal animal : animals) {
            System.out.println(animal.sound());
        }
    }
}