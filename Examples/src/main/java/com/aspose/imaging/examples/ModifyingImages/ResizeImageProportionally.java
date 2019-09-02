package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;

public class ResizeImageProportionally
{
    public static void main(String... args)
    {
		//ExStart:ResizeImageProportionally
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir() + "ModifyingImages/";
        Image image = Image.load(dataDir + "aspose-logo.jpg");

		try
		{
			if (!image.isCached())
			{
				image.cacheData();
			}

			// specifying width and height
			int newWidth = image.getWidth() / 2;
			image.resizeHeightProportionally(newWidth);

			int newHeight = image.getHeight() / 2;
			image.resizeHeightProportionally(newHeight);

			// saving result
			image.save(dataDir + "ResizeImageProportionally_out.png");
		}
		finally
		{
			image.close();
		}
		//ExEnd:ResizeImageProportionally
    }

}
