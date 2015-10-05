module Asposeimagingjava
  module DrawingLines
    def initialize()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Create an instance of BmpOptions and set its various properties
        create_options = Rjb::import('com.aspose.imaging.imageoptions.BmpOptions').new
        create_options.setBitsPerPixel(32)

        # Define the source property for the instance of BmpOptions
        create_options.setSource(Rjb::import('com.aspose.imaging.sources.StreamSource').new(Rjb::import('java.io.ByteArrayInputStream').new(Array.new)))

        # Create an instance of Image
        image = Rjb::import('com.aspose.imaging.Image').create(create_options,100,100)

        # Create an instance of Color
        color = Rjb::import('com.aspose.imaging.Color')

        # Create an instance of Pen
        pen = Rjb::import('com.aspose.imaging.Pen')

        # Create and initialize an instance of Graphics class
        graphic = Rjb::import('com.aspose.imaging.Graphics').new(image)

        # Clear the image surface with Yellow color
        graphic.clear(color.getYellow())

        # Draw a dotted line by specifying the Pen object having blue color and co-ordinate Points
        graphic.drawLine(pen.new(color.getBlue()), 9, 9, 90, 90)
        graphic.drawLine(pen.new(color.getBlue()), 9, 90, 90, 9)

        solid_brush = Rjb::import('com.aspose.imaging.brushes.SolidBrush')
        point = Rjb::import('com.aspose.imaging.Point')

        # Draw a continuous line by specifying the Pen object having Solid Brush with red color and two point structures
        graphic.drawLine(pen.new(solid_brush.new(color.getRed())), point.new(9, 9), point.new(9, 90))

        # Draw a continuous line by specifying the Pen object having Solid Brush with aqua color and two point structures
        graphic.drawLine(pen.new(solid_brush.new(color.getAqua())), point.new(9, 90), point.new(90, 90))

        # Draw a continuous line by specifying the Pen object having Solid Brush with black color and two point structures
        graphic.drawLine(pen.new(solid_brush.new(color.getBlack())), point.new(90,90), point.new(90,9))

        # Draw a continuous line by specifying the Pen object having Solid Brush with white color and two point structures
        graphic.drawLine(pen.new(solid_brush.new(color.getWhite())), point.new(90,9), point.new(9,9))

        # Save all changes.
        image.save(data_dir + "DrawLinesExample.bmp")

        puts "Lines have been drawn in image successfully!"
    end
  end
end
