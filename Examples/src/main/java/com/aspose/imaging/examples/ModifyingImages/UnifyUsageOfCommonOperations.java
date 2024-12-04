package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.*;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.opendocument.OdImage;
import com.aspose.imaging.imageoptions.PngOptions;
import com.aspose.imaging.imageoptions.VectorRasterizationOptions;

public class UnifyUsageOfCommonOperations
{
    public static void main(String[] args)
    {
        Logger.startExample();
        // The path to the documents' directory.
        String dataDir = Utils.getSharedDataDir() + "CDR/";
        String fileName = "test.cdr";
        String inputFileName = dataDir + fileName;
        String outputFileNamePng = Utils.getOutDir() + "output.png";

        try (Image image = Image.load(inputFileName))
        {
            if (image instanceof OdImage)
            {
                image.crop(new Rectangle(92, 179, 260, 197));
            }
            else
            {
                image.crop(new Rectangle(88, 171, 250, 190));
            }

            image.save(outputFileNamePng, new PngOptions()
            {{
                setVectorRasterizationOptions(new VectorRasterizationOptions()
                {{
                    setPageSize(Size.to_SizeF(image.getSize()));
                    setTextRenderingHint(TextRenderingHint.SingleBitPerPixel);
                    setSmoothingMode(SmoothingMode.None);

                }});
            }});
        }
        Utils.deleteFile(outputFileNamePng);
        Logger.endExample();
    }
}
