package com.aspose.imaging.examples.wmf;

import com.aspose.imaging.examples.Utils;

public class ConvertingWMFToSVG {
	public static void main(String... args) throws Exception {
		// ExStart:ConvertingWMFToSVG
		String dataDir = Utils.getSharedDataDir(ConvertingWMFToSVG.class) + "wmf/";
		// Path & Name of input file
		String inputFileName = dataDir + "sample.wmf";

		// Path & Name of output file
		String outputFileName = dataDir + "ConvertingWMFToSVG_out.svg";

		// Create an instance of Image class by loading an existing WMF image.
		com.aspose.imaging.Image image = com.aspose.imaging.Image.load(inputFileName, new com.aspose.imaging.imageloadoptions.MetafileLoadOptions(true));
		try {
			// Create an instance of EmfRasterizationOptions class.
			final com.aspose.imaging.imageoptions.EmfRasterizationOptions options = new com.aspose.imaging.imageoptions.EmfRasterizationOptions();
			options.setPageWidth(image.getWidth());
			options.setPageHeight(image.getHeight());

			// Call save method to convert WMF to SVG format by passing output
			// file name and SvgOptions class instance.
			image.save(outputFileName,
					new com.aspose.imaging.imageoptions.SvgOptions() {
						{
							setVectorRasterizationOptions(options);
						}
					});
		} finally {
			image.dispose();
		}
		// ExEnd:ConvertingWMFToSVG
	}
}
