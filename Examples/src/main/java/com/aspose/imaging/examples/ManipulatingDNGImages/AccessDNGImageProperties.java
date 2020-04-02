package com.aspose.imaging.examples.ManipulatingDNGImages;

import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.fileformats.dng.decoder.ImageOtherParameters;
import com.aspose.imaging.fileformats.dng.decoder.ImageParameters;

public class AccessDNGImageProperties
{
    public static void main(String[] args)
    {
		Logger.startExample("AccessDNGImageProperties");

        //Declare variables to store file path for input image.
        String sourceFiles = "Path_to_source_folder\\Source\\HDR - 3c.dng";

        // Create an instance of Image class and load an exiting DNG file.
        // Convert the image to DngImage object.
		try (com.aspose.imaging.fileformats.dng.DngImage objimage = (com.aspose.imaging.fileformats.dng.DngImage)
				com.aspose.imaging.Image.load(sourceFiles))
		{
			ImageParameters imageDataParameters = objimage.getImgData().getImageDataParameters();
			Logger.println("Camera model:" + imageDataParameters.getModel());
			Logger.println("Camera manufacturer:" + imageDataParameters.getCameraManufacturer());
			Logger.println("Software:" + imageDataParameters.getSoftware());
			Logger.println("Colors count:" + imageDataParameters.getColorsCount());
			ImageOtherParameters imageOtherParameters = objimage.getImgData().getImageOtherParameters();
			Logger.println("Artist:" + imageOtherParameters.getArtist());
			Logger.println("Aperture:" + imageOtherParameters.getAperture());
			Logger.println("Focal length:" + imageOtherParameters.getFocalLength());
			Logger.println("Iso speed:" + imageOtherParameters.getIsoSpeed());
		}

		Logger.endExample();
    }

}
