package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.tiff.enums.TiffExpectedFormat;
import com.aspose.imaging.imageoptions.TiffOptions;

import java.io.FileInputStream;
import java.io.IOException;


public class CMYKPSDToCMYKTiff
{
    //ExStart:CMYKPSDToCMYKTiff

    public static void main(String... args) throws IOException

    {
        String dataDir = Utils.getSharedDataDir() + "ModifyingImages/";

        //With IccProfile
        CMYKPSDToCMYKTiff.psdToTiffCmyk(dataDir, true);

        //Without IccProfile
        CMYKPSDToCMYKTiff.psdToTiffCmyk(dataDir, false);
    }

    private static void psdToTiffCmyk(String folder, boolean isIccProfile) throws IOException
    {
        String fileName = String.format("cmyk_%b.tiff", isIccProfile);
        String inputFile = folder + "cmyk.psd";
        String inputIccFile = folder + "JapanWebCoated.icc";
        String outputFile = folder + fileName;
        Image image = Image.load(inputFile);
        try
        {
            if (isIccProfile)
            {
                FileInputStream f = new FileInputStream(inputIccFile);
                final byte[] icc = new byte[f.available()];
                f.read(icc);
                f.close();
                image.save(outputFile, new TiffOptions(TiffExpectedFormat.TiffLzwCmyk)
                {
                    {
                        setIccProfile(icc);
                    }

                    public void setIccProfile(byte[] icc)
                    {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                });
            }
            else
            {
                image.save(outputFile, new TiffOptions(TiffExpectedFormat.TiffLzwCmyk));
            }
        }
        finally
        {
            image.dispose();
        }
    }
    //ExEnd:CMYKPSDToCMYKTiff
}
