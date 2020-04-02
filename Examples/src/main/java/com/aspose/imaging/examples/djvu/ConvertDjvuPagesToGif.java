package com.aspose.imaging.examples.djvu;

import com.aspose.imaging.ColorPaletteHelper;
import com.aspose.imaging.Image;
import com.aspose.imaging.IntRange;
import com.aspose.imaging.ResolutionSetting;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.djvu.DjvuImage;
import com.aspose.imaging.imageoptions.DjvuMultiPageOptions;
import com.aspose.imaging.imageoptions.GifOptions;

public class ConvertDjvuPagesToGif
{

    public static void main(String[] args)
    {
        Logger.startExample("ConvertDjvuPagesToGif");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "djvu/";

        //Load a DjVu image
        try (DjvuImage image = (DjvuImage) Image.load(dataDir + "Sample.djvu"))
        {
            //Create an instance of GifOptions with its default constructor
            GifOptions exportOptions = new GifOptions();

            //Set the resolution of resultant image
            exportOptions.setResolutionSettings(new ResolutionSetting(300, 300));

            //Set PaletteCorrection to false
            exportOptions.setDoPaletteCorrection(false);

            //Create an instance of 8bit palette and set it as Palette property for instance of GifOptions
            exportOptions.setPalette(ColorPaletteHelper.create8Bit());

            //Create an instance of IntRange and initialize it with range of pages to be exported
            IntRange range = new IntRange(0, 2); //Export first 2 pages

            //Initialize an instance of DjvuMultiPageOptions while passing instance of IntRange
            exportOptions.setMultiPageOptions(new DjvuMultiPageOptions(range));

            //Call Save method while passing instance of GifOptions
            image.save(Utils.getOutDir() + "ConvertDjvuPagesToGif_out.gif", exportOptions);

            Logger.println("File converted");
        }
        Logger.endExample();
    }
}
