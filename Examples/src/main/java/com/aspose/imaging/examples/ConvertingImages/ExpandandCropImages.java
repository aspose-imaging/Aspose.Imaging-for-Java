package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.Rectangle;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.JpegOptions;

public class ExpandandCropImages {
	public static void main(String... args) throws Exception {
		//ExStart:ExpandandCropImages
		String dataDir = Utils.getSharedDataDir(ExpandandCropImages.class) + "ConvertingImages/";

		RasterImage rasterImage = (RasterImage) Image.load(dataDir + "aspose-logo.jpg");
		// setting for image data to be cashed
		rasterImage.cacheData();

		// Create an instance of Rectangle class and define X,Y and Width, height of the rectangle.
		Rectangle destRect = new Rectangle(200, 200, 300, 300);

		// Save output image by passing output file name, image options and rectangle object.
		rasterImage.save(dataDir + "ExpandandCropImages_out.jpg", new JpegOptions(), destRect);
		//ExEnd:ExpandandCropImages
	}

}
