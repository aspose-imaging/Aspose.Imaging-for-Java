package com.aspose.imaging.examples.metafile;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.Color;
import com.aspose.imaging.Image;
import com.aspose.imaging.fileformats.svg.SvgResourceKeeperCallback;
import com.aspose.imaging.imageloadoptions.MetafileLoadOptions;
import com.aspose.imaging.imageoptions.EmfRasterizationOptions;
import com.aspose.imaging.imageoptions.SvgOptions;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


class MetaFilesAsSVG

{
      //ExStart:MetaFilesAsSVG
    private static final String ImageFolderName = "Images";
    private static final String OutFolderName = "Out\\";
    private static final String SourceFolder = "C:\\Temp\\Errors\\7\\";
    private static String OutFolder = SourceFolder + OutFolderName;
    private static String ImageFolder = OutFolder + "\\" + ImageFolderName;

    public void saveWithEmbeddedImages()
    {
        String[] files = new String[]
                {
                        "auto.svg"
                };

        for (int i = 0; i < files.length; i++)
        {
            this.save(true, files[i], null);
        }
    }

    public void saveWithExportImages()
    {
        String[] files = new String[]
                {
                        "auto.svg"
                };

        String[][] expectedImages = new String[][]
        {
            new String[]
            {
                "svg_img1.png",  "svg_img10.png", "svg_img11.png","svg_img12.png",
                "svg_img13.png", "svg_img14.png", "svg_img15.png", "svg_img16.png",
                "svg_img2.png", "svg_img3.png", "svg_img4.png", "svg_img5.png",
                "svg_img6.png","svg_img7.png", "svg_img8.png", "svg_img9.png"
            },
        };

        for (int i = 0; i < files.length; i++)
        {
            this.save(false, files[i], expectedImages[i]);
        }
    }

    private void save(final boolean useEmbedded, String fileName, String[] expectedImages)
    {
        File f = new File(OutFolder);
        if (!f.exists())
        {
            f.mkdir();
        }
        String fontStoreType = useEmbedded ? "Embedded" : "Stream";
        String inputFile = SourceFolder + fileName;
        String outFileName = fileName + "_" + fontStoreType + ".svg";
        String outputFile = OutFolder  + "\\" +  outFileName;
        Image image = Image.load(inputFile);
        final String imageFolder;
        try
        {
            final EmfRasterizationOptions emfRasterizationOptions = new EmfRasterizationOptions();
            emfRasterizationOptions.setBackgroundColor(Color.getWhite());
            emfRasterizationOptions.setPageWidth(image.getWidth());
            emfRasterizationOptions.setPageHeight(image.getHeight());
            final String testingFileName = inputFile.substring(inputFile.lastIndexOf("\\")+1, inputFile.length() - 4);
            imageFolder = ImageFolder + "\\" +  testingFileName;
            image.save(outputFile,
                    new SvgOptions()
                    {{
                        setVectorRasterizationOptions(emfRasterizationOptions);
                        setCallback(
                                new SvgCallbackImageTest(useEmbedded, imageFolder)
                                {{
                                    setLink(ImageFolderName +"/"+testingFileName);
                                }});
                    }});
        }
        finally
        {
            image.dispose();
        }

        if (!useEmbedded)
        {
            f = new File(imageFolder);
            String[] files = f.list();
            if (files.length != expectedImages.length)
            {
                throw new RuntimeException(String.format(
                        "Expected count image files = %d, Current count image files = %d", expectedImages.length,
                        files.length));
            }

            for (int i = 0; i < files.length; i++)
            {
                String file = files[i];
                if (file == null || file.isEmpty())
                {
                    throw new TestException(String.format("Expected file name: %s, current is empty", expectedImages[i]));
                }

                if (!file.equalsIgnoreCase(expectedImages[i]))
                {
                    throw new TestException(String.format("Expected file name: '%s', current: '%s'", expectedImages[i], file));
                }
            }
        }
    }
}


class SvgCallbackImageTest extends SvgResourceKeeperCallback
{
    /**
     * The out folder
     */
    private final String outFolder;

    /**
     * The use embedded font
     */
    private final boolean useEmbeddedImage;

    /**
     * The font counter
     */
    private int fontCounter = 0;

   
    public SvgCallbackImageTest(boolean useEmbeddedImage, String outFolder)
    {
        this.useEmbeddedImage = useEmbeddedImage;
        this.outFolder = outFolder;
        File f = new File(outFolder);
        if (f.exists())
        {
            File[] list = f.listFiles();
            for (File it : list)
                it.delete();
            f.delete();
        }
    }

    private String link;

    public String getLink()
    {
        return link;
    }

    public void setLink(String link)
    {
        this.link = link;
    }


  
    public String onImageResourceReady(byte[] imageData, int imageType, String suggestedFileName, boolean[] useEmbeddedImage)
    {
        useEmbeddedImage[0] = this.useEmbeddedImage;

        if (this.useEmbeddedImage)
        {
            return suggestedFileName;
        }

        String imageFolder = this.outFolder;
        File f = new File(imageFolder);
        if (!f.exists())
        {
            f.mkdirs();
        }

        String name = suggestedFileName;
        name = name.substring(name.indexOf('\\')+1);
        String fileName = imageFolder + "\\" + name;

        try
        {
            FileOutputStream fs = new FileOutputStream(fileName);
            try
            {
                fs.write(imageData);
            }
            finally
            {
                fs.close();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return "./" + this.getLink() + "/" + suggestedFileName;
    }
}
 //ExEnd:MetaFilesAsSVG