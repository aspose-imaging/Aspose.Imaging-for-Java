package com.aspose.imaging.examples.images;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;

public class CombineImages
{
    public static void main(String[] args)
    {
		//ExStart:CombineImages

        String dataDir = Utils.getSharedDataDir() + "DrawingAndFormattingImages/";
        // Create an instance of JpegOptions and set its various properties
        com.aspose.imaging.imageoptions.JpegOptions imageOptions = new com.aspose.imaging.imageoptions.JpegOptions();

        // Create an instance of FileCreateSource and assign it to Source
        // property
        imageOptions.setSource(
                new com.aspose.imaging.sources.FileCreateSource(dataDir + "two_images_result.jpeg", false));

        // Create an instance of Image
        com.aspose.imaging.Image image = com.aspose.imaging.Image.create(imageOptions, 600, 600);

		try
		{
			// Create and initialize an instance of Graphics
			com.aspose.imaging.Graphics graphics = new com.aspose.imaging.Graphics(image);

			// Clear the image surface with white color
			graphics.clear(com.aspose.imaging.Color.getWhite());

			// Draw Image
			try (Image tmp0 = Image.load(dataDir + "sample_1.bmp"))
			{
				graphics.drawImage(tmp0, 0, 0, 600, 300);
			}
			try (Image tmp1 = Image.load(dataDir + "File1.bmp"))
			{
				graphics.drawImage(tmp1, 0, 300, 600, 300);
			}

			// Call save method to save the resultant image.
			image.save();
		}
		finally
		{
			image.close();
			imageOptions.close();
		}

		//ExEnd:CombineImages
    }

}
