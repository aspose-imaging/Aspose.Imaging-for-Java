package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.*;
import com.aspose.imaging.brushes.SolidBrush;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;

public class AddDiagonalWatermarkToImage
{
    public static void main(String... args)
    {
        Logger.startExample("AddDiagonalWatermarkToImage");

        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ModifyingImages/";

        // Load an existing JPG image
        try (Image image = Image.load(dataDir + "SampleTiff1.tiff"))
        {
            // Declare a String object with Watermark Text
            String theString = "45 Degree Rotated Text";

            // Create and initialize an instance of Graphics class and Initialize an object of SizeF to store image Size
            Graphics graphics = new Graphics(image);
            Size sz = graphics.getImage().getSize();

            // Creates an instance of Font, initialize it with Font Face, Size and Style
            Font font = new Font("Times New Roman", 20, FontStyle.Bold);

            // Create an instance of SolidBrush and set its various properties
            SolidBrush brush = new SolidBrush();
            brush.setColor(Color.getRed());
            brush.setOpacity(0);

            // Initialize an object of StringFormat class and set its various properties
            StringFormat format = new StringFormat();
            format.setAlignment(StringAlignment.Center);
            format.setFormatFlags(StringFormatFlags.MeasureTrailingSpaces);

            // Create an object of Matrix class for transformation
            Matrix matrix = new Matrix();

            // First a translation then a rotation
            matrix.translate(sz.getWidth() / 2f, sz.getHeight() / 2f);
            matrix.rotate(-45.0f);

            // Set the Transformation through Matrix
            graphics.setTransform(matrix);

            // Draw the string on Image Save output to disk
            graphics.drawString(theString, font, brush, 0, 0, format);
            image.save(dataDir + "AddDiagonalWatermarkToImage_out.jpg");
        }

        Logger.endExample();
    }
}
