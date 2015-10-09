/* 
 * Copyright 2001-2015 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Imaging. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
package com.aspose.imaging.examples.metafile;

import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.metafile.FontSettings;
import com.aspose.imaging.fileformats.metafile.MetafileImage;
import com.aspose.imaging.fileformats.metafile.EmfMetafileImage;

public class GetFontInfo {

    public static void main(String... args) throws Exception {
        String dataDir = Utils.getDataDir(GetFontInfo.class);

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
    }
}

