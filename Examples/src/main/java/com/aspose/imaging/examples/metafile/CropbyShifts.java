package com.aspose.imaging.examples.metafile;

import com.aspose.imaging.Image;
import com.aspose.imaging.Size;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.emf.MetaImage;
import com.aspose.imaging.imageoptions.EmfRasterizationOptions;
import com.aspose.imaging.imageoptions.PngOptions;

public class CropbyShifts
{
    public static void main(String... args)
    {
		Logger.startExample("CropbyShifts");
        String dataDir = Utils.getSharedDataDir() + "metafile/";
        // Load an EMF file in an instance of MetafileImage
		try (MetaImage metaImage = (MetaImage) Image.load(dataDir + "Picture1.emf"))
		{
			// Define shift values for all four sides
			int leftShift = 10;
			int rightShift = 10;
			int topShift = 10;
			int bottomShift = 10;

			// Based on the shift values, apply the cropping on image
			// Crop method will shift the image bounds toward the center of image
			metaImage.crop(leftShift, rightShift, topShift, bottomShift);

			// Save the result in PNG format
			PngOptions pngOptions = new PngOptions();
			pngOptions.setVectorRasterizationOptions(new EmfRasterizationOptions()
			{{
				setPageSize(Size.to_SizeF(metaImage.getSize()));
			}});
			metaImage.save(Utils.getOutDir() + "CropbyShifts_out.png", pngOptions);
		}
		Logger.endExample();
    }
}
