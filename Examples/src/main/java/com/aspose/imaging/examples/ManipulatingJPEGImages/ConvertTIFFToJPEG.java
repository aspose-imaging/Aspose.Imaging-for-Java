/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.imaging.examples.ManipulatingJPEGImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.ResolutionSetting;
import com.aspose.imaging.ResolutionUnit;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.tiff.TiffFrame;
import com.aspose.imaging.fileformats.tiff.TiffImage;
import com.aspose.imaging.fileformats.tiff.enums.TiffResolutionUnits;
import com.aspose.imaging.imageoptions.JpegOptions;
import com.aspose.imaging.imageoptions.TiffOptions;

/**
 * @author mfazi
 */
public class ConvertTIFFToJPEG
{
    public static void main(String[] args)
    {
        //ExStart:ConvertTIFFToJPEG
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ManipulatingJPEGImages/";

        TiffImage tiffImage = (TiffImage) Image.load(dataDir + "source2.tif");
        try
        {
            int i = 0;
            for (TiffFrame tiffFrame : tiffImage.getFrames())
            {
                JpegOptions saveOptions = new JpegOptions();
                saveOptions.setResolutionSettings(new ResolutionSetting(tiffFrame.getHorizontalResolution(), tiffFrame.getVerticalResolution()));

                TiffOptions frameOptions = tiffFrame.getFrameOptions();
                if (frameOptions != null)
                {
                    // Set the resolution unit explicitly.
                    switch (frameOptions.getResolutionUnit())
                    {
                        case TiffResolutionUnits.None:
                            saveOptions.setResolutionUnit(ResolutionUnit.None);
                            break;

                        case TiffResolutionUnits.Inch:
                            saveOptions.setResolutionUnit(ResolutionUnit.Inch);
                            break;

                        case TiffResolutionUnits.Centimeter:
                            saveOptions.setResolutionUnit(ResolutionUnit.Cm);
                            break;

                        default:
                            throw new RuntimeException("Current resolution unit is unsupported!");
                    }
                }

                String fileName = "source2.tif.frame." + (i++) + "."
                        + ResolutionUnit.toString(ResolutionUnit.class, saveOptions.getResolutionUnit()) + ".jpg";
                tiffFrame.save(dataDir + fileName, saveOptions);
            }
        }
        finally
        {
            tiffImage.close();
        }

        //ExEnd:ConvertTIFFToJPEG
    }

}
