package com.aspose.imaging.examples.files;

public class SavingtoStream {
	public static void main(String[] args) throws Exception {
		//Create an instance of FileOutputStream
		java.io.OutputStream os = new java.io.FileOutputStream("C:\\output.bmp");

		//Save the image using the Save method exposed by the Image class and pass the outputstream object
		image.save(os);
	}

}
