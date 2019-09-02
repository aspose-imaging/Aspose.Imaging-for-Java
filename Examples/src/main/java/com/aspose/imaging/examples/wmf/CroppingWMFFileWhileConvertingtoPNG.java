package com.aspose.imaging.examples.wmf;

import com.aspose.imaging.Color;
import com.aspose.imaging.Image;
import com.aspose.imaging.ImageOptionsBase;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.PngOptions;
import com.aspose.imaging.imageoptions.WmfRasterizationOptions;

public class CroppingWMFFileWhileConvertingtoPNG
{
    public static void main(String... args)
    {
        //ExStart:CroppingWMFFileWhileConvertingtoPNG
        String dataDir = Utils.getSharedDataDir() + "ModifyingImages/";
        String inputFileName = dataDir + "WMF sample.wmf";
        String outFileName = dataDir + "CroppingWMFFileWhileConvertingtoPNG.png";
        // Load an existing WMF image
        Image image = Image.load(inputFileName);
        try
        {
            // Create an instance of WmfRasterizationOptions class and set
            // different properties
            WmfRasterizationOptions wmf = new WmfRasterizationOptions();
            wmf.setPageWidth(2000);
            wmf.setPageHeight(2000);
            wmf.setBackgroundColor(Color.getWhiteSmoke());

            // Create an instance of PngOptions class and provide rasterization
            // option
            ImageOptionsBase options = new PngOptions();
            options.setVectorRasterizationOptions(wmf);

            // Call the save method, provide output path and PngOptions to
            // convert the cropped WMF file to PNG and save the output
            image.save(outFileName, options);
        }
        finally
        {
            image.dispose();
        }
        //ExEnd:CroppingWMFFileWhileConvertingtoPNG
    }
}
