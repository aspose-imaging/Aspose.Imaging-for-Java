package com.aspose.imaging.examples.ModifyingImages.tga;

import com.aspose.imaging.Color;
import com.aspose.imaging.Image;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.jpeg.JpegImage;
import com.aspose.imaging.fileformats.tga.TgaImage;
import com.aspose.imaging.imageoptions.TgaOptions;

import java.util.Date;

public class ConvertToTGA
{
    public static void main(String[] args)
    {
        Logger.startExample("DicomCompression");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "tga/";
        String outDir = Utils.getOutDir("tga");

        String inputFile1 = dataDir + "test.jpg";
        String inputFile2 = dataDir + "test.png";
        String inputFile3 = dataDir + "test.tga";
        String output1 = outDir + "test_.tga";
        String output2 = outDir + "test2_.tga";
        String output3 = outDir + "test3_.tga";

        try (RasterImage image = (JpegImage) Image.load(inputFile1))
        {
            image.save(output1, new TgaOptions());
        }

        try (RasterImage image = (RasterImage)Image.load(inputFile2))
        {
            try (TgaImage tgaImage = new TgaImage(image))
            {
                tgaImage.save(output2);
            }
        }

        try (TgaImage image = (TgaImage)Image.load(inputFile3))
        {
            image.setDateTimeStamp(new Date());
            image.setAuthorName("John Smith");
            image.setAuthorComments("Comment");
            image.setImageId("ImageId");
            image.setJobNameOrId("Important Job");
            image.setJobTime(new Date(0, 0, 10));
            image.setTransparentColor(Color.fromArgb(123));
            image.setSoftwareId("SoftwareId");
            image.setSoftwareVersion("abc1");
            image.setSoftwareVersionLetter('a');
            image.setSoftwareVersionNumber(2);
            image.setXOrigin(1000);
            image.setYOrigin(1000);

            image.save(output3);
        }

        Utils.deleteFile(output1);
        Utils.deleteFile(output2);
        Utils.deleteFile(output3);

        Logger.endExample();
    }
}