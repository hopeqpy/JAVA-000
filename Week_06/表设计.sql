CREATE TABLE `d_user` (
`id` bigint(20) NOT NULL COMMENT '主键',
`name` varchar(50) NULL COMMENT '用户名',
`sex` int(11) NULL COMMENT '0未知 ，1 男，2 女',
`nick_name` varchar(50) NULL COMMENT '昵称',
`birthday` date NULL COMMENT '出生日期',
`nation` int(11) NULL COMMENT '民族',
`create_time` datetime NULL COMMENT '创建时间',
`modify_time` datetime NULL COMMENT '修改时间',
`address` varchar(100) NULL COMMENT '地址',
`salt` varchar(30) NULL COMMENT '盐',
`pass_word` varchar(100) NULL COMMENT '密码',
`status` int(11) NULL COMMENT '状态 ',
`is_del` tinyint(1) NULL COMMENT '是否删除 0 未删除  1删除',
`login_name` varchar(50) NULL COMMENT '登录名',
`mobile` varchar(40) NULL COMMENT '电话号码',
PRIMARY KEY (`id`) 
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '用户表';
CREATE TABLE `d_product` (
`id` bigint(20) NOT NULL COMMENT '主键',
`name` varchar(50) NULL COMMENT '商品名称',
`price` decimal(16,2) NULL COMMENT '商品价格',
`img` varchar(255) NULL COMMENT '图片',
`des` varchar(255) NULL COMMENT '描述',
`create_time` datetime NULL COMMENT '创建时间',
`modify_time` datetime NULL,
`remark` varchar(100) NULL COMMENT '备注',
`is_del` tinyint(1) NULL COMMENT '是否删除 0 未删除 1删除',
`is_show` tinyint(1) NULL COMMENT '0 展示 1 不展示',
`is_down` tinyint(1) NULL COMMENT '是否下架 0 为下架 1下架',
PRIMARY KEY (`id`) 
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '商品表';
CREATE TABLE `d_order` (
`id` bigint(20) NOT NULL COMMENT '主键',
`order_no` varchar(100) NULL COMMENT '订单号',
`create_time` datetime NULL,
`modify_time` datetime NULL,
`status` int(11) NULL COMMENT '订单状态',
`pay_time` datetime NULL COMMENT '支付状态',
`money` decimal(16,2) NULL COMMENT '订单金额',
`address` varchar(100) NULL COMMENT '订单地址',
`pay_money` decimal(16,2) NULL COMMENT '实际支付金额',
`remark` varchar(100) NULL COMMENT '备注',
`is_del` tinyint(1) NULL COMMENT '是否删除 0 未删除 1 删除',
`user_id` bigint(20) NULL COMMENT '用户id',
`mobile` varchar(20) NULL COMMENT '联系电话',
PRIMARY KEY (`id`) 
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '订单表';
CREATE TABLE `d_order_detail` (
`id` bigint(20) NOT NULL COMMENT '主键',
`order_id` bigint(20) NULL COMMENT '订单id',
`product_id` bigint(20) NULL COMMENT '商品id',
`product_name` varchar(100) NULL COMMENT '商品名称',
`img` varchar(255) NULL COMMENT '商品图片',
`status` int(11) NULL COMMENT '订单明细状态',
`create_time` datetime NULL,
`modify_time` datetime NULL,
`count` int(11) NULL COMMENT '商品数量',
`money` decimal(16,2) NULL COMMENT '商品金额',
`pay_money` decimal(16,2) NULL COMMENT '支付金额',
`pay_time` datetime NULL COMMENT '支付实际',
`is_del` tinyint(1) NULL COMMENT '是否删除 0 未删除 1删除',
`user_id` bigint(20) NULL COMMENT '用户id',
`remark` varchar(50) NULL COMMENT '备注',
PRIMARY KEY (`id`) 
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '订单明细表';
