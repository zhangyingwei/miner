
CREATE TABLE `t_rss_article` (
  `id` int(11) NOT NULL auto_increment COMMENT '编号',
  `stitle` varchar(100) default NULL COMMENT '网站标题',
  `slink` varchar(500) default NULL COMMENT '网站网址',
  `supdated` varchar(50) default NULL COMMENT '网站更新时间',
  `etitle` varchar(500) default NULL COMMENT '文章标题',
  `elink` varchar(500) default NULL COMMENT '文章链接',
  `epublished` varchar(50) default NULL COMMENT '发表时间',
  `edescription` longtext COMMENT '文章简介',
  `delflag` varchar(1) default NULL COMMENT '删除标志 0-正常 1-删除',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2378 DEFAULT CHARSET=utf8;


CREATE TABLE `t_rss_website` (
  `id` int(11) NOT NULL auto_increment COMMENT '编号',
  `websitelink` varchar(500) default NULL COMMENT '订阅地址',
  `title` varchar(500) default NULL COMMENT '网站名称',
  `link` varchar(500) default NULL COMMENT '网站地址',
  `updated` varchar(100) default NULL COMMENT '网站更新时间',
  `description` longtext COMMENT '网站简介',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=142 DEFAULT CHARSET=utf8;


CREATE TABLE `t_sys_user` (
  `userid` int(11) NOT NULL auto_increment COMMENT '编号',
  `username` varchar(100) default NULL COMMENT '用户名 --邮箱',
  `passwd` varchar(50) default NULL COMMENT '密码',
  PRIMARY KEY  (`userid`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


CREATE TABLE `t_wx_article` (
  `id` int(20) NOT NULL auto_increment COMMENT '编号',
  `stitle` varchar(20) default NULL COMMENT '公众号名称',
  `key` varchar(100) default NULL COMMENT 'key-来源于搜狗',
  `title` varchar(100) default NULL COMMENT '文章标题',
  `decription` varchar(1000) default NULL COMMENT '简介',
  `publishTime` varchar(20) default NULL COMMENT '发表时间',
  `docid` varchar(200) default NULL COMMENT '文章标识',
  `url` varchar(1000) default NULL COMMENT 'url-来源于搜狗',
  `location` varchar(1000) default NULL COMMENT 'url-来源于微信',
  `delflag` varchar(1) default NULL COMMENT '删除标志 0-正常 1-删除',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;


CREATE TABLE `t_wx_site` (
  `id` int(20) NOT NULL auto_increment COMMENT '编号',
  `wxcode` varchar(20) default NULL COMMENT '微信号',
  `wxname` varchar(50) default NULL COMMENT '微信号名称',
  `description` varchar(20) default NULL COMMENT '微信描述',
  `url` varchar(50) default NULL COMMENT '基链接',
  `openid` varchar(50) default NULL COMMENT 'openid',
  `ext` varchar(100) default NULL COMMENT 'ext',
  `page` varchar(1) default NULL COMMENT 'page',
  `cb` varchar(50) default NULL COMMENT 'cb',
  `gzhArtKeyWord` varchar(50) default NULL COMMENT 'gzhArtKeyWord',
  `updatetime` varchar(20) default NULL COMMENT '更新时间',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
