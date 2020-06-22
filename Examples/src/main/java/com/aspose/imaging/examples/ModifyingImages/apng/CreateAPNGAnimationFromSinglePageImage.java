package com.aspose.imaging.examples.ModifyingImages.apng;

import com.aspose.imaging.Image;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.apng.ApngFrame;
import com.aspose.imaging.fileformats.apng.ApngImage;
import com.aspose.imaging.fileformats.png.PngColorType;
import com.aspose.imaging.imageoptions.ApngOptions;
import com.aspose.imaging.sources.FileCreateSource;

public class CreateAPNGAnimationFromSinglePageImage
{
    public static void main(String... args)
    {
        Logger.startExample("CreateAPNGAnimationFromSinglePageImage");

        final int AnimationDuration = 1000; // 1 s
        final int FrameDuration = 70; // 70 ms

        String dataDir = Utils.getSharedDataDir() + "APNG/";
        String fileName = "not_animated.png";
        String inputFilePath = dataDir + fileName;
        String outputFilePath = Utils.getOutDir() + "raster_animation.png";


        try (RasterImage sourceImage = (RasterImage) Image.load(inputFilePath))
        {
            try (ApngOptions createOptions = new ApngOptions())
            {
                createOptions.setSource(new FileCreateSource(outputFilePath, false));
                createOptions.setDefaultFrameTime(FrameDuration);
                createOptions.setColorType(PngColorType.TruecolorWithAlpha);

                try (ApngImage apngImage = (ApngImage) Image.create(
                        createOptions,
                        sourceImage.getWidth(),
                        sourceImage.getHeight()))
                {
                    int numOfFrames = AnimationDuration / FrameDuration;
                    int numOfFrames2 = numOfFrames / 2;

                    apngImage.removeAllFrames();

                    // add first frame
                    apngImage.addFrame(sourceImage, FrameDuration);

                    // add intermediate frames
                    for (int frameIndex = 1; frameIndex < numOfFrames - 1; ++frameIndex)
                    {
                        apngImage.addFrame(sourceImage, FrameDuration);
                        ApngFrame lastFrame = (ApngFrame) apngImage.getPages()[apngImage.getPageCount() - 1];
                        float gamma = frameIndex >= numOfFrames2 ? numOfFrames - frameIndex - 1 : frameIndex;
                        lastFrame.adjustGamma(gamma);
                    }

                    // add last frame
                    apngImage.addFrame(sourceImage, FrameDuration);

                    apngImage.save();
                }
            }
        }

        Utils.deleteFile(outputFilePath);

        Logger.endExample();
    }
}