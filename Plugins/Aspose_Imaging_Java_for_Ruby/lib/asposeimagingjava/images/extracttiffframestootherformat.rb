module Asposeimagingjava
  module ExtractTiffFramesToOtherFormat
    def initialize()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Load an existing image
        image = Rjb::import('com.aspose.imaging.Image').load(data_dir + "multipage.tiff")

        frames = image.getFrames()
        i = 1
        frames.each do |frame|
            frame.save(data_dir + "frame#{i}.jpg", Rjb::import('com.aspose.imaging.imageoptions.JpegOptions').new)
            i +=1
        end

        puts "Saved images successfully!"
    end
  end
end
