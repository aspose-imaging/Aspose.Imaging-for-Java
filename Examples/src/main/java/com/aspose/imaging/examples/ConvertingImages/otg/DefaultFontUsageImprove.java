package com.aspose.imaging.examples.ConvertingImages.otg;

import com.aspose.imaging.FontSettings;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Path;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.OdgRasterizationOptions;
import com.aspose.imaging.imageoptions.PngOptions;

public class DefaultFontUsageImprove
{
    public static void main(String[] args)
    {
        Logger.startExample();
        String dataDir = Utils.getSharedDataDir() + "otg/";
        String outDir = Utils.getOutDir("DefaultFontUsageImprove");

        FontSettings.setFontsFolder(Path.combine(dataDir, "fonts"));
        FontSettings.setGetSystemAlternativeFont(false);
        exportToPng(Path.combine(dataDir, "missing-font2.odg"), "Arial", Path.combine(outDir, "arial.png"));
        exportToPng(
                Path.combine(dataDir, "missing-font2.odg"),
                "Courier New",
                Path.combine(outDir, "courier.png"));

        Logger.endExample();
    }


    private static void exportToPng(String filePath, String defaultFontName, String outfileName)
    {
        FontSettings.setDefaultFontName(defaultFontName);
        try (com.aspose.imaging.Image document = com.aspose.imaging.Image.load(filePath))
        {
            PngOptions saveOptions = new PngOptions();
            final OdgRasterizationOptions rasterizationOptions = new OdgRasterizationOptions();
            rasterizationOptions.setPageWidth(1000);
            rasterizationOptions.setPageHeight(1000);
            saveOptions.setVectorRasterizationOptions(rasterizationOptions);
            document.save(outfileName, saveOptions);
        }

        Utils.deleteFile(outfileName);
    }
}
