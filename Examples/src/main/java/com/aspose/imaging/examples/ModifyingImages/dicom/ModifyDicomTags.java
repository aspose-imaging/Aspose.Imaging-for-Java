package com.aspose.imaging.examples.ModifyingImages.dicom;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.dicom.DicomImage;
import com.aspose.imaging.fileformats.dicom.DicomImageInfo;

public class ModifyDicomTags
{
    public static void main(String[] args)
    {
        Logger.startExample();
        // The path to the document directory.
        String dataDir = Utils.getSharedDataDir() + "dicom/";
        String outDir = Utils.getOutDir();

        try (DicomImage image = (DicomImage) Image.load(dataDir + "file.dcm"))
        {
            final DicomImageInfo fileInfo = image.getFileInfo();
            fileInfo.updateTagAt(33, "Test Patient"); // "Patient's Name"
            fileInfo.addTag("Angular View Vector", 234);
            fileInfo.removeTagAt(29); // "Station Name"

            image.save(outDir + "output.dcm");
        }

        Utils.deleteFile(outDir + "output.dcm");
        Logger.endExample();
    }
}
