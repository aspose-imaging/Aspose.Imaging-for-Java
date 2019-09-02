package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.ResizeType;
import com.aspose.imaging.examples.Utils;

public class ResizingWithResizeTypeEnumeration
{
    public static void main(String... args)
    {
        //ExStart:ResizingWithResizeTypeEnumeration
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ManipulatingPNGImages/";
        Image image = Image.load(dataDir + "aspose_logo.png");
        try
        {
            image.resize(300, 300, ResizeType.LanczosResample);
            image.save(dataDir + "SimpleResizing_out.jpg");
        }
        finally
        {
            image.close();
        }
        //ExEnd:ResizingWithResizeTypeEnumeration
    }

}
