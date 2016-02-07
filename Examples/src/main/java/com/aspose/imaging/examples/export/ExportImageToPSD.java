package com.aspose.imaging.examples.export;

import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.psd.ColorModes;
import com.aspose.imaging.fileformats.psd.CompressionMethod;
//import com.aspose.imaging.saveoptions.*;

public class ExportImageToPSD
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(ExportImageToPSD.class);

        //Load an existing image
        com.aspose.imaging.Image image = com.aspose.imaging.Image.load(dataDir + "sample.bmp");

        //Create an instance of PsdSaveOptions class
        //Create an instance of PsdSaveOptions class
        com.aspose.imaging.imageoptions.PsdOptions saveOptions = new com.aspose.imaging.imageoptions.PsdOptions();

        //Set the CompressionMethod as Raw
        //Note: Other supported CompressionMethod is CompressionMethod.Rle [No Compression]
        saveOptions.setCompressionMethod(CompressionMethod.Raw);

        //Set the ColorMode to GrayScale//Note: Other supported ColorModes are ColorModes.Bitmap and ColorModes.RGB
        saveOptions.setColorMode(ColorModes.RGB);

        //Save the image to disk location with supplied PsdOptions settings
        image.save(dataDir + "output.psd", saveOptions);

        // Display Status.
        System.out.println("Image exported to PSD successfully!");
    }
}




