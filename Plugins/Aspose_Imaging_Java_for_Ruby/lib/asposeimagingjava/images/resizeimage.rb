module Asposeimagingjava
  module ResizeImage
    def initialize()
        # Simple Resizing
        simple_image_resizing()

        # Resizing with ResizeType Enumeration
        resizing_with_resizetype_enumeration()
    end

    def simple_image_resizing()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Load an existing image
        image = Rjb::import('com.aspose.imaging.Image').load(data_dir + "test.jpg")

        # Cache data if not cached previously
        if !image.isCached()
            image.cacheData()
        end

        # Specify only width
        new_width = image.getWidth() / 2
        image.resizeWidthProportionally(new_width)

        # Specify only height
        new_height = image.getHeight() / 2
        image.resizeHeightProportionally(new_height)

        # Save the image to disk
        image.save(data_dir + "simple_image_resizing.jpg")

        # Display Status.
        puts "Resized image successfully!"
    end

    def resizing_with_resizetype_enumeration()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Load an existing image
        image = Rjb::import('com.aspose.imaging.Image').load(data_dir + "test.jpg")

        # Cache data if not cached previously
        if !image.isCached()
            image.cacheData()
        end

        # Specify only width
        new_width = image.getWidth() / 2
        image.resizeWidthProportionally(new_width, Rjb::import('com.aspose.imaging.ResizeType').LanczosResample)

        # Specify only height
        new_height = image.getHeight() / 2
        image.resizeHeightProportionally(new_height, Rjb::import('com.aspose.imaging.ResizeType').NearestNeighbourResample)

        # Save the image to disk
        image.save(data_dir + "resizing_with_resizetype_enumeration.jpg")

        # Display Status.
        puts "Resized image successfully!"
    end
  end
end
