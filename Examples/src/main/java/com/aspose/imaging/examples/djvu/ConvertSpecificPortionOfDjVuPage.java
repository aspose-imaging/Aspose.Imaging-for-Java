package com.aspose.imaging.examples.djvu;

import com.aspose.imaging.Image;
import com.aspose.imaging.Rectangle;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.djvu.DjvuImage;
import com.aspose.imaging.fileformats.png.PngColorType;
import com.aspose.imaging.imageoptions.DjvuMultiPageOptions;
import com.aspose.imaging.imageoptions.PngOptions;

public class ConvertSpecificPortionOfDjVuPage
{
    public static void main(String... args)
    {
		Logger.startExample("ConvertSpecificPortionOfDjVuPage");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "djvu/";

        // Load a DjVu image
		try (DjvuImage image = (DjvuImage) Image.load(dataDir + "Sample.djvu"))
		{
			// Create an instance of PngOptions
			PngOptions exportOptions = new PngOptions();
			// Set ColorType to Grayscale
			exportOptions.setColorType(PngColorType.Grayscale);
			// Create an instance of Rectangle and specify the portion on DjVu page
			Rectangle exportArea = new Rectangle(0, 0, 500, 500);
			// Specify the DjVu page index
			int exportPageIndex = 2;
			// Initialize an instance of DjvuMultiPageOptions
			// while passing index of DjVu page index and instance of Rectangle
			// covering the area to be exported
			exportOptions.setMultiPageOptions(new DjvuMultiPageOptions(exportPageIndex, exportArea));
			// Save the image
			image.save(Utils.getOutDir() + "ConvertSpecificPortionOfDjVuPage_out.djvu", exportOptions);
		}
		Logger.endExample();
    }

}
