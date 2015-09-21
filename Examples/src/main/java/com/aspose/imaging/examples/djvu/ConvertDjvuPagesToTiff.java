/* 
 * Copyright 2001-2015 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Imaging. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
package com.aspose.imaging.examples.djvu;

import com.aspose.imaging.Image;
import com.aspose.imaging.IntRange;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.djvu.DjvuImage;
import com.aspose.imaging.fileformats.tiff.enums.TiffExpectedFormat;
import com.aspose.imaging.imageoptions.DjvuMultiPageOptions;
import com.aspose.imaging.imageoptions.TiffOptions;

public class ConvertDjvuPagesToTiff {

    public static void main(String[] args) throws Exception {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(ConvertDjvuPagesToTiff.class);

        //Load a DjVu image
        DjvuImage image = (DjvuImage) Image.load(dataDir + "Sample.djvu");

        //Create an instance of TiffOptions & use preset options for Black n While with Deflate compression
        TiffOptions exportOptions = new TiffOptions(TiffExpectedFormat.TiffDeflateBW);

        //Create an instance of IntRange and initialize it with range of pages to be exported
        IntRange range = new IntRange(0, 2); //Export first 2 pages

        //Initialize the DjvuMultiPageOptions
        exportOptions.setMultiPageOptions(new DjvuMultiPageOptions(range));

        //Call Save method while passing instance of TiffOptions
        image.save(dataDir + "Output.tiff", exportOptions);

        // Display Status.
        System.out.println("File conveted");
    }
}
