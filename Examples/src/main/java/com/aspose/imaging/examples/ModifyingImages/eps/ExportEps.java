package com.aspose.imaging.examples.ModifyingImages.eps;

import com.aspose.imaging.Image;
import com.aspose.imaging.PdfComplianceVersion;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.eps.EpsBinaryImage;
import com.aspose.imaging.fileformats.eps.EpsImage;
import com.aspose.imaging.fileformats.eps.EpsPreviewFormat;
import com.aspose.imaging.fileformats.pdf.PdfCoreOptions;
import com.aspose.imaging.fileformats.tiff.enums.TiffExpectedFormat;
import com.aspose.imaging.imageoptions.PdfOptions;
import com.aspose.imaging.imageoptions.TiffOptions;

import java.io.File;

public class ExportEps
{
    public static void main(String[] args)
    {
        Logger.startExample("ExportEps");

        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "/eps/";
        final String outDir = Utils.getOutDir("eps");

        try (EpsImage image = (EpsImage) Image.load(dataDir + "Sample.eps"))
        {
            PdfOptions options = new PdfOptions();
            final PdfCoreOptions coreOptions = new PdfCoreOptions();
            coreOptions.setPdfCompliance(PdfComplianceVersion.PdfA1b); // Set required PDF compliance
            options.setPdfCoreOptions(coreOptions);

            image.setPreviewToExport(EpsPreviewFormat.PostScriptRendering);
            image.save(outDir + "Sample.pdf", options);
        }

        try (EpsBinaryImage image = (EpsBinaryImage)Image.load(dataDir + "Sample.eps"))
        {
            // Tiff image export options
            TiffOptions options = new TiffOptions(TiffExpectedFormat.TiffJpegRgb);

            // The first way:
            image.getTiffPreview().save(outDir + "Sample1.tiff", options);

            // The second way:
            image.setPreviewToExport(EpsPreviewFormat.TIFF);
            image.save(outDir + "Sample2.tiff", options);
        }

        deleteFile(outDir + "Sample.pdf");
        deleteFile(outDir + "Sample1.tiff");
        deleteFile(outDir + "Sample2.tiff");

        Logger.endExample();
    }

    private static void deleteFile(String name)
    {
        File f = new File(name);
        if (!f.delete())
            f.deleteOnExit();
    }
}
