/*
 Navicat Premium Dump SQL

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80020 (8.0.20)
 Source Host           : localhost:3306
 Source Schema         : hospitalmanagement

 Target Server Type    : MySQL
 Target Server Version : 80020 (8.0.20)
 File Encoding         : 65001

 Date: 18/04/2025 22:45:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for alipaytransactions
-- ----------------------------
DROP TABLE IF EXISTS `alipaytransactions`;
CREATE TABLE `alipaytransactions`  (
  `AlipayTransactionID` int NOT NULL AUTO_INCREMENT COMMENT '支付宝交易记录唯一标识',
  `OrderNumber` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '订单号',
  `TotalAmount` decimal(10, 2) NOT NULL COMMENT '总金额',
  `TradeStatus` enum('待付款','已关闭','已成功','已结束') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '待付款' COMMENT '交易状态',
  PRIMARY KEY (`AlipayTransactionID`) USING BTREE,
  UNIQUE INDEX `Unique_Transaction_Order`(`OrderNumber` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '支付宝交易记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of alipaytransactions
-- ----------------------------
INSERT INTO `alipaytransactions` VALUES (1, 'alipay:6', 500.00, '待付款');
INSERT INTO `alipaytransactions` VALUES (3, 'alipay:26', 200.00, '待付款');
INSERT INTO `alipaytransactions` VALUES (4, 'alipay:27', 200.00, '待付款');

-- ----------------------------
-- Table structure for appointments
-- ----------------------------
DROP TABLE IF EXISTS `appointments`;
CREATE TABLE `appointments`  (
  `AppointmentID` int NOT NULL AUTO_INCREMENT COMMENT '挂号唯一标识',
  `PatientID` int NULL DEFAULT NULL COMMENT '病人唯一标识（外键）',
  `AppointmentDate` date NOT NULL COMMENT '预约日期',
  `AppointmentSession` enum('上午','下午') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '就诊时段（上午 / 下午）',
  `Status` enum('已计划','已完成','取消','已过时') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '已计划' COMMENT '预约状态',
  `CreatedAt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `DoctorID` int NOT NULL COMMENT '医生唯一标识（外键）',
  PRIMARY KEY (`AppointmentID`) USING BTREE,
  INDEX `PatientID`(`PatientID` ASC) USING BTREE,
  INDEX `date`(`AppointmentDate` DESC) USING BTREE,
  INDEX `idx_doctor_id`(`DoctorID` ASC) USING BTREE,
  CONSTRAINT `appointments_ibfk_1` FOREIGN KEY (`PatientID`) REFERENCES `patients` (`PatientID`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `fk_doctor_id` FOREIGN KEY (`DoctorID`) REFERENCES `doctors` (`DoctorID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '挂号与预约表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of appointments
-- ----------------------------
INSERT INTO `appointments` VALUES (4, 1, '2025-03-28', '上午', '已计划', '2025-03-26 00:42:29', 1);
INSERT INTO `appointments` VALUES (5, 2, '2025-03-28', '上午', '已完成', '2025-03-26 00:42:29', 2);
INSERT INTO `appointments` VALUES (6, 3, '2025-03-29', '上午', '取消', '2025-03-26 00:42:29', 3);
INSERT INTO `appointments` VALUES (7, 4, '2025-03-29', '上午', '已过时', '2025-03-26 00:42:29', 4);
INSERT INTO `appointments` VALUES (8, 5, '2025-03-30', '上午', '已计划', '2025-03-26 00:42:29', 5);
INSERT INTO `appointments` VALUES (9, 6, '2025-03-31', '下午', '已计划', '2025-03-26 00:40:00', 1);
INSERT INTO `appointments` VALUES (10, 7, '2025-03-31', '上午', '已完成', '2025-03-26 00:42:29', 1);
INSERT INTO `appointments` VALUES (11, 8, '2025-03-31', '上午', '取消', '2025-03-26 00:42:29', 8);
INSERT INTO `appointments` VALUES (12, 9, '2025-04-01', '上午', '已计划', '2025-03-26 00:42:29', 9);
INSERT INTO `appointments` VALUES (13, 10, '2025-04-01', '上午', '已计划', '2025-03-26 00:42:29', 10);
INSERT INTO `appointments` VALUES (14, 1, '2025-04-03', '上午', '已计划', '2025-04-03 20:40:47', 1);
INSERT INTO `appointments` VALUES (15, 1, '2025-07-03', '上午', '已计划', '2025-04-03 20:43:30', 6);

-- ----------------------------
-- Table structure for doctors
-- ----------------------------
DROP TABLE IF EXISTS `doctors`;
CREATE TABLE `doctors`  (
  `DoctorID` int NOT NULL AUTO_INCREMENT COMMENT '医生唯一标识',
  `Name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '医生姓名',
  `Gender` enum('男','女') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '性别',
  `Phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '联系方式',
  `Email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电子邮件',
  `Department` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '所属科室',
  `Specialization` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '专业方向',
  `CreatedAt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`DoctorID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '医生基本信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of doctors
-- ----------------------------
INSERT INTO `doctors` VALUES (1, '张伟', '男', '13800138001', 'zhangwei@example.com', '内科', '心血管', '2025-03-26 00:37:53');
INSERT INTO `doctors` VALUES (2, '李娜', '女', '13800138002', 'lina@example.com', '内科', '普外科', '2025-03-26 00:37:53');
INSERT INTO `doctors` VALUES (3, '王强', '男', '13800138003', 'wangqiang@example.com', '儿科', '新生儿科', '2025-03-26 00:37:53');
INSERT INTO `doctors` VALUES (4, '赵敏', '女', '13800138004', 'zhaomin@example.com', '妇产科', '产科', '2025-03-26 00:37:53');
INSERT INTO `doctors` VALUES (5, '刘洋', '男', '13800138005', 'liuyang@example.com', '骨科', '脊柱外科', '2025-03-26 00:37:53');
INSERT INTO `doctors` VALUES (6, '陈杰', '男', '13800138006', 'chenjie@example.com', '皮肤科', '皮肤病', '2025-03-26 00:37:53');
INSERT INTO `doctors` VALUES (7, '杨柳', '女', '13800138007', 'yangliu@example.com', '眼科', '视网膜疾病', '2025-03-26 00:37:53');
INSERT INTO `doctors` VALUES (8, '吴刚', '男', '13800138008', 'wugang@example.com', '耳鼻喉科', '耳科', '2025-03-26 00:37:53');
INSERT INTO `doctors` VALUES (9, '周婷', '女', '13800138009', 'zhouting@example.com', '耳鼻喉科', '牙周病', '2025-03-26 00:37:53');
INSERT INTO `doctors` VALUES (10, '郑辉', '男', '13800138010', 'zhenghui@example.com', '神经内科', '癫痫', '2025-03-26 00:37:53');

-- ----------------------------
-- Table structure for drugconsumption
-- ----------------------------
DROP TABLE IF EXISTS `drugconsumption`;
CREATE TABLE `drugconsumption`  (
  `ConsumptionID` int NOT NULL AUTO_INCREMENT COMMENT '药品消耗唯一标识',
  `DrugID` int NOT NULL COMMENT '药品唯一标识（外键）',
  `PatientID` int NULL DEFAULT NULL COMMENT '病人唯一标识（外键）',
  `QuantityUsed` int NOT NULL COMMENT '使用数量',
  `LastUpdated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `Count` int NULL DEFAULT NULL COMMENT '用时总量',
  PRIMARY KEY (`ConsumptionID`) USING BTREE,
  INDEX `date`(`LastUpdated` DESC) USING BTREE,
  INDEX `drugconsumption_ibfk_1`(`DrugID` ASC) USING BTREE,
  INDEX `drugconsumption_ibfk_2`(`PatientID` ASC) USING BTREE,
  CONSTRAINT `drugconsumption_ibfk_1` FOREIGN KEY (`DrugID`) REFERENCES `druginventory` (`DrugID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `drugconsumption_ibfk_2` FOREIGN KEY (`PatientID`) REFERENCES `patients` (`PatientID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 72 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '药品消耗记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of drugconsumption
-- ----------------------------
INSERT INTO `drugconsumption` VALUES (2, 2, 2, 5, '2025-01-14 00:00:00', 0);
INSERT INTO `drugconsumption` VALUES (3, 3, 3, 3, '2025-01-15 00:00:00', 0);
INSERT INTO `drugconsumption` VALUES (4, 2, 1, -100, '2025-02-25 15:52:20', 500);
INSERT INTO `drugconsumption` VALUES (5, 2, 1, -100, '2025-02-25 15:52:33', 500);
INSERT INTO `drugconsumption` VALUES (12, 2, 1, -200, '2025-02-25 23:23:08', 500);
INSERT INTO `drugconsumption` VALUES (26, 2, 1, -200, '2025-02-26 00:06:08', 500);
INSERT INTO `drugconsumption` VALUES (27, 2, 1, -200, '2025-02-26 00:24:46', 500);
INSERT INTO `drugconsumption` VALUES (34, 2, 1, -200, '2025-02-26 00:28:11', 500);
INSERT INTO `drugconsumption` VALUES (35, 2, 1, -200, '2025-02-26 11:23:49', 500);
INSERT INTO `drugconsumption` VALUES (45, 2, 1, -200, '2025-02-26 12:03:18', 500);
INSERT INTO `drugconsumption` VALUES (46, 2, 1, -200, '2025-02-26 12:06:11', 500);
INSERT INTO `drugconsumption` VALUES (57, 2, 2, 2, '2025-03-03 16:49:58', 2);
INSERT INTO `drugconsumption` VALUES (71, 2, 3, 4, '2025-03-05 17:35:53', 5);

-- ----------------------------
-- Table structure for druginventory
-- ----------------------------
DROP TABLE IF EXISTS `druginventory`;
CREATE TABLE `druginventory`  (
  `DrugID` int NOT NULL AUTO_INCREMENT COMMENT '药品唯一标识',
  `DrugName` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '药品名称',
  `Category` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '药品类别',
  `Quantity` int NOT NULL COMMENT '库存数量',
  `UnitPrice` decimal(10, 2) NOT NULL COMMENT '单价',
  `SupplierName` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '供应商名称',
  `LastUpdated` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `ManufactureDate` date NULL DEFAULT NULL COMMENT '药品制作日期',
  `ExpiryDate` date NULL DEFAULT NULL COMMENT '药品有效日期',
  PRIMARY KEY (`DrugID`) USING BTREE,
  INDEX `date`(`LastUpdated` DESC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '药品库存管理表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of druginventory
-- ----------------------------
INSERT INTO `druginventory` VALUES (2, '头孢克肟', '抗生素', 300, 1.20, '国药集团', '2025-01-19 13:20:39', NULL, NULL);
INSERT INTO `druginventory` VALUES (3, '维生素C', '保健品', 200, 0.30, '上海医药', '2025-01-19 13:20:39', NULL, NULL);
INSERT INTO `druginventory` VALUES (4, 'sdasd', 'sad', 112, 2323.00, 'xxx', '2025-03-05 18:22:08', NULL, NULL);
INSERT INTO `druginventory` VALUES (5, 'asd', 'sss', 11, 11.00, '1x', '2025-03-05 18:23:07', NULL, NULL);
INSERT INTO `druginventory` VALUES (6, '1', 'xc', 2, 232.00, 'xcc', '2025-03-05 18:26:16', NULL, NULL);
INSERT INTO `druginventory` VALUES (7, '2', 'x', 23, 2.00, 'x', '2025-03-05 23:25:53', '2025-03-24', '2025-03-27');
INSERT INTO `druginventory` VALUES (8, '2', 'x', 23, 2.00, 'x', '2025-03-05 23:26:49', '2025-03-24', '2025-03-27');
INSERT INTO `druginventory` VALUES (9, '2', 'x', 22, 22.00, '22', '2025-03-05 23:27:39', '2025-03-04', '2025-03-20');
INSERT INTO `druginventory` VALUES (10, '1', '2', 4, 4.00, '5', '2025-03-06 01:09:03', NULL, NULL);

-- ----------------------------
-- Table structure for financialrecords
-- ----------------------------
DROP TABLE IF EXISTS `financialrecords`;
CREATE TABLE `financialrecords`  (
  `TransactionID` int NOT NULL AUTO_INCREMENT COMMENT '财务记录唯一标识',
  `PatientID` int NULL DEFAULT NULL COMMENT '病人唯一标识（外键）',
  `Amount` decimal(10, 2) NOT NULL COMMENT '金额',
  `TransactionDate` date NULL DEFAULT NULL COMMENT '交易日期',
  `PaymentMethod` enum('现金','银行卡','支付宝') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '支付方式',
  `Description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '描述',
  `PaymentStatus` enum('已支付','未支付') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '未支付' COMMENT '支付状态',
  `OrderNumber` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '订单号',
  PRIMARY KEY (`TransactionID`) USING BTREE,
  INDEX `date`(`TransactionDate` DESC) USING BTREE,
  INDEX `financialrecords_ibfk_1`(`PatientID` ASC) USING BTREE,
  CONSTRAINT `financialrecords_ibfk_1` FOREIGN KEY (`PatientID`) REFERENCES `patients` (`PatientID`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '财务管理表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of financialrecords
-- ----------------------------
INSERT INTO `financialrecords` VALUES (1, 1, 100.00, '2025-01-13', '现金', '挂号费', '已支付', NULL);
INSERT INTO `financialrecords` VALUES (2, 2, 200.00, '2025-01-14', '银行卡', '住院费', '已支付', NULL);
INSERT INTO `financialrecords` VALUES (6, 2, 500.00, '2025-02-06', '支付宝', '挂号费', '已支付', 'alipay:6');
INSERT INTO `financialrecords` VALUES (17, 1, 500.45, '2025-03-08', '现金', 'xx', '已支付', NULL);
INSERT INTO `financialrecords` VALUES (18, 1, 500.00, '2025-03-08', '现金', 'xx', '已支付', NULL);
INSERT INTO `financialrecords` VALUES (19, 1, 500.00, NULL, '现金', 'xx', '未支付', NULL);
INSERT INTO `financialrecords` VALUES (20, 1, 500.00, NULL, '现金', 'xx', '未支付', NULL);
INSERT INTO `financialrecords` VALUES (23, 1, 1.00, NULL, '现金', '1', '未支付', NULL);
INSERT INTO `financialrecords` VALUES (24, 1, 2.00, NULL, '银行卡', '3', '未支付', NULL);
INSERT INTO `financialrecords` VALUES (25, 1, 22.00, NULL, '现金', '2332', '未支付', NULL);
INSERT INTO `financialrecords` VALUES (26, 1, 200.00, '2025-03-08', '支付宝', 'sdaszd', '已支付', 'alipay:26');
INSERT INTO `financialrecords` VALUES (27, 1, 200.00, NULL, '支付宝', 'sdaszd', '未支付', 'alipay:27');
INSERT INTO `financialrecords` VALUES (28, 1, 200.00, NULL, '支付宝', 'sdaszd', '未支付', NULL);
INSERT INTO `financialrecords` VALUES (29, 1, 122.00, NULL, '银行卡', '223', '未支付', NULL);

-- ----------------------------
-- Table structure for financialrecords_drugconsumption_relation
-- ----------------------------
DROP TABLE IF EXISTS `financialrecords_drugconsumption_relation`;
CREATE TABLE `financialrecords_drugconsumption_relation`  (
  `TransactionID` int NOT NULL COMMENT '财务记录唯一标识（外键）',
  `ConsumptionID` int NOT NULL COMMENT '药品消耗唯一标识（外键）',
  PRIMARY KEY (`ConsumptionID`) USING BTREE,
  INDEX `TransactionID`(`TransactionID` ASC) USING BTREE,
  CONSTRAINT `fr_drug_fk1` FOREIGN KEY (`TransactionID`) REFERENCES `financialrecords` (`TransactionID`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `fr_drug_fk2` FOREIGN KEY (`ConsumptionID`) REFERENCES `drugconsumption` (`ConsumptionID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '财务记录与药品消耗关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of financialrecords_drugconsumption_relation
-- ----------------------------
INSERT INTO `financialrecords_drugconsumption_relation` VALUES (1, 34);
INSERT INTO `financialrecords_drugconsumption_relation` VALUES (1, 35);
INSERT INTO `financialrecords_drugconsumption_relation` VALUES (1, 45);
INSERT INTO `financialrecords_drugconsumption_relation` VALUES (1, 46);
INSERT INTO `financialrecords_drugconsumption_relation` VALUES (17, 26);
INSERT INTO `financialrecords_drugconsumption_relation` VALUES (18, 27);

-- ----------------------------
-- Table structure for financialrecords_inpatients_relation
-- ----------------------------
DROP TABLE IF EXISTS `financialrecords_inpatients_relation`;
CREATE TABLE `financialrecords_inpatients_relation`  (
  `TransactionID` int NOT NULL COMMENT '财务记录唯一标识（外键）',
  `InpatientID` int NOT NULL COMMENT '住院唯一标识（外键）',
  PRIMARY KEY (`InpatientID`) USING BTREE,
  INDEX `TransactionID`(`TransactionID` ASC) USING BTREE,
  CONSTRAINT `fr_inpatient_fk1` FOREIGN KEY (`TransactionID`) REFERENCES `financialrecords` (`TransactionID`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `fr_inpatient_fk2` FOREIGN KEY (`InpatientID`) REFERENCES `inpatients` (`InpatientID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '财务记录与住院关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of financialrecords_inpatients_relation
-- ----------------------------
INSERT INTO `financialrecords_inpatients_relation` VALUES (18, 5);

-- ----------------------------
-- Table structure for financialrecords_medicalrecords_relation
-- ----------------------------
DROP TABLE IF EXISTS `financialrecords_medicalrecords_relation`;
CREATE TABLE `financialrecords_medicalrecords_relation`  (
  `TransactionID` int NOT NULL COMMENT '财务记录唯一标识（外键）',
  `RecordID` int NOT NULL COMMENT '病历唯一标识（外键）',
  PRIMARY KEY (`RecordID`) USING BTREE,
  INDEX `TransactionID`(`TransactionID` ASC) USING BTREE,
  CONSTRAINT `fr_medical_fk1` FOREIGN KEY (`TransactionID`) REFERENCES `financialrecords` (`TransactionID`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `fr_medical_fk2` FOREIGN KEY (`RecordID`) REFERENCES `medicalrecords` (`RecordID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '财务记录与病历关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of financialrecords_medicalrecords_relation
-- ----------------------------
INSERT INTO `financialrecords_medicalrecords_relation` VALUES (26, 1);

-- ----------------------------
-- Table structure for hospitalbeds
-- ----------------------------
DROP TABLE IF EXISTS `hospitalbeds`;
CREATE TABLE `hospitalbeds`  (
  `BedID` int NOT NULL AUTO_INCREMENT COMMENT '病床唯一标识',
  `RoomNumber` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '病房号',
  `BedNumber` int NOT NULL COMMENT '床号',
  `BedStatus` enum('空闲','占用','维修中') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '空闲' COMMENT '病床状态',
  `PatientID` int NULL DEFAULT NULL COMMENT '当前占用该床的病人ID',
  `LastUpdated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`BedID`) USING BTREE,
  UNIQUE INDEX `uk_room_bed`(`RoomNumber` ASC, `BedNumber` ASC) USING BTREE,
  INDEX `idx_status`(`BedStatus` ASC) USING BTREE,
  INDEX `idx_patient`(`PatientID` ASC) USING BTREE,
  CONSTRAINT `fk_hospitalbeds_patient` FOREIGN KEY (`PatientID`) REFERENCES `patients` (`PatientID`) ON DELETE SET NULL ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '病床管理表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hospitalbeds
-- ----------------------------
INSERT INTO `hospitalbeds` VALUES (11, '101', 1, '空闲', NULL, '2025-02-24 17:22:14');
INSERT INTO `hospitalbeds` VALUES (12, '101', 2, '维修中', 1, '2025-03-06 18:34:02');
INSERT INTO `hospitalbeds` VALUES (13, '102', 1, '空闲', NULL, '2025-02-24 17:22:14');
INSERT INTO `hospitalbeds` VALUES (14, '102', 2, '维修中', NULL, '2025-02-24 17:22:14');
INSERT INTO `hospitalbeds` VALUES (15, '103', 1, '占用', 2, '2025-02-24 17:22:14');
INSERT INTO `hospitalbeds` VALUES (16, '103', 2, '空闲', NULL, '2025-02-24 17:22:14');
INSERT INTO `hospitalbeds` VALUES (17, '104', 1, '空闲', NULL, '2025-02-24 17:22:14');
INSERT INTO `hospitalbeds` VALUES (18, '104', 2, '占用', 3, '2025-02-24 17:22:14');
INSERT INTO `hospitalbeds` VALUES (19, '105', 1, '空闲', NULL, '2025-02-24 17:22:14');
INSERT INTO `hospitalbeds` VALUES (20, '105', 2, '占用', 4, '2025-02-24 17:22:14');

-- ----------------------------
-- Table structure for inpatients
-- ----------------------------
DROP TABLE IF EXISTS `inpatients`;
CREATE TABLE `inpatients`  (
  `InpatientID` int NOT NULL AUTO_INCREMENT COMMENT '住院唯一标识',
  `PatientID` int NOT NULL COMMENT '病人唯一标识（外键）',
  `AdmissionDate` date NOT NULL COMMENT '入院日期',
  `DischargeDate` date NULL DEFAULT NULL COMMENT '出院日期',
  `RoomNumber` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '病房号',
  `BedNumber` int NOT NULL COMMENT '床号',
  `CurrentStatus` enum('入院','出院','转院') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '入院' COMMENT '当前状态',
  PRIMARY KEY (`InpatientID`) USING BTREE,
  INDEX `idx_patient`(`PatientID` ASC) USING BTREE,
  INDEX `date`(`AdmissionDate` DESC) USING BTREE,
  INDEX `fk_inpatients_bed`(`RoomNumber` ASC, `BedNumber` ASC) USING BTREE,
  CONSTRAINT `fk_inpatients_bed` FOREIGN KEY (`RoomNumber`, `BedNumber`) REFERENCES `hospitalbeds` (`RoomNumber`, `BedNumber`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_inpatients_patient` FOREIGN KEY (`PatientID`) REFERENCES `patients` (`PatientID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '住院管理表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of inpatients
-- ----------------------------
INSERT INTO `inpatients` VALUES (3, 1, '2023-01-01', NULL, '101', 2, '入院');
INSERT INTO `inpatients` VALUES (4, 2, '2023-01-03', NULL, '103', 1, '入院');
INSERT INTO `inpatients` VALUES (5, 3, '2023-01-04', '2023-01-10', '104', 2, '出院');
INSERT INTO `inpatients` VALUES (6, 4, '2023-02-01', NULL, '105', 2, '入院');
INSERT INTO `inpatients` VALUES (7, 5, '2023-02-05', NULL, '102', 1, '入院');
INSERT INTO `inpatients` VALUES (8, 6, '2023-02-10', NULL, '104', 1, '入院');
INSERT INTO `inpatients` VALUES (9, 7, '2023-03-01', NULL, '105', 1, '入院');
INSERT INTO `inpatients` VALUES (10, 8, '2023-03-05', '2023-03-15', '102', 2, '出院');
INSERT INTO `inpatients` VALUES (11, 9, '2023-03-10', NULL, '103', 2, '入院');
INSERT INTO `inpatients` VALUES (14, 1, '2025-03-05', '2025-03-21', '101', 1, '入院');
INSERT INTO `inpatients` VALUES (16, 1, '2025-03-22', '2025-03-03', '101', 1, '入院');

-- ----------------------------
-- Table structure for medicalrecords
-- ----------------------------
DROP TABLE IF EXISTS `medicalrecords`;
CREATE TABLE `medicalrecords`  (
  `RecordID` int NOT NULL AUTO_INCREMENT COMMENT '病历唯一标识',
  `PatientID` int NOT NULL COMMENT '病人唯一标识（外键）',
  `Diagnosis` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '诊断记录',
  `TreatmentPlan` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '治疗计划',
  `TestReports` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '检查报告',
  `RecordDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '病历日期',
  `image_data` json NULL COMMENT '影像数据',
  PRIMARY KEY (`RecordID`) USING BTREE,
  INDEX `PatientID`(`PatientID` ASC) USING BTREE,
  INDEX `date`(`RecordDate` DESC) USING BTREE,
  CONSTRAINT `medicalrecords_ibfk_1` FOREIGN KEY (`PatientID`) REFERENCES `patients` (`PatientID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '病历管理表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of medicalrecords
-- ----------------------------
INSERT INTO `medicalrecords` VALUES (1, 1, '感冒', '多喝水，休息', '血常规正常', '2025-04-01 17:01:22', '{\"data\": [{\"url\": \"https://mf-oss2.oss-cn-guangzhou.aliyuncs.com/mf/images/20250401/1743498080604.jfif\", \"name\": \"OIP (8).jfif\", \"label\": \"\"}]}');
INSERT INTO `medicalrecords` VALUES (2, 1, '贫血', '补铁，改善饮食', '血红蛋白偏低', '2025-04-01 16:29:29', '{\"data\": [{\"url\": \"https://mf-oss2.oss-cn-guangzhou.aliyuncs.com/mf/images/20250308/1741428589531.jfif\", \"name\": \"OIP.jfif\", \"label\": \"23\"}, {\"url\": \"https://mf-oss2.oss-cn-guangzhou.aliyuncs.com/mf/images/20250310/1741590152423.jfif\", \"name\": \"OIP (5).jfif\", \"label\": \"23\"}]}');
INSERT INTO `medicalrecords` VALUES (3, 1, '骨折', '石膏固定', 'X光显示骨裂', '2025-04-01 16:29:32', '{\"data\": [{\"url\": \"https://mf-oss2.oss-cn-guangzhou.aliyuncs.com/mf/images/20250308/1741428569643.jfif\", \"name\": \"下载.jfif\", \"label\": \"00\"}, {\"url\": \"https://mf-oss2.oss-cn-guangzhou.aliyuncs.com/mf/images/20250308/1741428594692.jfif\", \"name\": \"OIP (4).jfif\", \"label\": \"54554\"}]}');

-- ----------------------------
-- Table structure for patients
-- ----------------------------
DROP TABLE IF EXISTS `patients`;
CREATE TABLE `patients`  (
  `PatientID` int NOT NULL AUTO_INCREMENT COMMENT '病人唯一标识',
  `Name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '病人姓名',
  `Gender` enum('男性','女性','其他') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '性别',
  `DateOfBirth` date NOT NULL COMMENT '出生日期',
  `ContactNumber` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系电话',
  `Address` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '地址',
  `EmergencyContact` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '紧急联系人',
  `CreatedAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `id_card_number` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '身份证号',
  `id_card_type` enum('身份证','护照','港澳台证','其他') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '证件类型',
  `id_card_expiry` date NULL DEFAULT NULL COMMENT '证件有效期',
  PRIMARY KEY (`PatientID`) USING BTREE,
  UNIQUE INDEX `id_card_number`(`id_card_number` ASC) USING BTREE,
  INDEX `date`(`PatientID` DESC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '病人信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of patients
-- ----------------------------
INSERT INTO `patients` VALUES (1, '张三', '女性', '1990-05-15', '13800138000', '北京市朝阳区', '13800987654', '2025-01-19 13:20:39', '44010619780410003X', '身份证', NULL);
INSERT INTO `patients` VALUES (2, '李四', '其他', '1985-03-22', '13800238001', '上海市浦东新区', '13800765432', '2025-01-19 13:20:39', 'E12345678', '护照', NULL);
INSERT INTO `patients` VALUES (3, '王五', '男性', '1978-11-10', '13800338002', '广州市天河区', '13800543210', '2025-01-19 13:20:39', '44010619780710003X', '身份证', NULL);
INSERT INTO `patients` VALUES (4, '张伟', '女性', '1985-01-15', '13800138000', '北京市朝阳区', '13900139000', '2025-02-11 16:26:40', '11010119850115001X', '身份证', '2035-01-15');
INSERT INTO `patients` VALUES (5, '李娜', '男性', '1990-03-22', '13800138001', '上海市浦东新区', '13900139001', '2025-02-11 16:26:40', '31011519900322002X', '身份证', '2040-03-22');
INSERT INTO `patients` VALUES (6, '王强', '男性', '1978-07-09', '13800138002', '广州市天河区', '13900139002', '2025-02-11 16:26:40', '44010619780709003X', '身份证', '2028-07-09');
INSERT INTO `patients` VALUES (7, '刘洋', '其他', '1982-11-30', '13800138003', '深圳市南山区', '13900139003', '2025-02-11 16:26:40', '44030519821130004X', '身份证', '2032-11-30');
INSERT INTO `patients` VALUES (8, '陈杰', '男性', '1995-05-18', '13800138004', '杭州市西湖区', '13900139004', '2025-02-11 16:26:40', '33010619950518005X', '身份证', '2045-05-18');
INSERT INTO `patients` VALUES (9, '赵敏', '女性', '1988-08-25', '13800138005', '成都市武侯区', '13900139005', '2025-02-11 16:26:40', '51010719880825006X', '身份证', '2038-08-25');
INSERT INTO `patients` VALUES (10, '孙磊', '女性', '1975-12-12', '13800138006', '武汉市江汉区', '13900139006', '2025-02-11 16:26:40', '42010319751212007X', '身份证', '2025-12-12');
INSERT INTO `patients` VALUES (11, '周婷', '女性', '1992-04-05', '13800138007', '南京市鼓楼区', '13900139007', '2025-02-11 16:26:40', '32010619920405008X', '身份证', '2042-04-05');
INSERT INTO `patients` VALUES (12, '吴刚', '男性', '1980-09-17', '13800138008', '重庆市渝中区', '13900139008', '2025-02-11 16:26:40', '50010319800917009X', '身份证', '2030-09-17');
INSERT INTO `patients` VALUES (13, '郑爽', '女性', '1986-02-28', '13800138009', '天津市和平区', '13900139009', '2025-02-11 16:26:40', '12010119860228010X', '身份证', '2036-02-28');
INSERT INTO `patients` VALUES (14, '何军', '女性', '1993-06-14', '13800138010', '苏州市姑苏区', '13900139010', '2025-02-11 16:26:40', '32050819930614011X', '身份证', '2043-06-14');
INSERT INTO `patients` VALUES (15, '林静', '其他', '1979-10-23', '13800138011', '厦门市思明区', '13900139011', '2025-02-11 16:26:40', '35020319791023012X', '身份证', '2029-10-23');
INSERT INTO `patients` VALUES (16, '高峰', '女性', '1983-03-11', '13800138012', '青岛市市南区', '13900139012', '2025-02-11 16:26:40', '37020219830311013X', '身份证', '2033-03-11');
INSERT INTO `patients` VALUES (17, '郭丽', '男性', '1991-07-19', '13800138013', '大连市中山区', '13900139013', '2025-02-11 16:26:40', '21020219910719014X', '身份证', '2041-07-19');
INSERT INTO `patients` VALUES (18, '马超', '男性', '1977-11-05', '13800138014', '沈阳市和平区', '13900139014', '2025-02-11 16:26:40', '21010219771105015X', '身份证', '2027-11-05');
INSERT INTO `patients` VALUES (19, '罗兰', '男性', '1984-05-22', '13800138015', '长沙市芙蓉区', '13900139015', '2025-02-11 16:26:40', '43010219840522016X', '身份证', '2034-05-22');
INSERT INTO `patients` VALUES (20, '贾鑫', '其他', '1996-08-30', '13800138016', '合肥市庐阳区', '13900139016', '2025-02-11 16:26:40', '34010319960830017X', '身份证', '2046-08-30');
INSERT INTO `patients` VALUES (21, '唐静', '女性', '1981-12-15', '13800138012', '福州市鼓楼区', '13900139017', '2025-02-11 16:26:40', '35010219811215018X', '身份证', '2031-12-15');
INSERT INTO `patients` VALUES (22, '韩磊', '男性', '1987-04-07', '13800138018', '郑州市金水区', '13900139018', '2025-02-11 16:26:40', '41010519870407019X', '身份证', '2037-04-07');
INSERT INTO `patients` VALUES (23, '曹丽', '女性', '1994-09-21', '13800138019', '济南市历下区', '13900139019', '2025-02-11 16:26:40', '37010219940921020X', '身份证', '2044-09-21');
INSERT INTO `patients` VALUES (24, '1', '男性', '2025-02-26', '13000000123', '3', '3', '2025-03-06 15:26:24', '37010219940921021X', '身份证', '2025-03-28');

-- ----------------------------
-- Table structure for rbac_permissions
-- ----------------------------
DROP TABLE IF EXISTS `rbac_permissions`;
CREATE TABLE `rbac_permissions`  (
  `permission_id` int NOT NULL AUTO_INCREMENT COMMENT '权限唯一标识',
  `permission_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '权限名称（例如 View_Orders）',
  `resource` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '权限关联的资源名称（如模块或API）',
  `action` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '操作类型（例如 read, write, delete）',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '权限描述信息',
  PRIMARY KEY (`permission_id`) USING BTREE,
  UNIQUE INDEX `permission_name`(`permission_name` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '权限表，存储系统中的操作权限定义' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rbac_permissions
-- ----------------------------
INSERT INTO `rbac_permissions` VALUES (1, 'View_Orders', '/pms/product/index1', 'read', '查看订单详情');
INSERT INTO `rbac_permissions` VALUES (2, 'Edit_Orders', '/pms/product/index2', 'write', '编辑订单详情');
INSERT INTO `rbac_permissions` VALUES (3, 'Delete_Orders', '/pms/product/index3', 'delete', '删除订单');
INSERT INTO `rbac_permissions` VALUES (4, 'System', '/**', 'all', '全部权限');
INSERT INTO `rbac_permissions` VALUES (5, 'Customer', '/customer/**', 'all', '客户端全部的权限');

-- ----------------------------
-- Table structure for rbac_role_permission_relation
-- ----------------------------
DROP TABLE IF EXISTS `rbac_role_permission_relation`;
CREATE TABLE `rbac_role_permission_relation`  (
  `role_id` int NOT NULL COMMENT '角色唯一标识（外键）',
  `permission_id` int NOT NULL COMMENT '权限唯一标识（外键）',
  PRIMARY KEY (`role_id`, `permission_id`) USING BTREE COMMENT '联合主键：角色与权限的唯一关系',
  INDEX `permission_id`(`permission_id` ASC) USING BTREE,
  CONSTRAINT `rbac_role_permission_relation_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `rbac_roles` (`role_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `rbac_role_permission_relation_ibfk_2` FOREIGN KEY (`permission_id`) REFERENCES `rbac_permissions` (`permission_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色-权限关联表，存储角色与权限的多对多关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rbac_role_permission_relation
-- ----------------------------
INSERT INTO `rbac_role_permission_relation` VALUES (2, 3);
INSERT INTO `rbac_role_permission_relation` VALUES (1, 4);
INSERT INTO `rbac_role_permission_relation` VALUES (4, 5);

-- ----------------------------
-- Table structure for rbac_roles
-- ----------------------------
DROP TABLE IF EXISTS `rbac_roles`;
CREATE TABLE `rbac_roles`  (
  `role_id` int NOT NULL AUTO_INCREMENT COMMENT '角色唯一标识',
  `role_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色名称（例如 Admin, Editor）',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '角色描述信息',
  PRIMARY KEY (`role_id`) USING BTREE,
  UNIQUE INDEX `role_name`(`role_name` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色表，定义系统中的角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rbac_roles
-- ----------------------------
INSERT INTO `rbac_roles` VALUES (1, 'Admin', '系统管理员，拥有所有权限');
INSERT INTO `rbac_roles` VALUES (2, 'Editor', '内容编辑员，拥有编辑权限');
INSERT INTO `rbac_roles` VALUES (3, 'Viewer', '仅拥有查看权限');
INSERT INTO `rbac_roles` VALUES (4, 'Customer', '客户端权限');

-- ----------------------------
-- Table structure for rbac_user_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `rbac_user_role_relation`;
CREATE TABLE `rbac_user_role_relation`  (
  `user_id` int NOT NULL COMMENT '用户唯一标识（外键）',
  `role_id` int NOT NULL COMMENT '角色唯一标识（外键）',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE COMMENT '联合主键：用户与角色的唯一关系',
  INDEX `role_id`(`role_id` ASC) USING BTREE,
  CONSTRAINT `rbac_user_role_relation_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `rbac_users` (`user_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `rbac_user_role_relation_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `rbac_roles` (`role_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户-角色关联表，存储用户与角色的多对多关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rbac_user_role_relation
-- ----------------------------
INSERT INTO `rbac_user_role_relation` VALUES (1, 1);
INSERT INTO `rbac_user_role_relation` VALUES (4, 1);
INSERT INTO `rbac_user_role_relation` VALUES (2, 2);
INSERT INTO `rbac_user_role_relation` VALUES (3, 3);
INSERT INTO `rbac_user_role_relation` VALUES (16, 4);

-- ----------------------------
-- Table structure for rbac_users
-- ----------------------------
DROP TABLE IF EXISTS `rbac_users`;
CREATE TABLE `rbac_users`  (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT '用户唯一标识',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '加密密码',
  `enabled` tinyint(1) NOT NULL DEFAULT 1 COMMENT '用户是否启用（1-启用，0-禁用）',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `username`(`username` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户信息表，存储系统中的用户数据' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rbac_users
-- ----------------------------
INSERT INTO `rbac_users` VALUES (1, 'admin', '$2a$10$95lZ79cnRbwRz7rR7vrWBOpPR2EuU6/GoRzyB54tRS.c1Fb85DNuy', 1, '1970-01-01 00:00:00');
INSERT INTO `rbac_users` VALUES (2, 'editor', '$2a$10$95lZ79cnRbwRz7rR7vrWBOpPR2EuU6/GoRzyB54tRS.c1Fb85DNuy', 1, '1970-01-01 00:00:00');
INSERT INTO `rbac_users` VALUES (3, 'viewer', '$2a$10$rOLp5Q3B8bQGWMR2lldkkuiLaqtcDZRGCvtb4T7RzZDIPHcXQ6Yxu', 1, '1970-01-01 00:00:00');
INSERT INTO `rbac_users` VALUES (4, 'admin1', '$2a$10$X9cJFKTFu0dVKUHC2v2cB.hPd1AGA9b2GHUtKmHwkkiPu6aqzdBkS', 1, '2025-02-10 14:20:27');
INSERT INTO `rbac_users` VALUES (7, 'admin2', '$2a$10$7HtznPYOpU4fvekjLRnNKe0tOK9hpJexI4L/07mbYpMr20jLvx9t2', 1, '2025-02-20 22:37:29');
INSERT INTO `rbac_users` VALUES (8, 'admin3', '$2a$10$ssffdSt4hBuaE/U0WxPuYOtDqx6N8Dy8ZZzfbkHuVupP2DDoFspmW', 1, '2025-02-20 22:47:31');
INSERT INTO `rbac_users` VALUES (9, 'admin4', '$2a$10$BT8C5UUs88Jfl8oEi.O7Z./PRWT0mO3JV0wIDqRFq9xtXIvwd62K2', 1, '2025-02-20 22:50:25');
INSERT INTO `rbac_users` VALUES (16, 'ooo', '$2a$10$NsBqz1saLgWh9YalESGAgOYIDwWrVGNWFHx2isxvHswQFsEGBN.Bq', 1, '2025-04-02 02:03:25');

-- ----------------------------
-- Table structure for space_model_3d_json
-- ----------------------------
DROP TABLE IF EXISTS `space_model_3d_json`;
CREATE TABLE `space_model_3d_json`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '3D模型记录ID',
  `bed_id` int NULL DEFAULT NULL COMMENT '关联病床ID',
  `floor_number` int NOT NULL COMMENT '楼层号',
  `model_data` json NOT NULL COMMENT '存储3D模型的JSON格式数据',
  `created_at` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
  `updated_at` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_model_bed`(`bed_id` ASC) USING BTREE,
  CONSTRAINT `fk_model_bed` FOREIGN KEY (`bed_id`) REFERENCES `hospitalbeds` (`BedID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '存储3D模型JSON数据的表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of space_model_3d_json
-- ----------------------------
INSERT INTO `space_model_3d_json` VALUES (25, NULL, 3, '{\"object\": {\"up\": [0, 1, 0], \"type\": \"Group\", \"uuid\": \"a9bd5cad-b20b-4b37-8a2c-cfffefb6a2b0\", \"layers\": 1, \"matrix\": [1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1], \"children\": [{\"up\": [0, 1, 0], \"type\": \"Mesh\", \"uuid\": \"92aa766f-86cd-41c7-8110-2fe904e1feac\", \"layers\": 1, \"matrix\": [1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 19.903686550465927, -111.4398764930374, -12.224999666214009, 1], \"geometry\": \"55a54394-bb37-4578-ae11-ab3b61c911f2\", \"material\": \"8ef5b70e-7c94-4bc2-83cb-414dc78f5a6b\"}, {\"up\": [0, 1, 0], \"type\": \"Line\", \"uuid\": \"ed2ab5bd-b0a9-4e74-bc68-fed7fe8daa5c\", \"layers\": 1, \"matrix\": [1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1], \"geometry\": \"922d2cee-b108-4de7-bdca-f63756ebb57b\", \"material\": \"7495f0f6-ab16-4cdb-ad61-7fdb235cd811\"}, {\"up\": [0, 1, 0], \"type\": \"Mesh\", \"uuid\": \"ed69534c-1fd4-4ba3-a8b5-3b3bb6435743\", \"layers\": 1, \"matrix\": [0.99492588344538, -0.10061056828335398, 0.0000003617142007125653, 0, -0.10061056828334732, -0.9949258834454456, -0.000000036577871604381507, 0, 0.0000003635589411474247, -6.930700183631523e-17, -0.9999999999999338, 0, 27.839677810668945, -105.6910400390625, -12.22499942779541, 1], \"geometry\": \"0bbc718d-71e0-46e8-92b4-144c8c217062\", \"material\": \"e7c6695a-a5bf-48eb-aa8d-72449f2e34ff\", \"userData\": {\"xx\": 0, \"bed_id\": null, \"selectable\": true}}]}, \"metadata\": {\"type\": \"Object\", \"version\": 4.6, \"generator\": \"Object3D.toJSON\"}, \"materials\": [{\"type\": \"MeshBasicMaterial\", \"uuid\": \"8ef5b70e-7c94-4bc2-83cb-414dc78f5a6b\", \"color\": 16711680, \"blendColor\": 0, \"reflectivity\": 1, \"envMapRotation\": [0, 0, 0, \"XYZ\"], \"refractionRatio\": 0.98}, {\"type\": \"LineBasicMaterial\", \"uuid\": \"7495f0f6-ab16-4cdb-ad61-7fdb235cd811\", \"color\": 16776960, \"blendColor\": 0}, {\"type\": \"MeshBasicMaterial\", \"uuid\": \"e7c6695a-a5bf-48eb-aa8d-72449f2e34ff\", \"color\": 65280, \"opacity\": 0.5, \"blendColor\": 0, \"depthWrite\": false, \"transparent\": true, \"reflectivity\": 1, \"envMapRotation\": [0, 0, 0, \"XYZ\"], \"refractionRatio\": 0.98}], \"geometries\": [{\"type\": \"SphereGeometry\", \"uuid\": \"55a54394-bb37-4578-ae11-ab3b61c911f2\", \"radius\": 0.1, \"phiStart\": 0, \"phiLength\": 6.283185307179586, \"thetaStart\": 0, \"thetaLength\": 3.141592653589793, \"widthSegments\": 5, \"heightSegments\": 5}, {\"data\": {\"attributes\": {\"position\": {\"type\": \"Float32Array\", \"array\": [19.9036865234375, -111.43987274169922, -12.22499942779541, 34.464088439941406, -112.91227722167967, -12.22499942779541, 35.77566909790039, -99.94219970703124, -12.22499942779541, 21.215267181396484, -98.46980285644533, -12.22499942779541, 19.9036865234375, -111.43987274169922, -12.22499942779541], \"itemSize\": 3, \"normalized\": false}}}, \"type\": \"BufferGeometry\", \"uuid\": \"922d2cee-b108-4de7-bdca-f63756ebb57b\"}, {\"type\": \"BoxGeometry\", \"uuid\": \"0bbc718d-71e0-46e8-92b4-144c8c217062\", \"depth\": 4.549999713897721, \"width\": 14.634658825940832, \"height\": 13.036221958430046, \"depthSegments\": 1, \"widthSegments\": 1, \"heightSegments\": 1}]}', '2025-04-17 22:58:23', '2025-04-17 22:58:23');
INSERT INTO `space_model_3d_json` VALUES (27, NULL, 3, '{\"object\": {\"up\": [0, 1, 0], \"type\": \"Group\", \"uuid\": \"2bc0a1d2-f42d-4725-8cfb-f531608d6aa4\", \"layers\": 1, \"matrix\": [1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1], \"children\": [{\"up\": [0, 1, 0], \"type\": \"Mesh\", \"uuid\": \"3d964e05-5878-4a6c-adfc-7f3f6d6bb6e4\", \"layers\": 1, \"matrix\": [1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 46.6727383647699, -116.99389354274902, -12.22499966621402, 1], \"geometry\": \"6eb0d486-51a0-4df4-b5fe-d068855231df\", \"material\": \"d7951b5c-c420-4ae1-87d3-2a5ef459d145\"}, {\"up\": [0, 1, 0], \"type\": \"Line\", \"uuid\": \"149d2d92-f249-47a8-b1a6-0b422d61307c\", \"layers\": 1, \"matrix\": [1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1], \"geometry\": \"e8d543d9-6966-4006-b09f-a5675ce2ce4f\", \"material\": \"489fc78c-1ade-46ce-b143-96dbac877ac3\"}, {\"up\": [0, 1, 0], \"type\": \"Mesh\", \"uuid\": \"f473a112-68eb-4a8c-afb0-6fc9919ae80d\", \"layers\": 1, \"matrix\": [-0.977015808491488, -0.2131668594263528, 0.00000016803246544911264, 0, 0.21316685942634964, -0.9770158084915024, -0.000000036661589985614544, 0, 0.0000001719854110823954, -3.892469764191193e-17, 0.9999999999999852, 0, 49.560516357421875, -109.7076187133789, -12.22499942779541, 1], \"geometry\": \"fe63207b-ab3b-4d3d-a455-1bf4b679b112\", \"material\": \"fa4d801b-03ec-4108-a105-47c2c061ef2a\", \"userData\": {\"xx\": 0, \"bed_id\": null, \"selectable\": true}}]}, \"metadata\": {\"type\": \"Object\", \"version\": 4.6, \"generator\": \"Object3D.toJSON\"}, \"materials\": [{\"type\": \"MeshBasicMaterial\", \"uuid\": \"d7951b5c-c420-4ae1-87d3-2a5ef459d145\", \"color\": 16711680, \"blendColor\": 0, \"reflectivity\": 1, \"envMapRotation\": [0, 0, 0, \"XYZ\"], \"refractionRatio\": 0.98}, {\"type\": \"LineBasicMaterial\", \"uuid\": \"489fc78c-1ade-46ce-b143-96dbac877ac3\", \"color\": 16776960, \"blendColor\": 0}, {\"type\": \"MeshBasicMaterial\", \"uuid\": \"fa4d801b-03ec-4108-a105-47c2c061ef2a\", \"color\": 65280, \"opacity\": 0.5, \"blendColor\": 0, \"depthWrite\": false, \"transparent\": true, \"reflectivity\": 1, \"envMapRotation\": [0, 0, 0, \"XYZ\"], \"refractionRatio\": 0.98}], \"geometries\": [{\"type\": \"SphereGeometry\", \"uuid\": \"6eb0d486-51a0-4df4-b5fe-d068855231df\", \"radius\": 0.1, \"phiStart\": 0, \"phiLength\": 6.283185307179586, \"thetaStart\": 0, \"thetaLength\": 3.141592653589793, \"widthSegments\": 5, \"heightSegments\": 5}, {\"data\": {\"attributes\": {\"position\": {\"type\": \"Float32Array\", \"array\": [46.67273712158203, -116.993896484375, -12.22499942779541, 55.22084045410156, -115.12885284423828, -12.22499942779541, 52.44829177856445, -102.4213409423828, -12.22499942779541, 43.90019226074219, -104.28638458251952, -12.22499942779541, 46.67273712158203, -116.993896484375, -12.22499942779541], \"itemSize\": 3, \"normalized\": false}}}, \"type\": \"BufferGeometry\", \"uuid\": \"e8d543d9-6966-4006-b09f-a5675ce2ce4f\"}, {\"type\": \"BoxGeometry\", \"uuid\": \"fe63207b-ab3b-4d3d-a455-1bf4b679b112\", \"depth\": 4.549999713897721, \"width\": 8.749194145058084, \"height\": 13.00645428128347, \"depthSegments\": 1, \"widthSegments\": 1, \"heightSegments\": 1}]}', '2025-04-17 23:24:40', '2025-04-17 23:24:40');

-- ----------------------------
-- Table structure for user_appointment_relation
-- ----------------------------
DROP TABLE IF EXISTS `user_appointment_relation`;
CREATE TABLE `user_appointment_relation`  (
  `appointment_id` int NOT NULL COMMENT '挂号唯一标识，关联appointments表',
  `user_id` int NOT NULL COMMENT '用户唯一标识，关联rbac_users表',
  PRIMARY KEY (`appointment_id`) USING BTREE,
  UNIQUE INDEX `unique_user_appointment`(`appointment_id` ASC, `user_id` ASC) USING BTREE,
  INDEX `appointment_id`(`user_id` ASC) USING BTREE,
  CONSTRAINT `user_appointment_relation_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `rbac_users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_appointment_relation_ibfk_2` FOREIGN KEY (`appointment_id`) REFERENCES `appointments` (`AppointmentID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户与挂号关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_appointment_relation
-- ----------------------------
INSERT INTO `user_appointment_relation` VALUES (4, 4);
INSERT INTO `user_appointment_relation` VALUES (5, 4);
INSERT INTO `user_appointment_relation` VALUES (14, 4);
INSERT INTO `user_appointment_relation` VALUES (15, 4);

-- ----------------------------
-- Table structure for user_patient_relation
-- ----------------------------
DROP TABLE IF EXISTS `user_patient_relation`;
CREATE TABLE `user_patient_relation`  (
  `user_id` int NOT NULL COMMENT '用户唯一标识，关联rbac_users表',
  `patient_id` int NOT NULL COMMENT '病人唯一标识，关联patients表',
  PRIMARY KEY (`user_id`, `patient_id`) USING BTREE,
  UNIQUE INDEX `unique_user_patient`(`user_id` ASC, `patient_id` ASC) USING BTREE,
  UNIQUE INDEX `unique_user`(`user_id` ASC) USING BTREE,
  UNIQUE INDEX `unique_patient`(`patient_id` ASC) USING BTREE,
  CONSTRAINT `user_patient_relation_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `rbac_users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_patient_relation_ibfk_2` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`PatientID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户与病人关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_patient_relation
-- ----------------------------
INSERT INTO `user_patient_relation` VALUES (4, 1);

-- ----------------------------
-- Table structure for user_profiles
-- ----------------------------
DROP TABLE IF EXISTS `user_profiles`;
CREATE TABLE `user_profiles`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '唯一标识，自动递增主键',
  `user_id` int NOT NULL COMMENT '外键，关联到 users 表的主键，确保每个用户只有一条记录',
  `first_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户的名',
  `last_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户的姓',
  `gender` enum('Male','Female') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '性别（Male：男性，Female：女性）',
  `date_of_birth` date NULL DEFAULT NULL COMMENT '用户的出生日期',
  `profile_picture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像 URL，用户上传的头像图片链接',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户的详细地址',
  `city` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户所在的城市',
  `state` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户所在的省或州',
  `postal_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户的邮政编码',
  `country` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户所在的国家',
  `bio` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '个人简介或自我描述',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建的时间戳',
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录最后更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_id`(`user_id` ASC) USING BTREE,
  CONSTRAINT `fk_user` FOREIGN KEY (`user_id`) REFERENCES `rbac_users` (`user_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '存储用户的扩展信息，包括个人详细资料，如姓名、性别、地址等' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_profiles
-- ----------------------------

-- ----------------------------
-- View structure for view_appointment_details
-- ----------------------------
DROP VIEW IF EXISTS `view_appointment_details`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `view_appointment_details` AS select `a`.`AppointmentID` AS `AppointmentID`,`a`.`AppointmentDate` AS `AppointmentDate`,`a`.`AppointmentSession` AS `AppointmentSession`,`a`.`Status` AS `Status`,`d`.`Name` AS `DoctorsName`,`d`.`Gender` AS `Gender`,`d`.`Department` AS `Department`,row_number() OVER (PARTITION BY `a`.`DoctorID`,`a`.`AppointmentDate`,`a`.`AppointmentSession` ORDER BY `a`.`CreatedAt` )  AS `number` from (`appointments` `a` join `doctors` `d` on((`a`.`DoctorID` = `d`.`DoctorID`)));

-- ----------------------------
-- View structure for view_bed_usage
-- ----------------------------
DROP VIEW IF EXISTS `view_bed_usage`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `view_bed_usage` AS select (select count(0) from `hospitalbeds`) AS `总床位数`,(select count(0) from `hospitalbeds` where (`hospitalbeds`.`BedStatus` = '占用')) AS `占用床位数`,round((((select count(0) from `hospitalbeds` where (`hospitalbeds`.`BedStatus` = '占用')) / (select count(0) from `hospitalbeds`)) * 100),2) AS `床位使用率`;

-- ----------------------------
-- View structure for view_daily_quantity_change
-- ----------------------------
DROP VIEW IF EXISTS `view_daily_quantity_change`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `view_daily_quantity_change` AS with `drug_cte` as (select cast(`fr`.`TransactionDate` as date) AS `统计日期`,`dc`.`QuantityUsed` AS `QuantityUsed`,`fr`.`Amount` AS `Amount`,row_number() OVER (PARTITION BY `fr`.`TransactionID` ORDER BY `fdr`.`ConsumptionID` )  AS `rn` from ((`financialrecords` `fr` join `financialrecords_drugconsumption_relation` `fdr` on((`fr`.`TransactionID` = `fdr`.`TransactionID`))) join `drugconsumption` `dc` on((`fdr`.`ConsumptionID` = `dc`.`ConsumptionID`))) where (`fr`.`PaymentStatus` = '已支付')), `inpatient_cte` as (select cast(`fr`.`TransactionDate` as date) AS `统计日期`,(case when (`i`.`CurrentStatus` = '入院') then 1 when (`i`.`CurrentStatus` in ('出院','转院')) then -(1) else 0 end) AS `qty`,`fr`.`Amount` AS `Amount`,row_number() OVER (PARTITION BY `fr`.`TransactionID` ORDER BY `fir`.`InpatientID` )  AS `rn` from ((`financialrecords` `fr` join `financialrecords_inpatients_relation` `fir` on((`fr`.`TransactionID` = `fir`.`TransactionID`))) join `inpatients` `i` on((`fir`.`InpatientID` = `i`.`InpatientID`))) where (`fr`.`PaymentStatus` = '已支付')), `outpatient_cte` as (select cast(`fr`.`TransactionDate` as date) AS `统计日期`,count(`mr`.`RecordID`) AS `qty`,`fr`.`Amount` AS `Amount`,row_number() OVER (PARTITION BY `fr`.`TransactionID` ORDER BY min(`fmr`.`RecordID`) )  AS `rn` from ((`financialrecords` `fr` join `financialrecords_medicalrecords_relation` `fmr` on((`fr`.`TransactionID` = `fmr`.`TransactionID`))) join `medicalrecords` `mr` on((`fmr`.`RecordID` = `mr`.`RecordID`))) where (`fr`.`PaymentStatus` = '已支付') group by `fr`.`TransactionID`,cast(`fr`.`TransactionDate` as date),`fr`.`Amount`) select `drug_cte`.`统计日期` AS `统计日期`,'药品' AS `类别`,sum(`drug_cte`.`QuantityUsed`) AS `数量变化`,sum((case when (`drug_cte`.`rn` = 1) then `drug_cte`.`Amount` else 0 end)) AS `日收入` from `drug_cte` group by `drug_cte`.`统计日期` union all select `inpatient_cte`.`统计日期` AS `统计日期`,'住院' AS `类别`,sum(`inpatient_cte`.`qty`) AS `数量变化`,sum((case when (`inpatient_cte`.`rn` = 1) then `inpatient_cte`.`Amount` else 0 end)) AS `日收入` from `inpatient_cte` group by `inpatient_cte`.`统计日期` union all select `outpatient_cte`.`统计日期` AS `统计日期`,'门诊' AS `类别`,sum(`outpatient_cte`.`qty`) AS `数量变化`,sum((case when (`outpatient_cte`.`rn` = 1) then `outpatient_cte`.`Amount` else 0 end)) AS `日收入` from `outpatient_cte` group by `outpatient_cte`.`统计日期` order by `统计日期`,`类别`;

-- ----------------------------
-- View structure for view_key_metrics
-- ----------------------------
DROP VIEW IF EXISTS `view_key_metrics`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `view_key_metrics` AS select (select count(0) from `medicalrecords` where ((year(`medicalrecords`.`RecordDate`) = year(curdate())) and (month(`medicalrecords`.`RecordDate`) = month(curdate())))) AS `本月门诊量`,(select count(0) from `inpatients` where ((year(`inpatients`.`AdmissionDate`) = year(curdate())) and (month(`inpatients`.`AdmissionDate`) = month(curdate())))) AS `住院人次`,(select round((sum(`financialrecords`.`Amount`) / 10000),2) from `financialrecords` where ((year(`financialrecords`.`TransactionDate`) = year(curdate())) and (month(`financialrecords`.`TransactionDate`) = month(curdate())) and (`financialrecords`.`PaymentStatus` = '已支付'))) AS `总收入(万元)`;

-- ----------------------------
-- View structure for view_monthly_revenue_trend
-- ----------------------------
DROP VIEW IF EXISTS `view_monthly_revenue_trend`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `view_monthly_revenue_trend` AS select date_format(`financialrecords`.`TransactionDate`,'%Y-%m') AS `月份`,sum(`financialrecords`.`Amount`) AS `月收入` from `financialrecords` where (`financialrecords`.`PaymentStatus` = '已支付') group by date_format(`financialrecords`.`TransactionDate`,'%Y-%m') order by `月份`;

-- ----------------------------
-- View structure for view_outpatient_trend
-- ----------------------------
DROP VIEW IF EXISTS `view_outpatient_trend`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `view_outpatient_trend` AS select cast(`medicalrecords`.`RecordDate` as date) AS `日期`,count(0) AS `门诊量` from `medicalrecords` group by cast(`medicalrecords`.`RecordDate` as date) order by cast(`medicalrecords`.`RecordDate` as date);

-- ----------------------------
-- View structure for view_revenue_composition
-- ----------------------------
DROP VIEW IF EXISTS `view_revenue_composition`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `view_revenue_composition` AS select `t`.`RevenueType` AS `收入类型`,sum(`t`.`TotalAmount`) AS `收入金额` from (select `fr`.`TransactionID` AS `TransactionID`,`fr`.`Amount` AS `TotalAmount`,(case when exists(select 1 from `financialrecords_drugconsumption_relation` `fdr` where (`fr`.`TransactionID` = `fdr`.`TransactionID`)) then '药品' when exists(select 1 from `financialrecords_inpatients_relation` `fir` where (`fr`.`TransactionID` = `fir`.`TransactionID`)) then '住院' when exists(select 1 from `financialrecords_medicalrecords_relation` `fmr` where (`fr`.`TransactionID` = `fmr`.`TransactionID`)) then '门诊' else '其它' end) AS `RevenueType` from `financialrecords` `fr` where (`fr`.`PaymentStatus` = '已支付')) `t` group by `t`.`RevenueType`;

SET FOREIGN_KEY_CHECKS = 1;
