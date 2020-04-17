package com.coder.opencv.cmd;

/**
 * @author: AnJoiner
 * @datetime: 20-4-16
 */
public class BlurryCmd {

    static {
        System.loadLibrary("opencv_java4");
        System.loadLibrary("opencv-invoke");
    }


    public static  native int blurImage(String inputPath,String outputPath,int blurry, int type);

}
