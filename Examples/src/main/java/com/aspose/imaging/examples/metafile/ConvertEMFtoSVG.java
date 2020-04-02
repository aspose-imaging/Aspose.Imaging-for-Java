package com.aspose.imaging.examples.metafile;

import com.aspose.imaging.Color;
import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.EmfRasterizationOptions;
import com.aspose.imaging.imageoptions.SvgOptions;

public class ConvertEMFtoSVG
{
    public static void main(String... args)
    {
        Logger.startExample("ConvertEMFtoSVG");
        String dataDir = Utils.getSharedDataDir() + "metafile/";
        // Load an existing EMF file
        try(Image image = Image.load(dataDir + "Picture1.emf"))
        {
            // Create an instance of EmfRasterizationOptions class and set
            // different options
            final EmfRasterizationOptions emfRasterizationOptions = new EmfRasterizationOptions();
            emfRasterizationOptions.setBackgroundColor(Color.getWhite());
            emfRasterizationOptions.setPageWidth(image.getWidth());
            emfRasterizationOptions.setPageHeight(image.getHeight());

            // call the save method and pass instance of SvgOptions class to
            // convert it to SVG format.
            image.save(Utils.getOutDir() + "ConvertEMFtoSVG_out.svg", new SvgOptions()
					{
						{
							setVectorRasterizationOptions(emfRasterizationOptions);
						}
					});
        }
        Logger.endExample();
    }

}
