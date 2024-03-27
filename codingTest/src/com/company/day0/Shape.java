package com.company.day0;

interface Shape {

    void draw();
}

class Circle implements Shape {
    public void draw() {
        System.out.println("동그라미 그려");
        }
}

class Square implements Shape {
    public void draw() {
        System.out.println("네모 그려");
    }
}

class Example {
    public static void main(String[] args) {
        Shape myShape = new Circle();
        myShape.draw();
        }

    }

