package com.aspose.imaging.examples.metafile;

import com.aspose.imaging.FontSettings;

import java.nio.file.Paths;

public class SpecifyFontFolder
{

    public static void main(String... args)
    {
        //ExStart:SpecifyFontFolder
        String fonts = Paths.get(System.getProperty("user.home"), "Fonts").toString();
        System.out.println("Adding fonts from user's home directory: " + fonts);
        FontSettings.addFontsFolder(fonts);

        System.out.println("List of all fonts:");
        for (String f : FontSettings.getAllFonts())
        {
            System.out.println("\t" + f);
        }
        //ExEnd:SpecifyFontFolder
    }
}
