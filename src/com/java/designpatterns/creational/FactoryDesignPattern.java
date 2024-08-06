package com.java.designpatterns.creational;

/**
 * 
 * In the Abstract Factory pattern, we get rid of if-else block and have a
 * factory class for each sub-class. Then an Abstract Factory class that will
 * return the sub-class based on the input factory class.
 * 
 * Examples:
 * 
 * java.nio.charset.Charset#forName()
 */
public class FactoryDesignPattern {

	public static void main(String[] args) {
		Shape shape1 = ShapeFactory.getShape("CIRCLE");
		shape1.draw();

		Shape shape2 = ShapeFactory.getShape("RECTANGLE");
		shape2.draw();
	}

	static interface Shape {
		void draw();
	}

	static class Circle implements Shape {
		@Override
		public void draw() {
			System.out.println("Drawing a Circle");
		}
	}

	static class Rectangle implements Shape {
		@Override
		public void draw() {
			System.out.println("Drawing a Rectangle");
		}
	}

	static class ShapeFactory {
		public static Shape getShape(String shapeType) {
			if (shapeType == null) {
				return null;
			}
			if (shapeType.equalsIgnoreCase("CIRCLE")) {
				return new Circle();
			} else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
				return new Rectangle();
			}
			return null;
		}
	}

}
