package com.aspose.imaging.examples.ManipulatingTIFFImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.PointF;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.psd.layers.layerresources.vectorpaths.BezierKnotRecord;
import com.aspose.imaging.fileformats.psd.layers.layerresources.vectorpaths.LengthRecord;
import com.aspose.imaging.fileformats.psd.layers.layerresources.vectorpaths.VectorPathRecord;
import com.aspose.imaging.fileformats.tiff.TiffImage;
import com.aspose.imaging.fileformats.tiff.pathresources.PathResource;
import com.aspose.imaging.imageoptions.PsdOptions;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class SupportExtractingPathsFromTiff
{
    public static void main(String... args)
    {
        Logger.startExample("SupportExtractingPathsFromTiff");
        String filePath = Utils.getSharedDataDir() + "Tiff/Sample.tif";
        String outFilePath = Utils.getOutDir() + "SampleWithPaths.psd";
        String outFilePath2 = Utils.getOutDir() + "ImageWithPath.psd";

        try (TiffImage image = (TiffImage)Image.load(filePath))
        {
            for (PathResource path : image.getActiveFrame().getPathResources())
            {
                System.out.println(path.getName());
            }

            image.save(outFilePath, new PsdOptions());
        }

        // Create Clipping Path manually
        try (TiffImage image = (TiffImage) Image.load(filePath))
        {
            final List<PathResource> list = new LinkedList<>();

            final PathResource pathResource = new PathResource();
            pathResource.setBlockId((short) 2000); // Block Id according to Photoshop specification
            pathResource.setName("My Clipping Path"); // Path name
            pathResource.setRecords(createRecords(0.2f, 0.2f, 0.8f, 0.2f, 0.8f, 0.8f, 0.2f, 0.8f)); // Create path records using coordinates
            list.add(pathResource);

            image.getActiveFrame().setPathResources(list);

            image.save(outFilePath2);
        }

        File f = new File(outFilePath);
        if (!f.delete())
            f.deleteOnExit();

        f = new File(outFilePath2);
        if (!f.delete())
            f.deleteOnExit();

        Logger.endExample();
    }

    private static List<VectorPathRecord> createRecords(float ... coordinates)
    {
        java.util.List<VectorPathRecord> records = createBezierRecords(coordinates); // Create Bezier records using coordinates

        LengthRecord lr = new LengthRecord(); // LengthRecord required by Photoshop specification
        lr.setOpen(false); // Lets create closed path
        lr.setRecordCount(records.size()); // Record count in the path

        records.add(0, lr);

        return records;
    }

    private static java.util.List<VectorPathRecord> createBezierRecords(float[] coordinates)
    {
        final java.util.List<VectorPathRecord> list = new LinkedList<>();

        for (int index = 0; index < coordinates.length - 1; index += 2)
        {
            PointF point = new PointF(coordinates[index], coordinates[index + 1]);
            list.add(createBezierRecord(point));
        }

        return list;
    }

    private static VectorPathRecord createBezierRecord(PointF point)
    {
        BezierKnotRecord it = new BezierKnotRecord();
        it.setPathPoints(new PointF[] { point, point, point } );
        return it;
    }
}
