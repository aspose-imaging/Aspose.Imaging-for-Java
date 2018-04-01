package com.aspose.imaging.examples.metafile;

import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.PdfOptions;

public class ConvertEMFtoWMF 
{
	public static void main(String... args) throws Exception 
        {
            //ExStart:ConvertEMFtoWMF
         // List of existing EMF images. 
        String path = "";
        String[] files = new String[] { "TestEmfRotatedText.emf", "TestEmfPlusFigures.emf", "TestEmfBezier.emf" };

        // Loop for each file name.
        for (String file : files)
        {
            // Input file name & path.
            String filePath = path + "\\" + file;
            
            // Load the EMF image as image and convert it to MetaImage object.
            com.aspose.imaging.fileformats.emf.MetaImage image = 
                    (com.aspose.imaging.fileformats.emf.MetaImage)com.aspose.imaging.Image.load(filePath, new com.aspose.imaging.imageloadoptions.MetafileLoadOptions(true));
	try
	{
            // Convert the EMF image to WMF image by creating and passing WMF image options class object.
            image.save(filePath + "_out.wmf", new com.aspose.imaging.imageoptions.WmfOptions());
	}
	finally
	{
            // clean the resources
            image.dispose();
	}
	}
        //ExEnd:ConvertEMFtoWMF
        }
}