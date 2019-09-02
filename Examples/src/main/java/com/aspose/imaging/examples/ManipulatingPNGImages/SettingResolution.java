package com.aspose.imaging.examples.ManipulatingPNGImages;

import com.aspose.imaging.*;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.png.PngImage;
import com.aspose.imaging.imageoptions.PngOptions;

public class SettingResolution
{
    public static void main(String... args)
    {
        //ExStart:SettingResolution

        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ManipulatingPNGImages/";
        // Initialize variables to hold width & height values
        int width = 0;
        int height = 0;

        // Initialize an array of type Color to hold the pixel data
        Color[] pixels = null;

        // Create an instance of RasterImage and load a BMP image
        try (RasterImage raster = (RasterImage) Image.load(dataDir + "aspose_logo.png"))
        {
            // Store the width & height in variables for later use
            width = raster.getWidth();
            height = raster.getHeight();

            // Load the pixels of RasterImage into the array of type Color
            pixels = raster.loadPixels(new Rectangle(0, 0, width, height));
        }

        // Create & initialize an instance of PngImage while specifying size and PngColorType
        try (PngImage png = new PngImage(width, height))
        {
            // Save the previously loaded pixels on to the new PngImage
            png.savePixels(new Rectangle(0, 0, width, height), pixels);

            // Create an instance of PngOptions, Set the horizontal & vertical resolutions and Save the result on disc
            PngOptions options = new PngOptions();
            options.setResolutionSettings(new ResolutionSetting(72, 96));
            png.save(dataDir + "SettingResolution_output.png", options);
        }
        //ExEnd:SettingResolution
    }
}
