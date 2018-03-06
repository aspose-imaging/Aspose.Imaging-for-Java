package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.tiff.TiffFrame;
import com.aspose.imaging.fileformats.tiff.TiffImage;

public class ExportImagesInMultiThreadedEnvironment 
{
	public static void main(String... args) throws Exception 
{
		//ExStart:ExportImagesInMultiThreadedEnvironment

		// Create temporary image.
        java.io.File tmp = java.io.File.createTempFile("image", "tes");
        
        // Delete the file. This statement should execute to make it sure that resource is properly disposed off.
        tmp.deleteOnExit();
        
        // Path & name of existing image.
        String imageDataPath = tmp.getAbsolutePath();

        // Create the stream of the existing image file.
        java.io.InputStream fileStream = new java.io.FileInputStream(tmp);
        try
        {
            // Create an instance of BMP image option class.
            com.aspose.imaging.imageoptions.BmpOptions bmpOptions = new com.aspose.imaging.imageoptions.BmpOptions();
            try
            {
		bmpOptions.setBitsPerPixel(32);
		
                // Set the source property of the imaging option class object.
                bmpOptions.setSource(new com.aspose.imaging.sources.StreamSource(fileStream));

                // Do processing. Following is the sample processing on the image. Un-comment to use it.
		// com.aspose.imaging.RasterImage image = (com.aspose.imaging.RasterImage)com.aspose.imaging.Image.create(bmpOptions, 10, 10);
		// try
		// {
		//	com.aspose.imaging.Color[] pixels = new com.aspose.imaging.Color[4];
		//	for (int i = 0; i < 4; ++i)
		//	{
		//		pixels[i] = com.aspose.imaging.Color.fromArgb(40, 30, 20, 10);
		//	}
		//	image.savePixels(new com.aspose.imaging.Rectangle(0, 0, 2, 2), pixels);
		//	image.save(imageDataPath);
		//}
		//finally
		//{
                    // This statement is in the final block because in any case this statement should execute to make it sure that resource is properly disposed off.
                //    image.dispose();
		//}
            }
            finally
            {
                // This statement is in the final block because in any case this statement should execute to make it sure that resource is properly disposed off.
                bmpOptions.dispose();
            }
        }
        finally
        {
            // This statement is in the final block because in any case this statement should execute to make it sure that resource is properly disposed off.
            fileStream.close();
            fileStream = null;
        }

		//ExEnd:ExportImagesInMultiThreadedEnvironment
	}

}
