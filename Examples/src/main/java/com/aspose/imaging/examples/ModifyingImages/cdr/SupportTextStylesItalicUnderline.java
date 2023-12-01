package com.aspose.imaging.examples.ModifyingImages.cdr;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.FontSettings;

public class SupportTextStylesItalicUnderline
{
    public static void main(String[] args)
    {
        Logger.startExample();
        // The path to the documents' directory.
        String dataDir = Utils.getSharedDataDir() + "cdr/";
        String fontsDir = Utils.getSharedDataDir() + "Fonts/";

        String inputFileName = dataDir + "test3.cdr";
        String outputFile = Utils.getOutDir("cdr") + "/test3.cdr.jpg";

        FontSettings.setFontsFolder(fontsDir);

        try (Image image = Image.load(inputFileName))
        {
            image.save(outputFile);
        }

        Logger.endExample();
    }
}