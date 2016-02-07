package com.aspose.imaging.examples.djvu;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.djvu.DjvuImage;
import com.aspose.imaging.fileformats.tiff.enums.TiffExpectedFormat;
import com.aspose.imaging.imageoptions.DjvuMultiPageOptions;
import com.aspose.imaging.imageoptions.TiffOptions;

public class ConvertDjvuToTiff {

    public static void main(String[] args) throws Exception {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(ConvertDjvuToTiff.class);

        //Load a DjVu image
        DjvuImage image = (DjvuImage) Image.load(dataDir + "Sample.djvu");


        //Create an instance of TiffOptions & use preset options for Black n While with Deflate compression
        TiffOptions exportOptions = new TiffOptions(TiffExpectedFormat.TiffDeflateBW);
        
        //Initialize the DjvuMultiPageOptions
        exportOptions.setMultiPageOptions(new DjvuMultiPageOptions());
        
        //Call Save method while passing instance of TiffOptions
        image.save(dataDir + "Output.tiff", exportOptions);

        // Display Status.
        System.out.println("File conveted");
    }
}
