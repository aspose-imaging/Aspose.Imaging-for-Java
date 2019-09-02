package com.aspose.imaging.examples.ManipulatingTIFFImages;

import com.aspose.imaging.Color;
import com.aspose.imaging.DataRecoveryMode;
import com.aspose.imaging.Image;
import com.aspose.imaging.LoadOptions;
import com.aspose.imaging.examples.Utils;

public class DataRecovery
{
    public static void main(String... args)
    {
		//ExStart:DataRecovery

        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ManipulatingTIFFImages/";

        // Create an instance of LoadOptions
        LoadOptions loadOptions = new LoadOptions();

        // Specify the DataRecoveryMode for the object of LoadOptions
        loadOptions.setDataRecoveryMode(DataRecoveryMode.ConsistentRecover);

        // Specify the DataBackgroundColor for the object of LoadOptions
        loadOptions.setDataBackgroundColor(Color.getRed());

        // Create an instance of Image and load a damaged image by passing the
        // instance of LoadOptions
        Image image = Image.load(dataDir + "DataRecovery_out.tif", loadOptions);
        image.close();
        //ExEnd:DataRecovery
    }

}
