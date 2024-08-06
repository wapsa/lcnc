package com.java.designpatterns.behavioral;

public class CommandDesignPattern {

	public static void main(String[] args) {
		Service audioService = new AudioCommand();
		Service displayService = new DisplayCommand();
		Service videoService = new VideoCommand();

		ServiceInvoker invoker = new ServiceInvoker();

		invoker.executeCommand(audioService);
		invoker.executeCommand(displayService);
		invoker.executeCommand(videoService);
	}

	static interface Service {
		void process();
	}

	static class ServiceInvoker {
		public void executeCommand(Service command) {
			// pre-process
			command.process();
			// post-process
		}
	}

	static class AudioCommand implements Service {
		@Override
		public void process() {
			System.out.println("AUDIO!");
		}
	}

	static class DisplayCommand implements Service {
		@Override
		public void process() {
			System.out.println("DISPLAY!");
		}
	}

	static class VideoCommand implements Service {
		@Override
		public void process() {
			System.out.println("VIDEO!");
		}
	}

}
