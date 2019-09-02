package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.tiff.enums.TiffExpectedFormat;
import com.aspose.imaging.imageoptions.TiffOptions;


public class RGBColorSystem {

    public static void main(String[] args)
    {
        //ExStart:RGBColorSystem
        String dataDir = Utils.getSharedDataDir() + "ConvertingImages/";

        String sourceFilePath = "testTileDeflate.tif";
        String outputFilePath = "testTileDeflate Cmyk.tif";

        TiffOptions options = new TiffOptions(TiffExpectedFormat.TiffLzwCmyk);

        Image image = Image.load(dataDir + sourceFilePath);
        try
        {
            image.save(dataDir + outputFilePath, options);
        }
        finally
        {
            image.dispose();
        }
        //ExEnd:RGBColorSystem
    }

}
