package com.aspose.imaging.examples.dicom;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.dicom.DicomImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import static java.lang.System.in;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdjustingBrightness {

 public static void main(String... args)  {
		// The path to the documents directory.
                //ExStart:AdjustingBrightness 
                String dataDir = Utils.getSharedDataDir(AdjustingBrightness.class) + "dicom/";
		String inputFile = dataDir + "image.dcm";
		String outputFile = dataDir + "AdjustingBrightness_out.bmp";

		File file = new File(inputFile);
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(file);

                // Load a DICOM image in an instance of DicomImage
                com.aspose.imaging.fileformats.dicom.DicomImage image = new com.aspose.imaging.fileformats.dicom.DicomImage(fis);
             
       
                //yar Image image = Image.load(dataDir + "aspose-logo.dxf");
                // Adjust the brightness
		image.adjustBrightness(50);

		// Create an instance of BmpOptions for the resultant image and Save the
		// resultant image
		image.save(outputFile, new com.aspose.imaging.imageoptions.BmpOptions());
	}   catch (FileNotFoundException ex) {
                Logger.getLogger(AdjustingBrightness.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    //   try 
      // catch(Exception e)
        {
        //    e.printStackTrace();
        }
        //ExEnd:AdjustingBrightness 
}
