package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.Size;
import com.aspose.imaging.examples.Path;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.EmfOptions;
import com.aspose.imaging.imageoptions.SvgRasterizationOptions;

import java.io.File;


public class SVGToEMFConversion
{
    public static void main(String... args)
    {
        //ExStart:SVGToEMFConversion
        String dataDir = Utils.getSharedDataDir() + "ConvertingImages/";

        String[] testFiles = new String[]
                {
                        "input.svg",
                        "juanmontoya_lingerie.svg",
                        "rg1024_green_grapes.svg",
                        "sample_car.svg",
                        "tommek_Car.svg"
                };

        String outputPath = Path.combine(Utils.getOutDir(), "output/");

        File dir = new File(outputPath);
        assert dir.exists() || dir.mkdirs() : "Can not create output directory!";

        for (String fileName : testFiles)
        {
            String inputFileName = dataDir + fileName;
            String outputFileName = outputPath + fileName + ".emf";
            try (Image image = Image.load(inputFileName))
            {
                image.save(outputFileName, new EmfOptions()
                {{
                    setVectorRasterizationOptions(new SvgRasterizationOptions()
                    {{
                        setPageSize(Size.to_SizeF(image.getSize()));
                    }});
                }});
            }
        }
        //ExEnd:SVGToEMFConversion
    }
}
