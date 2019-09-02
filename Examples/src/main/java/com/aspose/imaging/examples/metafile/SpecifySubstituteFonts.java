package com.aspose.imaging.examples.metafile;

public class SpecifySubstituteFonts
{
    public static void main(String... args)
    {
		//ExStart:SpecifySubstituteFonts
        String[] substituteFontName = {"font1", "font2"};
        com.aspose.imaging.FontSettings.addFontSubstitutes("originalFontName", substituteFontName);
		//ExEnd:SpecifySubstituteFonts
    }

}
