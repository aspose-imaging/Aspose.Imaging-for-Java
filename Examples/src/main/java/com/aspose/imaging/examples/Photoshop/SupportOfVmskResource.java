package com.aspose.imaging.examples.Photoshop;

import com.aspose.imaging.Image;
import com.aspose.imaging.Point;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.psd.PsdImage;
import com.aspose.imaging.fileformats.psd.layers.Layer;
import com.aspose.imaging.fileformats.psd.layers.LayerResource;
import com.aspose.imaging.fileformats.psd.layers.layerresources.VmskResource;
import com.aspose.imaging.fileformats.psd.layers.layerresources.vectorpaths.*;

/**
 * @author mfazi
 */
public class SupportOfVmskResource
{

    public static void main(String[] args)
    {
        Logger.startExample("SupportOfVmskResource");

        String dataDir = Utils.getSharedDataDir() + "Photoshop/";

        String sourceFileName = dataDir + "Rectangle.psd";
        String exportPath = Utils.getOutDir() + "Rectangle_changed.psd";

        try (PsdImage im = (PsdImage) Image.load(sourceFileName))
        {
            VmskResource resource = getVmskResource(im);

            // Reading
            if (resource.isDisabled() ||
                    resource.isInverted() ||
                    resource.isNotLinked() ||
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
                    initialFillRule.isFillStartsWithAllPixels() ||
                    subpathLength.getType() != VectorPathType.ClosedSubpathLengthRecord ||
                    !subpathLength.isClosed() ||
                    subpathLength.isOpen())
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
        Logger.endExample();
    }

    private static VmskResource getVmskResource(PsdImage image)
    {
        Layer layer = image.getLayers()[1];

        VmskResource resource = null;
        LayerResource[] resources = layer.getResources();
        for (LayerResource layerResource : resources)
        {
            if (layerResource instanceof VmskResource)
            {
                resource = (VmskResource) layerResource;
                break;
            }
        }

        if (resource == null)
        {
            throw new RuntimeException("VmskResource not found");
        }

        return resource;
    }

}
