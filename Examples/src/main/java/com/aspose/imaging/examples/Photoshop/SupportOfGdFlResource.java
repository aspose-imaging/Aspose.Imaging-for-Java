/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.imaging.examples.Photoshop;

import com.aspose.imaging.Color;
import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.psd.PsdImage;
import com.aspose.imaging.fileformats.psd.layers.Layer;
import com.aspose.imaging.fileformats.psd.layers.LayerResource;
import com.aspose.imaging.fileformats.psd.layers.filllayers.FillLayer;
import com.aspose.imaging.fileformats.psd.layers.fillsettings.GradientColorPoint;
import com.aspose.imaging.fileformats.psd.layers.fillsettings.GradientTransparencyPoint;
import com.aspose.imaging.fileformats.psd.layers.fillsettings.IGradientColorPoint;
import com.aspose.imaging.fileformats.psd.layers.fillsettings.IGradientTransparencyPoint;
import com.aspose.imaging.fileformats.psd.layers.layerresources.GdFlResource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author mfazi
 */
public class SupportOfGdFlResource {
    public static void main(String[] args)  {
         
         //ExStart:SupportOfGdFlResource
     
        String dataDir = Utils.getSharedDataDir(SupportOfGdFlResource.class) + "Photoshop/";
        
        
        String sourceFileName = dataDir + "ComplexGradientFillLayer.psd";
        String exportPath = dataDir + "ComplexGradientFillLayer_after.psd";
 
        PsdImage im = (PsdImage) Image.load(sourceFileName);
 
        try
        {
            for (Layer layer : im.getLayers())
            {
                if (layer instanceof FillLayer)
                {
                    FillLayer fillLayer = (FillLayer) layer;
 
                    for (LayerResource res : fillLayer.getResources())
                    {
                        if (res instanceof GdFlResource)
                        {
                            // Reading
                            GdFlResource resource = (GdFlResource) res;
 
                            if (resource.getAlignWithLayer() != false ||
                                    (Math.abs(resource.getAngle() - 45.0) > 0.001) ||
                                    resource.getDither() != true ||
                                    resource.getReverse() != false ||
                                    !resource.getColor().equals(Color.getEmpty()) ||
                                    Math.abs(resource.getHorizontalOffset() - (-39)) > 0.001 ||
                                    Math.abs(resource.getVerticalOffset() - (-5)) > 0.001 ||
                                    resource.getTransparencyPoints().length != 3 ||
                                    resource.getColorPoints().length != 2)
                            {
                                throw new RuntimeException("Resource Parameters were read wrong");
                            }
 
                            IGradientTransparencyPoint[] transparencyPoints = resource.getTransparencyPoints();
 
                            if (Math.abs(100.0 - transparencyPoints[0].getOpacity()) > 0.25 ||
                                    transparencyPoints[0].getLocation() != 0 ||
                                    transparencyPoints[0].getMedianPointLocation() != 50 ||
                                    Math.abs(50.0 - transparencyPoints[1].getOpacity()) > 0.25 ||
                                    transparencyPoints[1].getLocation() != 2048 ||
                                    transparencyPoints[1].getMedianPointLocation() != 50 ||
                                    Math.abs(100.0 - transparencyPoints[2].getOpacity()) > 0.25 ||
                                    transparencyPoints[2].getLocation() != 4096 ||
                                    transparencyPoints[2].getMedianPointLocation() != 50)
                            {
                                throw new RuntimeException("Gradient Transparency Points were read Wrong");
                            }
 
                            IGradientColorPoint[] colorPoints = resource.getColorPoints();
 
                            if (!colorPoints[0].getColor().equals(Color.fromArgb(203, 64, 140)) ||
                                    colorPoints[0].getLocation() != 0 ||
                                    colorPoints[0].getMedianPointLocation() != 50 ||
                                    !colorPoints[1].getColor().equals(Color.fromArgb(203, 0, 0)) ||
                                    colorPoints[1].getLocation() != 4096 ||
                                    colorPoints[1].getMedianPointLocation() != 50)
                            {
                                throw new RuntimeException("Gradient Color Points were read Wrong");
                            }
 
                            // Editing
                            resource.setAngle(30.0);
                            resource.setDither(false);
                            resource.setAlignWithLayer(true);
                            resource.setReverse(true);
                            resource.setHorizontalOffset(25);
                            resource.setVerticalOffset(-15);
 
                            List<IGradientColorPoint> newColorPoints = new ArrayList<IGradientColorPoint>();
                            Collections.addAll(newColorPoints, resource.getColorPoints());
                            List<IGradientTransparencyPoint> newTransparencyPoints = new ArrayList<IGradientTransparencyPoint>();
                            Collections.addAll(newTransparencyPoints, resource.getTransparencyPoints());
 
                            GradientColorPoint gr = new GradientColorPoint();
                            gr.setMedianPointLocation(75);
                            gr.setLocation(4096);
                            gr.setColor(Color.getViolet());
                            newColorPoints.add(gr);
 
                            colorPoints[1].setLocation(3000);
 
                            GradientTransparencyPoint gr2 = new GradientTransparencyPoint();
                            gr2.setOpacity(80.0);
                            gr2.setLocation(4096);
                            gr2.setMedianPointLocation(25);
 
                            newTransparencyPoints.add(gr2);
 
                            transparencyPoints[2].setLocation(3000);
 
                            resource.setColorPoints(newColorPoints.toArray(new IGradientColorPoint[0]));
                            resource.setTransparencyPoints(newTransparencyPoints.toArray(new IGradientTransparencyPoint[0]));
 
                            im.save(exportPath);
                        }
 
                        break;
                    }
 
                    break;
                }
            }
        }
        finally
        {
            im.close();
        }
    }
        //ExEnd:SupportOfGdFlResource
    }

