package com.aspose.imaging.examples.Photoshop;

import com.aspose.imaging.Image;
import com.aspose.imaging.StreamContainer;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.psd.PsdImage;
import com.aspose.imaging.fileformats.tiff.enums.TiffExpectedFormat;
import com.aspose.imaging.fileformats.tiff.enums.TiffPhotometrics;
import com.aspose.imaging.imageoptions.TiffOptions;
import com.aspose.imaging.sources.StreamSource;

public class ICCProfileExtraction
{
    public static void main(String... args)
    {
        Logger.startExample("ICCProfileExtraction");
        String dataDir = Utils.getSharedDataDir() + "Photoshop/";
        PsdImage psdImage = (PsdImage) Image.load(dataDir + "gray-d15.psd");
        try
        {

            StreamSource grayProfile = psdImage.getGrayColorProfile();
            // Save to grayscale TIFF
            TiffOptions saveOptions = new TiffOptions(TiffExpectedFormat.Default);
            saveOptions.setPhotometric(TiffPhotometrics.MinIsBlack);
            saveOptions.setBitsPerSample(new int[]{8});
            // No ICC profile
            psdImage.save(dataDir + "gray-d15.psd.noprofile.tif", saveOptions);
            // Embed ICC profile
            saveOptions.setIccProfile(toMemoryStream(grayProfile));
            psdImage.save(Utils.getOutDir() + "gray-d15.psd.tif", saveOptions);
        }

        finally
        {
            psdImage.dispose();
        }
        Logger.endExample();
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
}
