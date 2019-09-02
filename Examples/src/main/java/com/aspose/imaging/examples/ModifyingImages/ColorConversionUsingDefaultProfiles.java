package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.jpeg.JpegImage;
import com.aspose.imaging.sources.StreamSource;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class ColorConversionUsingDefaultProfiles
{
    public static void main(String... args) throws FileNotFoundException
    {
        //ExStart:ColorConversionUsingDefaultProfiles
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ModifyingImages/";

        // Load an existing JPG image
        try (JpegImage image = (JpegImage) Image.load(dataDir + "aspose-logo_tn.jpg"))
        {
            StreamSource rgbprofile = new StreamSource(new RandomAccessFile(dataDir + "rgb.icc", "r"));
            StreamSource cmykprofile = new StreamSource(new RandomAccessFile(dataDir + "cmyk.icc", "r"));
            image.setDestinationRgbColorProfile(rgbprofile);
            image.setDestinationCmykColorProfile(cmykprofile);
            image.save(dataDir + "ColorConversionUsingDefaultProfiles_out.icc");
        }
        //ExStart:ColorConversionUsingDefaultProfiles
    }
}
