package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.ResizeType;
import com.aspose.imaging.examples.Utils;

public class ResizeImageWithResizeTypeEnumeration
{
    public static void main(String... args)
    {
		//ExStart:ResizeImageWithResizeTypeEnumeration
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir() + "ModifyingImages/";
        Image image = Image.load(dataDir + "aspose-logo.jpg");

		try
		{
			if (!image.isCached())
			{
				image.cacheData();
			}

			// specifying only width and ResizeType
			int newWidth = image.getWidth() / 2;
			image.resizeWidthProportionally(newWidth, ResizeType.LanczosResample);

			// specifying only height and ResizeType
			int newHeight = image.getHeight() / 2;
			image.resizeHeightProportionally(newHeight, ResizeType.NearestNeighbourResample);
			// saving result
			image.save(dataDir + "ResizeImageWithResizeTypeEnumeration_out.png");
		}
		finally
		{
			image.close();
		}
		//ExEnd:ResizeImageWithResizeTypeEnumeration
    }
}
