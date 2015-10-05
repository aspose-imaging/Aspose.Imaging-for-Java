module Asposeimagingjava
  module DataRecoveryForTiffImages
    def initialize()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Create an instance of LoadOptions
        load_options = Rjb::import('com.aspose.imaging.LoadOptions').new

        # Specify the DataRecoveryMode for the object of LoadOptions
        load_options.setDataRecoveryMode(Rjb::import('com.aspose.imaging.DataRecoveryMode').ConsistentRecover)

        # Specify the DataBackgroundColor for the object of LoadOptions
        load_options.setDataBackgroundColor(Rjb::import('java.awt.Color').getRed())

        # Load an existing image
        image = Rjb::import('com.aspose.imaging.Image').load(data_dir + "multipage.tiff", load_options)

        # do some work
    end
  end
end
