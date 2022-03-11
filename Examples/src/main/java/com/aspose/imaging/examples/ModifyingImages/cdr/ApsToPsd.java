package com.aspose.imaging.examples.ModifyingImages.cdr;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.psd.VectorDataCompositionMode;
import com.aspose.imaging.imageoptions.PsdOptions;
import com.aspose.imaging.imageoptions.PsdVectorizationOptions;
import com.aspose.imaging.imageoptions.VectorRasterizationOptions;

public class ApsToPsd
{
    public static void main(String[] args)
    {
        Logger.startExample();

        String inputFileName = Utils.getSharedDataDir() + "CDR/SimpleShapes.cdr";
        String outFile = Utils.getOutDir("CDR") + "/SimpleShapes.psd";

        //Export vector image to PSD format keeping vector shapes

        //Aspose.Imaging allows to export the vector image formats such as CDR, EMF, EPS, ODG, SVG, WMF to the PSD format,
        //while keeping vector properties of the original, utilizing PSD Shapes, Paths //and Vector Masks.
        //Currently, export of not very complex shapes is supported, without texture brushes or open shapes with stroke,
        //which will be improved in the upcoming releases.
        //Example

        //Export from the CDR format to the PSD format preserving vector
        //properties is as simple as the following snippet:
        try (Image image = Image.load(inputFileName))
        {
            VectorRasterizationOptions vectorRasterizationOptions = new VectorRasterizationOptions();
            vectorRasterizationOptions.setPageWidth(image.getWidth());
            vectorRasterizationOptions.setPageHeight(image.getHeight());

            PsdVectorizationOptions psdOptions = new PsdVectorizationOptions();
            psdOptions.setVectorDataCompositionMode(VectorDataCompositionMode.SeparateLayers);

            PsdOptions imageOptions = new PsdOptions();
            imageOptions.setVectorRasterizationOptions(vectorRasterizationOptions);
            imageOptions.setVectorizationOptions(psdOptions);

            // Export image to PSD format
            image.save(outFile, imageOptions);
        }

        Utils.deleteFile(outFile);

        Logger.endExample();
    }
}
