package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.examples.Logger;

public class SyncRootProperty
{
    public static void main(String... args)
    {
        Logger.startExample("SyncRootProperty");
        // To get proper output please apply a valid Aspose.Imaging License. You can purchase full license or get 30 day temporary license from http:// Www.aspose.com/purchase/default.aspx."

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

        Logger.endExample();
    }

}
