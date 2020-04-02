package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.PdfOptions;


public class RasterImageToPDF
{

    public static void main(String... args)
    {
        Logger.startExample("RasterImageToPDF");
        String dataDir = Utils.getSharedDataDir() + "ConvertingImages/";
        String destFilePath = Utils.getOutDir() + "transparent_orig.gif.pdf";
        Image image = Image.load(dataDir + "aspose-logo.gif");
        try
        {
            image.save(destFilePath, new PdfOptions());
        }
        finally
        {
            image.dispose();
        }
        Logger.endExample();
    }
}