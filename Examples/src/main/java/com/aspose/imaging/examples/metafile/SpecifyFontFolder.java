package com.aspose.imaging.examples.metafile;

import com.aspose.imaging.FontSettings;
import com.aspose.imaging.examples.Logger;

import java.nio.file.Paths;

public class SpecifyFontFolder
{

    public static void main(String... args)
    {
        Logger.startExample("SpecifyFontFolder");
        String fonts = Paths.get(System.getProperty("user.home"), "Fonts").toString();
        Logger.println("Adding fonts from user's home directory: " + fonts);
        FontSettings.addFontsFolder(fonts);

        Logger.println("List of all fonts:");
        for (String f : FontSettings.getAllFonts())
        {
            Logger.println("\t" + f);
        }
        Logger.endExample();
    }
}
