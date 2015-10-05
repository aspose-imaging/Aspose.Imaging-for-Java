module Asposeimagingjava
  module AdjustingColors
    def initialize()
        # Adjusting Brightness
        adjust_brightness()

        # Adjusting Contrast
        adjust_contrast()

        # Adjusting Contrast
        adjust_gamma()
    end

    def adjust_brightness()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Load an existing image
        image = Rjb::import('com.aspose.imaging.Image').load(data_dir + "test.jpg")

        # Check if image is cached
        if !image.isCached()
            # Cache image if not already cached
            image.cacheData()
        end

        # Adjust the brightness
        image.adjustBrightness(70)

        # Save the image to disk
        image.save(data_dir + "adjust_brightness.jpg")

        # Display Status.
        puts "Adjust image brightness successfully!"
    end

    def adjust_contrast()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Load an existing image
        image = Rjb::import('com.aspose.imaging.Image').load(data_dir + "test.jpg")

        # Check if image is cached
        if !image.isCached()
            # Cache image if not already cached
            image.cacheData()
        end

        # Adjust the contrast
        image.adjustContrast(10)

        # Save the image to disk
        image.save(data_dir + "adjust_contrast.jpg")

        # Display Status.
        puts "Adjust image contrast successfully!"
    end

    def adjust_gamma()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Load an existing image
        image = Rjb::import('com.aspose.imaging.Image').load(data_dir + "test.jpg")

        # Check if image is cached
        if !image.isCached()
            # Cache image if not already cached
            image.cacheData()
        end

        # Adjust the gamma
        image.adjustGamma(2.2, 2.2, 2.2)

        # Save the image to disk
        image.save(data_dir + "adjust_gamma.jpg")

        # Display Status.
        puts "Adjust image gamma successfully!"
    end
  end
end
