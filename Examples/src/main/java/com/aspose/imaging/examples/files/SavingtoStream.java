package com.aspose.imaging.examples.files;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;

public class SavingtoStream
{
    public static void main(String[] args) throws Exception
    {
        Logger.startExample("SavingtoStream");
        //Create an instance of FileOutputStream
        String dataDir = Utils.getSharedDataDir() + "dicom/";

        java.io.OutputStream os = new java.io.FileOutputStream(Utils.getOutDir() + "SavingtoStream_out.bmp");
        //Save the image using the Save method exposed by the Image class and pass the OutputStream object
        try (Image image = Image.load(dataDir + "aspose-logo.jpg"))
        {
            // save to the same format
            image.save(os);
        }
        Logger.endExample();
    }

}
