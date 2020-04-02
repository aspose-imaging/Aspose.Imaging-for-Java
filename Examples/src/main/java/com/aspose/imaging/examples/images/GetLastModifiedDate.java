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

        com.aspose.imaging.RasterImage image = (com.aspose.imaging.RasterImage) Image.load(path);
        try
        {
            // gets the date from [FileInfo]
            String modifyDate = image.getModifyDate(true).toString();
            Logger.printf("Last modify date using FileInfo: %s", modifyDate);

            // gets the date from XMP metadata of [FileInfo] as long as it's not
            // default case
            modifyDate = image.getModifyDate(false).toString();
            Logger.printf("Last modify date using info from FileInfo and XMP metadata: %s", modifyDate);
        }
        finally
        {
            image.dispose();
        }
        Logger.endExample();
    }
}
