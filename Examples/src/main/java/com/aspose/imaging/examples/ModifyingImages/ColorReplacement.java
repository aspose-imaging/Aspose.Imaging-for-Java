package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.cad.imageoptions.PngOptions;
import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.psd.PsdImage;

import com.aspose.imaging.imageoptions.PngOptions;

public class ColorReplacement {
	public static void main(String... args) throws Exception {

		//ExStart:ColorReplacement
                	String dataDir = Utils.getSharedDataDir(ColorReplacement.class) + "ModifyingImages/";
		// using(PsdImage image = (PsdImage)Image.Load(dataDir+ "photooverlay_5_new_3.psd"))
              
               {
                 PsdImage psdImage = image PsdImage();
                var pngOptions = new PngOptions();
                foreach (var layer in psdImage.Layers)
                {
                    if (layer.GetType() == typeof(Aspose.Imaging.FileFormats.Psd.Layers.TextLayer))
                    {
                        if (layer.Name == "dealerwebsite")
                        {
                            ((Aspose.Imaging.FileFormats.Psd.Layers.TextLayer)layer).UpdateText("My new Text!", Color.Red);
                        }
                    }
                    else if (layer.Name == "Maincolor")
                    {
                        //layer.BackgroundColor = Color.Yellow;
                        //TODO: Change color of this layer  
                        int dd = 0;
                        layer.HasBackgroundColor = true;
                        layer.BackgroundColor = Color.Orange;


                       // layer.BackgroundColor = Color.Yellow;
                    }

                }
                psdImage.Save(dataDir+"asposeImage02.png", new com.aspose.Imaging.ImageOptions.PngOptions();
            }
            //ExEnd:ColorReplacement
        }
	}
        