package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.tiff.TiffFrame;
import com.aspose.imaging.fileformats.tiff.TiffImage;
import com.aspose.imaging.fileformats.tiff.enums.*;
import com.aspose.imaging.imageoptions.TiffOptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConcatenateTiffImagesHavingSeveralFrames
{
    public static void main(String[] args)
    {
        Logger.startExample("ConcatenateTiffImagesHavingSeveralFrames");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ModifyingImages/";
        List<String> files = Arrays.asList(dataDir + "TestDemo.tiff", dataDir + "sample.tiff");
        TiffOptions createOptions = new TiffOptions(TiffExpectedFormat.Default);
        createOptions.setBitsPerSample(new int[] { 1 });
        createOptions.setOrientation(TiffOrientations.TopLeft);
        createOptions.setPhotometric(TiffPhotometrics.MinIsBlack);
        createOptions.setCompression(TiffCompressions.CcittFax3);
        createOptions.setFillOrder(TiffFillOrders.Lsb2Msb);

        // Create a new image by passing the TiffOptions and size of first frame, we will remove the first frame at the end, cause it will be empty
        TiffImage output = null;
        try
        {
            List<TiffImage> images = new ArrayList<>();
            try
            {
                for (String file : files)
                {
                    // Create an instance of TiffImage and load the source image
                    TiffImage input = (TiffImage) Image.load(file);
                    images.add(input); // Do not dispose before data is fetched. Data is fetched on 'Save' later.
                    for (TiffFrame frame : input.getFrames())
                    {
                        if (output == null)
                        {
                            // Create a new tiff image with first frame defined.
                            output = new TiffImage(TiffFrame.copyFrame(frame));
                        }
                        else
                        {
                            // Add copied frame to destination image
                            output.addFrame(TiffFrame.copyFrame(frame));
                        }
                    }
                }

                if (output != null)
                {
                    // Save the result
                    output.save(Utils.getOutDir() + "ConcatenateTiffImagesHavingSeveralFrames_out.tif", createOptions);
                }
            }
            finally
            {
                for (TiffImage image : images)
                {
                    image.close();
                }
            }
        }
        catch (Exception ignored)
        {

        }
        Logger.endExample();
    }
}
