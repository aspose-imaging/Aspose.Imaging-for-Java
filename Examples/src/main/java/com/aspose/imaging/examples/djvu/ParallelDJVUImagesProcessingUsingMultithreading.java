package com.aspose.imaging.examples.djvu;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.PngOptions;

import java.io.FileNotFoundException;
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

        //ExStart:ParallelDJVUImagesProcessingUsingMultithreading

        String dir = Utils.getSharedDataDir() + "djvu/";

        final String fileName = dir + "Sample.djvu";
        int numThreads = 20;

        ExecutorService execServ = Executors.newFixedThreadPool(numThreads);

        for (int i = 0; i < numThreads; i++)
        {
            final String outputFile = String.format("%s_task%d.png", fileName, i);
            execServ.execute(new Runnable()
            {
                @Override
                public void run()
                {
                    RandomAccessFile fs;
                    try
                    {
                        fs = new RandomAccessFile(fileName, "r");
                    }
                    catch (FileNotFoundException e)
                    {
                        throw new RuntimeException(e.getMessage(), e);
                    }

                    try
                    {
                        Image image = Image.load(fs);
                        try
                        {
                            image.save(outputFile, new PngOptions());
                        }
                        finally
                        {
                            image.close();
                        }
                    }
                    finally
                    {
                        try
                        {
                            fs.close();
                        }
                        catch (IOException ignore)
                        {
                        }
                    }
                }
            });
        }

        execServ.shutdown();
        while (!execServ.awaitTermination(1, TimeUnit.SECONDS))
        {
            Thread.yield();
        }
        //ExEnd:ParallelDJVUImagesProcessingUsingMultithreading
    }
}
