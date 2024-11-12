package com.aspose.imaging.examples.CDR;

import com.aspose.imaging.FileFormat;
import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Assert;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;

/**
 *
 * @author mfazi
 */
public class SupportOfCDR {

    //ExStart:SupportOfCDR

    public static void main(String[] args)
    {
        Logger.startExample("SupportOfCDR");
        // The path to the documents directory.
        String baseFolder = Utils.getSharedDataDir() + "CDR/";
        String inputFileName = baseFolder + "test.cdr";
        
        long expectedFileFormat = FileFormat.Cdr;
        long realFileFormat = Image.getFileFormat(inputFileName);

        Assert.areEqual(expectedFileFormat, realFileFormat, "File format is incorrect!");
        Logger.endExample();
    }
    //ExEnd:SupportOfCDR
}
