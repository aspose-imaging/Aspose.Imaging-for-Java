package com.aspose.imaging.examples.Photoshop;

import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.JpegOptions;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MergePSDlayers
{
    public static void main(String... args) throws IOException
	{
		//ExStart:MergePSDlayers
		String dataDir = Utils.getSharedDataDir() + "psd/";
        String sourceFileName = dataDir + "PsdImage.psd";

        // Load an existing PSD file as image
		com.aspose.imaging.fileformats.psd.PsdImage psdImage;
		try (com.aspose.imaging.Image image = com.aspose.imaging.Image.load(sourceFileName))
		{
			// Convert the loaded image to PSDImage
			psdImage = (com.aspose.imaging.fileformats.psd.PsdImage) image;

			// Create a JPG file stream
			try (OutputStream stream = new FileOutputStream(sourceFileName.replace(".psd", ".jpg")))
			{
				// Create JPEG option class object, Set the source property to jpg file stream and save image
				JpegOptions jpgOptions = new JpegOptions();
				psdImage.save(stream, jpgOptions);
			}
		}
        //ExEnd:MergePSDlayers
    }

}
