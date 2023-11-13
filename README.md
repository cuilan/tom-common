# tom-common

Tools of mybatis(TOM) common.

Java project commons.

# Table of Contents

- [Overview](#overview)
- [Installing](#installing)
  * [Maven](#maven)
  * [Gradle](#gradle)
- [Components](#components)
- [License](#license)

# Overview

mybatis-plus 开发工具集，对 mapper 层增强了批量操作、集成 redis 缓存操作，支持实体对象缓存、自定义缓存、本地缓存等。

# Installing

## Maven

在项目的pom.xml的dependencies中加入以下内容:

```xml

<dependency>
    <groupId>cn.cuilan</groupId>
    <artifactId>tom-all</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Gradle

```groovy
implementation 'cn.cuilan:tom-all:1.0.0'
```

# Components

用于 mybatis-plus 开发的各种组件及工具：

| 模块               | 介绍                          |
|------------------|-----------------------------|
| tom-all          | 全部引入                        |
| tom-bom          | bom的方式进行依赖管理                |
| tom-constants    | 一些定义的常量、正则表达式、异常、SQL常量等     |
| tom-crypto       | 加密解密模块，提供对称、非对称和摘要算法封装      |
| tom-mybatis-base | mybatis基础操作，增强mapper层批量操作功能 |
| tom-network      | 网络工具、Http下载、文件下载、zip下载等     |
| tom-redis        | mybatis redis缓存增强           |
| tom-utils        | 一些工具类                       |

根据需求可对模块单独引入，也可通过引入 `tom-all` 方式引入所有模块。

# License

TOM is released ubder the Apache 2.0 license.See [LICENSE](https://github.com/cuilan/tom-common/blob/master/LICENSE)