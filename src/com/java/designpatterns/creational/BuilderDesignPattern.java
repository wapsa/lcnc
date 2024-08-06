package com.java.designpatterns.creational;

import com.java.designpatterns.creational.BuilderDesignPattern.House.HouseBuilder;

/**
 * When to Use the Builder Pattern
 * 
 * When the object construction involves many parameters.
 * 
 * When the object construction process is complex and involves multiple steps.
 * 
 * When you want to create different representations of the same object.
 * 
 * Examples:
 * 
 * java.lang.StringBuilder#append() (unsynchronized)
 * 
 * java.lang.StringBuffer#append() (synchronized)
 */
public class BuilderDesignPattern {

	public static void main(String[] args) {
		House house = new HouseBuilder().setRooms(4).setWindows(8).build();
		System.out.println(house);
	}

	static class House {
		private int rooms;
		private int windows;

		// Private constructor to enforce the use of the Builder
		private House(HouseBuilder builder) {
			this.rooms = builder.rooms;
			this.windows = builder.windows;
		}

		public int getRooms() {
			return rooms;
		}

		public int getWindows() {
			return windows;
		}

		static class HouseBuilder {
			private int rooms;
			private int windows;

			public HouseBuilder setRooms(int rooms) {
				this.rooms = rooms;
				return this;
			}

			public HouseBuilder setWindows(int windows) {
				this.windows = windows;
				return this;
			}

			// Build method to construct the House object
			public House build() {
				return new House(this);
			}
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("House [rooms=").append(rooms).append(", windows=").append(windows).append("]");
			return builder.toString();
		}
	}
}
