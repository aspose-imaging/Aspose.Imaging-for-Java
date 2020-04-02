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
        //ExStart:ConvertRangeOfDjVuPagesToSeparateImages
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "djvu/";
        // Load a DjVu image
		try (DjvuImage image = (DjvuImage) Image.load(dataDir + "Sample.djvu"))
		{
			// Create an instance of BmpOptions
			BmpOptions exportOptions = new BmpOptions();
			// Set BitsPerPixel for resultant images
			exportOptions.setBitsPerPixel(32);
			// Create an instance of IntRange and initialize it with range of pages
			// to be exported
			IntRange range = new IntRange(0, 2); //Export first 2 pages

			int counter = 0;
			for (int i : range.getRange())
			{
				// Save each page in separate file, as BMP do not support layering
				exportOptions.setMultiPageOptions(new DjvuMultiPageOptions(range.getArrayOneItemFromIndex(counter)));
				image.save(Utils.getOutDir() + (counter++) + ".bmp", exportOptions);
			}
		}
		//ExEnd:ConvertRangeOfDjVuPagesToSeparateImages
    }

}
