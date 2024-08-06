package com.java.designpatterns.creational;

/**
 * 
 * 
 * Examples:
 * 
 * java.nio.charset.Charset#forName()
 */
public class AbstractFactoryDesignPattern {

	public static void main(String[] args) {
		Shape shape1 = ShapeFactory.getShape(new CircleFactory(5));
		shape1.draw();
		Shape shape2 = ShapeFactory.getShape(new RectangleFactory(10, 5));
		shape2.draw();
	}

	static interface Shape {
		void draw();
	}

	static class Circle implements Shape {
		private final int radius;

		public Circle(final int radius) {
			this.radius = radius;
		}

		@Override
		public void draw() {
			System.out.println("Drawing a Circle, radius: " + radius);
		}
	}

	static class Rectangle implements Shape {
		private final int length;
		private final int breadth;

		public Rectangle(final int length, final int breadth) {
			this.length = length;
			this.breadth = breadth;
		}

		@Override
		public void draw() {
			System.out.println("Drawing a Rectangle, length: " + length + ", breadth: " + breadth);
		}
	}

	static interface ShapeAbstractFactory {
		Shape createShape();
	}

	static class CircleFactory implements ShapeAbstractFactory {
		private final int radius;

		public CircleFactory(final int radius) {
			this.radius = radius;
		}

		@Override
		public Shape createShape() {
			return new Circle(radius);
		}
	}

	static class RectangleFactory implements ShapeAbstractFactory {
		private final int length;
		private final int breadth;

		public RectangleFactory(final int length, final int breadth) {
			this.length = length;
			this.breadth = breadth;
		}

		@Override
		public Shape createShape() {
			return new Rectangle(length, breadth);
		}
	}

	static class ShapeFactory {
		public static Shape getShape(ShapeAbstractFactory factory) {
			return factory.createShape();
		}
	}

}
