package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.Size;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.EmfOptions;
import com.aspose.imaging.imageoptions.SvgRasterizationOptions;
import java.io.File;


public class SVGToEMFConversion {

    //ExStart:SVGToEMFConversion    
public static void main(String... args) throws Exception {


String dataDir = Utils.getSharedDataDir(SVGToEMFConversion.class) + "ConvertingImages/";

String[] testFiles = new String[]
{
    "input.svg",
    "juanmontoya_lingerie.svg",
    "rg1024_green_grapes.svg",
    "sample_car.svg",
    "tommek_Car.svg"
};
 
String basePath = dataDir+"IMAGINGJAVA-1085\\";
String outputPath = basePath + "output\\";
 
File dir = new File(outputPath);
if (!dir.exists())
{
    assert dir.mkdirs() : "Can not create output directory!";
}
 
for (String fileName : testFiles)
{
    String inputFileName = basePath + fileName;
    String outputFileName = outputPath + fileName + ".emf";
    final Image image = Image.load(inputFileName);
    try
    {
        image.save(outputFileName, new EmfOptions()
        {{
            setVectorRasterizationOptions(new SvgRasterizationOptions()
            {{
                setPageSize(Size.to_SizeF(image.getSize()));
            }});
        }});
    }
    finally
    {
        image.close();
    }
}

}
    //ExEnd:SVGToEMFConversion
}
