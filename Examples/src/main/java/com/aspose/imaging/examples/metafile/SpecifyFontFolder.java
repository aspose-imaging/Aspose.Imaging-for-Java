package com.aspose.imaging.examples.metafile;

import java.nio.file.Paths;
import com.aspose.imaging.FontSettings;

public class SpecifyFontFolder {

    public static void main(String... args) throws Exception {
       //ExStart:SpecifyFontFolder
        String fonts = Paths.get(System.getProperty("user.home"), "Fonts").toString();
        System.out.println("Adding fonts from user's home directory: " + fonts);
        FontSettings.addFontsFolder(fonts);

        System.out.println("List of all fonts:");
        for (String f : FontSettings.getAllFonts()) {
            System.out.println("\t" + f);
        }
        //ExEnd:SpecifyFontFolder
    }
}
