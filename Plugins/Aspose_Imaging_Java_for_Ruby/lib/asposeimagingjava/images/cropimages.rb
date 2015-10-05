module Asposeimagingjava
  module CropImages
    def initialize()
        # Cropping by Shifts
        crop_by_shifts()

        # Cropping by Rectangle
        crop_by_rectangle()
    end

    def crop_by_shifts()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Load an existing image (of type bmp) in an instance of Image class
        image = Rjb::import('com.aspose.imaging.Image').load(data_dir + "test.jpg")

        # Before cropping, the image should be cached for better performance
        if !image.isCached()
            image.cacheData()
        end

        # Define shift values for all four sides
        left_shift = 10
        right_shift = 10
        top_shift = 10
        bottom_shift = 10

        # Based on the shift values, apply the cropping on image
        # Crop method will shift the image bounds toward the center of image
        image.crop(left_shift, right_shift, top_shift, bottom_shift)

        # Save the image to disk
        image.save(data_dir + "CropByShifts.jpg")

        # Display Status.
        puts "Cropped image by shifts successfully!"
    end

    def crop_by_rectangle()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Load an existing image (of type bmp) in an instance of Image class
        image = Rjb::import('com.aspose.imaging.Image').load(data_dir + "test.jpg")

        # Before cropping, the image should be cached for better performance
        if !image.isCached()
            image.cacheData()
        end

        # Create an instance of Rectangle class with desired size
        rectangle = Rjb::import('com.aspose.imaging.Rectangle').new(10, 10, 100, 100)

        # Perform the crop operation on object of Rectangle class
        image.crop(rectangle)

        # Save the image to disk
        image.save(data_dir + "crop_by_rectangle.jpg")

        # Display Status.
        puts "Cropped image by rectangle successfully!"
    end
  end
end
