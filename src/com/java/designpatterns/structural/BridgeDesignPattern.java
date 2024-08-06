package com.java.designpatterns.structural;

public class BridgeDesignPattern {

	public static void main(String[] args) {
		Shape circle = new Circle(new RedColor());
		circle.applyColor();

		Shape rectangle = new Rectangle(new GreenColor());
		rectangle.applyColor();
	}

	static interface Color {
		public void applyColor();
	}

	abstract static class Shape {
		// Composition - implementor
		protected Color color;

		// constructor with implementor as input argument
		Shape(Color c) {
			this.color = c;
		}

		abstract void applyColor();
	}

	static class Circle extends Shape {
		public Circle(Color c) {
			super(c);
		}

		@Override
		public void applyColor() {
			System.out.print("Circle filled with color: ");
			color.applyColor();
		}

	}

	static class Rectangle extends Shape {
		public Rectangle(Color c) {
			super(c);
		}

		@Override
		public void applyColor() {
			System.out.print("Rectangle filled with color: ");
			color.applyColor();
		}
	}

	static class RedColor implements Color {
		@Override
		public void applyColor() {
			System.out.println("red.");
		}
	}

	static class GreenColor implements Color {
		@Override
		public void applyColor() {
			System.out.println("green.");
		}
	}

}
