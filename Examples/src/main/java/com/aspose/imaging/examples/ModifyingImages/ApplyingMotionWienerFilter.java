package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imagefilters.filteroptions.MotionWienerFilterOptions;

public class ApplyingMotionWienerFilter
{
    public static void main(String... args)
    {
        Logger.startExample("ApplyingMotionWienerFilter");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ConvertingImages/";

        // Load the image
        try (RasterImage rasterImage = (RasterImage)Image.load(dataDir + "aspose-logo.gif"))
        {
            // Create an instance of MotionWienerFilterOptions class and set the length, smooth value and angle.
            MotionWienerFilterOptions options = new MotionWienerFilterOptions(50, 9, 90);
            options.setGrayscale(true);

            // Apply MedianFilterOptions filter to RasterImage object and  Save the resultant image
            rasterImage.filter(rasterImage.getBounds(), options);
            rasterImage.save(Utils.getOutDir() + "ApplyingMotionWienerFilter_out.gif");
        }
        Logger.endExample();
    }
}
