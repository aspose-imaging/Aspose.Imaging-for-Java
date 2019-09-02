package com.aspose.imaging.examples.ManipulatingPNGImages;

import com.aspose.imaging.Color;
import com.aspose.imaging.Image;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.Rectangle;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.png.PngColorType;
import com.aspose.imaging.fileformats.png.PngImage;

public class SpecifyTransparency
{
    public static void main(String... args)
    {
		//ExStart:SpecifyTransparency

        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ConvertingImages/";

        // Initialize variables to hold width & height values
        int width;
        int height;

        // Initialize an array of type Color to hold the pixel data
        Color[] pixels;

        // Create an instance of RasterImage and load a BMP image
        RasterImage raster = (RasterImage) Image.load(dataDir + "aspose-logo.jpg");
		try
		{
			// Store the width & height in variables for later use
			width = raster.getWidth();
			height = raster.getHeight();

			// Load the pixels of RasterImage into the array of type Color
			pixels = raster.loadPixels(new Rectangle(0, 0, width, height));

			// Create & initialize an instance of PngImage while specifying size and PngColorType
			PngImage png = new PngImage(width, height, PngColorType.TruecolorWithAlpha);
			try
			{
				// Save the previously loaded pixels on to the new PngImage
				png.savePixels(new Rectangle(0, 0, width, height), pixels);

				// Set TransparentColor property to specify which color to be rendered as transparent
				png.setTransparentColor(Color.getBlack());

				// Save the result on disc
				png.save(dataDir + "SpecifyTransparency_out.jpg");
			}
			finally
			{
				png.close();
			}
		}
		finally
		{
			raster.close();
		}
		//ExEnd:SpecifyTransparency
    }

}
