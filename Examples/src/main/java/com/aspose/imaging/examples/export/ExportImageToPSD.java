package com.aspose.imaging.examples.export;

import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.psd.ColorModes;
import com.aspose.imaging.fileformats.psd.CompressionMethod;

public class ExportImageToPSD
{
    public static void main(String[] args)
    {
        Logger.startExample("ExportImageToPSD");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "export/";

        //Load an existing image
        try (com.aspose.imaging.Image image = com.aspose.imaging.Image.load(dataDir + "sample.bmp"))
        {
            //Create an instance of PsdSaveOptions class
            com.aspose.imaging.imageoptions.PsdOptions saveOptions = new com.aspose.imaging.imageoptions.PsdOptions();

            //Set the CompressionMethod as Raw
            //Note: Other supported CompressionMethod is CompressionMethod.Rle [No Compression]
            saveOptions.setCompressionMethod(CompressionMethod.Raw);

            //Set the ColorMode to GrayScale//Note: Other supported ColorModes are ColorModes.Bitmap and ColorModes.RGB
            saveOptions.setColorMode(ColorModes.Rgb);

            //Save the image to disk location with supplied PsdOptions settings
            image.save(Utils.getOutDir() + "ExportImageToPSD_out.psd", saveOptions);

            // Display Status.
            Logger.println("Image exported to PSD successfully!");
        }

        Logger.endExample();
    }
}




