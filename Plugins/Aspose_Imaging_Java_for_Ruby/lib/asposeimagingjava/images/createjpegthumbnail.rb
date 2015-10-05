module Asposeimagingjava
  module CreateJpegThumbnail
    def initialize()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Load an existing image (of type bmp) in an instance of Image class
        image = Rjb::import('com.aspose.imaging.Image').load(data_dir + "test.jpg")

        if image.getExifData() != nil
            # Get the image thumbnail information and save it in an instance of JpegImage
            thumbnail = image.getExifData().get_Thumbnail()

            # Save the thumbnail to disk with a new name
            thumbnail.save(data_dir + "JpegThumbnail.jpeg")

            # Display Status.
            puts "Created thumbnail of JPEG image successfully!"
        end
    end
  end
end
