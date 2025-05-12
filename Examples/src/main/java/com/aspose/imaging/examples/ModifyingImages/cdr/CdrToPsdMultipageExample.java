package com.aspose.imaging.examples.ModifyingImages.cdr;

import com.aspose.imaging.*;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.cdr.CdrImage;
import com.aspose.imaging.imageoptions.MultiPageOptions;
import com.aspose.imaging.imageoptions.PsdOptions;
import com.aspose.imaging.imageoptions.VectorRasterizationOptions;

public class CdrToPsdMultipageExample
{
    public static void main(String... args)
    {
        Logger.startExample("CdrToPsdMultipageExample");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "CDR/";
        String inputFileName = dataDir + "MultiPage.cdr";
        String outFile = Utils.getOutDir() + "MultiPageOut.psd";

        try (CdrImage image = (CdrImage) Image.load(inputFileName))
        {
            ImageOptionsBase options = new PsdOptions();

            // By default if image is multipage image all pages exported
            MultiPageOptions multiPageOptions = new MultiPageOptions();
            options.setMultiPageOptions(multiPageOptions);

            // Optional parameter that indicates to export multipage image as one
            // layer (page) otherwise it will be exported page to page
            multiPageOptions.setMergeLayers(true);

            // Set rasterization options for fileformat
            VectorRasterizationOptions defaultOptions = image.getDefaultOptions(new Object[]{Color.getWhite(), image.getWidth(), image.getHeight()})
                    .getVectorRasterizationOptions();
            options.setVectorRasterizationOptions(defaultOptions);
            defaultOptions.setTextRenderingHint(TextRenderingHint.SingleBitPerPixel);
            defaultOptions.setSmoothingMode(SmoothingMode.None);

            image.save(outFile, options);
        }

        Utils.deleteFile(outFile);

        Logger.endExample();
    }
}
