package com.coder.opencv.annotation;

import androidx.annotation.IntDef;

/**
 * @author: AnJoiner
 * @datetime: 20-4-17
 */
@IntDef({
        BlurType.LINEAR_BLUR,
        BlurType.GAUSSIAN_BLUR,
        BlurType.MEDIAN_BLUR,
        BlurType.BOX_FILTER,
        BlurType.BILATERAL_FILTER
})
public @interface BlurType {
    int LINEAR_BLUR = 1; // 线性模糊
    int GAUSSIAN_BLUR = 2; //高斯模糊
    int MEDIAN_BLUR = 3; // 中位模糊
    int BOX_FILTER = 4;  //方框滤波
    int BILATERAL_FILTER = 5; //双边过滤
}
