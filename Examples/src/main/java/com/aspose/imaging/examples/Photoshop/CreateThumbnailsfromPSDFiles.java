package com.aspose.imaging.examples.Photoshop;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.bmp.BmpImage;
import com.aspose.imaging.fileformats.psd.PsdImage;
import com.aspose.imaging.fileformats.psd.ResourceBlock;
import com.aspose.imaging.fileformats.psd.resources.ThumbnailFormat;
import com.aspose.imaging.fileformats.psd.resources.ThumbnailResource;

public class CreateThumbnailsfromPSDFiles {
	public static void main(String... args) throws Exception {
		String dataDir = Utils.getDataDir(CreateThumbnailsfromPSDFiles.class);
		String sourceFileName = dataDir + "samplePsd.psd";
		String outputFileName = dataDir + "result.psd";
		// Load a PSD in an instance of PsdImage
		PsdImage image = (PsdImage) Image.load(sourceFileName);

		// Iterate over the PSD resources
		for (ResourceBlock resource : image.getImageResources()) {
			// Check if the resource is of thumbnail type
			if (resource instanceof ThumbnailResource) {
				// Retrieve the ThumbnailResource
				ThumbnailResource thumbnail = (ThumbnailResource) resource;
				// Check the format of the ThumbnailResource
				if (thumbnail.getFormat() == ThumbnailFormat.KJpegRgb) {
					// Create a new BmpImage by specifying the width and height
					BmpImage thumnailImage = new BmpImage(thumbnail.getWidth(), thumbnail.getHeight());
					// Store the pixels of thumbnail on to the newly created
					// BmpImage
					thumnailImage.savePixels(thumnailImage.getBounds(), thumbnail.getThumbnailData());
					// Save thumbnail on disc
					thumnailImage.save(outputFileName);
				}
			}
		}
	}

}
