package com.aspose.imaging.examples.metafile;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.Color;
import com.aspose.imaging.Image;
import com.aspose.imaging.SizeF;
import com.aspose.imaging.fileformats.svg.FontStoreType;
import com.aspose.imaging.fileformats.svg.FontStoringArgs;
import com.aspose.imaging.fileformats.svg.SvgResourceKeeperCallback;
import com.aspose.imaging.imageloadoptions.MetafileLoadOptions;
import com.aspose.imaging.imageoptions.EmfRasterizationOptions;
import com.aspose.imaging.imageoptions.PdfOptions;
import com.aspose.imaging.imageoptions.SvgOptions;
import com.aspose.imaging.imageoptions.SvgRasterizationOptions;
import com.aspose.imaging.system.io.FileMode;
import com.aspose.imaging.system.io.FileStream;
import java.io.File;

 class SvgFontTester
{
    //ExStart:SvgFontTester
    private static final String FontFolderName = "fonts";
    private static final String OutFolderName = "Out\\";
    private static final String SourceFolder = "C:\\Temp\\Errors\\6\\";
    private static String OutFolder = SourceFolder + OutFolderName;
    private static String FontFolder = OutFolder + "\\" + FontFolderName;
    public void readFileWithEmbeddedFontsAndExportToPdf()
    {
        this.readAndExportToPdf("EmbeddedFonts.svg");
    }

    public void readFileWithExportedFontsAndExportToPdf()
    {
        this.readAndExportToPdf("ExportedFonts.svg");
    }

    public void saveWithEmbeddedFonts()
    {
        String[] files = new String[]
                {
                        "exportedFonts.svg", // File with exported fonts
                        "embeddedFonts.svg", // File with embedded fonts
                        "mysvg.svg" // simple file
                };

        for (int i = 0; i < files.length; i++)
        {
            this.save(true, files[i], 0);
        }
    }

    public void saveWithExportFonts()
    {
        String[] files = new String[]
                {
                        "exportedFonts.svg", // File with exported fonts
                        "embeddedFonts.svg", // File with embedded fonts
                        "mysvg.svg" // simple file
                };

        int[] expectedFontsCount = new int[] {
                                    4, 4, 1
                                } ;

        for (int i = 0; i < files.length; i++)
        {
            this.save(false, files[i], expectedFontsCount[i]);
        }
    }

    private void readAndExportToPdf(String inputFileName)
    {
        File f = new File(OutFolder);
        if (!f.exists())
        {
            f.mkdir();
        }

        String inputFile = SourceFolder + inputFileName;
        String outFile = OutFolder  + "\\" +  inputFileName + ".pdf";
        final Image image = Image.load(inputFile);
        try
        {
            image.save(outFile,
                    new PdfOptions()
                    {{
                        setVectorRasterizationOptions(new SvgRasterizationOptions()
                        {{
                            setPageSize(new SizeF(image.getWidth(), image.getHeight()));
                        }});
                    }});
        }
        finally
        {
            image.dispose();
        }
    }

    private void save(final boolean useEmbedded, String fileName, int expectedCountFonts)
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
        final String fontFolder;
        try
        {
            final EmfRasterizationOptions emfRasterizationOptions = new EmfRasterizationOptions();
            emfRasterizationOptions.setBackgroundColor(Color.getWhite());
            emfRasterizationOptions.setPageWidth(image.getWidth());
            emfRasterizationOptions.setPageHeight(image.getHeight());
            final String testingFileName = inputFile.substring(inputFile.lastIndexOf("\\")+1, inputFile.length() - 4);
            fontFolder = FontFolder  + "\\" +  testingFileName;
            image.save(outputFile,
                    new SvgOptions()
                    {{
                        setVectorRasterizationOptions(emfRasterizationOptions);
                        setCallback(
                                new SvgCallbackFontTest(useEmbedded, fontFolder)
                                {{
                                    setLink(FontFolderName +"/"+testingFileName);
                                }});
                    }});
        }
        finally
        {
            image.dispose();
        }

        if (!useEmbedded)
        {
            f = new File(fontFolder);
            String[] files = f.list();
            if (files.length != expectedCountFonts)
            {
                throw new RuntimeException(String.format(
                        "Expected count font files = %d, Current count font files = %d", expectedCountFonts,
                        files.length));
            }
        }
    }
}

class SvgCallbackFontTest extends SvgResourceKeeperCallback
{
    /**
     * The out folder
     */
    private final String outFolder;
    
    /**
     * The use embedded font
     */
    private final boolean useEmbeddedFont;
    
    /**
     * The font counter
     */
    private int fontCounter = 0;

    /**
     * Initializes a new instance of the {@see SvgTests.svgCallbackFontTest} class.
     * @param useEbeddedFont if set to true [use ebedded font].
     * @param outFolder The out folder.
     */
    public SvgCallbackFontTest(boolean useEbeddedFont, String outFolder)
    {
        this.useEmbeddedFont = useEbeddedFont;
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

    /**
     * Called when font resource ready to be saved to storage.
     * @param args The arguments.
     */
   
    public void onFontResourceReady(FontStoringArgs args)
    {
        if (this.useEmbeddedFont)
        {
            args.setFontStoreType(FontStoreType.Embedded);
        }
        else
        {
            args.setFontStoreType(FontStoreType.Stream);
            String fontFolder = this.outFolder;
            File f = new File(fontFolder);
            if (!f.exists())
            {
                f.mkdirs();
            }

            String fName = args.getSourceFontFileName();
            f = new File(fName);
            if (!f.exists())
            {
                fName = String.format("font_%d.ttf", this.fontCounter++);
                f = new File(fName);
            }

            String name = f.getName();
            name = name.substring(name.indexOf('\\')+1);
            String fileName = fontFolder + "\\" + name;

            args.setDestFontStream(new FileStream(fileName, FileMode.OpenOrCreate));
            args.setDisposeStream(true);
            args.setFontFileUri("./" + this.getLink() + "/" + name);
        }
    }
}
 //ExEnd:SvgFontTester