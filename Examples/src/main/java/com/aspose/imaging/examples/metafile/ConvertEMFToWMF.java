package com.aspose.imaging.examples.metafile;

import com.aspose.imaging.Size;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.EmfRasterizationOptions;
import com.aspose.imaging.imageoptions.WmfOptions;

public class ConvertEMFToWMF
{
    public static void main(String... args)
    {
        //ExStart:ConvertEMFToWMF
        // List of existing EMF images.
        String path = Utils.getSharedDataDir() + "metafile";
        String[] files = new String[]{"TestEmfRotatedText.emf", "TestEmfPlusFigures.emf", "TestEmfBezier.emf"};

        // Loop for each file name.
        for (String file : files)
        {
            // Input file name & path.
            String filePath = path + "\\" + file;

            // Load the EMF image as image and convert it to MetaImage object.
            final com.aspose.imaging.fileformats.emf.MetaImage image =
                    (com.aspose.imaging.fileformats.emf.MetaImage) com.aspose.imaging.Image.load(filePath);
            try
            {
                // Convert the EMF image to WMF image by creating and passing WMF image options class object.
                WmfOptions imageOptionsBase = new WmfOptions();
                imageOptionsBase.setVectorRasterizationOptions(new EmfRasterizationOptions()
                {{
                    setPageSize(Size.to_SizeF(image.getSize()));
                }});
                image.save(filePath + "_out.wmf", imageOptionsBase);
            }
            finally
            {
                // clean the resources
                image.dispose();
            }
        }
        //ExEnd:ConvertEMFToWMF
    }
}