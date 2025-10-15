package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.ImageOptionsBase;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Path;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.exif.ExifData;
import com.aspose.imaging.exif.enums.ExifOrientation;
import com.aspose.imaging.metadata.IImageMetadataFormat;
import com.aspose.imaging.xmp.XmpPacketWrapper;
import com.aspose.imaging.xmp.schemas.xmpbaseschema.XmpBasicPackage;

import java.util.Arrays;

public class ExtendExifMetadataForRasterImage
{
    public static void main(String... args)
    {
        Logger.startExample();
        // The path to the documents' directory.
        String dataDir = Utils.getSharedDataDir() + "PNG/";

        String filePath = Path.combine(dataDir, "00020.png");
        String outputPath = filePath + ".edited.png";
        editSourceImageMetadata(filePath, outputPath);

        Logger.endExample();
    }

    public static void editSourceImageMetadata(String inputPath, String outputPath)
    {
        try (Image image = Image.load(inputPath))
        {
            if (image.getXmpData() != null)
            {
                XmpBasicPackage newPackage = new XmpBasicPackage();
                newPackage.addValue("New key", "New value");

                image.getXmpData().addPackage(newPackage);
            }

            if (image.getExifData() != null)
            {
                image.getExifData().setOrientation(ExifOrientation.RightTop);
            }

            image.save(outputPath);

            Utils.deleteFile(outputPath);
        }
    }

    public static void exportSourceImageMetadata(String inputPath, String outputPath, ImageOptionsBase outputOptions)
    {
        try (Image inputImage = Image.load(inputPath))
        {
            // Set KeepMetadata to true to export inputImage metadata profiles, if outputOptions instance does not contain ones.
            outputOptions.setKeepMetadata(true);

            inputImage.save(outputPath, outputOptions);
        }
    }

    public static void overwriteSourceImageMetadata(String inputPath, String outputPath, ImageOptionsBase outputOptions)
    {
        try (Image image = Image.load(inputPath))
        {
            IImageMetadataFormat[] newMetadata = GetNewMetadata();

            // Try to set metadata, if the image format support metadata format type.
            for (IImageMetadataFormat metadata : newMetadata)
            {
                if (outputOptions.trySetMetadata(metadata))
                {
                    System.out.format("%s image supports %s",
                            outputOptions.getClass().getName(), metadata.getClass().getName());
                }
            }

            // Or set metadata directly without image and metadata format compatibility check.
            outputOptions.setExifData(Arrays.stream(newMetadata)
                                            .filter(m -> m instanceof ExifData)
                                            .limit(1)
                                            .map(it -> (ExifData)it)
                                            .findFirst().get());
            outputOptions.setXmpData(Arrays.stream(newMetadata)
                                           .filter(m -> m instanceof XmpPacketWrapper)
                                           .limit(1)
                                            .map(it -> (XmpPacketWrapper)it)
                                           .findFirst().get()); //as XmpPacketWrapper;

            image.save(outputPath, outputOptions);
        }
    }

    public static IImageMetadataFormat[] GetNewMetadata()
    {
        XmpPacketWrapper xmpData = new XmpPacketWrapper();
        XmpBasicPackage xmpPackage = new XmpBasicPackage();
        xmpPackage.addValue("User key", "User value");
        xmpData.addPackage(xmpPackage);

        return new IImageMetadataFormat[]
                {
                        xmpData,
                        new ExifData()
                        {{
                                setOrientation(ExifOrientation.RightTop);
                        }},
                };
    }
}
