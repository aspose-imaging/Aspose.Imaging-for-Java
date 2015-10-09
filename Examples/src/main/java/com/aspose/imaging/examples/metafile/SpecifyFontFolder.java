/* 
 * Copyright 2001-2015 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Imaging. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
package com.aspose.imaging.examples.metafile;

import java.nio.file.Paths;
import com.aspose.imaging.fileformats.metafile.FontSettings;

public class SpecifyFontFolder {

    public static void main(String... args) throws Exception {
        String fonts = Paths.get(System.getProperty("user.home"), "Fonts").toString();
        System.out.println("Adding fonts from user's home directory: " + fonts);
        FontSettings.addFontsFolder(fonts);

        System.out.println("List of all fonts:");
        for (String f : FontSettings.getAllFonts()) {
            System.out.println("\t" + f);
        }
    }
}
