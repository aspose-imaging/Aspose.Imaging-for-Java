module Asposeimagingjava
  module AddThumbnailToJFIFSegment
    def initialize()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Create an instance of JpegImage to store the thumbnail
        thumbnail = Rjb::import('com.aspose.imaging.fileformats.jpeg.JpegImage').new(100, 100)

        # Create another instance of JpegImage as primary image
        image = Rjb::import('com.aspose.imaging.fileformats.jpeg.JpegImage').new(1000, 1000)

        # Set the Jfif value as new JFIFData
        image.setJfif(Rjb::import('com.aspose.imaging.fileformats.jpeg.JFIFData').new)

        # Store the thumbnail in the Jfif segment
        image.getJfif().setThumbnail(thumbnail)

        # Save the resultant image
        image.save(data_dir + "Thumbnail_JFIF.jpg")

        # Display Status.
        puts "Added thumbnail to JFIF segment successfully!"
    end
  end
end
