package com.aspose.imaging.examples.images;

import com.aspose.imaging.*;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.png.PngColorType;
import com.aspose.imaging.fileformats.psd.PsdImage;
import com.aspose.imaging.imageloadoptions.PsdLoadOptions;
import com.aspose.imaging.imageoptions.PngOptions;

public class MissingFonts
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir(MissingFonts.class) + "images/";
         //ExStart:MissingFonts
        String fileName = "testReplacementNotAvailableFonts.psd";
        PsdImage image = (PsdImage)Image.load(fileName, new PsdLoadOptions(){{ setDefaultReplacementFont ("Arial"); }});
     try
       {
	image.save("result.png", new PngOptions() {{ setColorType(PngColorType.TruecolorWithAlpha); }});
        }
         finally
       {
	image.dispose();
       }
      //ExEnd:MissingFonts
      
       }
      }




