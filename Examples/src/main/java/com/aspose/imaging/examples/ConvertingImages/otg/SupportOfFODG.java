package com.aspose.imaging.examples.ConvertingImages.otg;

import com.aspose.imaging.Image;
import com.aspose.imaging.Size;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.OdgRasterizationOptions;
import com.aspose.imaging.imageoptions.PngOptions;

public class SupportOfFODG
{
    public static void main(String[] args)
    {
        Logger.startExample("SupportOfFODG");
        String dataDir = Utils.getSharedDataDir() + "otg/";
        String outDir = Utils.getOutDir();

        String inputFile = dataDir + "sample.fodg";
        String outputFile = outDir + "sample.fodg.png";
        try (Image image = Image.load(inputFile))
        {
            OdgRasterizationOptions vector = new OdgRasterizationOptions();
            vector.setPageSize(Size.to_SizeF(image.getSize()));
            PngOptions options = new PngOptions();
            options.setVectorRasterizationOptions(vector);
            image.save(outputFile, options);
        }
        Logger.endExample();
    }
}
