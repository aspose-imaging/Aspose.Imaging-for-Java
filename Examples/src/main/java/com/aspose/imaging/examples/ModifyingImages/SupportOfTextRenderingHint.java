/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.Size;
import com.aspose.imaging.TextRenderingHint;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.cdr.CdrImage;
import com.aspose.imaging.fileformats.cmx.CmxImage;
import com.aspose.imaging.fileformats.emf.EmfImage;
import com.aspose.imaging.fileformats.opendocument.OdgImage;
import com.aspose.imaging.fileformats.svg.SvgImage;
import com.aspose.imaging.fileformats.wmf.WmfImage;
import com.aspose.imaging.imageoptions.*;

/**
 * @author mfazi
 */
public class SupportOfTextRenderingHint
{
    public static void main(String[] args)
    {
        Logger.startExample("SupportOfTextRenderingHint");
        // The path to the documents directory.
        String basePath = Utils.getSharedDataDir() + "ModifyingImages/";

        String[] files = new String[]{
                "TextHintTest.cdr",
                "TextHintTest.cmx",
                "TextHintTest.emf",
                "TextHintTest.wmf",
                "TextHintTest.odg",
                "TextHintTest.svg"
        };
        int[] textRenderingHints = new int[]{
                TextRenderingHint.AntiAlias, TextRenderingHint.AntiAliasGridFit,
                TextRenderingHint.ClearTypeGridFit, TextRenderingHint.SingleBitPerPixel, TextRenderingHint.SingleBitPerPixelGridFit
        };
        for (String fileName : files)
        {
            try (Image image = Image.load(basePath + fileName))
            {
                VectorRasterizationOptions vectorRasterizationOptions;
                if (image instanceof CdrImage)
                {
                    vectorRasterizationOptions = new CdrRasterizationOptions();
                }
                else if (image instanceof CmxImage)
                {
                    vectorRasterizationOptions = new CmxRasterizationOptions();
                }
                else if (image instanceof EmfImage)
                {
                    vectorRasterizationOptions = new EmfRasterizationOptions();
                }
                else if (image instanceof WmfImage)
                {
                    vectorRasterizationOptions = new WmfRasterizationOptions();
                }
                else if (image instanceof OdgImage)
                {
                    vectorRasterizationOptions = new OdgRasterizationOptions();
                }
                else if (image instanceof SvgImage)
                {
                    vectorRasterizationOptions = new SvgRasterizationOptions();
                }
                else
                {
                    throw new RuntimeException("This is image is not supported in this example");
                }
                vectorRasterizationOptions.setPageSize(Size.to_SizeF(image.getSize()));
                for (int textRenderingHint : textRenderingHints)
                {
                    String outputFileName = Utils.getOutDir() + String.format("image_%s%s.png", TextRenderingHint.toString(TextRenderingHint.class, textRenderingHint), fileName.substring(fileName.lastIndexOf('.')));
                    vectorRasterizationOptions.setTextRenderingHint(textRenderingHint);
                    PngOptions pngOptions = new PngOptions();
                    pngOptions.setVectorRasterizationOptions(vectorRasterizationOptions);
                    image.save(outputFileName, pngOptions);
                }
            }
        }
        Logger.endExample();
    }

}
