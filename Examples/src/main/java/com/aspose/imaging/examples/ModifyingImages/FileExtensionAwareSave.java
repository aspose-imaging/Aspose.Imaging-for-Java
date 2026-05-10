package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Path;
import com.aspose.imaging.examples.Utils;

public class FileExtensionAwareSave
{
    public static void main(String[] args)
    {
        Logger.startExample();

        // The path to the document directory.
        String dataDir = Path.combine(Utils.getSharedDataDir(), "jpeg");
        String outputPath = Path.combine(Utils.getOutDir(), "output.png");

        // Loading and saving the image.
        try (Image image = Image.load(Path.combine(dataDir, "aspose-logo.jpg")))
        {
            image.save(outputPath);
        }

        // Delete the temporary file.
        Utils.deleteFile(outputPath);

        Logger.endExample();
    }
}
