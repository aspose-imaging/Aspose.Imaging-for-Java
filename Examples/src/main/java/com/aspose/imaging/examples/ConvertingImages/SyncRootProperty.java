package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.tiff.TiffFrame;
import com.aspose.imaging.fileformats.tiff.TiffImage;

public class SyncRootProperty
{
	public static void main(String... args) throws Exception 
{
		// ExStart:ExportImagesInMultiThreadedEnvironment

		// create new synchronized two-way stream
        com.aspose.imaging.StreamContainer streamContainer = new com.aspose.imaging.StreamContainer(new java.io.ByteArrayInputStream(new byte[0]));
        try
        {
            // check if the access to the stream source is synchronized.
            synchronized (streamContainer.getSyncRoot())
            {
                    // do work
                    // now access to streamContainer is synchronized
            }
        }
        finally
        {
                streamContainer.dispose();
        }

		// ExEnd:ExportImagesInMultiThreadedEnvironment
	}

}
