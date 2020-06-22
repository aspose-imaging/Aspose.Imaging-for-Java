package com.aspose.imaging.examples.djvu;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.djvu.DjvuImage;
import com.aspose.imaging.fileformats.tiff.enums.TiffExpectedFormat;
import com.aspose.imaging.imageoptions.DjvuMultiPageOptions;
import com.aspose.imaging.imageoptions.TiffOptions;

public class ConvertDjvuToTiff
{

    public static void main(String[] args)
    {
        Logger.startExample("ConvertDjvuToTiff");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "djvu/";

        //Load a DjVu image
        try (DjvuImage image = (DjvuImage) Image.load(dataDir + "Sample.djvu"))
        {
            //Create an instance of TiffOptions & use preset options for Black n While with Deflate compression
            TiffOptions exportOptions = new TiffOptions(TiffExpectedFormat.TiffDeflateBw);

            //Initialize the DjvuMultiPageOptions
            exportOptions.setMultiPageOptions(new DjvuMultiPageOptions());

            //Call Save method while passing instance of TiffOptions
            image.save(Utils.getOutDir() + "ConvertDjvuToTiff_out.tiff", exportOptions);

            // Display Status.
            Logger.println("File converted");
        }


        Logger.endExample();
    }
}
