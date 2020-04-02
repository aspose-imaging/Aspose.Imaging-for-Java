package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Color;
import com.aspose.imaging.DataRecoveryMode;
import com.aspose.imaging.Image;
import com.aspose.imaging.LoadOptions;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;

public class TiffDataRecovery
{
    public static void main(String... args)
    {
        Logger.startExample("TiffDataRecovery");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ModifyingImages/";

        // Create an instance of LoadOptions and set LoadOptions properties
        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setDataRecoveryMode(DataRecoveryMode.ConsistentRecover);
        loadOptions.setDataBackgroundColor(Color.getRed());

        // Create an instance of Image and load a damaged image by passing the instance of LoadOptions
        try (Image image = Image.load(dataDir + "SampleTiff1.tiff", loadOptions))
        {
            // Do some work
        }
        Logger.endExample();
    }
}
