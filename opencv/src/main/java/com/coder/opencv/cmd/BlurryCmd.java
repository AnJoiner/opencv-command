package com.coder.opencv.cmd;

import com.coder.opencv.annotation.BlurType;

/**
 * @author: AnJoiner
 * @datetime: 20-4-16
 */
public class BlurryCmd {

    static {
        System.loadLibrary("opencv_java4");
        System.loadLibrary("opencv-invoke");
    }


    public static  native int blurImage(String inputPath,String outputPath,int blurry,@BlurType int type);

}
