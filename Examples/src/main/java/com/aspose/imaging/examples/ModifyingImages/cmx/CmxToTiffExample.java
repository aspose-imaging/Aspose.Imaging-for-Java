package com.aspose.imaging.examples.ModifyingImages.cmx;

import com.aspose.imaging.Image;
import com.aspose.imaging.VectorMultipageImage;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.ModifyingImages.PageOptionsBuilder;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.tiff.enums.TiffExpectedFormat;
import com.aspose.imaging.imageoptions.CmxRasterizationOptions;
import com.aspose.imaging.imageoptions.MultiPageOptions;
import com.aspose.imaging.imageoptions.TiffOptions;
import com.aspose.imaging.imageoptions.VectorRasterizationOptions;

public class CmxToTiffExample
{
    public static void main(String[] args)
    {
        Logger.startExample("CmxToTiffExample");
        // The path to the documents directory.
        String inputFile = Utils.getSharedDataDir() + "CMX/MultiPage2.cmx";
        String outFile = Utils.getOutDir() + "MultiPage2.cmx.tiff";

        try (VectorMultipageImage image = (VectorMultipageImage) Image.load(inputFile))
        {
            // Create page rasterization options
            VectorRasterizationOptions[] pageOptions = PageOptionsBuilder.createPageOptions(CmxRasterizationOptions.class, image);

            // Create TIFF options
            TiffOptions options = new TiffOptions(TiffExpectedFormat.TiffDeflateRgb);
            MultiPageOptions multiPageOptions = new MultiPageOptions();
            multiPageOptions.setPageRasterizationOptions(pageOptions);
            options.setMultiPageOptions(multiPageOptions);

            // Export image to TIFF format
            image.save(outFile, options);
        }

        Utils.deleteFile(outFile);

        Logger.endExample();
    }
}
