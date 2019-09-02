package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.FontSettings;
import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.EmfRasterizationOptions;
import com.aspose.imaging.imageoptions.OdgRasterizationOptions;
import com.aspose.imaging.imageoptions.PngOptions;
import com.aspose.imaging.imageoptions.SvgRasterizationOptions;
import com.aspose.imaging.imageoptions.VectorRasterizationOptions;
import com.aspose.imaging.imageoptions.WmfRasterizationOptions;


public class SupportForReplacingMissingFonts
{

    public static void main(String... args)
    {
        //ExStart:SupportForReplacingMissingFonts
        String dataDir = Utils.getSharedDataDir() + "ModifyingImages/";
        FontSettings.setDefaultFontName("Comic Sans MS");

        String[] files = new String[]{"missing-font.emf", "missing-font.odg", "missing-font.svg", "missing-font.wmf"};
        VectorRasterizationOptions[] options = new VectorRasterizationOptions[]{new EmfRasterizationOptions(), new OdgRasterizationOptions(), new SvgRasterizationOptions(), new WmfRasterizationOptions()};

        for (int i = 0; i < files.length; i++)
        {
            String outFile = dataDir + files[i] + ".png";

            try (Image img = Image.load(dataDir + files[i]))
            {
                options[i].setPageWidth(img.getWidth());
                options[i].setPageHeight(img.getHeight());
                PngOptions saveOptions = new PngOptions();
                saveOptions.setVectorRasterizationOptions(options[i]);
                img.save(outFile, saveOptions);
            }
        }
        //ExEnd:SupportForReplacingMissingFonts
    }
}
