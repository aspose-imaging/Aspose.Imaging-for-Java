package com.aspose.imaging.examples.ModifyingImages.psd;

import com.aspose.imaging.Color;
import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.psd.PsdImage;
import com.aspose.imaging.fileformats.psd.layers.Layer;
import com.aspose.imaging.fileformats.psd.layers.filllayers.FillLayer;
import com.aspose.imaging.fileformats.psd.layers.fillsettings.*;
import com.aspose.imaging.imageoptions.PsdOptions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SupportOfGradientFillLayer
{
    public static void main(String... args)
    {
        //ExStart:SupportOfGradientFillLayer
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "psd/";
        String sourceFileName = dataDir + "ComplexGradientFillLayer.psd";
        String outputFile = Utils.getOutDir() + "ComplexGradientFillLayer_output.psd";

        try(PsdImage im = (PsdImage) Image.load(sourceFileName))
        {
            for (Layer layer : im.getLayers())
            {
                if (layer instanceof FillLayer)
                {
                    FillLayer fillLayer = (com.aspose.imaging.fileformats.psd.layers.filllayers.FillLayer)layer;

                    if (fillLayer.getFillSettings().getFillType() != FillType.Gradient)
                    {
                        throw new RuntimeException("Wrong Fill Layer");
                    }

                    GradientFillSettings settings = (GradientFillSettings)fillLayer.getFillSettings();

                    if (
//                            Math.abs(settings.getAngle() - 45) > 0.25 ||
//                                    settings.getDither() ||
//                                    !settings.getAlignWithLayer() ||
//                                    !settings.getReverse() ||
//                                    Math.abs(settings.getVerticalOffset() - (-39)) > 0.25 ||
//                                    Math.abs(settings.getVerticalOffset() - (-5)) > 0.25 ||
                                    settings.getTransparencyPoints().length != 3 ||
                                    settings.getColorPoints().length != 2 ||
                                    Math.abs(100.0 - settings.getTransparencyPoints()[0].getOpacity()) > 0.25 ||
//                                    settings.getTransparencyPoints()[0].getLocation() != 0 ||
//                                    settings.getTransparencyPoints()[0].getMedianPointLocation() != 50 ||
                                    !settings.getColorPoints()[0].getColor().equals(Color.fromArgb(203, 64, 140))
//                                    settings.getColorPoints()[0].getLocation() != 0 ||
//                                    settings.getColorPoints()[0].getMedianPointLocation() != 50
                        )
                    {
                        throw new RuntimeException("Gradient Fill was not read correctly");
                    }

                    settings.setAngle(0.0);
                    settings.setDither(false);
                    settings.setAlignWithLayer(true);
                    settings.setReverse(true);
                    settings.setHorizontalOffset(25);
                    settings.setVerticalOffset(-15);

                    List<IGradientColorPoint> colorPoints = new ArrayList<>();
                    Collections.addAll(colorPoints, settings.getColorPoints());
                    List<IGradientTransparencyPoint> transparencyPoints = new ArrayList<>();
                    Collections.addAll(transparencyPoints, settings.getTransparencyPoints());

                    colorPoints.add(new GradientColorPoint()
                    {{
                        setColor(Color.getViolet());
                        setLocation(4096);
                        setMedianPointLocation(75);
                    }});

                    colorPoints.get(1).setLocation(3000);

                    transparencyPoints.add(new GradientTransparencyPoint()
                    {{
                        setOpacity(80.0);
                        setLocation(4096);
                        setMedianPointLocation(25);
                    }});

                    transparencyPoints.get(2).setLocation(3000);

                    settings.setColorPoints(colorPoints.toArray(new IGradientColorPoint[0]));
                    settings.setTransparencyPoints(transparencyPoints.toArray(new IGradientTransparencyPoint[0]));
                    fillLayer.update();

                    im.save(outputFile, new PsdOptions(im));

                    break;
                }
            }
        }

        //ExEnd:SupportOfGradientFillLayer
    }
}
