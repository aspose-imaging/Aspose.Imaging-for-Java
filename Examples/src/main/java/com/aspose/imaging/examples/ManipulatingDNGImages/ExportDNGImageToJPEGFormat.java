package com.aspose.imaging.examples.ManipulatingDNGImages;

import com.aspose.imaging.examples.Logger;

public class ExportDNGImageToJPEGFormat
{
    public static void main(String[] args)
    {
        Logger.startExample("ExportDNGImageToJPEGFormat");

        //Declare variables to store file paths for input and output images.
        String sourceFiles = "Path_to_source_folder\\Source\\HDR - 3c.dng";
        String destPath = "Path_to_results_folder\\Results\\result.jpg";

        // Create an instance of Image class and load an exiting DNG file.
        // Convert the image to DngImage object.
        try (com.aspose.imaging.fileformats.dng.DngImage objimage = (com.aspose.imaging.fileformats.dng.DngImage)
                com.aspose.imaging.Image.load(sourceFiles))
        {
            // Create an instance of JpegOptions class.
            // convert and save to disk in Jpeg file format.
            objimage.save(destPath, new com.aspose.imaging.imageoptions.JpegOptions());
        }

        Logger.endExample();
    }

}
