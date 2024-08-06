package com.java.designpatterns.behavioral;

/**
 * 
 * The Strategy Design Pattern is a behavioral design pattern that defines a
 * family of algorithms, encapsulates each one of them, and makes them
 * interchangeable. This pattern allows the algorithm to vary independently from
 * clients that use it. The key idea is to enable selecting an algorithm's
 * behavior at runtime.
 * 
 * Imagine an e-commerce application where users can pay using different payment
 * methods such as credit card, PayPal, or Google Pay. The Strategy Pattern can
 * be used to encapsulate these payment algorithms.
 */
public class StrategyDesignPattern {

	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();

		// Pay using PayPal
		cart.setPaymentStrategy(new PayPalPayment("johndoe@example.com", "password123"));
		cart.checkout(200);

		// Pay using Google Pay
		cart.setPaymentStrategy(new GooglePayPayment("9876543210", "1234"));
		cart.checkout(300);
	}

	static interface PaymentStrategy {
		void pay(int amount);
	}

	static class ShoppingCart {
		private PaymentStrategy paymentStrategy;

		public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
			this.paymentStrategy = paymentStrategy;
		}

		public void checkout(int amount) {
			paymentStrategy.pay(amount);
		}
	}

	static class PayPalPayment implements PaymentStrategy {

		public PayPalPayment(String emailId, String password) {
		}

		@Override
		public void pay(int amount) {
			System.out.println(amount + " paid using PayPal.");
		}
	}

	static class GooglePayPayment implements PaymentStrategy {

		public GooglePayPayment(String phoneNumber, String pin) {
		}

		@Override
		public void pay(int amount) {
			System.out.println(amount + " paid using Google Pay.");
		}
	}

}
