package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Color;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.tiff.TiffFrame;
import com.aspose.imaging.fileformats.tiff.TiffImage;
import com.aspose.imaging.fileformats.tiff.TiffRational;
import com.aspose.imaging.fileformats.tiff.enums.*;
import com.aspose.imaging.imageoptions.TiffOptions;

public class CreatingTIFFImageWithCompression
{
    public static void main(String... args)
    {
        Logger.startExample("CreatingTIFFImageWithCompression");
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

        // Create a new TiffImage with specific size and TiffOptions settings
        try (TiffImage tiffImage = new TiffImage(new TiffFrame(options, 100, 100)))
        {
            // Loop over the pixels to set the color to red
            for (int i = 0; i < 100; i++)
            {
                tiffImage.getActiveFrame().setPixel(i, i, Color.getRed());
            }
            // Save resultant image
            tiffImage.save(Utils.getOutDir() + "CreatingTIFFImageWithCompression.tiff");
        }
        Logger.endExample();
    }
}
