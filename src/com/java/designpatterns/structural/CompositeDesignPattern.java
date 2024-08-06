package com.java.designpatterns.structural;

import java.util.ArrayList;
import java.util.List;

/**
 * When to Use the Composite Pattern?
 * 
 * When you need to represent part-whole hierarchies of objects.
 * 
 * When clients should be able to ignore the difference between compositions of
 * objects and individual objects.
 * 
 * When dealing with tree structures, like file systems, HTML/XML documents, or
 * organizational structures.
 * 
 * The Composite Design Pattern is powerful in scenarios where you have
 * hierarchical structures and want to treat both individual objects and
 * composites uniformly, thereby simplifying client code and making the system
 * more flexible and scalable.
 */
public class CompositeDesignPattern {

	public static void main(String[] args) {
		Shape rectangle = new Rectangle();
		Shape circle = new Circle();

		Drawing drawing = new Drawing();
		drawing.add(rectangle);
		drawing.add(circle);

		drawing.draw("Red");

		drawing.add(rectangle);
		drawing.add(circle);
		drawing.draw("Green");
	}

	static interface Shape {
		public void draw(String color);
	}

	static class Rectangle implements Shape {
		@Override
		public void draw(String color) {
			System.out.println("Drawing Rectangle with color " + color);
		}
	}

	static class Circle implements Shape {
		@Override
		public void draw(String color) {
			System.out.println("Drawing Circle with color " + color);
		}
	}

	static class Drawing implements Shape {
		// collection of Shapes
		private List<Shape> shapes = new ArrayList<>();

		@Override
		public void draw(String color) {
			for (Shape sh : shapes)
				sh.draw(color);
		}

		// adding shape to drawing
		public void add(Shape s) {
			this.shapes.add(s);
		}
	}

}
