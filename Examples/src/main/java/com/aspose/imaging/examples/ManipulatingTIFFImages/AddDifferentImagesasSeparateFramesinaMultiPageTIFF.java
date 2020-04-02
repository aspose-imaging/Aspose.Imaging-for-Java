package com.aspose.imaging.examples.ManipulatingTIFFImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.ResizeType;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.tiff.TiffFrame;
import com.aspose.imaging.fileformats.tiff.TiffImage;
import com.aspose.imaging.fileformats.tiff.enums.TiffExpectedFormat;
import com.aspose.imaging.imageoptions.TiffOptions;
import com.aspose.imaging.sources.FileCreateSource;

import java.io.File;
import java.io.FilenameFilter;

public class AddDifferentImagesasSeparateFramesinaMultiPageTIFF
{
    public static void main(String... args)
    {
		Logger.startExample("AddDifferentImagesasSeparateFramesinaMultiPageTIFF");

        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ManipulatingTIFFImages/";

        // Create an instance of TiffOptions with CCITTFAX3 compression
        TiffOptions outputSettings = new TiffOptions(TiffExpectedFormat.TiffCcittFax3);
        // Set source for the result
        outputSettings.setSource(new FileCreateSource(Utils.getOutDir() + "output.tiff", false));

        // Declare Height and Width for the new TiffImage
        final int newWidth = 500;
        final int newHeight = 500;

        // Create an instance of TiffImage using the object of TiffOptions and dimension
        TiffImage tiffImage = (TiffImage) Image.create(outputSettings, newWidth, newHeight);
		try
		{
			// Initialize a variable to keep track of frames in the TiffImage
			int index = 0;
			// Read all JPG files from any specified directory and iterate over the list
			final File folder = new File("samples/");
			File[] files = folder.listFiles(new FilenameFilter()
			{
				public boolean accept(File dir, String name)
				{
					return name.toLowerCase().endsWith(".jpg");
				}
			});

			if (files == null)
				return;

			for (final File fileEntry : files)
			{
				// Load the image into an instance of RasterImage
				RasterImage image = (RasterImage) Image.load(fileEntry.getAbsolutePath());
				// Resize the image according to TiffImage dimensions
				image.resize(newWidth, newHeight, ResizeType.NearestNeighbourResample);
				// Get the active frame of TiffImage
				TiffFrame frame = tiffImage.getActiveFrame();
				// Save the RasterImage data onto TiffFrame
				frame.savePixels(frame.getBounds(), image.loadPixels(image.getBounds()));
				// Check if TiffImage already has a frame
				if (index > 0)
				{
					// Create a new TiffFrame according to the TiffOptions settings
					frame = new TiffFrame(new TiffOptions(outputSettings), newWidth, newHeight);
					// Add the newly created frame to the TiffImage
					tiffImage.addFrame(frame);
				}
				index++;
			}
			// Save the changes to TiffImage
			tiffImage.save();
		}
		finally
		{
			tiffImage.close();
			outputSettings.close();
		}
		Logger.endExample();
    }

}
