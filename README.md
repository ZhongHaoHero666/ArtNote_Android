# ArtNote_Android

文艺笔记android备忘录


### 接口mock工具 apizza

    http://apizza.cc/console/project/0a793559e396958a0fd6e298e583229a/dev
    
#### 接口文档中的域名需要根据上下班时间进行更换


### 域名映射工具花生壳
    工作时间（10：00-18：00）域名：17t14b6937.51mypc.cn:11744
 
    休息时间（19：00-23：00）域名：17t14b6937.51mypc.cn:38211

## 原型工具 墨刀
    原型连接：//TODO @锅大侠

## 新建组件的流程
    1.新建一个module
    2.在module的main文件夹下新建两个文件夹debug和release,用于放置Debug和Release环境的Manifest文件
    3.在新的module的gradle中加入两个判断
        if (IsBuildModule.toBoolean()) {
            apply plugin: 'com.android.application'
        } else {
            apply plugin: 'com.android.library'
        }
        
          sourceSets {
                main {
                    if (IsBuildModule.toBoolean()) {
                        manifest.srcFile 'src/main/debug/AndroidManifest.xml'
                    } else {
                        manifest.srcFile 'src/main/release/AndroidManifest.xml'
                        java {//在debug模式下需要触发源，apk需要默认的启动activity，在release模式下不需要
                            exclude 'debug/**' //不打包此包下面的资源文件
                        }
                    }
                }
            }
            resourcePrefix "login_"
        //切记,复制sourceSets这段代码时 studio会提示你一个包,一定要点cancel,不要导包,否则会报错
        //resourcePrefix 是为了防止不同的Library中出现相同名字的资源文件加的前缀.命名是你的module名字加下划线
        //即在你的module下的资源文件最好都加入这个前缀
       
###### Module是否能单独运行的开发在gradle.properties中

## 交流qq群：637588525
