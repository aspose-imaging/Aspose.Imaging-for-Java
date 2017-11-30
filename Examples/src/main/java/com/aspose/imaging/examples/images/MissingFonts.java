package com.aspose.imaging.examples.images;

import com.aspose.imaging.*;
import com.aspose.imaging.examples.Utils;

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




