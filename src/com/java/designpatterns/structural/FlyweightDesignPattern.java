package com.java.designpatterns.structural;

import java.util.HashMap;
import java.util.Map;

/**
 * you can think of the Flyweight Pattern as a type of cache. The Flyweight
 * Pattern uses a shared pool of objects, which can be reused to avoid creating
 * multiple instances of the same object, thereby saving memory and improving
 * performance. This is similar to how a cache stores frequently accessed data
 * to improve retrieval times and reduce resource consumption.
 */
public class FlyweightDesignPattern {

	public static void main(String[] args) {
		CircleFactory factory = new CircleFactory();
		Circle circle = factory.getCircle(5);
		circle.draw();

		circle = factory.getCircle(10);
		circle.draw();

		circle = factory.getCircle(5);
		circle.draw();
	}

	public interface Circle {
		void draw();
	}

	static class ConcreteCircle implements Circle {
		private int radius;

		public ConcreteCircle(int radius) {
			this.radius = radius;
		}

		@Override
		public void draw() {
			System.out.println("Drawing circle with radius: " + radius);
		}
	}

	static class CircleFactory {
		private final Map<Integer, Circle> circleMap = new HashMap<>();

		public Circle getCircle(int radius) {
			Circle circle = circleMap.get(radius);
			if (circle == null) {
				circle = new ConcreteCircle(radius);
				circleMap.put(radius, circle);
				System.out.println("Creating circle with radius: " + radius);
			}
			return circle;
		}
	}
}
