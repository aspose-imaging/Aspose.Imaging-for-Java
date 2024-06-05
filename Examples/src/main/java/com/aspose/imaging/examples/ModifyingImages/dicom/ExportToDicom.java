package com.aspose.imaging.examples.ModifyingImages.dicom;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Path;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.DicomOptions;

public class ExportToDicom
{
    public static void main(String[] args)
    {
        Logger.startExample("ExportToDicom");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "dicom/";
        String outDir = Utils.getOutDir();
        String fileName = "sample.jpg";
        String inputFileNameSingle = Path.combine(dataDir, fileName);
        String inputFileNameMultipage = Path.combine(dataDir, "multipage.tif");
        String outputFileNameSingleDcm = Path.combine(outDir, "ExportToDicom_output.dcm");
        String outputFileNameMultipageDcm = Path.combine(outDir, "ExportToDicom_outputMultipage.dcm");

        // The next code sample converts JPEG image to DICOM file format
        try (Image image = Image.load(inputFileNameSingle))
        {
            image.save(outputFileNameSingleDcm, new DicomOptions());
        }

        // DICOM format supports multipage images. You can convert GIF or TIFF images to DICOM in the same way as JPEG images
        try (Image image = Image.load(inputFileNameMultipage))
        {
            image.save(outputFileNameMultipageDcm, new DicomOptions());
        }

        Logger.endExample();
    }
}
