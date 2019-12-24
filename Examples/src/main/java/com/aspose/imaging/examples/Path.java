package com.aspose.imaging.examples;

import java.io.File;

public class Path
{
    public static String combine(String dataDir, String dir)
    {
        if (dataDir.isEmpty())
            return dir;
        char lastChar = dataDir.charAt(dataDir.length() - 1);
        if (lastChar == '/' || lastChar == '\\')
            return dataDir + dir;
        
        return dataDir + File.separator + dir;
    }
}
