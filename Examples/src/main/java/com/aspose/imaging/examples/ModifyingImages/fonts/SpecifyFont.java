package com.aspose.imaging.examples.ModifyingImages.fonts;

import com.aspose.imaging.FontSettings;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.emf.EmfImage;
import com.aspose.imaging.fileformats.emf.emf.consts.EmfExtTextOutOptions;
import com.aspose.imaging.fileformats.emf.emf.objects.EmfLogFont;
import com.aspose.imaging.fileformats.emf.emf.objects.EmfText;
import com.aspose.imaging.fileformats.emf.emf.records.EmfExtCreateFontIndirectW;
import com.aspose.imaging.fileformats.emf.emf.records.EmfExtTextOutW;
import com.aspose.imaging.fileformats.emf.emf.records.EmfSelectObject;

import java.io.File;

public class SpecifyFont
{
    public static void main(String[] args)
    {
        Logger.startExample();

        // The path to the documents' directory.
        String baseFolder = Utils.getSharedDataDir() + "Fonts/";
        final String fontName = "Cambria Math";
        final int symbolCount = 40; //count symbols in the example
        final int startIndex = 2001; //start GlyphIndex for example
        FontSettings.setFontsFolder(baseFolder);

        //Fill GlyphIndex buffer
        int[] glyphCodes = new int[symbolCount];
        for (int i = 0; i < symbolCount; i++)
        {
            glyphCodes[i] = startIndex + i;
        }

        //create emf
        try (EmfImage emf = new EmfImage(700, 100))
        {
            //font record
            EmfExtCreateFontIndirectW font = new EmfExtCreateFontIndirectW();
            final EmfLogFont emfLogFont = new EmfLogFont();
            font.setElw(emfLogFont);
            emfLogFont.setFacename(fontName);
            emfLogFont.setHeight(30);

            //text record
            EmfExtTextOutW text = new EmfExtTextOutW();
            final EmfText emfText = new EmfText();
            text.setWEmrText(emfText);
            emfText.setOptions(EmfExtTextOutOptions.ETO_GLYPH_INDEX); //symbols index as GlyphIndex
            emfText.setChars(symbolCount); //string length
            emfText.setGlyphIndexBuffer(glyphCodes); //index buffer

            emf.getRecords().add(font); //add font
            final EmfSelectObject emfSelectObject = new EmfSelectObject();
            emfSelectObject.setObjectHandle(0);
            emf.getRecords().add(emfSelectObject); //select font
            emf.getRecords().add(text); //add text
            emf.save(baseFolder + "result.png"); //rendering
        }

        // Delete the result file
        new File(baseFolder + "result.png").delete();

        Logger.endExample();
    }
}
