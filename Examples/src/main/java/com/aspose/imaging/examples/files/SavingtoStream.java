package com.aspose.imaging.examples.files;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;

public class SavingtoStream
{
    public static void main(String[] args) throws Exception
    {
        //Create an instance of FileOutputStream
        String dataDir = Utils.getSharedDataDir() + "dicom/";
        //ExStart:SavingtoStream
        java.io.OutputStream os = new java.io.FileOutputStream(dataDir + "SavingtoStream_out.bmp");
        Image image = Image.load(dataDir + "aspose-logo.jpg");
        //Save the image using the Save method exposed by the Image class and pass the outputstream object
        try
        {
            // save to the same format
            image.save(os);
        }
        finally
        {
            image.close();
        }
        //ExEnd:SavingtoStream

    }

}
