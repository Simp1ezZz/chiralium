# chiralium消息触达平台

## 1.项目介绍

**chiralium**这个名字源自于游戏**死亡搁浅**，为游戏中的开罗尔物质，我想用这个名字代表死亡搁浅的一个理念：**联结**。通过消息发送来达到联结的目的。

chiralium的核心功能就是发送消息，定位是整合各种消息发送方式，包括但不限于短信、邮件、微信小程序等等，提供统一的调用方式，让使用者不必拘泥于发送的方式，开箱即用。

chiralium又或者说消息触达平台是每个需要消息发送的公司都**不可或缺**的，拥有专门的消息发送平台，可极大的减小相关业务时的代码开发，减轻开发负担以及开发成本。

## 2. 项目结构
该平台设计为既提供API可以远程调用发送消息，又可以通过配套的后台管理页面来操作发送，分别对应于开发人员和业务人员的发送消息需要。

**common包**存放的是通用工具类以及一些通用常量等等；

**service-api包**内存放的是对外提供的api接口，其实现存放在**service-api-impl包**；

**handler包**则是实际用来处理不同的发送逻辑。

**web包**对接的是后台管理页面，提供后台管理系统的接口；

## 3. TODO LIST
 - [x] 项目框架搭建
 - [x] 发送一条短信
 - [x] 完善整个发送短信流程，提取公共方法。
 - [x] 接入数据库及MybatisPlus,存储发送记录。
 - [ ] 接口统一日志
 - [ ] 接入Kafka消息队列
 - [ ] 接入Nacos配置中心，可动态读取或修改相关配置。