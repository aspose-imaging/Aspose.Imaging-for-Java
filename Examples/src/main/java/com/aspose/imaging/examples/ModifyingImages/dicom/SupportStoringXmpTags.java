package com.aspose.imaging.examples.ModifyingImages.dicom;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.dicom.DicomImage;
import com.aspose.imaging.imageoptions.DicomOptions;
import com.aspose.imaging.xmp.XmpPacketWrapper;
import com.aspose.imaging.xmp.schemas.dicom.DicomPackage;

import java.util.List;

public class SupportStoringXmpTags
{
    public static void main(String[] args)
    {
        Logger.startExample();
        // The path to the documents' directory.
        String dataDir = Utils.getSharedDataDir() + "dicom/";
        String outDir = Utils.getOutDir();

        try (DicomImage image = (DicomImage) Image.load(dataDir + "file.dcm"))
        {
            XmpPacketWrapper xmpPacketWrapper = new XmpPacketWrapper();
            DicomPackage dicomPackage = new DicomPackage();

            dicomPackage.setEquipmentInstitution("Test Institution");
            dicomPackage.setEquipmentManufacturer("Test Manufacturer");
            dicomPackage.setPatientBirthDate("19010101");
            dicomPackage.setPatientId("010101");
            dicomPackage.setPatientName("Test Name");
            dicomPackage.setPatientSex("M");
            dicomPackage.setSeriesDateTime("19020202");
            dicomPackage.setSeriesDescription("Test Series Description");
            dicomPackage.setSeriesModality("Test Modality");
            dicomPackage.setSeriesNumber("01");
            dicomPackage.setStudyDateTime("19030303");
            dicomPackage.setStudyDescription("Test Study Description");
            dicomPackage.setStudyId("02");
            dicomPackage.setStudyPhysician("Test Physician");

            xmpPacketWrapper.addPackage(dicomPackage);
            String outputFile = outDir + "output.dcm";

            image.save(outputFile, new DicomOptions() {{ setXmpData(xmpPacketWrapper); }});


            try (DicomImage imageSaved = (DicomImage)Image.load(outputFile))
            {
                List<String> originalDicomInfo = image.getFileInfo().getDicomInfo();
                List<String> imageSavedDicomInfo = imageSaved.getFileInfo().getDicomInfo();
                int tagsCountDiff = Math.abs(imageSavedDicomInfo.size() - originalDicomInfo.size());
                Logger.println("The difference between info of two dicom files: ", tagsCountDiff);
            }

            new java.io.File(outputFile).delete();
        }

        Logger.endExample();
    }
}
