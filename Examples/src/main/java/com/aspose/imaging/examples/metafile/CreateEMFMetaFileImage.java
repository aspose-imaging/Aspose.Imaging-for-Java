package com.aspose.imaging.examples.metafile;

import com.aspose.imaging.Color;
import com.aspose.imaging.HatchStyle;
import com.aspose.imaging.LineCap;
import com.aspose.imaging.LineJoin;
import com.aspose.imaging.Pen;
import com.aspose.imaging.Point;
import com.aspose.imaging.Rectangle;
import com.aspose.imaging.Size;
import com.aspose.imaging.brushes.HatchBrush;
import com.aspose.imaging.brushes.SolidBrush;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.emf.EmfImage;
import com.aspose.imaging.fileformats.emf.graphics.EmfRecorderGraphics2D;
import com.aspose.imaging.imageoptions.EmfRasterizationOptions;
import com.aspose.imaging.imageoptions.PdfOptions;

public class CreateEMFMetaFileImage {
	public static void main(String... args) throws Exception {
		String dataDir = Utils.getSharedDataDir(CreateEMFMetaFileImage.class) + "metafile/";
		new CreateEMFMetaFileImage().penAndMixedArcTests();
	}
	public void penAndMixedArcTests()
	{
	// EmfRecorderGraphics2D class provides you the frame or canvas to draw shapes on it.
	// Create an instance of EmfRecorderGraphics2D class. The constructor takes in 3 parameters:
	// 1. Instance of Imaging Rectangle class
	// 2. Instance of Imaging Size class
	// 3. Instance of Imaging Size class
	EmfRecorderGraphics2D graphics = new EmfRecorderGraphics2D(new Rectangle(0, 0, 1000, 1000), new Size(1000, 1000)
	            , new Size(100, 100));
	        {
	        	String dataDir = Utils.getSharedDataDir(CreateEMFMetaFileImage.class) + "metafile/";
	            // Create an instance of Imaging Pen class and mention its color.
	            Pen pen = new Pen(Color.getBisque().Clone());

	            // Draw a line by calling DrawLine method and passing x,y coordinates of 1st point and same for 2nd point along with color info as Pen.
	            graphics.drawLine(pen, 1, 1, 50, 50);

	            // Reset the Pen color.
	            pen = new Pen(Color.getBlueViolet().Clone(), 3);

	            // specify the end style of the line.
	            pen.setEndCap(LineCap.Round);

	            // Draw a line by calling DrawLine method and passing x,y coordinates of 1st point and same for 2nd point along with color infor as Pen and end style of line.
	            graphics.drawLine(pen, 15, 5, 50, 60);

	            // specify the end style of the line.
	            pen.setEndCap(LineCap.Square);

	            // Draw a line by calling DrawLine method.
	            graphics.drawLine(pen, 5, 10, 50, 10);

	            // specify the end style of the line.
	            pen.setEndCap(LineCap.Flat);

	            // Draw a line by calling DrawLine method.
	            graphics.drawLine(pen, new Point(5, 20), new Point(50, 20));
	            
	            // Create an instance of HatchBrush class to define rectanglurar brush with with different settings.
	            HatchBrush hatchBrush = new com.aspose.imaging.brushes.HatchBrush();
	            hatchBrush.setBackgroundColor(Color.getAliceBlue().Clone());
	            hatchBrush.setForegroundColor(Color.getRed().Clone());
	            hatchBrush.setHatchStyle(HatchStyle.Cross);
	            pen = new Pen(hatchBrush, 7);
	            graphics.drawRectangle(pen, 50, 50, 20, 30);
	            graphics.setBackgroundMode(com.aspose.imaging.fileformats.emf.emf.consts.EmfBackgroundMode.OPAQUE);
	            graphics.drawLine(pen, 80, 50, 80, 80);
	            
	            // Draw a line by calling DrawLine method and passing parameters.
	            pen = new Pen(new SolidBrush(Color.getAqua().Clone()), 3);
	            pen.setLineJoin(LineJoin.MiterClipped);

	            // Draw a polygon by calling DrawPolygon method and passing parameters with line join setting/style.
	            graphics.drawPolygon(pen, new Point[] { new Point(10, 20), new Point(12, 45), new Point(22, 48), new Point(48
	                , 36), new Point(30, 55) });
	            pen.setLineJoin(LineJoin.Bevel);
	            graphics.drawRectangle(pen, 50, 10, 10, 5);
	            pen.setLineJoin(LineJoin.Round);
	            graphics.drawRectangle(pen, 65, 10, 10, 5);
	            pen.setLineJoin(LineJoin.Miter);
	            graphics.drawRectangle(pen, 80, 10, 10, 5);

	            
	            // Call EndRecording method to produce the final shape. EndRecording method will return the final shape as EmfImage.
	            // So create an instance of EmfImage class and initialize it with EmfImage returned by EndRecording method.           
	            final EmfImage image = graphics.endRecording();

	            try /*JAVA: was using*/
	            {
	                
	                test(image, dataDir + "Picture1.emf");
	            }
	            finally
	            {
	                if (image != null)
	                    (image).dispose();
	            }
	        }
	    }

	private void test(EmfImage image, String fileName)
	    {
	        // Create an instance of PdfOptions class.
	        PdfOptions options = new PdfOptions();

	        // Create an instance of EmfRasterizationOptions class and define different settings.
	        EmfRasterizationOptions rasterizationOptions = new EmfRasterizationOptions();
	        options.setVectorRasterizationOptions(rasterizationOptions);
	        rasterizationOptions.setPageSize(com.aspose.imaging.Size.to_SizeF(image.getSize()).Clone());

	        String outPath = fileName + "CreateEMFMetaFileImage_out.pdf";

		// Call the save method to convert the EMF metafile image to PDF.
	        image.save(outPath, options);
	    }
}
