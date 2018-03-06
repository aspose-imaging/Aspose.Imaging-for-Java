package com.aspose.imaging.examples.metafile;

import com.aspose.imaging.Color;
import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageloadoptions.MetafileLoadOptions;
import com.aspose.imaging.imageoptions.EmfRasterizationOptions;
import com.aspose.imaging.imageoptions.SvgOptions;

public class ConvertEMFtoSVG {
	public static void main(String... args) throws Exception {

		String dataDir = Utils.getSharedDataDir(ConvertEMFtoSVG.class) + "metafile/";
		
		// Load an existing EMF file
		Image image = Image.load(dataDir + "Picture1.emf", new MetafileLoadOptions(true));
		try {
			// Create an instance of EmfRasterizationOptions class and set
			// different options
			final EmfRasterizationOptions emfRasterizationOptions = new EmfRasterizationOptions();
			emfRasterizationOptions.setBackgroundColor(Color.getWhite());
			emfRasterizationOptions.setPageWidth(image.getWidth());
			emfRasterizationOptions.setPageHeight(image.getHeight());

			// call the save method and pass instance of SvgOptions class to
			// convert it to SVG format.
			image.save(dataDir + "ConvertEMFtoSVG_out.svg", new SvgOptions() {
				{
					setVectorRasterizationOptions(emfRasterizationOptions);
				}
			});
		} finally {
			image.dispose();
		}

	}

}
