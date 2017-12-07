# RCDialog
仿 MIUI 底部弹框 Dialog

之前做项目的时候有圆角窗口相关需求，参考 MIUI 系统的底部 Dialog，自己做了一个，目前已经使用了一段时间，我遇到的问题都进行了修复。

## 主要文件

| 名字              | 摘要       |
| --------------- | -------- |
| RoundRectDialog | 圆角Dialog |

## 基本用法

与 Android 官方的 AlertDialog 的 Builder 使用方法基本一致。

```java
new RoundRectDialog.Builder(MainActivity.this)
    .setCancelable(true)//按物理返回键或者点击窗口外部区域时是否取消显示
    .setCanceledOnTouchOutside(true)//点击窗口外部时是否取消显示（默认为 true，将它设置为 true 时，会默认将 setCancelable 设置为 true）
    .setTitle("提示")//设置标题
    .setMsg("Hello Round Rect Dialog")//设置内容
    .setNegativeButton("取消", null)//设置左侧按钮的提示文字，以及点击事件监听
    .setGravity(Gravity.BOTTOM)//设置显示位置（默认为 bottom）
    .setPositiveButton("确定", new DialogInterface.OnClickListener() {//设置右侧按钮的提示文字，以及点击事件监听
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(MainActivity.this, "Click Sure", Toast.LENGTH_SHORT).show();
        }
    }).show();//设置显示出 Dialog。show 方法，显示出 dialog
```

## 添加方法

### Step 1. 添加JitPack仓库

在当前项目的根目录下的 `build.gradle` 文件中添加如下内容:

```
allprojects {
    repositories {
		//…
      	maven { url 'https://jitpack.io' }
    }
}
```

### Step 2. 添加项目依赖

在需要添加依赖的 Module 下添加以下信息，使用方式和普通的远程仓库一样。

```
dependencies {
        compile 'com.github.ivanljt:RCDialog:v1.0.0'
}
```



## License

```
Copyright (c) 2017 ivanljt

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

