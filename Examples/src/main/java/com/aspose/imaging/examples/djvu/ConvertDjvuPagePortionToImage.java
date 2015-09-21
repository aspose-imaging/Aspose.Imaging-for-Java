/* 
 * Copyright 2001-2015 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Imaging. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
package com.aspose.imaging.examples.djvu;

import com.aspose.imaging.Image;
import com.aspose.imaging.Rectangle;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.djvu.DjvuImage;
import com.aspose.imaging.fileformats.png.PngColorType;
import com.aspose.imaging.imageoptions.DjvuMultiPageOptions;
import com.aspose.imaging.imageoptions.PngOptions;

public class ConvertDjvuPagePortionToImage {

    public static void main(String[] args) throws Exception {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(ConvertDjvuPagePortionToImage.class);

        //Load a DjVu image
        DjvuImage image = (DjvuImage) Image.load(dataDir + "Sample.djvu");

        //Create an instance of PngOptions
        PngOptions exportOptions = new PngOptions();
        
        //Set ColorType to Grayscale
        exportOptions.setColorType(PngColorType.Grayscale);
        
        //Create an instance of Rectangle and specify the portion on DjVu page
        Rectangle exportArea = new Rectangle(0, 0, 2000, 2000);
        
        //Specify the DjVu page index
        int exportPageIndex = 2;
        
        //Initialize an instance of DjvuMultiPageOptions
        //while passing index of DjVu page index and instance of Rectangle
        //covering the area to be exported
        exportOptions.setMultiPageOptions(new DjvuMultiPageOptions(exportPageIndex, exportArea));

        //Save the image
        image.save(dataDir + "Output.png", exportOptions);

        System.out.println("File conveted");
    }
}
