# miner 说明



## miner是什么

miner是一个rss订阅工具。就像下边酱紫。

![](http://7vzt96.com1.z0.glb.clouddn.com/miner_5.png)

## miner从何而来

这事还得从去年说起。大约去年2月中旬，我接触到了个人博客，并自己开了一个博客，[大约是这里^—*](http://blog.zhangyingwei.com)，然后我知道了RSS这个东西，但是很遗憾的是我却错过了万人推崇的Google Reader，随后我知道鲜果也关闭了个人订阅的功能，我用过feedly，用过其他各种各样的rss阅读器。但遗憾的是，没有一个使我用着感到非常舒服。因此本着不折腾不成魔的方针，决定自己动手写一个。

##	为什么叫miner

miner这个名字是后来改的，开始的时候我直接称之为rssreader4j。然后一个朋友说太yy了，所以想了又想取名为miner，意思就是矿工，中文名称就叫**[掘金者]**,有点装X哈。

##	miner环境介绍

* 开发工具：myeclipse
* 依赖管理：maven
* 运行环境：jdk1.7
* 数据库：mysql

##	miner的功能介绍

目前miner只有订阅rss源的功能，我理想中的miner还可以订阅微信公众号。
虽然我自己不怎么看微信公众号，也挺反感企鹅公司把公众号做的太封闭。但是考虑到现在很多人订阅微信公众号，所以还是想把这个功能加上，额..目前正在努力中...
至于具体是什么样子，看图啦...
![登录功能](http://7vzt96.com1.z0.glb.clouddn.com/miner_1.gif)
这里的登录功能还仅仅处于一个大门的功能。有待完善。

![订阅功能](http://7vzt96.com1.z0.glb.clouddn.com/miner_2.gif)
亲测，可以订阅网易新闻...

![阅读功能](http://7vzt96.com1.z0.glb.clouddn.com/miner_3.gif)

##	如何安装

### 首先准备工作
* 服务器 or 其他一切可以运行java程序的地方
* tomcat7
* mysql 5.0
* myeclipse (安装好maven?请继续:[看这里](http://blog.zhangyingwei.com/categories/maven/))

###然后
如果你只是想要运行一个miner系统的话，你只需要项目中的miner.war与，miner.sql两个文件。
miner.war是项目编译后的war包
miner.sql里边是所有表的ddl

###初始化
* 新建一个数据库并按照sql文件中的ddl语句建立所有表，并在t_sys_user表中初始化登录信息
* 把miner.war放在tomcat的webapps文件夹中并运行tomcat。
* 运行tomcat后会在wenapps文件夹中产生一个miner文件夹
* 进入路径 miner/WEB-INF/classes
* 打开conf.properties配置文件配置数据库信息
* 打开mail.properties配置文件配置邮箱信息，其中有发送邮件的邮箱账号密码，接收邮件的邮箱账号密码（发送邮件的邮箱必须开启SMTP、POP3等服务）
* 重启tomcat服务器，并登录:http://url:port/miner(例如：http://localhost:8080/miner)
收到的邮件是酱紫的
![](http://7vzt96.com1.z0.glb.clouddn.com/miner_0044.png)

###OK
