/* 
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Imaging. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package programmerguide.concattiffimages.java;

import com.aspose.imaging.fileformats.tiff.TiffFrame;
import com.aspose.imaging.fileformats.tiff.TiffImage;

public class ConcatTIFFImages
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmerguide/concattiffimages/data/";

        //Create a copy of original image to avoid any alteration
        /*InputStream inStream = null;
        OutputStream outStream = null;

        try{
            File afile =new File(dataDir + "demo.tif");
            File bfile =new File(dataDir + "TestDemo.tif");

            inStream = new FileInputStream(afile);
            outStream = new FileOutputStream(bfile);

            byte[] buffer = new byte[1024];

            int length;
            //copy the file content in bytes
            while ((length = inStream.read(buffer)) > 0)
                outStream.write(buffer, 0, length);

            inStream.close();
            outStream.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }*/

        //Create an instance of TiffImage and load the copied destination image
        TiffImage image1 = (TiffImage) com.aspose.imaging.Image.load(dataDir + "TestDemo.tif");

        //Create an instance of TiffImage and load the source image
        TiffImage image2 = (TiffImage) com.aspose.imaging.Image.load(dataDir + "sample.tif");

        // Create an instance of TIffFrame and copy active frame of source image
        TiffFrame frame = TiffFrame.copyFrame(image2.getActiveFrame());

        // Add copied frame to destination image
        image1.addFrame(frame);

        // save the image with changes.
        //image1.save();

        // Display Status.
        System.out.println("Concatenation of TIF files done successfully!");
    }
}




