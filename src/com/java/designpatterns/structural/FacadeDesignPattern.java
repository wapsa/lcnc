package com.java.designpatterns.structural;

/**
 * The Facade Pattern is a structural design pattern that provides a simplified
 * interface to a complex subsystem. It offers a high-level interface that makes
 * the subsystem easier to use, without revealing the underlying complexities.
 * This pattern is often used to make a library, framework, or set of classes
 * easier to use.
 * 
 * Imagine a home theater system with various components like a DVD player,
 * amplifier, and projector. The Facade Pattern can be used to provide a
 * simplified interface to operate the entire system.
 */
public class FacadeDesignPattern {

	public static void main(String[] args) {
		DVDPlayer dvdPlayer = new DVDPlayer();
		Amplifier amplifier = new Amplifier();
		Projector projector = new Projector();

		HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvdPlayer, amplifier, projector);
		homeTheater.watchMovie("Inception");
		homeTheater.endMovie();
	}

	static class HomeTheaterFacade {
		private DVDPlayer dvdPlayer;
		private Amplifier amplifier;
		private Projector projector;

		public HomeTheaterFacade(DVDPlayer dvdPlayer, Amplifier amplifier, Projector projector) {
			this.dvdPlayer = dvdPlayer;
			this.amplifier = amplifier;
			this.projector = projector;
		}

		public void watchMovie(String movie) {
			System.out.println("Get ready to watch a movie...");
			projector.on();
			projector.setInput("DVD");
			amplifier.on();
			amplifier.setVolume(5);
			dvdPlayer.on();
			dvdPlayer.play(movie);
		}

		public void endMovie() {
			System.out.println("Shutting movie theater down...");
			dvdPlayer.off();
			amplifier.off();
			projector.off();
		}
	}

	static class DVDPlayer {
		public void on() {
			System.out.println("DVD Player is on.");
		}

		public void play(String movie) {
			System.out.println("Playing movie: " + movie);
		}

		public void off() {
			System.out.println("DVD Player is off.");
		}
	}

	static class Amplifier {
		public void on() {
			System.out.println("Amplifier is on.");
		}

		public void setVolume(int level) {
			System.out.println("Setting volume to " + level);
		}

		public void off() {
			System.out.println("Amplifier is off.");
		}
	}

	static class Projector {
		public void on() {
			System.out.println("Projector is on.");
		}

		public void setInput(String input) {
			System.out.println("Setting projector input to " + input);
		}

		public void off() {
			System.out.println("Projector is off.");
		}
	}

}
