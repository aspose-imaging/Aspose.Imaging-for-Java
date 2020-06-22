package com.aspose.imaging.examples;

import java.util.Arrays;
import java.util.Date;

public final class Logger
{
    private Logger()
    {

    }

    private static String currentExample;
    private static String idents = "";

    public static void startExample(String name)
    {
        if (currentExample != null)
        {
            endExample();
        }
        System.out.print(new Date());
        System.out.print("  Running example: ");
        System.out.println(name);
        currentExample = name;
        idents = "    ";
    }

    public static void endExample()
    {
        if (currentExample == null)
            return;
        System.out.print(new Date());
        System.out.print("  Finished example: ");
        System.out.println(currentExample);
        currentExample = null;
        idents = "";
        Utils.deleteAllOutputFiles();
    }

    public static void println(String text)
    {
        System.out.print(idents);
        System.out.println(text);
    }

    public static void println(String ... text)
    {
        System.out.print(idents);
        for (String s : text)
        {
            System.out.print(s);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void println(int value)
    {
        System.out.print(idents);
        System.out.println(value);
    }

    public static void println(String text, int value)
    {
        System.out.print(idents);
        System.out.print(text);
        System.out.print(" ");
        System.out.println(value);
    }

    public static void printf(String text, Object ... args)
    {
        System.out.print(idents);
        System.out.format(text, args);
        System.out.println();
    }

    public static void printlnArray(String text, Object array)
    {
        System.out.print(idents);
        System.out.print(text);
        if (array instanceof byte[])
        {
            System.out.println(Arrays.toString((byte[])array));
        }
        else if (array instanceof short[])
        {
            System.out.println(Arrays.toString((short[])array));
        }
        else if (array instanceof int[])
        {
            System.out.println(Arrays.toString((int[])array));
        }
        else if (array instanceof long[])
        {
            System.out.println(Arrays.toString((long[])array));
        }
        else if (array instanceof char[])
        {
            System.out.println(Arrays.toString((char[])array));
        }
        else if (array instanceof float[])
        {
            System.out.println(Arrays.toString((float[])array));
        }
        else if (array instanceof double[])
        {
            System.out.println(Arrays.toString((double[])array));
        }
        else if (array instanceof boolean[])
        {
            System.out.println(Arrays.toString((boolean[])array));
        }
        else
            System.out.println(Arrays.toString((Object[])array));
    }
}
