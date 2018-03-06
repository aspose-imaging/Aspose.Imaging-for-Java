package com.aspose.imaging.examples.images;

import com.aspose.imaging.*;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.psd.PsdImage;

public class ForceFontCache
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir(ForceFontCache.class) + "images/";
         //ExStart:ForceFontCache
         PsdImage image = (PsdImage)Image.load(dataDir+"input.psd");
          try
        {
	image.save("NoFont.psd");
         }
       finally
       {
	image.dispose();
        }

         System.out.println("You have 2 minutes to install the font");
          Thread.sleep(2 * 60 * 1000);
           OpenTypeFontsCache.updateCache();

           image = (PsdImage)Image.load("input.psd");
       try
        {
        	image.save("HasFont.psd");
         }
            finally
         {
	image.dispose();
        }
      //ExEnd:ForceFontCache
       }
      }




