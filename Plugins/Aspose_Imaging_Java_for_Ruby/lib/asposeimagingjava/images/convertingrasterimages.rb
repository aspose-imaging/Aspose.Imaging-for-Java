module Asposeimagingjava
  module ConvertingRasterImages
    def initialize()
        # Binarization with Fixed Threshold
        binarization_with_fixed_threshold()

        # Binarization with Otsu Threshold
        binarization_with_otsu_threshold()

        # Transform image to its grayscale representation
        transform_image_to_grayscale()
    end

    def binarization_with_fixed_threshold()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Load an existing image
        image = Rjb::import('com.aspose.imaging.Image').load(data_dir + "test.jpg")

        # Check if image is cached
        if !image.isCached()
            # Cache image if not already cached
            image.cacheData()
        end

        # Binarize image with predefined fixed threshold
        image.binarizeFixed(100)

        # Save the image to disk
        image.save(data_dir + "binarization_with_fixed_threshold.jpg")

        # Display Status.
        puts "Binarization image with Fixed Threshold successfully!"
    end

    def binarization_with_otsu_threshold()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Load an existing image
        image = Rjb::import('com.aspose.imaging.Image').load(data_dir + "test.jpg")

        # Check if image is cached
        if !image.isCached()
            # Cache image if not already cached
            image.cacheData()
        end

        # Binarize image with Otsu Thresholding
        image.binarizeOtsu()

        # Save the image to disk
        image.save(data_dir + "binarization_with_otsu_threshold.jpg")

        # Display Status.
        puts "Binarization image with Otsu Threshold successfully!"
    end

    def transform_image_to_grayscale()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Load an existing image
        image = Rjb::import('com.aspose.imaging.Image').load(data_dir + "test.jpg")

        # Check if image is cached
        if !image.isCached()
            # Cache image if not already cached
            image.cacheData()
        end

        # Transform image to its grayscale representation
        image.grayscale()

        # Save the image to disk
        image.save(data_dir + "transform_image_to_grayscale.jpg")

        # Display Status.
        puts "Transform image to its grayscale representation successfully!"
    end
  end
end
