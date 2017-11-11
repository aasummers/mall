/*---- 创建数据库 ----*/
CREATE DATABASE `mall` /*!40100 DEFAULT CHARACTER SET utf8 */
/*---- 创建用户地址表 ----*/
CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `rec_user_name` varchar(45) DEFAULT NULL,
  `rec_user_phone` varchar(45) DEFAULT NULL,
  `rec_user_address` varchar(200) DEFAULT NULL,
  `rec_user_area` varchar(45) DEFAULT NULL,
  `is_default` int(11) DEFAULT NULL COMMENT '是否默认地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*---- 创建商品表 -----*/
CREATE TABLE `goods` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `image` varchar(400) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `goodscol` varchar(45) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  `promotionPrice` varchar(45) DEFAULT NULL,
  `descripe` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*---- 创建订单表 ----*/
CREATE TABLE `order` (
  `id` int(11) NOT NULL,
  `orderCode` varchar(45) DEFAULT NULL,
  `goodsName` varchar(45) DEFAULT NULL,
  `goodsImg` varchar(45) DEFAULT NULL,
  `goodsPrice` varchar(45) DEFAULT NULL,
  `goodsPromotionPrice` varchar(45) DEFAULT NULL,
  `createTime` varchar(45) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `recUserName` varchar(45) DEFAULT NULL,
  `recUserPhone` varchar(45) DEFAULT NULL,
  `recUserAddress` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*---- 创建用户表 ----*/
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `usercol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;