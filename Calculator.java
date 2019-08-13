package fivepointtwo;

import java.util.Scanner;

abstract class Figure{
	double dim1;
	abstract void findArea();
	abstract void findPerimeter();
}

class Circle extends Figure{
	
	public Circle(double radius) {
		this.dim1 = radius;
	}
	void findArea() {
		System.out.println("Area = " + (Math.PI * Math.pow(dim1, 2)));
	}
	void findPerimeter() {
		System.out.println("Perimeter = " + (2 * Math.PI * dim1));
	}
	
	@Override
	public String toString() {
		return "Circle: "
				+ "\nRadius = " + dim1;
	}
}

class Rectangle extends Figure{
	double dim2;
	
	public Rectangle (double length, double width) {
		this.dim1 = length;
		this.dim2 = width;
	}
	void findArea() {
		System.out.println("Area = " + (dim1 * dim2));
	}
	void findPerimeter() {
		System.out.println("Perimeter = " + (2 * (dim1 + dim2)));
	}
	
	@Override
	public String toString() {
		return "Rectangle: "
				+ "\nlength = " + dim1 + "\twidth = " + dim2;
	}
}

class Triangle extends Figure{
	double dim2;
	double dim3;
	public Triangle(double side1, double side2, double side3) {
		this.dim1 = side1;
		this.dim2 = side2;
		this.dim3 = side3;
	}
	void findArea() {
		double p = 0.5 * (dim1 + dim2 + dim3);
		System.out.println("Area = " + (Math.sqrt(p * (p-dim1) * (p-dim2) * (p-dim3))));
	}
	void findPerimeter() {
		System.out.println("Perimeter = " + (dim1 + dim2 + dim3));
	}
	
	@Override
	public String toString() {
		return "Triangle: "
				+ "\nSide 1 = " + dim1 + "\tSide 2 = " + dim2 + "\tSide 3 = " + dim3;
	}
}

public class Calculator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double dim1, dim2, dim3;
		
		//making circle
		System.out.println("Circle: ");
		dim1 = scanDouble(sc, "Enter radius: ");
		Circle c = new Circle(dim1);
		System.out.println();
		
		//making rectangle
		System.out.println("Rectangle: ");
		dim1 = scanDouble(sc, "Enter length: ");
		dim2 = scanDouble(sc, "Enter width:");
		Rectangle r = new Rectangle(dim1, dim2);
		System.out.println();
		
		//making triangle
		System.out.println("Traingle:");
		dim1 = scanDouble(sc, "Enter side 1: ");
		dim2 = scanDouble(sc, "Enter side 2: ");
		dim3 = scanDouble(sc, "Enter side 3: ");
		Triangle t = new Triangle(dim1, dim2, dim3);
		System.out.println();

		sc. close();
		
		//display
		System.out.println(c);
		c.findArea();
		c.findPerimeter();
		
		System.out.println("\n" + r);
		r.findArea();
		r.findPerimeter();
		
		System.out.println("\n" + t);
		t.findArea();
		t.findPerimeter();
	}
	
	static Double scanDouble(Scanner sc, String prompt) {
		double num = 0;
		boolean pass = false;
		while (!pass) {
			System.out.print(prompt);
			try {
				num = sc.nextDouble();
				pass = true;
			} catch(Exception e){
				System.out.println("Input must be a number.");
			}
			if (sc.hasNextLine()) sc.nextLine();
		}
		return num;
	}
}