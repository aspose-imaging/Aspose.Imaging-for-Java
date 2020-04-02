package com.aspose.imaging.examples.dicom;

import com.aspose.imaging.Image;
import com.aspose.imaging.ResizeType;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.dicom.DicomImage;
import com.aspose.imaging.imageoptions.BmpOptions;

public class DICOMSOtherImageResizingOptions
{
    public static void main(String... args)
    {
        Logger.startExample("DICOMSOtherImageResizingOptions");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "dicom/";

        try (DicomImage image = (DicomImage)Image.load(dataDir + "image.dcm"))
        {
            image.resizeHeightProportionally(100, ResizeType.AdaptiveResample);
            image.save(Utils.getOutDir() + "DICOMSOtherImageResizingOptions_out.bmp", new BmpOptions());
        }


        try (DicomImage image1 = (DicomImage)Image.load(dataDir + "image.dcm"))
        {
            image1.resizeWidthProportionally(150, ResizeType.AdaptiveResample);
            image1.save(Utils.getOutDir() + "DICOMSOtherImageResizingOptions1_out.bmp", new BmpOptions());
        }
        Logger.endExample();
    }
}
