package com.java.designpatterns.behavioral;

import java.util.ArrayList;
import java.util.List;

public class VisitorDesignPattern {

	public static void main(String[] args) {
		ShapeCollection shapeCollection = new ShapeCollection();
		shapeCollection.addShape(new Circle());
		shapeCollection.addShape(new Rectangle());

		Visitor areaVisitor = new AreaVisitor();
		Visitor perimeterVisitor = new PerimeterVisitor();

		shapeCollection.accept(areaVisitor);
		shapeCollection.accept(perimeterVisitor);
	}

	static interface Shape {
		void accept(Visitor visitor);
	}

	static class Circle implements Shape {
		@Override
		public void accept(Visitor visitor) {
			visitor.visit(this);
		}
	}

	static class Rectangle implements Shape {
		@Override
		public void accept(Visitor visitor) {
			visitor.visit(this);
		}
	}

	static interface Visitor {
		void visit(Circle circle);

		void visit(Rectangle rectangle);
	}

	static class AreaVisitor implements Visitor {
		@Override
		public void visit(Circle circle) {
			System.out.println("Circle Area");
		}

		@Override
		public void visit(Rectangle rectangle) {
			System.out.println("Rectangle Area");
		}
	}

	// Concrete visitor
	static class PerimeterVisitor implements Visitor {
		@Override
		public void visit(Circle circle) {
			System.out.println("Circle Perimeter");
		}

		@Override
		public void visit(Rectangle rectangle) {
			System.out.println("Rectangle Perimeter");
		}
	}

	static class ShapeCollection {
		private List<Shape> shapes = new ArrayList<>();

		public void addShape(Shape shape) {
			shapes.add(shape);
		}

		public void accept(Visitor visitor) {
			for (Shape shape : shapes) {
				shape.accept(visitor);
			}
		}
	}

}
