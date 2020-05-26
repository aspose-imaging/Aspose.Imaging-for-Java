package com.aspose.imaging.examples.ManipulatingTIFFImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.psd.layers.layerresources.vectorpaths.VectorPathRecord;
import com.aspose.imaging.fileformats.tiff.TiffFrame;
import com.aspose.imaging.fileformats.tiff.TiffImage;
import com.aspose.imaging.fileformats.tiff.enums.TiffExpectedFormat;
import com.aspose.imaging.fileformats.tiff.pathresources.PathResource;
import com.aspose.imaging.imageoptions.TiffOptions;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SupportExtractingPathsFromTiff
{
    public static void main(String... args)
    {
        Logger.startExample("OptimizationStrategyInDicom");
        String filePath = Utils.getOutDir() + "SupportExtractingPathsFromTiff.tif";
        PathResource resource = new PathResource();
        resource.setBlockId((short) 2000);
        resource.setName("Name");
        resource.setRecords(new ArrayList<VectorPathRecord>());

        List<PathResource> pathResources = Collections.singletonList(resource);

        try (TiffImage image = new TiffImage(new TiffFrame(new TiffOptions(TiffExpectedFormat.Default), 10, 10)))
        {
            image.getActiveFrame().setPathResources(pathResources);
            image.save(filePath);
        }

        try (TiffImage image = (TiffImage) Image.load(filePath))
        {
            List<PathResource> actual = image.getActiveFrame().getPathResources();
            if (pathResources.size() != actual.size())
            {
                Logger.println("Resources count not equal");
            }

            if (pathResources.get(0).getBlockId() != actual.get(0).getBlockId())
            {
                Logger.println("BlockId not equal");
            }

            if (!pathResources.get(0).getName().equals(actual.get(0).getName()))
            {
                Logger.println("Resource name not equal");
            }
        }

        File f = new File(filePath);
        f.delete();

        Logger.endExample();
    }
}
