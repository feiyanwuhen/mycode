CREATE TABLE `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `question` varchar(1000) NOT NULL COMMENT '问题',
  `choicea` varchar(255) NOT NULL COMMENT '选项A',
  `choiceb` varchar(255) NOT NULL COMMENT '选项B',
  `choicec` varchar(255) NOT NULL COMMENT '选项C',
  `choiced` varchar(255) DEFAULT NULL COMMENT '选项D',
  `answer` char(10) NOT NULL COMMENT '正确答案',
  `test_no` int(11) NOT NULL COMMENT '试卷编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4   

CREATE TABLE `test_paper` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `category_id` varchar(1000) NOT NULL COMMENT '试卷分类id',
  `test_title` varchar(255) NOT NULL COMMENT '试卷标题',
  `test_description` int(11) DEFAULT NULL COMMENT '试卷描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4       