package com.aspose.imaging.examples.export;

import com.aspose.imaging.examples.Utils;

public class UseBradleythresholding {
	public static void main(String[] args) throws Exception {
		String dataDir = Utils.getSharedDataDir(UseBradleythresholding.class) + "export/";
		String sourcepath = dataDir + "aspose_logo.png";
		String outputPath = dataDir + "UseBradleythresholding_out.png";

		// Load an existing image.
		com.aspose.imaging.fileformats.png.PngImage objimage = (com.aspose.imaging.fileformats.png.PngImage) com.aspose.imaging.Image
				.load(sourcepath);

		// Define threshold value
		double threshold = 0.15;

		// Call BinarizeBradley method and pass the threshold value as parameter
		objimage.binarizeBradley(threshold);

		// Save the output image
		objimage.save(outputPath);
	}

}
