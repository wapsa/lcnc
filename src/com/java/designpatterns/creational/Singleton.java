package com.java.designpatterns.creational;

/**
 * 
 * The singleton pattern restricts the instantiation of a Class and ensures that
 * only one instance of the class exists in the Java Virtual Machine.
 * 
 * Private constructor to restrict instantiation of the class from other
 * classes.
 * 
 * Private static variable of the same class that is the only instance of the
 * class.
 * 
 * Public static method that returns the instance of the class, this is the
 * global access point for the outer world to get the instance of the singleton
 * class.
 * 
 * 
 * Examples:
 * 
 * java.lang.Runtime#getRuntime()
 * 
 * java.awt.Desktop#getDesktop()
 * 
 * java.lang.System#getSecurityManager()
 */
public interface Singleton {

	// EAGER INIT
	enum EnumSingleton {

		INSTANCE;

		public static void doSomething() {
			// do something
		}
	}

	// LAZY INIT
	class BillPughSingleton {

		private BillPughSingleton() {
		}

		private static class SingletonHelper {
			private static final BillPughSingleton INSTANCE = new BillPughSingleton();
		}

		public static BillPughSingleton getInstance() {
			return SingletonHelper.INSTANCE;
		}
	}

}
