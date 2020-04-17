# OpencvCommand

> 该项目是使用Opencv,实现对图形图像的处理,暂时只实现了图像美颜和图像模糊

## 引入

根据最新版本替换下面的`latestVersion`，当前最新版本[ ![Download](https://api.bintray.com/packages/sourfeng/repositories/opencv/images/download.svg) ](https://bintray.com/sourfeng/repositories/opencv/_latestVersion)

```groovy
implementation 'com.coder.command:opencv:${latestVersion}'
```

## 模糊

```
final long currentTime = System.currentTimeMillis();
new Thread(new Runnable() {
    @Override
    public void run() {
    int ret = BlurryCmd.blurImage(inputPath, outputPath, 21, BlurType.GAUSSIAN_BLUR);
    if (ret == 1) {
        mTimeText.setText(String.format("时长:%s",
        System.currentTimeMillis() - currentTime));
        RequestOptions options =RequestOptions
                .diskCacheStrategyOf(DiskCacheStrategy.NONE)
                .skipMemoryCache(true);
        Glide.with(MainActivity.this)
        .applyDefaultRequestOptions(options)
        .load(outputPath).into(imageView);
        }
    }
}).start();
```

**注意模糊度只能是奇数**

