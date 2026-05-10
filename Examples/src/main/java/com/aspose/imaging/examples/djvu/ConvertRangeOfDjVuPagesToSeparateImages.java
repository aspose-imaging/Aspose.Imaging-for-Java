package com.aspose.imaging.examples.djvu;

import com.aspose.imaging.Image;
import com.aspose.imaging.IntRange;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.djvu.DjvuImage;
import com.aspose.imaging.imageoptions.BmpOptions;
import com.aspose.imaging.imageoptions.DjvuMultiPageOptions;

public class ConvertRangeOfDjVuPagesToSeparateImages
{
    public static void main(String... args)
    {
        // The path to the document directory.
        String dataDir = Utils.getSharedDataDir() + "djvu/";
        // Load a DjVu image
		try (DjvuImage image = (DjvuImage) Image.load(dataDir + "Sample.djvu"))
		{
            // Create an instance of BmpOptions and set BitsPerPixel for the resultant images
			BmpOptions exportOptions = new BmpOptions();
			exportOptions.setBitsPerPixel(32);
            // Create an instance of IntRange and initialize it with the range of pages to be exported
			IntRange range = new IntRange(0, 2); //Export first 2 pages

			int counter = 0;
			for (int i : range.getRange())
			{
                // Save each page in a separate file, as BMP does not support layering
				exportOptions.setMultiPageOptions(new DjvuMultiPageOptions(range.getArrayOneItemFromIndex(counter)));
				image.save(Utils.getOutDir() + (counter++) + ".bmp", exportOptions);
			}
		}
    }
}
