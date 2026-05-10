package com.aspose.imaging.examples.images;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;

public class GetLastModifiedDate
{
    public static void main(String... args)
    {
        Logger.startExample("GetLastModifiedDate");
        String dataDir = Utils.getSharedDataDir() + "images/";
        // Declare variable to store file path for input image
        String path = dataDir + "aspose-logo.jpg";

        try (com.aspose.imaging.RasterImage image = (com.aspose.imaging.RasterImage) Image.load(path))
        {
            // Gets the date from the file system.
            String modifyDate = image.getModifyDate(true)
                                     .toString();
            Logger.printf("Last modify date using FileInfo: %s", modifyDate);

            // Gets the date from XMP metadata when it is available; otherwise falls back to the file system.
            modifyDate = image.getModifyDate(false)
                              .toString();
            Logger.printf("Last modify date using info from FileInfo and XMP metadata: %s", modifyDate);
        }
        Logger.endExample();
    }
}
