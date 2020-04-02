package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.tiff.enums.TiffExpectedFormat;
import com.aspose.imaging.imageoptions.TiffOptions;


public class RGBColorSystem {

    public static void main(String[] args)
    {
        Logger.startExample("RGBColorSystem");
        String dataDir = Utils.getSharedDataDir() + "ConvertingImages/";

        String sourceFilePath = "testTileDeflate.tif";
        String outputFilePath = "testTileDeflate Cmyk.tif";

        TiffOptions options = new TiffOptions(TiffExpectedFormat.TiffLzwCmyk);

        Image image = Image.load(dataDir + sourceFilePath);
        try
        {
            image.save(Utils.getOutDir() + outputFilePath, options);
        }
        finally
        {
            image.dispose();
        }
        Logger.endExample();
    }

}
