package com.aspose.imaging.examples.metafile;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.emf.MetaImage;

public class GetFontInfo
{
    public static void main(String... args)
    {
        Logger.startExample("GetFontInfo");
        String dataDir = Utils.getSharedDataDir() + "metafile/";

        Logger.println("Get list of font names used in the metafile");
        try(MetaImage metafile = (MetaImage)Image.load(dataDir + "Sample1.emf"))
        {
            for (String f : metafile.getUsedFonts())
            {
                Logger.println("\t" + f);
            }

            Logger.println("Get list of font names that are missing");
            for (String f : metafile.getMissedFonts())
            {
                Logger.println("\t" + f);
            }
        }
        Logger.endExample();
    }
}

