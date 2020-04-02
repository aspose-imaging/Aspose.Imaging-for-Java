package com.aspose.imaging.examples.djvu;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.PngOptions;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author mfazi
 */
public class ParallelDJVUImagesProcessingUsingMultithreading
{
    public static void main(String[] args) throws InterruptedException
    {
        Logger.startExample("ParallelDJVUImagesProcessingUsingMultithreading");

        String dir = Utils.getSharedDataDir() + "djvu/";

        final String fileName = dir + "Sample.djvu";
        final String outFile = Utils.getOutDir() + "Sample.djvu";
        int numThreads = 20;

        ExecutorService execServ = Executors.newFixedThreadPool(numThreads);

        for (int i = 0; i < numThreads; i++)
        {
            final String outputFile = String.format("%s_task%d.png", outFile, i);
            execServ.execute(new Runnable()
            {
                @Override
                public void run()
                {
                    try(RandomAccessFile fs = new RandomAccessFile(fileName, "r"))
                    {
                        try (Image image = Image.load(fs))
                        {
                            image.save(outputFile, new PngOptions());
                        }
                    }
                    catch (IOException ex)
                    {
                        Logger.println(ex.getMessage());
                        ex.printStackTrace();
                    }
                }
            });
        }

        execServ.shutdown();
        while (!execServ.awaitTermination(1, TimeUnit.SECONDS))
        {
            Thread.yield();
        }
        Logger.endExample();
    }
}
