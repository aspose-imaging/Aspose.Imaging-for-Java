module Asposeimagingjava
  module AutoCorrectOrientationOfJpegImage
    def initialize()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Load an existing image in an instance of Image class
        image = Rjb::import('com.aspose.imaging.Image').load(data_dir + "test.jpg")

        # Perform the automatic rotation on the image depending on the orientation data stored in the EXIF
        image.autoRotate()

        # Save the image
        image.save(data_dir + "AutoCorrectOrientation.jpg")

        # Display Status.
        puts "Auto Correct orientation of JPEG image successfully!"
    end
  end
end
