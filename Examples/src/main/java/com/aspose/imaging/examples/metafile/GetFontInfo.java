package com.aspose.imaging.examples.metafile;

import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.FontSettings;
import com.aspose.imaging.fileformats.metafile.MetafileImage;
import com.aspose.imaging.fileformats.metafile.EmfMetafileImage;

public class GetFontInfo {

    public static void main(String... args) throws Exception {
        String dataDir = Utils.getSharedDataDir(GetFontInfo.class) + "metafile/";
        //ExStart:GetFontInfo
        System.out.println("Get list of font names accessible to Aspose.Imaging API");
        for (String f : FontSettings.getAllFonts()) {
            System.out.println("\t" + f);
        }

        System.out.println("Get list of font names used in the metafile");
        MetafileImage metafile = new EmfMetafileImage(dataDir + "Sample1.emf");
        for (String f : metafile.getUsedFonts()) {
            System.out.println("\t" + f);
        }

        System.out.println("Get list of font names that are missing");
        for (String f : metafile.getMissedFonts()) {
            System.out.println("\t" + f);
        }
        //ExEnd:GetFontInfo
    }
}

