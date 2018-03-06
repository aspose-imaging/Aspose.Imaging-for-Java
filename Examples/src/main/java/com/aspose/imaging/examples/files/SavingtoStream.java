package com.aspose.imaging.examples.files;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.examples.dicom.SimpleResizing;

public class SavingtoStream {
	public static void main(String[] args) throws Exception {
		//Create an instance of FileOutputStream
                //ExStart:SavingtoStream
               java.io.OutputStream os = new java.io.FileOutputStream("C:\\SavingtoStream_out.bmp");
               String dataDir = Utils.getSharedDataDir(SavingtoStream.class) + "dicom/";
                Image image = Image.load(dataDir + "aspose-logo.jpg");
		//Save the image using the Save method exposed by the Image class and pass the outputstream object
		image.save(os);
                //ExEnd:SavingtoStream
        
        }

}
