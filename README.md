[![](https://jitpack.io/v/WotCore/Http-ktx.svg)](https://jitpack.io/#WotCore/Http-ktx)
[![API](https://img.shields.io/badge/API-21%2B-orange.svg?style=flat)](https://android-arsenal.com/api?level=21)

# Http-ktx
> DSL网络请求框架

#### 第一步 先写个 `ApiService`
``` kotlin
@GET("/banner/json")
suspend fun getBanner(): Response<List<Banner>>
```

#### 第二步 创建 `Service`实例
``` kotlin
val apiService: ApiService by lazy {
    HttpBuilder.createService(
        "https://www.wanandroid.com",
        okClientAction = {
            // OkHttpClient.Builder
        },
        retrofitAction = {
            // Retrofit.Builder
        }
    )
}
```

#### 第三步 数据获取
```kotlin
 val liveData = viewModelScope.requestData {
            // 请求网络
            api {
                wanAndroidService.getBanner()
            }

            // 加载数据缓存
            loadCache {
            }

            // 将数据保存到数据库
            saveCache {
            }
        }
```

------
> 引入

#### 添加仓库

在项目的 `build.gradle` 文件中配置仓库地址。

```android
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

#### 添加项目依赖

在需要添加依赖的 Module 下添加以下信息，使用方式和普通的远程仓库一样。

```android
implementation 'com.github.WotCore:Http-ktx:v1.0.1'
```
