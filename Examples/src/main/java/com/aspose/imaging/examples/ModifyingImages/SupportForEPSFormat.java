package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.eps.EpsBinaryImage;
import com.aspose.imaging.fileformats.eps.EpsImage;
import com.aspose.imaging.fileformats.eps.EpsInterchangeImage;
import com.aspose.imaging.fileformats.eps.consts.EpsType;
import com.aspose.imaging.imageoptions.PngOptions;

public class SupportForEPSFormat
{
    public static void main(String[] args)
    {
        Logger.startExample("SupportForEPSFormat");
        String dataDir = Utils.getSharedDataDir() + "ModifyingImages/";;

        try (EpsImage epsImage = (EpsImage)Image.load(dataDir+"bmpPhotoshop1bit.eps"))
        {
            // check if EPS image has any raster preview to proceed (for now only raster preview is supported)
            if (epsImage.hasRasterPreview())
            {
                if (epsImage.getPhotoshopThumbnail() != null)
                {
                    // process Photoshop thumbnail if it's present
                    Logger.println("process Photoshop thumbnail if it's present");
                }

                if (epsImage.getEpsType() == EpsType.Interchange)
                {
                    // Get EPS Interchange subformat instance
                    EpsInterchangeImage epsInterchangeImage = (EpsInterchangeImage)epsImage;

                    if (epsInterchangeImage.getRasterPreview() != null)
                    {
                        // process black-and-white Interchange raster preview if it's present
                        Logger.println("process black-and-white Interchange raster preview if it's present");
                    }
                }
                else
                {
                    // Get EPS Binary subformat instance
                    EpsBinaryImage epsBinaryImage = (EpsBinaryImage)epsImage;

                    if (epsBinaryImage.getTiffPreview() != null)
                    {
                        // process TIFF preview if it's present
                        Logger.println("process TIFF preview if it's present");
                    }

                    if (epsBinaryImage.getWmfPreview() != null)
                    {
                        // process WMF preview if it's present
                        Logger.println("process WMF preview if it's present");
                    }
                }

                // export EPS image to PNG (by default, best available quality preview is used for export)
                epsImage.save(Utils.getOutDir() + "anyEpsFile.png", new PngOptions());
            }
        }

        Logger.endExample();
    }
}
