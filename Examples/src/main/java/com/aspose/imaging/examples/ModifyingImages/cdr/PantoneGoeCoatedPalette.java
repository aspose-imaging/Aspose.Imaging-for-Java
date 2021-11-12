package com.aspose.imaging.examples.ModifyingImages.cdr;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.CdrRasterizationOptions;
import com.aspose.imaging.imageoptions.PngOptions;
import com.aspose.imaging.imageoptions.PositioningTypes;

public class PantoneGoeCoatedPalette
{
    public static void main(String[] args)
    {
        Logger.startExample();
        // The path to the documents' directory.
        String dataDir = Utils.getSharedDataDir() + "cdr/";
        String path = dataDir + "test2.cdr";
        String outputFile = Utils.getOutDir("cdr") + "/result.png";

        Image image = Image.load(path);
        try
        {
            CdrRasterizationOptions cdrOptions = new CdrRasterizationOptions();
            cdrOptions.setPositioning(PositioningTypes.Relative);
            PngOptions options = new PngOptions();
            options.setVectorRasterizationOptions(cdrOptions);
            image.save(outputFile, options);
        }
        finally
        {
            image.close();
        }
        Utils.deleteFile(outputFile);
        Logger.endExample();
    }
}
