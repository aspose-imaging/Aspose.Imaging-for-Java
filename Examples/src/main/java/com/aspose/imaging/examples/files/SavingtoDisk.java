package com.aspose.imaging.examples.files;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;

public class SavingtoDisk {
	public static void main(String[] args) throws Exception {
           String dataDir = Utils.getSharedDataDir(SavingtoDisk.class) + "dicom/";
           //ExStart:SavingtoDisk
            Image image = Image.load(dataDir + "aspose-logo.jpg");
            image.save("SavingtoDisk_out.bmp");
            //ExEnd:SavingtoDisk
        
        }

}
