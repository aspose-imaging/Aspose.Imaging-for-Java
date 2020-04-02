package com.aspose.imaging.examples.metafile;

import com.aspose.imaging.examples.Logger;

public class SpecifySubstituteFonts
{
    public static void main(String... args)
    {
        Logger.startExample("SpecifySubstituteFonts");
        String[] substituteFontName = {"font1", "font2"};
        com.aspose.imaging.FontSettings.addFontSubstitutes("originalFontName", substituteFontName);
        Logger.endExample();
    }

}
