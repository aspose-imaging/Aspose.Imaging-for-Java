package com.aspose.imaging.examples.metafile;

import com.aspose.imaging.Size;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.EmfRasterizationOptions;
import com.aspose.imaging.imageoptions.WmfOptions;

public class ConvertEMFToWMF
{
    public static void main(String... args)
    {
        // To get proper output, please apply a valid Aspose.Imaging license. You can purchase a full license or obtain a 30‑day temporary license from https://www.aspose.com/purchase/default.aspx.
        Logger.startExample();
        // List of existing EMF images.
        String path = Utils.getSharedDataDir() + "metafile";
        String[] files = new String[]{"TestEmfRotatedText.emf", "TestEmfPlusFigures.emf", "TestEmfBezier.emf"};

        // Loop for each file name.
        for (String file : files)
        {
            // Input file name & path.
            String filePath = path + "\\" + file;

            // Load the EMF image as image and convert it to MetaImage object.
            try (com.aspose.imaging.fileformats.emf.MetaImage image =
                         (com.aspose.imaging.fileformats.emf.MetaImage) com.aspose.imaging.Image.load(filePath))
            {
                // Call the `save` method of the Image class and pass an instance of WmfOptions to the `save` method.
                WmfOptions imageOptionsBase = new WmfOptions();
                imageOptionsBase.setVectorRasterizationOptions(new EmfRasterizationOptions()
                {{
                    setPageSize(Size.to_SizeF(image.getSize()));
                }});
                image.save(Utils.getOutDir() + file + "_out.wmf", imageOptionsBase);
            }
        }
        Logger.endExample();
    }
}