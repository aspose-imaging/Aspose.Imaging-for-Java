package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.cad.imageoptions.PngOptions;
import com.aspose.imaging.Image;
import static com.aspose.imaging.KnownColor.LightGreen;
import static com.aspose.imaging.KnownColor.Orange;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.png.PngColorType;
import com.aspose.imaging.fileformats.psd.PsdImage;
import static com.aspose.imaging.fileformats.psd.layers.BlendMode.Color;
import com.aspose.imaging.fileformats.psd.layers.Layer;


public class ColorReplacement {
	public static void main(String... args) throws Exception {

		//ExStart:ColorReplacement
                	String dataDir = Utils.getSharedDataDir(ColorReplacement.class) + "ModifyingImages/";
		
              String fileName = "photooverlay_5_new";
              PngOptions pngOptions = new PngOptions() {{ setColorType(PngColorType.TruecolorWithAlpha); }};
              PsdImage input = (PsdImage)Image.load(fileName + ".psd");
           try
{
	         for (Layer layer : input.getLayers())
	{
		if (layer.getName().equals("Maincolor"))
		{
			layer.replaceNonTransparentColors(Orange);
                          //      replaceNonTransparentColors(Color.getOrange());
			input.save(fileName + "_nonTransparentColors_result.png");
			input.save(fileName + "_nonTransparentColors_result.psd");
			break;
		}
	}
}
finally
{
	input.dispose();
}

input = (PsdImage)Image.load(fileName + ".psd");
try
{
	for (Layer layer : input.getLayers())
	{
		if (layer.getName().equals("Maincolor"))
		{
			layer.replaceColor(LightGreen,(byte)40,Orange);
                               
			input.save(fileName + "_specificColor_result.png");
			input.save(fileName + "_specificColor_result.psd");
			break;
		}
	}
}
finally
{
	input.dispose();
            //ExEnd:ColorReplacement
}
  }
  }

	
        