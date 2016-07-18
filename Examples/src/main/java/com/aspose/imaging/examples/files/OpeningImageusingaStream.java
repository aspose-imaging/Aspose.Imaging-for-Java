package com.aspose.imaging.examples.files;

public class OpeningImageusingaStream {
	public static void main(String[] args) throws Exception {
		// Create a Stream Object
		java.io.InputStream stream = stream = new java.io.FileInputStream("C:\\Sample.bmp");

		// Create an Image Object and open an existing file using the Stream
		// Object
		com.aspose.imaging.Image image = com.aspose.imaging.Image.load(stream);

		// do some image processing
	}

}
