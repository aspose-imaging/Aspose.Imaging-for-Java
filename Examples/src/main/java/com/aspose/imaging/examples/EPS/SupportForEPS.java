
package com.aspose.imaging.examples.EPS;
import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.eps.EpsBinaryImage;
import com.aspose.imaging.fileformats.eps.EpsImage;
import com.aspose.imaging.fileformats.eps.EpsInterchangeImage;
import com.aspose.imaging.fileformats.eps.consts.EpsType;
import com.aspose.imaging.imageoptions.PngOptions;

public class SupportForEPS {
    
 public static void main(String... args) throws Exception    
 {

     //ExStart:SupportForEPS
     
String dataDir = Utils.getSharedDataDir(SupportForEPS.class) + "EPS/"; 
EpsImage epsImage = (EpsImage)Image.load(dataDir+"anyEpsFile.eps");
try
{
	// check if EPS image has any raster preview to proceed (for now only raster preview is supported)
	if (epsImage.hasRasterPreview())
	{
		if (epsImage.getPhotoshopThumbnail() != null)
		{
			// process Photoshop thumbnail if it's present
		}

		if (epsImage.getEpsType() == EpsType.Interchange)
		{
			// Get EPS Interchange subformat instance
			EpsInterchangeImage epsInterchangeImage = (EpsInterchangeImage)epsImage;

			if (epsInterchangeImage.getRasterPreview() != null)
			{
				// process black-and-white Interchange raster preview if it's present
			}
		}
		else
		{
			// Get EPS Binary subformat instance
			EpsBinaryImage epsBinaryImage = (EpsBinaryImage)epsImage;

			if (epsBinaryImage.getTiffPreview() != null)
			{
				// process TIFF preview if it's present
			}

			if (epsBinaryImage.getWmfPreview() != null)
			{
				// process WMF preview if it's present
			}
		}

		// export EPS image to PNG (by default, best available quality preview is used for export)
		epsImage.save(dataDir+"anyEpsFile.png", new PngOptions());
	}
}
finally
{
	epsImage.close();
}
//ExEnd:SupportForEPS
}
}