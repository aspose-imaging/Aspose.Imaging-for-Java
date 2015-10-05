module Asposeimagingjava
  module DrawingEllipse
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

        solid_brush = Rjb::import('com.aspose.imaging.brushes.SolidBrush')
        rectangle = Rjb::import('com.aspose.imaging.Rectangle')

        # Draw a dotted ellipse shape by specifying the Pen object having red color and a surrounding Rectangle
        graphic.drawEllipse(pen.new(color.getRed()), rectangle.new(30, 10, 40, 80))

        # Draw a continuous ellipse shape by specifying the Pen object having solid brush with blue color and a surrounding Rectangle
        graphic.drawEllipse(pen.new(solid_brush.new(color.getBlue())), rectangle.new(10, 30, 80, 40))

        # Save all changes.
        image.save(data_dir + "DrawEllipseExample.bmp")

        puts "Ellipse have been drawn in image successfully!"
    end
  end
end
