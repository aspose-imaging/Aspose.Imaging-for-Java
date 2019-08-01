package com.aspose.imaging.examples.ManipulatingTIFFImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.png.PngColorType;
import com.aspose.imaging.fileformats.tiff.TiffImage;
import com.aspose.imaging.fileformats.tiff.enums.TiffExpectedFormat;
import com.aspose.imaging.imageoptions.PngOptions;
import com.aspose.imaging.imageoptions.TiffOptions;
import com.aspose.imaging.examples.Assert;

public class SupportTiffDeflate {

    public static void main(String... args) throws Exception {

        //ExStart:SupportTiffDeflate
        String dataDir = Utils.getSharedDataDir(SupportTiffDeflate.class) + "ManipulatingTIFFImages/";

        String inputFile = dataDir + "Alpha.png";
        String outputFileTiff = dataDir + "Alpha.tiff";
        String outputFilePng = dataDir + "Alpha1.png";
             
        try(Image image = Image.load(inputFile))
        {
            TiffOptions options = new TiffOptions(TiffExpectedFormat.TiffDeflateRgba);
            image.save(outputFileTiff, options);
        }         

        try(Image image = Image.load(outputFileTiff))
        {
            Assert.assertTrue(((RasterImage)image).hasAlpha());
            PngOptions options = new PngOptions();
            options.setColorType(PngColorType.TruecolorWithAlpha);
            image.save(outputFilePng, options);
        }
        //ExEnd:SupportTiffDeflate
    }
}