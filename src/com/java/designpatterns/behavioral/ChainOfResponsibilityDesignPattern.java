package com.java.designpatterns.behavioral;

/**
 * The Chain of Responsibility Pattern is a behavioral design pattern that
 * allows an object to pass a request along a chain of potential handlers until
 * one of them handles the request. This pattern decouples the sender of a
 * request from its receivers by giving multiple objects a chance to handle the
 * request.
 * 
 * Example: Logging System Imagine a logging system where log messages can be
 * processed by different loggers (e.g., console, file, error). The Chain of
 * Responsibility Pattern allows each logger to process the message or pass it
 * to the next logger in the chain.
 */
public class ChainOfResponsibilityDesignPattern {

	public static void main(String[] args) {
		Logger loggerChain = getChainOfLoggers();

		loggerChain.logMessage("A.");
		loggerChain.logMessage("B.");
		loggerChain.logMessage("C.");
	}

	private static Logger getChainOfLoggers() {
		Logger errorLogger = new ErrorLogger();
		Logger fileLogger = new FileLogger();
		Logger consoleLogger = new ConsoleLogger();

		errorLogger.setNextLogger(fileLogger);
		fileLogger.setNextLogger(consoleLogger);

		return errorLogger;
	}

	abstract static class Logger {
		// next element in chain or responsibility
		protected Logger nextLogger;

		public void setNextLogger(Logger nextLogger) {
			this.nextLogger = nextLogger;
		}

		public void logMessage(String message) {
			write(message);
			if (nextLogger != null) {
				nextLogger.logMessage(message);
			}
		}

		abstract void write(String message);
	}

	static class ConsoleLogger extends Logger {
		@Override
		protected void write(String message) {
			System.out.println("Console::Logger: " + message);
		}
	}

	static class ErrorLogger extends Logger {
		@Override
		protected void write(String message) {
			System.out.println("Error::Logger: " + message);
		}
	}

	static class FileLogger extends Logger {
		@Override
		protected void write(String message) {
			System.out.println("File::Logger: " + message);
		}
	}

}
