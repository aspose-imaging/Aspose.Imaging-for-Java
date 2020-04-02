package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.LoadOptions;
import com.aspose.imaging.ProgressEventHandler;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Path;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.jpeg.JpegCompressionMode;
import com.aspose.imaging.imageoptions.JpegOptions;
import com.aspose.imaging.progressmanagement.EventType;
import com.aspose.imaging.progressmanagement.ProgressEventHandlerInfo;

public class DocumentConvertionProgress
{
    public static void main(String[] args)
    {
        Logger.startExample("DocumentConvertionProgress");
        String dataDir = Utils.getSharedDataDir() + "ConvertingImages/";

        String fileName = "aspose-logo.jpg";
        String inputFileName = dataDir + fileName;

        // Example of use of separate operation progress event handlers for load/export operations
        try (Image image = Image.load(inputFileName, new LoadOptions()
        {{
            setProgressEventHandler(new ProgressEventHandler()
            {
                @Override
                public void invoke(ProgressEventHandlerInfo info)
                {
                    progressCallback(info);
                }
            });
        }}))
        {

            image.save(
                    Path.combine(Utils.getOutDir(), "outputFile_Baseline.jpg"),
                    new JpegOptions()
                    {{
                        setCompressionType(JpegCompressionMode.Baseline);
                        setQuality(100);
                        setProgressEventHandler(new ProgressEventHandler()
                        {
                            @Override
                            public void invoke(ProgressEventHandlerInfo info)
                            {
                                exportProgressCallback(info);
                            }
                        });
                    }});
        }
        Logger.endExample();
    }

    static void progressCallback(ProgressEventHandlerInfo info)
    {
        Logger.printf("Progress %s : %d/%d", EventType.toString(EventType.class, info.getEventType()), info.getValue(), info.getMaxValue());
    }

    static void exportProgressCallback(ProgressEventHandlerInfo info)
    {
        Logger.printf("Export event %s : %d/%d", EventType.toString(EventType.class, info.getEventType()), info.getValue(), info.getMaxValue());
    }
}
