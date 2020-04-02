package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.ResizeType;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;

public class ResizingWithResizeTypeEnumeration
{
    public static void main(String... args)
    {
        Logger.startExample("ResizingWithResizeTypeEnumeration");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ManipulatingPNGImages/";
        try (Image image = Image.load(dataDir + "aspose_logo.png"))
        {
            image.resize(300, 300, ResizeType.LanczosResample);
            image.save(Utils.getOutDir() + "SimpleResizing_out.jpg");
        }
        Logger.endExample();
    }

}
