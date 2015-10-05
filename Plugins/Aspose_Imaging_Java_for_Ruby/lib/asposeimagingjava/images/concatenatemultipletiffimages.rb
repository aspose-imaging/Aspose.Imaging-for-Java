module Asposeimagingjava
  module ConcatenateMultipleTiffImages
    def initialize()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Create an instance of TiffImage and load the copied source image
        source = Rjb::import('com.aspose.imaging.Image').load(data_dir + "test.tiff")

        # Create an instance of TiffImage and load the source image
        destination = Rjb::import('com.aspose.imaging.Image').load(data_dir + "demo.tif")

        # Create an instance of TIffFrame and copy active frame of source image
        frame = Rjb::import('com.aspose.imaging.fileformats.tiff.TiffFrame').copyFrame(source.getActiveFrame())

        # Add copied frame to destination image
        destination.addFrame(frame)

        # save the changes
        destination.save()

        puts "Concatenated Multiple Tiff Images Successfully!"
    end
  end
end
