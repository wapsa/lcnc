package com.java.designpatterns.structural;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * Examples:
 * 
 * java.util.Arrays#asList()
 * 
 * java.util.Collections#list()
 * 
 * java.util.Collections#enumeration()
 * 
 * java.io.InputStreamReader(InputStream) (returns a Reader)
 * 
 * java.io.OutputStreamWriter(OutputStream) (returns a Writer)
 */
public class AdapterDesignPattern {

	public static void main(String[] args) {
		String[] strings = new String[] { "a", "b", "c" };
		List<String> list = Arrays.asList(strings);
		// Client code can use the Array as if it were a List
		list.forEach(item -> System.out.println(item));

		// ------------

		// Using the adapter to make FancyPrinter compatible with MessagePrinter
		FancyPrinter fancyPrinter = new FancyPrinter();
		MessagePrinter printerAdapter = new FancyPrinterAdapter(fancyPrinter);
		// Client code can use the adapter as if it were a MessagePrinter
		printerAdapter.printMessage("Hello world!");
	}

	static class FancyPrinter {
		public void display(String[] messages) {
			System.out.println("Fancy: " + Arrays.toString(messages));
		}
	}

	static interface MessagePrinter {
		void printMessage(String message);
	}

	static class FancyPrinterAdapter implements MessagePrinter {
		private FancyPrinter fancyPrinter;

		public FancyPrinterAdapter(FancyPrinter fancyPrinter) {
			this.fancyPrinter = fancyPrinter;
		}

		@Override
		public void printMessage(String message) {
			fancyPrinter.display(new String[] { message });
		}
	}

}