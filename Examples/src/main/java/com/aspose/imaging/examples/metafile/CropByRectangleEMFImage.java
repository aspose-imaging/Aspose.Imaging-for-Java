package com.aspose.imaging.examples.metafile;

import com.aspose.imaging.Image;
import com.aspose.imaging.Rectangle;
import com.aspose.imaging.Size;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.emf.MetaImage;
import com.aspose.imaging.imageoptions.EmfRasterizationOptions;
import com.aspose.imaging.imageoptions.PngOptions;

public class CropByRectangleEMFImage
{
    public static void main(String... args)
    {
		//ExStart:CropByRectangleEMFImage
        String dataDir = Utils.getSharedDataDir() + "metafile/";
        // Load an EMF file in an instance of MetaImage
        final MetaImage metaImage = (MetaImage) Image.load(dataDir + "Picture1.emf");

		try
		{
			// Create an instance of Rectangle class with desired size
			final Rectangle rectangle = new Rectangle(10, 10, 100, 100);

			// Perform the crop operation on object of Rectangle class
			metaImage.crop(rectangle);

			// Save the result in PNG format
			PngOptions pngOptions = new PngOptions();
			pngOptions.setVectorRasterizationOptions(new EmfRasterizationOptions() {{ setPageSize(Size.to_SizeF(rectangle.getSize())); }});

			metaImage.save(dataDir + "CropByRectangle_out.png", pngOptions);
		}
		finally
		{
			metaImage.close();
		}

		//ExEnd:CropByRectangleEMFImage
    }
}
