package com.aspose.imaging.examples.ManipulatingDNGImages;

import com.aspose.imaging.fileformats.dng.decoder.ImageOtherParameters;
import com.aspose.imaging.fileformats.dng.decoder.ImageParameters;

public class AccessDNGImageProperties
{
    public static void main(String[] args)
    {
        //ExStart:AccessDNGImageProperties

        //Declare variables to store file path for input image.
        String sourceFiles = "Path_to_source_folder\\Source\\HDR - 3c.dng";

        // Create an instance of Image class and load an exiting DNG file.
        // Convert the image to DngImage object.
        com.aspose.imaging.fileformats.dng.DngImage objimage = (com.aspose.imaging.fileformats.dng.DngImage)
                com.aspose.imaging.Image.load(sourceFiles);

		try
		{
			ImageParameters imageDataParameters = objimage.getImgData().getImageDataParameters();
			System.out.println("Camera model:" + imageDataParameters.getModel());
			System.out.println("Camera manufacturer:" + imageDataParameters.getCameraManufacturer());
			System.out.println("Software:" + imageDataParameters.getSoftware());
			System.out.println("Colors count:" + imageDataParameters.getColorsCount());
			ImageOtherParameters imageOtherParameters = objimage.getImgData().getImageOtherParameters();
			System.out.println("Artist:" + imageOtherParameters.getArtist());
			System.out.println("Aperture:" + imageOtherParameters.getAperture());
			System.out.println("Focal length:" + imageOtherParameters.getFocalLength());
			System.out.println("Iso speed:" + imageOtherParameters.getIsoSpeed());
		}
		finally
		{
			objimage.close();
		}

		//ExEnd:AccessDNGImageProperties
    }

}
