package com.aspose.imaging.examples.CMX;

import com.aspose.imaging.Image;
import com.aspose.imaging.SmoothingMode;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.CmxRasterizationOptions;
import com.aspose.imaging.imageoptions.PngOptions;
import com.aspose.imaging.imageoptions.PositioningTypes;

/**
 *
 * @author mfazi
 */
public class CMXToPNGConversion {

    public static void main(String[] args) {
        Logger.startExample("CMXToPNGConversion");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "CMX/";
        
        
        // Example of exporting the entire document page
        String[] fileNames = new String[] {
         "Rectangle.cmx",
         "Rectangle+Fill.cmx",
         "Ellipse.cmx",
         "Ellipse+fill.cmx",
         "brushes.cmx",
         "outlines.cmx",
         "order.cmx",
         "many_images.cmx",
        };
        for (String fileName: fileNames) {
            try (Image image = Image.load(dataDir + fileName))
            {
                CmxRasterizationOptions cmxRasterizationOptions = new CmxRasterizationOptions();
                cmxRasterizationOptions.setPositioning(PositioningTypes.DefinedByDocument);
                cmxRasterizationOptions.setSmoothingMode(SmoothingMode.AntiAlias);
                PngOptions options = new PngOptions();
                options.setVectorRasterizationOptions(cmxRasterizationOptions);
                image.save(Utils.getOutDir() + fileName + ".docpage.png", options);
            }
        }
        Logger.endExample();
    }
}
