module Asposeimagingjava
  module DrawingImagesUsingCoreFunctionality
    def initialize()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Create an instance of BmpOptions and set its various properties
        create_options = Rjb::import('com.aspose.imaging.imageoptions.BmpOptions').new
        create_options.setBitsPerPixel(24)

        # Create an instance of FileCreateSource and assign it to Source property
        create_options.setSource(Rjb::import('com.aspose.imaging.sources.FileCreateSource').new(data_dir + "DrawingImage.bmp",false))

        # Create an instance of RasterImage
        raster_image = Rjb::import('com.aspose.imaging.Image').create(create_options,500,500)

        # Get the pixels of the image by specifying the area as image boundary
        pixels = raster_image.loadPixels(raster_image.getBounds())

        index = 0
        while index < pixels.length
            # Set the indexed pixel color to yellow
            pixels[index] =  Rjb::import('com.aspose.imaging.Color').getYellow()
            index +=1
        end
        raster_image.savePixels(raster_image.getBounds(), pixels)

        # save all changes
        raster_image.save()

        puts "Draw Images Using Core Functionality."
    end
  end
end
