package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.tiff.TiffFrame;
import com.aspose.imaging.fileformats.tiff.TiffImage;

import java.io.FileInputStream;
import java.io.IOException;

public class ConcatenatingTIFFImagesfromStream
{
    public static void main(String[] args) throws IOException
    {
        Logger.startExample("ConcatenatingTIFFImagesfromStream");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "images/";

        // Create instances of FileStream and initialize with Tiff images
        // Note the better performance you get using RandomAccessFile or string path
        try (FileInputStream fileStream = new FileInputStream(dataDir + "TestDemo.tif"))
        {
            try (FileInputStream fileStream1 = new FileInputStream(dataDir + "sample1.tif"))
            {

                // Create an instance of TiffImage and load the destination image from filestream
                try (TiffImage image = (TiffImage) Image.load(fileStream))
                {
                    // Create an instance of TiffImage and load the source image from filestream
                    try (TiffImage image1 = (TiffImage) Image.load(fileStream1))
                    {
                        // Create an instance of TIffFrame and copy active frame of source image
                        TiffFrame frame = TiffFrame.copyFrame(image1.getActiveFrame());

                        // Add copied frame to destination image
                        image.addFrame(frame);
                    }

                    // Save the image with changes
                    image.save(Utils.getOutDir() + "ConcatenatingTIFFImagesfromStream_out.tif");
                }
            }
        }
        Logger.endExample();
    }
}
