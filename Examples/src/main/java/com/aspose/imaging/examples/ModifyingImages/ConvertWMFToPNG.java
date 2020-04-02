package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Color;
import com.aspose.imaging.Image;
import com.aspose.imaging.ImageOptionsBase;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.PngOptions;
import com.aspose.imaging.imageoptions.WmfRasterizationOptions;

public class ConvertWMFToPNG
{
    public static void main(String... args)
    {
        Logger.startExample("ConvertWMFToPNG");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ModifyingImages/";

        String inputFileName = dataDir + "thistlegirl_wmfsample.wmf";
        String outputFileNamePng = Utils.getOutDir() + "thistlegirl_wmfsample.png";

        // Load an existing WMF image
        try (final Image image = Image.load(inputFileName))
        {
            WmfRasterizationOptions emfRasterization = new WmfRasterizationOptions()
            {{
                setBackgroundColor(Color.getWhiteSmoke());
                setPageWidth(image.getWidth());
                setPageHeight(image.getHeight());
            }};

            ImageOptionsBase imageOptions = new PngOptions();
            imageOptions.setVectorRasterizationOptions(emfRasterization);

            image.save(outputFileNamePng, imageOptions);
        }
        Logger.endExample();
    }
}
