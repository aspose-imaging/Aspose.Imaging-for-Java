package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.ResizeType;
import com.aspose.imaging.examples.Utils;

public class ResizingWithResizeTypeEnumeration {
	public static void main(String... args) throws Exception {
		// The path to the documents directory.
                String dataDir = Utils.getSharedDataDir(ResizingWithResizeTypeEnumeration.class) + "ModifyingImages/";
		  //ExStart:ResizingWithResizeTypeEnumeration
              Image image = Image.load(dataDir + "aspose-logo.png");
		image.resize(300, 300, ResizeType.LanczosResample);
		 image.save(dataDir + "SimpleResizing_out.jpg");
	//ExEnd:ResizingWithResizeTypeEnumeration
        }
        
}
