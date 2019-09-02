package com.aspose.imaging.examples.Photoshop;

import com.aspose.imaging.Image;
import com.aspose.imaging.LoadOptions;
import com.aspose.imaging.StreamContainer;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.psd.PsdImage;
import com.aspose.imaging.fileformats.tiff.enums.TiffExpectedFormat;
import com.aspose.imaging.fileformats.tiff.enums.TiffPhotometrics;
import com.aspose.imaging.imageoptions.TiffOptions;
import com.aspose.imaging.sources.StreamSource;

public class ExtractICCProfileIgnoreICC
{
    //ExStart:ExtractICCProfileIgnoreICC

    public static void main(String... args)
    {
        String dataDir = Utils.getSharedDataDir() + "Photoshop/";
        String sourcePath = dataDir + "gray-d15.psd";
        String outputPath = dataDir + "gray-d15.psd.ignore-icc.tif";

        // Save to grayscale TIFF
        TiffOptions saveOptions = new TiffOptions(TiffExpectedFormat.Default);
        saveOptions.setPhotometric(TiffPhotometrics.MinIsBlack);
        saveOptions.setBitsPerSample(new int[]{8});

        // If the image contains a built-in Gray ICC profile, it is not be applied by default in contrast of the CMYK profile.
        // Enable ICC conversion explicitly.
        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setUseIccProfileConversion(false);

        PsdImage psdImage = (PsdImage) Image.load(sourcePath, loadOptions);
        try
        {
            // Embed the gray ICC profile to the output TIFF.
            // The built-in Gray Profile can be read via the PsdImage.GrayColorProfile property.
            saveOptions.setIccProfile(toMemoryStream(psdImage.getGrayColorProfile()));
            psdImage.save(outputPath, saveOptions);
        }
        finally
        {
            psdImage.dispose();
        }
    }

    private static byte[] toMemoryStream(StreamSource streamSource)
    {
        StreamContainer sc = streamSource.getStreamContainer();
        try
        {
            return sc.toBytes();
        }
        finally
        {
            sc.dispose();
        }
    }
    //ExEnd:ExtractICCProfileIgnoreICC
}
