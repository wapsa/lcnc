package com.java.designpatterns.structural;

/**
 * The proxy controls access to the real object, providing additional
 * functionality like lazy initialization, logging, or access control.
 * 
 * The proxy encapsulates the real object, hiding its complexity from the
 * client.
 * 
 * In the case of a virtual proxy, resource-intensive objects are created only
 * when needed.
 * 
 * Protection proxies can add security measures to control access to the real
 * object.
 */
public class ProxyDesignPattern {

	public static void main(String[] args) {
		Image image1 = new ProxyImage("test_10mb.jpg");

		// Image will be loaded from disk and displayed
		image1.display();
		// Image will be displayed directly without loading from disk
		image1.display();
		// Image will be displayed directly without loading from disk
		image1.display();
	}

	static interface Image {
		void display();
	}

	static class RealImage implements Image {
		private String filename;

		public RealImage(String filename) {
			this.filename = filename;
			loadFromDisk();
		}

		private void loadFromDisk() {
			System.out.println("Loading " + filename);
		}

		@Override
		public void display() {
			System.out.println("Displaying " + filename);
		}
	}

	static class ProxyImage implements Image {
		private RealImage realImage;
		private String filename;

		public ProxyImage(String filename) {
			this.filename = filename;
		}

		@Override
		public void display() {
			if (realImage == null) {
				realImage = new RealImage(filename);
			}
			realImage.display();
		}
	}

}
