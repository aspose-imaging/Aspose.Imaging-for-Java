# Aspose_Imaging_Java_for_Ruby
Aspose.Imaging Java for Ruby is a Ruby gem that demonstrates / provides the Aspose.Imaging for Java API usage examples in Ruby by using Rjb - Ruby Java Bridge.

## Installation

Execute following command.

    $ gem install asposeimagingjava

To download Aspose.Imaging for Java API to be used with these examples through RJB, Please navigate to:

http://www.aspose.com/downloads/imaging/java

Note: Create jars folder at root of the gem folder and copy downloaded Aspose.Imaging for java component into it.

For most complete documentation of the project, check Aspose.Imaging for Java confluence wiki link for Ruby:

https://docs.aspose.com//display/imagingjava/Aspose.Imaging+Java+For+Ruby

## Usage

You can export image to different formats using following example code.

```ruby
require File.dirname(File.dirname(File.dirname(__FILE__))) + '/lib/asposeimagingjava'
include Asposeimagingjava
include Asposeimagingjava::ExportImageToDifferentFormats
initialize_aspose_imaging
```
Lets understand the above code
* The first line makes sure that the Aspose.Imaging is loaded and available 
* Include the files that are required to access the Aspose.Imaging
* Initialize the libraries. The aspose JAVA classes are loaded from the path provided in the aspose.yml file

## Download Latest Versions?

* [Latest Releases on Codeplex](https://asposeimagingjavaruby.codeplex.com/releases/view/617825)

## Clone Plugin SourceCodes?

This project is also hosted and maintained at CodePlex. To clone navigate to:

* [Aspose.Imaging Java for Ruby on CodePlex - click here](https://asposeimagingjavaruby.codeplex.com/SourceControl/latest)
