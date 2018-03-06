package com.aspose.imaging.examples.images;

import com.aspose.imaging.*;
import com.aspose.imaging.brushes.*;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.examples.export.ExportDxfToPdf;
import com.aspose.imaging.imageoptions.GifOptions;

public class ImplementationOfLossyGIFCompressor
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir(ImplementationOfLossyGIFCompressor.class) + "images/";
        //ExStart:ImplementationOfLossyGIFCompressor
        
        // Sets the maximum allowed pixel difference. If greater than zero, lossy compression will be used.
       //  Recommended value for optimal lossy compression is 80. 30 is very light compression, 200 is heavy.
           GifOptions gifExport = new GifOptions();
           gifExport.setMaxDiff(80);
                 
         	Image image = Image.load(dataDir + "aspose-logo.gif");
        {
           image.save("anim_lossy-80.gif", gifExport);
        }
    
      //ExEnd:ImplementationOfLossyGIFCompressor
       }
       }




