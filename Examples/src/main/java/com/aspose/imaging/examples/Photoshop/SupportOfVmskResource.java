/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.imaging.examples.Photoshop;

import com.aspose.imaging.Image;
import com.aspose.imaging.Point;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.psd.PsdImage;
import com.aspose.imaging.fileformats.psd.layers.Layer;
import com.aspose.imaging.fileformats.psd.layers.LayerResource;
import com.aspose.imaging.fileformats.psd.layers.layerresources.VmskResource;
import com.aspose.imaging.fileformats.psd.layers.layerresources.vectorpaths.BezierKnotRecord;
import com.aspose.imaging.fileformats.psd.layers.layerresources.vectorpaths.InitialFillRuleRecord;
import com.aspose.imaging.fileformats.psd.layers.layerresources.vectorpaths.LengthRecord;
import com.aspose.imaging.fileformats.psd.layers.layerresources.vectorpaths.PathFillRuleRecord;
import com.aspose.imaging.fileformats.psd.layers.layerresources.vectorpaths.VectorPathType;
import static com.aspose.imaging.fileformats.psd.layers.layerresources.vectorpaths.VectorPathType.PathFillRuleRecord;

/**
 *
 * @author mfazi
 */
public class SupportOfVmskResource {
    
     public static void main(String[] args)  {
         
         //ExStart:SupportOfVmskResource
     
        String dataDir = Utils.getSharedDataDir(SupportOfVmskResource.class) + "Photoshop/";
        
        String sourceFileName = dataDir+ "Rectangle.psd";
    String exportPath = dataDir + "Rectangle_changed.psd";
 
    PsdImage im = (PsdImage)Image.load(sourceFileName);
 
    try
    {
        VmskResource resource = getVmskResource(im);
 
        // Reading
        if (resource.isDisabled() != false ||
                resource.isInverted() != false ||
                resource.isNotLinked() != false ||
                resource.getPaths().length != 7 ||
                resource.getPaths()[0].getType() != VectorPathType.PathFillRuleRecord ||
                resource.getPaths()[1].getType() != VectorPathType.InitialFillRuleRecord ||
                resource.getPaths()[2].getType() != VectorPathType.ClosedSubpathLengthRecord ||
                resource.getPaths()[3].getType() != VectorPathType.ClosedSubpathBezierKnotUnlinked ||
                resource.getPaths()[4].getType() != VectorPathType.ClosedSubpathBezierKnotUnlinked ||
                resource.getPaths()[5].getType() != VectorPathType.ClosedSubpathBezierKnotUnlinked ||
                resource.getPaths()[6].getType() != VectorPathType.ClosedSubpathBezierKnotUnlinked)
        {
            throw new RuntimeException("VmskResource was read wrong");
        }
 
        PathFillRuleRecord pathFillRule = (PathFillRuleRecord) resource.getPaths()[0];
        InitialFillRuleRecord initialFillRule = (InitialFillRuleRecord) resource.getPaths()[1];
        LengthRecord subpathLength = (LengthRecord) resource.getPaths()[2];
 
        // Path fill rule doesn't contain any additional information
        if (pathFillRule.getType() != VectorPathType.PathFillRuleRecord ||
                initialFillRule.getType() != VectorPathType.InitialFillRuleRecord ||
                initialFillRule.isFillStartsWithAllPixels() != false ||
                subpathLength.getType() != VectorPathType.ClosedSubpathLengthRecord ||
                subpathLength.isClosed() != true ||
                subpathLength.isOpen() != false)
        {
            throw new RuntimeException("VmskResource paths were read wrong");
        }
 
        // Editing
        resource.setDisabled(true);
        resource.setInverted(true);
        resource.setNotLinked(true);
 
        BezierKnotRecord bezierKnot = (BezierKnotRecord) resource.getPaths()[3];
        bezierKnot.getPoints()[0] = new Point(0, 0);
 
        bezierKnot = (BezierKnotRecord) resource.getPaths()[4];
        bezierKnot.getPoints()[0] = new Point(8039797, 10905190);
 
        initialFillRule.setFillStartsWithAllPixels(true);
        subpathLength.setClosed(false);
        im.save(exportPath);
    }
    finally
    {
        im.close();
    }
         //ExEnd:SupportOfVmskResource
     }
     
     //ExStart:VmskResource
     static VmskResource getVmskResource(PsdImage image)
{
    Layer layer = image.getLayers()[1];
 
    VmskResource resource = null;
    LayerResource[] resources = layer.getResources();
    for (int i = 0; i < resources.length; i++)
    {
        if (resources[i] instanceof VmskResource)
        {
            resource = (VmskResource) resources[i];
            break;
        }
    }
 
    if (resource == null)
    {
        throw new RuntimeException("VmskResource not found");
    }
 
    return resource;
}
     //ExEnd:VmskResource
}
