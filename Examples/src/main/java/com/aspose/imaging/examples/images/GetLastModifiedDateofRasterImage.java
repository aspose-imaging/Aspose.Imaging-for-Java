package com.aspose.imaging.examples.images;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;

public class GetLastModifiedDateofRasterImage {
	public static void main(String... args) throws Exception {
		String dataDir = Utils.getSharedDataDir(GetLastModifiedDateofRasterImage.class) + "images/";
		// Declare variable to store file path for input image
                //ExStart:GetLastModifiedDateofRasterImage
                String path = dataDir + "aspose-logo.jpg";

		com.aspose.imaging.RasterImage image = (com.aspose.imaging.RasterImage) Image.load(path);
		try {
			// gets the date from [FileInfo]
			String modifyDate = image.getModifyDate(true).toString();
			System.out.format("Last modify date using FileInfo: %s\n", modifyDate);

			// gets the date from XMP metadata of [FileInfo] as long as it's not
			// default case
			modifyDate = image.getModifyDate(false).toString();
			System.out.format("Last modify date using info from FileInfo and XMP metadata: %s\n", modifyDate);
		} finally {
			image.dispose();
		}
                //ExEnd:GetLastModifiedDateofRasterImage
	}
}
