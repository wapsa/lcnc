package com.java.designpatterns.structural;

public class DecoratorDesignPattern {

	public static void main(String[] args) {
		Coffee coffee = new SimpleCoffee();
		System.out.println(coffee.getDescription() + " $" + coffee.getCost());

		coffee = new MilkDecorator(coffee);
		System.out.println(coffee.getDescription() + " $" + coffee.getCost());

		coffee = new SugarDecorator(coffee);
		System.out.println(coffee.getDescription() + " $" + coffee.getCost());

	}

	static interface Coffee {
		int getCost();

		String getDescription();
	}

	static class SimpleCoffee implements Coffee {
		@Override
		public int getCost() {
			return 5;
		}

		@Override
		public String getDescription() {
			return "Simple coffee";
		}
	}

	abstract static class CoffeeDecorator implements Coffee {
		private Coffee decoratedCoffee;

		CoffeeDecorator(Coffee coffee) {
			this.decoratedCoffee = coffee;
		}

		@Override
		public int getCost() {
			return decoratedCoffee.getCost();
		}

		@Override
		public String getDescription() {
			return decoratedCoffee.getDescription();
		}
	}

	static class MilkDecorator extends CoffeeDecorator {
		MilkDecorator(Coffee coffee) {
			super(coffee);
		}

		@Override
		public int getCost() {
			return super.getCost() + 2;
		}

		@Override
		public String getDescription() {
			return super.getDescription() + ", +milk";
		}
	}

	static class SugarDecorator extends CoffeeDecorator {
		SugarDecorator(Coffee coffee) {
			super(coffee);
		}

		@Override
		public int getCost() {
			return super.getCost() + 1;
		}

		@Override
		public String getDescription() {
			return super.getDescription() + ", +sugar";
		}
	}
}
