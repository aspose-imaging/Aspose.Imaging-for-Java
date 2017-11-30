package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;

public class ColorReplacement {
	public static void main(String... args) throws Exception {

		//ExStart:ColorReplacement
		 using (PsdImage image = (PsdImage)Image.Load(path + "photooverlay_5_new_3.psd"))
              {

                PsdImage psdImage = image;
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
                psdImage.Save(path+"asposeImage02.png", new Aspose.Imaging.ImageOptions.PngOptions());
            }
            //ExEnd:ColorReplacement
        }
	}
        }
