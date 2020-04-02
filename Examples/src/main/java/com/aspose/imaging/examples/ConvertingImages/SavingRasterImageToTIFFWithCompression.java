package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.tiff.TiffFrame;
import com.aspose.imaging.fileformats.tiff.TiffImage;
import com.aspose.imaging.fileformats.tiff.TiffRational;
import com.aspose.imaging.fileformats.tiff.enums.*;
import com.aspose.imaging.imageoptions.TiffOptions;

public class SavingRasterImageToTIFFWithCompression
{
    public static void main(String... args)
    {
        Logger.startExample("SavingRasterImageToTIFFWithCompression");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ModifyingImages/";

        // Create an instance of TiffOptions and set its various properties
        TiffOptions options = new TiffOptions(TiffExpectedFormat.Default);
        options.setBitsPerSample(new int[] { 8, 8, 8 });
        options.setPhotometric(TiffPhotometrics.Rgb);
        options.setXresolution(new TiffRational(72));
        options.setYresolution(new TiffRational(72));
        options.setResolutionUnit(TiffResolutionUnits.Inch);
        options.setPlanarConfiguration(TiffPlanarConfigs.Contiguous);

        // Set the Compression to AdobeDeflate
        options.setCompression(TiffCompressions.AdobeDeflate);
        // Or Deflate
        // Options.Compression = TiffCompressions.Deflate;

        // Load an existing image in an instance of RasterImage
        try (RasterImage image = (RasterImage) Image.load(dataDir + "SampleTiff1.tiff"))
        {
            // Create a new TiffImage from the RasterImage and Save the resultant image while passing the instance of TiffOptions
            try (TiffImage tiffImage = new TiffImage(new TiffFrame(image)))
            {
                tiffImage.save(Utils.getOutDir() + "SavingRasterImage_out.tiff", options);
            }
        }
        Logger.endExample();
    }
}
