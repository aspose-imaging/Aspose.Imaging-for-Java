package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.ColorPaletteHelper;
import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.tiff.enums.TiffCompressions;
import com.aspose.imaging.fileformats.tiff.enums.TiffExpectedFormat;
import com.aspose.imaging.fileformats.tiff.enums.TiffPhotometrics;
import com.aspose.imaging.imageoptions.TiffOptions;

public class CompressingTIFFImagesWithAdobeDeflateCompression
{
    public static void main(String... args)
    {
        Logger.startExample("CompressingTIFFImagesWithAdobeDeflateCompression");
        // To get proper output please apply a valid Aspose.Imaging License. You can purchase full license or get 30 day temporary license from http:// Www.aspose.com/purchase/default.aspx.");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ConvertingImages/";

        // Load an image through file path location or stream
        try (Image image = Image.load(dataDir + "sample.tiff"))
        {
            // Create an instance of TiffOptions for the resultant image
            TiffOptions outputSettings = new TiffOptions(TiffExpectedFormat.Default);

            // Set BitsPerSample, Photometric mode & Compression mode
            outputSettings.setBitsPerSample(new int[] { 4 });
            outputSettings.setCompression(TiffCompressions.AdobeDeflate);
            outputSettings.setPhotometric(TiffPhotometrics.Palette);

            // Set graycale palette
            outputSettings.setPalette(ColorPaletteHelper.create4BitGrayscale(false));
            image.save(Utils.getOutDir() + "out_adobedeflate.tiff", outputSettings);
        }

        Logger.endExample();
    }
}
