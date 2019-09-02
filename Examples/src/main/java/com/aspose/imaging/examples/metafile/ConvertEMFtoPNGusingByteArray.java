package com.aspose.imaging.examples.metafile;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.emf.EmfImage;
import com.aspose.imaging.imageoptions.PngOptions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConvertEMFtoPNGusingByteArray
{
    public static void main(String... args) throws Exception
    {
		//ExStart:ConvertEMFtoPNGusingByteArray

        String dataDir = Utils.getSharedDataDir() + "metafile/";
        // Read all bytes from an EMF file
        byte[] bytes = Files.readAllBytes(Paths.get(dataDir + "picture1.emf"));

        // Load array of bytes into an instance of ByteArrayInputStream
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);

        // Use the instance of ByteArrayInputStream to load the image into an
        // instance of EmfImage
        EmfImage metafile = (EmfImage) Image.load(inputStream);

		try
		{
			// Create an instance of ByteArrayOutputStream to store the results
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

			// Save the EMF to ByteArrayOutputStream in PNG format
			// by passing an instance of PngOptions class as second parameter to
			// save method
			metafile.save(outputStream, new PngOptions());

			// Convert the data in ByteArrayOutputStream to an array of bytes
			byte[] outputBytes = outputStream.toByteArray();
		}
		finally
		{
			metafile.close();
		}

		//ExEnd:ConvertEMFtoPNGusingByteArray
    }
}
