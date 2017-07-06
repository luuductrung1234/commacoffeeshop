CREATE DATABASE COMMACOFFEESHOP
GO

USE COMMACOFFEESHOP
GO

-- EMPLOYEE
create table tbAdmin (
	ad_id varchar(20) not null			constraint pk_adminid primary key ,
	pass varchar(30) not null,
	name nvarchar(50) not null,
	ad_role int not null				constraint chk_adminrole check(ad_role >= 0 and ad_role <= 10)   -- cấp độ càng cao càng nhiều quyền truy cập dữ liệu
)
go

create table tbEmployee (
	em_id varchar(20) not null			constraint pk_emid primary key,
	pass varchar(30) not null,
	name varchar(50) not null,
	age int null,
	startday date not null,
	addr varchar(50) null,
	email varchar(50) null,
	phone varchar(12) null,
	em_role int	not null				constraint chk_employeerole check(em_role = 1 or em_role = 2),   -- 1: nhân viên quầy nước, 2: nhân viên bếp
	manager varchar(20) not null		constraint fk_manager foreign key references tbAdmin(ad_id)
)
go


create table tbEmpSchedule(
	sche_id varchar(10)			constraint pk_scheid primary key,
	em_id varchar(20)			constraint fk_employee foreign key references tbEmployee(em_id),
	workday date				constraint def_workday default getdate(),
	starthour int not null		constraint chk_starthour check(starthour >= 8 and starthour <= 22),
	startminute int not null	constraint chk_startminute check(startminute >= 0 and startminute <= 59),
	endhour int not null		constraint chk_endhour check(endhour >= 8 and endhour <= 22),
	endminute int not null		constraint chk_endminute check(endminute >= 0 and endminute <= 59)
)
go
-- END EMPLOYEE


-- CUSTOMER
create table tbCustomer(
	cus_id varchar(10)				constraint pk_customerid primary key,
	name varchar(40) not null,
	dis_percent int not null		constraint chk_discount_percent check (dis_percent >= 0 and dis_percent <= 100)
)
go
-- CUSTOMER


-- INVENTORY
create table tbFood(
	food_id varchar(10)				constraint pk_menufoodid primary key,
	name varchar(50) not null,
	info varchar(100) not null,
	price money not null,
	isdrink tinyint not null		constraint chk_isdrink_or_eat check (isdrink = 1 or isdrink = 0)     -- 1: thức ăn, 0: thức uống
)
go

create table tbFoodMaterial (
	fm_id varchar(10) not null			constraint pk_itemfoodid primary key,
	name varchar(50) not null,
	info varchar(100) null,
	isfordrink tinyint not null			constraint chk_ismaterial_fordrink_or_eat check (isfordrink = 1 or isfordrink = 0 or isfordrink = 2),     	-- 1: nguyên liệu thức ăn, 0: nguyên liệu thức uống, 2: không sử dụng theo khối lượng (vd: ly chén đĩa,...)
	kind varchar(20) not null,
	unit_buy varchar(100) not null,
	weight_unit_buy float not null,
	price_unit_buy int not null,
	stock_weight float not null,
	fm_status tinyint not null		constraint chk_status_of_stock check(fm_status = 1 or fm_status = 5 or fm_status = 10),	-- 1: sắp hết, 5: còn không nhiều, 10: còn nhiều
	supply_contact varchar(100) null
)
go


create table tbFoodDetails(
	fd_id varchar(10) not null		constraint pk_fooddetails primary key,
	food_id varchar(10) not null	constraint fk_foodid foreign key references tbFood(food_id),
	fm_id varchar(10) not null		constraint fk_foodmaterialid foreign key references tbFoodMaterial(fm_id),
	quan float not null				constraint chk_use_quantity check(quan >= 0),
	unit_use varchar(100) not null,
	weight_unit_use float not null
)
go

-- END INVENTORY


-- INCOME
create table tbOrder (
	order_id varchar(10) not null	constraint pk_orderid primary key,
	cus_id varchar(10)				constraint fk_customerdiscount foreign key references tbCustomer(cus_id),
	ordertable int not null,               -- số bàn
	ordertime date not null,               -- thời gian order
	price money not null,
	customerpay money not null,
	payback money not null
)
go

create table tbOrderDetails(
	order_id varchar(10) not null		constraint fk_order foreign key references tbOrder(order_id),
	food_id varchar(10) not null		constraint fk_foodinmenu foreign key references tbFood(food_id),
										constraint pk_orderdetails primary key (order_id, food_id),
	quan int not null					constraint chk_order_quantity check(quan >= 0),
	fail_quan int not null				constraint chk_fail_quantity check(fail_quan >= 0)
)
go
-- END INCOME



-- EXPOSE
create table tbBuyMaterial(
	bm_id varchar(10)		constraint pk_buymaterialid primary key,
	em_id varchar(20)		constraint fk_employee_buy foreign key references tbEmployee(em_id),
	daybuy date not null,													-- ngày nhập kho
	payment money not null	constraint chk_payment check(payment >= 0),     -- số tiền chi
)
go

create table tbBuyMaterialDetails(
	bm_id varchar(10)		constraint fk_buymaterial foreign key references tbBuyMaterial(bm_id),
	fm_id varchar(10)		constraint fk_foodmaterial foreign key references tbFoodMaterial(fm_id),
							constraint pk_buymaterialdetails primary key (bm_id, fm_id),
	quan int not null		constraint chk_buy_quantity check(quan >= 0),
	extra_info varchar(100) null
)
go

create table tbSalaryPay(
	sp_id varchar(10)		constraint pk_salarypayid primary key,
	em_id varchar(20)		constraint fk_employee_receive foreign key references tbEmployee(em_id),
	date_pay date null,                                                 -- ngày trả lương
	salary_value money not null,                                         -- số tiền lương
	work_hour int not null	constraint chk_workhour check(work_hour >= 0),
	for_month int not null		constraint chk_month check(for_month >= 1 and for_month <= 12),
	for_year int not null,			-- lương của tháng/năm nào
	is_paid tinyint not null	constraint chk_is_salary_was_paid check(is_paid = 0 or is_paid = 1),		-- 1: đã trả lương, 0: chưa trả lương
)
go
-- END EXPOSE

-- chỉnh sửa

alter table tbEmpSchedule
add result_pay varchar(10)	constraint fk_result_salarypay foreign key references tbSalaryPay(sp_id)		-- tham chiếu đến bảng lương để trả kết quả lương của lịch làm trong 1 ngày
go

-- kết thúc chỉnh sửa


insert into tbAdmin values
('admin_username1', 'password1', 'Ricky Park', 9),
('admin_username2', 'password2', 'Tôn Thất Vĩnh', 9),
('admin_username3', 'password3', 'Lưu Đức Trung', 10)
go


insert into tbEmployee values
('emp_username1', 	'password1',	'Phạm Thanh Bình', 		20,	'2017/07/01',	'KTX trường Tôn Đức Thắng',						'example_email1@gmail.com',		'0969876940',	1,	'admin_username1'),
('emp_username2', 	'password2',	'Nguyễn Khánh Duy', 	19,	'2017/07/01',	'KTX trường Tôn Đức Thắng',						'example_email2@gmail.com',		'0964753827',	1,	'admin_username1'),
('emp_username3', 	'password3',	'Lý Đông Nghi', 		19,	'2017/07/01',	'19 Nguyễn Hữu Thọ, Tân Phong, Quận 7',			'example_email3@gmail.com',		'01677048100',	1,	'admin_username1'),
('emp_username4', 	'password4',	'Bảo Nguyên', 			21,	'2017/07/01',	'1017/34 Lê Văn Lương, Phước Kiển, Nhà Bè',		'example_email4@gmail.com',		'0965164474',	1,	'admin_username1'),
('emp_username5', 	'password5',	'Lương Nhật Duy', 		21,	'2017/07/01',	'10/7 Lý Phục Mang, Quận 7',					'desmonmiles8996@gmail.com',	'01215925627',	1,	'admin_username1'),
('emp_username6', 	'password6',	'Đinh Thanh Hưng', 		20,	'2017/07/01',	'1558A phường 7, Quận 8',						'example_email5@gmail.com',		'01207305775',	1,	'admin_username1'),
('emp_username7', 	'password7',	'Ngọc Phấn', 			22,	'2017/07/01',	'585 Nguyễn Hữu Thọ, phường Tân Phong, Quận 7',	'example_email6@gmail.com',		'01242095099',	1,	'admin_username1'),
('emp_username8', 	'password8',	'Hữu Phát', 			20,	'2017/07/01',	'19 Nguyễn Hữu Thọ, Tân Phong, Quận 7',			'example_email7@gmail.com',		'01663598586',	1,	'admin_username1'),
('emp_username9', 	'password9',	'Phan Việt Nhân', 		21,	'2017/07/01',	'19 Nguyễn Hữu Thọ, Tân Phong, Quận 7',			'example_email8@gmail.com',		'0916466886',	1,	'admin_username1'),
('emp_username10', 	'password10',	'Nguyễn Thị Diễm My', 	19,	'2017/07/01',	'19 Nguyễn Hữu Thọ, Tân Phong, Quận 7',			'example_email9@gmail.com',		'0973035001',	1,	'admin_username1'),
('emp_username11', 	'password11',	'Phan Thanh Hằng', 		19,	'2017/07/01',	'599 Lê Văn Lương, Quận 7',						'example_email10@gmail.com',	'0948846462',	1,	'admin_username1'),
('emp_username12', 	'password12',	'Đặng Anh Thư', 		21,	'2017/07/01',	'41  Bùi Huy Bích, phường 12, Quận 8',			'example_email11@gmail.com',	'01216956119',	1,	'admin_username1'),
('emp_username13', 	'password13',	'Hà Nguyễn Nhật Minh', 	20,	'2017/07/01',	'122/27/30/1/2 Tôn Đản, phường 10, Quận 4',		'nhatminh157@yahoo.com.vn',		'01208459569',	1,	'admin_username1'),
('emp_username14', 	'password14',	'Phan Hữu Tiến', 		19,	'2017/07/01',	'458/10/2 Huỳnh Tấn Phát, Quận 7',				'example_email12.@gmail.com',	'0902448327',	1,	'admin_username1'),
('emp_username15', 	'password15',	'Ngô Thanh Hiếu', 		20,	'2017/07/01',	'KTX trường Tôn Đức Thắng',						'ngohieu2698@gmail.com',		'0969945661',	2,	'admin_username2')
go


insert into tbCustomer values
('CUS0000001', 'Lưu Đức Trung',			20),
('CUS0000002', 'Phạm Thanh Bình',		20),
('CUS0000003', 'Nguyễn Khánh Duy',		20),
('CUS0000004', 'Lý Đông Nghi',			20),
('CUS0000005', 'Bảo Nguyên',			20),
('CUS0000006', 'Lương Nhật Duy',		20),
('CUS0000007', 'Đinh Thanh Hưng',		20),
('CUS0000008', 'Ngọc Phấn',				20),
('CUS0000009', 'Hữu Phát',				20),
('CUS0000010', 'Phan Việt Nhân',		20),
('CUS0000011', 'Nguyễn Thị Diễm My',	20),
('CUS0000012', 'Phan Thanh Hằng',		20),
('CUS0000013', 'Đặng Anh Thư',			20),
('CUS0000014', 'Hà Nguyễn Nhật Minh',	20),
('CUS0000015', 'Phan Hữu Tiến',			20),
('CUS0000016', 'Ngô Thanh Hiếu',		20)
go


insert into tbFoodMaterial values
('FM00000001',	'pepsi', 					'',											0,	'dry',			'thùng',	7920,	0,	0,	1,	'chị Kiều: 01648360321'),
('FM00000002',	'aquafina', 				'',											0,	'dry',			'thùng',	12000,	0,	0,	1,	'chị Kiều: 01648360321'),
('FM00000003',	'7up', 						'',											0,	'dry',			'thùng',	7920,	0,	0,	1,	'chị Kiều: 01648360321'),
('FM00000004',	'water bottle (big)', 		'',											0,	'dry',			'bình',		20000,	0,	0,	1,	'0836026692'),
('FM00000005',	'Coffee Bean', 				'',											0,	'dry',			'kí',		1000,	0,	0,	1,	'mr Vĩnh'),
('FM00000006',	'Trung Nguyen coffee S', 	'pha phin ra thành café nước (bịch 500g)',	0,	'dry',			'bịch',		3150,	0,	0,	1,	'Coopxtra (2nd floor)'),
('FM00000007',	'Dalat milk', 				'',											0,	'dairy',		'hộp',		950,	0,	0,	1,	'ms.Huyen: 0933336118'),
('FM00000008',	'Dutch Lady milk', 			'',											0,	'dairy',		'hộp',		1000,	0,	0,	1,	'Chợ Tân Mỹ, Red Dragon Fly shop'),
('FM00000009',	'Condense milk', 			'',											0,	'dairy',		'hộp',		1284,	0,	0,	1,	'Chợ Tân Mỹ, Red Dragon Fly shop'),
('FM00000010',	'Soda', 					'',											0,	'dry',			'thùng',	7920,	0,	0,	1,	'Chợ Tân Mỹ, Red Dragon Fly shop'),
('FM00000011',	'Whipping cream', 			'',											0,	'dairy',		'hộp',		1000,	0,	0,	1,	'Coopxtra (3nd floor)'),
('FM00000012',	'Cream cheese', 			'',											0,	'dairy',		'hộp',		200,	0,	0,	1,	'Coopxtra (3nd floor)'),
('FM00000013',	'Milk Tea Powder', 			'',											0,	'dry',			'hộp',		408,	0,	0,	1,	'Coopxtra (2nd floor)'),
('FM00000014',	'Matcha Tea Powder', 		'',											0,	'dry',			'hộp',		408,	0,	0,	1,	'Coopxtra (2nd floor)'),
('FM00000015',	'Durian coffee Powder', 	'',											0,	'dry',			'hộp',		216,	0,	0,	1,	'Lotte Mart'),
('FM00000016',	'Peach Tea Bag(cozy)', 		'',											0,	'dry',			'hộp',		50,		25,	0,	1,	'Coopxtra (2nd floor)'),
('FM00000017',	'Strawberry Tea Bag(cozy)', '',											0,	'dry',			'hộp',		50,		25,	0,	1,	'Lotte Mart'),
('FM00000018',	'Apple Tea bag(cozy)', 		'',											0,	'dry',			'hộp',		50,		25,	0,	1,	'Coopxtra (2nd floor)'),
('FM00000019',	'Lemon Tea bag(cozy)', 		'',											0,	'dry',			'hộp',		50,		25,	0,	1,	'Coopxtra (2nd floor)'),
('FM00000020',	'Cacao Powder', 			'',											0,	'dry',			'bịch',		1000,	0,	0,	1,	'Ham Nghi'),
('FM00000021',	'sugar (bar)', 				'',											0,	'dry',			'kí',		1000,	0,	0,	1,	'grocery'),
('FM00000022',	'Icing sugar', 				'',											0,	'dry',			'kí',		1000,	0,	0,	1,	'Ham Nghi'),
('FM00000023',	'Peach Can', 				'hộp đào xài cả cái lẫn nước (820/470)',	0,	'dry',			'lon',		470,	0,	0,	1,	'0906677787'),
('FM00000024',	'Mandarin orange Can', 		'hộp cam lấy chỉ lấy cái bỏ nước',			0,	'dry',			'lon',		172,	0,	0,	1,	'Ham Nghi'),
('FM00000028',	'Mint leaf', 				'',											0,	'vegetable',	'kí',		1000,	0,	0,	1,	'Super market or coopxtra'),
('FM00000029',	'Blue curacao syrup', 		'',											0,	'dry',			'chai',		700,	0,	0,	1,	'0906677787'),
('FM00000030',	'Peach syrup', 				'',											0,	'dry',			'chai',		700,	0,	0,	1,	'0906677787'),
('FM00000031',	'Ginger honey sauce', 		'',											0,	'dry',			'bình',		1000,	0,	0,	1,	'Skymart 0854101219 save point (0751)'),
('FM00000032',	'Ketchup (bar)', 			'',											0,	'dry',			'chai',		2100,	0,	0,	1,	'Coopxtra (3nd floor)'),
('FM00000033',	'Chilli sauce (bar)',		'',											0,	'dry',			'chai',		2100,	0,	0,	1,	'Coopxtra (3nd floor)'),
('FM00000027',	'Lemon', 					'',											2,	'vegetable',	'trái',		1,		0,	0,	1,	'Super market or coopxtra'),
('FM00000025',	'Yellow orange', 			'',											2,	'vegetable',	'trái',		1,		0,	0,	1,	'Queenland Mart'),
('FM00000026',	'Green orange', 			'',											2,	'vegetable',	'trái',		1,		0,	0,	1,	'Super market or Tien Staff or,….'),
('FM00000034',	'ice', 						'',											2,	'dry',			'bịch',		1,		0,	0,	1,	'01645422630'),
('FM00000035',	'Plastic cup', 				'tính theo cái không tính theo khối lượng',	2,	'daily goods',	'lóc',		1,		0,	0,	1,	'Son staff : 01264463379'),
('FM00000036',	'Plastic cover', 			'tính theo cái không tính theo khối lượng',	2,	'daily goods',	'lóc',		1,		0,	0,	1,	'Son staff : 01264463379'),
('FM00000037',	'Paper cup', 				'tính theo cái không tính theo khối lượng',	2,	'daily goods',	'lóc',		1,		0,	0,	1,	'Son staff : 01264463379'),
('FM00000038',	'Black cover', 				'tính theo cái không tính theo khối lượng',	2,	'daily goods',	'lóc',		1,		0,	0,	1,	'Son staff : 01264463379'),
('FM00000039',	'Straw', 					'tính theo cái không tính theo khối lượng',	2,	'daily goods',	'lóc',		1,		0,	0,	1,	'Son staff : 01264463379'),
('FM00000040',	'Toilet paper', 			'tính theo cái không tính theo khối lượng',	2,	'daily goods',	'cuộn',		1,		0,	0,	1,	'Coopxtra (2nd floor)'),
('FM00000041',	'Napkin', 					'tính theo cái không tính theo khối lượng',	2,	'daily goods',	'lóc',		1,		0,	0,	1,	'Coopxtra (2nd floor)'),
('FM00000042',	'Aroma', 					'tính theo cái không tính theo khối lượng',	2,	'daily goods',	'bình',		1,		0,	0,	1,	'Lazada'),
('FM00000043',	'Trash bag', 				'tính theo cái không tính theo khối lượng',	2,	'daily goods',	'cuộn',		1,		0,	0,	1,	'Coopxtra (2nd floor)'),
('FM00000044',	'Print paper', 				'tính theo cái không tính theo khối lượng',	2,	'daily goods',	'cuộn',		1,		0,	0,	1,	'maybanhang.net staff: 0912700646'),
('FM00000045',	'Bag T', 					'tính theo cái không tính theo khối lượng',	2,	'daily goods',	'lóc',		1,		0,	0,	1,	'Lesable'),
('FM00000088',	'Chocalate bar',			'',											1,	'dry',			'kí',		1000,	0,	0,	1,	'mr Vĩnh')									
go


insert into tbFood values
('F000000030',	'pepsi',					'',		25,		0),
('F000000031',	'7up',						'',		25,		0),
('F000000032',	'water',					'',		25,		0),
('F000000033',	'black coffee',				'',		30,		0),
('F000000034',	'coffee milk',				'',		35,		0),
('F000000035',	'cream coffee',				'',		40,		0),
('F000000036',	'americano',				'',		40,		0),
('F000000037',	'durian coffee',			'',		50,		0),
('F000000038',	'coffee latte',				'',		50,		0),
('F000000039',	'cappucino',				'',		50,		0),
('F000000040',	'orange coffee',			'',		50,		0),
('F000000041',	'tiramisu coffee',			'',		50,		0),
('F000000042',	'chocolate coffee',			'',		60,		0),
('F000000043',	'caramel cofffee',			'',		60,		0),
('F000000044',	'strawberry tea',			'',		30,		0),
('F000000045',	'lemon tea',				'',		30,		0),
('F000000046',	'apple tea',				'',		30,		0),
('F000000047',	'milk tea',					'',		40,		0),
('F000000048',	'peach tea',				'',		50,		0),
('F000000049',	'matcha latte',				'',		50,		0),
('F000000050',	'ginger honey latte',		'',		50,		0),
('F000000051',	'hot choco',				'',		60,		0),
('F000000052',	'ice choco',				'',		60,		0),
('F000000053',	'orange juice (trái nhỏ)',	'',		40,		0),
('F000000054',	'orange ade',				'',		40,		0),
('F000000055',	'lemonade',					'',		40,		0),
('F000000056',	'orange juice (trái lớn)',	'',		40,		0),
('F000000057',	'orange juice (trái vừa)',	'',		40,		0)
go


insert into tbFoodDetails values
('FD00000001', 'F000000030',	'FM00000001',	1,		'chai',				330),
('FD00000002', 'F000000031',	'FM00000002',	1,		'chai',				330),
('FD00000003', 'F000000032',	'FM00000003',	1,		'chai',				330),
('FD00000004', 'F000000033',	'FM00000006',	1,		'lần',				50),
('FD00000005', 'F000000033',	'FM00000021',	1,		'lần dường',		3.3),
('FD00000006', 'F000000034',	'FM00000006',	1,		'lần',				40),
('FD00000007', 'F000000034',	'FM00000009',	1,		'lần',				20),
('FD00000008', 'F000000035',	'FM00000006',	1,		'lần',				40),
('FD00000009', 'F000000035',	'FM00000007',	1,		'milkF',			240),
('FD00000010', 'F000000035',	'FM00000021',	2,		'lần đường',		3.3),
('FD00000011', 'F000000035',	'FM00000022',	1,		'lần',				10),
('FD00000012', 'F000000036',	'FM00000005',	1,		'shot',				17),
('FD00000013', 'F000000036',	'FM00000021',	1,		'lần đường',		3.3),
('FD00000014', 'F000000037',	'FM00000007',	1,		'Milk(1Cup)',		120),
('FD00000015', 'F000000037',	'FM00000009',	1,		'lần',				10),
('FD00000016', 'F000000037',	'FM00000015',	1,		'gói',				18),
('FD00000017', 'F000000038',	'FM00000005',	1,		'shot',				17),
('FD00000018', 'F000000038',	'FM00000007',	1,		'Milk(1Cup)',		120),
('FD00000019', 'F000000038',	'FM00000021',	2,		'lần dường',		3.3),
('FD00000020', 'F000000039',	'FM00000005',	1,		'shot',				17),
('FD00000021', 'F000000039',	'FM00000007',	1,		'Milk(1Cup)',		120),
('FD00000022', 'F000000039',	'FM00000021',	2,		'lần đường',		3.3),
('FD00000023', 'F000000042',	'FM00000005',	2,		'shot',				17),
('FD00000024', 'F000000042',	'FM00000007',	1,		'Milk(1Cup)',		120),
('FD00000025', 'F000000042',	'FM00000021',	3,		'lần đường',		3.3),
('FD00000026', 'F000000042',	'FM00000007',	1,		'nl choco',			24),
('FD00000027', 'F000000042',	'FM00000021',	1,		'nl choco',			4),
('FD00000028', 'F000000042',	'FM00000088',	1,		'nl choco',			16),
('FD00000029', 'F000000043',	'FM00000005',	1,		'shot',				17),
('FD00000030', 'F000000043',	'FM00000007',	1,		'Milk(1Cup)',		120),
('FD00000031', 'F000000043',	'FM00000021',	3,		'lần đường',		3.3),
('FD00000032', 'F000000043',	'FM00000021',	1,		'nl caramel',		15),
('FD00000033', 'F000000040',	'FM00000005',	1,		'shot',				17),
('FD00000034', 'F000000040',	'FM00000007',	1,		'Milk(1Cup)',		120),
('FD00000035', 'F000000040',	'FM00000021',	2,		'lần đường',		3.3),
('FD00000036', 'F000000040',	'FM00000024',	1,		'phần cam miếng',	30),
('FD00000037', 'F000000040',	'FM00000007',	0.5,	'milkF',			240),
('FD00000038', 'F000000041',	'FM00000005',	1,		'shot',				17),
('FD00000039', 'F000000041',	'FM00000007',	1,		'Milk(1Cup)',		120),
('FD00000040', 'F000000041',	'FM00000020',	1,		'lần',				10),
('FD00000041', 'F000000041',	'FM00000021',	2,		'lần đường',		3.3),
('FD00000042', 'F000000041',	'FM00000022',	1,		'lần',				5),
('FD00000043', 'F000000041',	'FM00000007',	0.5,	'milkF',			240),
('FD00000044', 'F000000041',	'FM00000011',	1,		'nl tiramisu',		60),
('FD00000045', 'F000000041',	'FM00000012',	1,		'nl tiramisu',		30),
('FD00000046', 'F000000041',	'FM00000021',	6,		'lần/nl tiramisu',	3.3),
('FD00000047', 'F000000044',	'FM00000017',	1,		'túi lọc',			2),
('FD00000048', 'F000000044',	'FM00000021',	1,		'lần đường',		3.3),
('FD00000049', 'F000000045',	'FM00000019',	1,		'túi lọc',			2),
('FD00000050', 'F000000045',	'FM00000021',	1,		'lần đường',		3.3),
('FD00000051', 'F000000046',	'FM00000018',	1,		'túi lọc',			2),
('FD00000052', 'F000000046',	'FM00000021',	1,		'lần đường',		3.3),
('FD00000053', 'F000000047',	'FM00000009',	1,		'lần',				15),
('FD00000054', 'F000000047',	'FM00000013',	1.5,	'gói',				17),
('FD00000055', 'F000000048',	'FM00000016',	1,		'gói',				2),
('FD00000056', 'F000000048',	'FM00000021',	4,		'lần đường',		3.3),
('FD00000057', 'F000000048',	'FM00000023',	3,		'miếng',			14.7),
('FD00000058', 'F000000048',	'FM00000030',	4,		'lần',				5),
('FD00000059', 'F000000049',	'FM00000007',	1,		'Milk(1Cup)',		120),
('FD00000060', 'F000000049',	'FM00000014',	1.5,	'gói',				17),
('FD00000061', 'F000000050',	'FM00000007',	1,		'Milk(1Cup)',		120),
('FD00000062', 'F000000050',	'FM00000031',	1,		'lần',				20),
('FD00000063', 'F000000051',	'FM00000021',	1,		'lần đường',		3.3),
('FD00000064', 'F000000051',	'FM00000007',	1,		'nl choco',			24),
('FD00000065', 'F000000051',	'FM00000021',	1,		'nl choco',			4),
('FD00000066', 'F000000051',	'FM00000088',	1,		'nl choco',			16),
('FD00000067', 'F000000052',	'FM00000021',	1,		'lần đường',		3.3),
('FD00000068', 'F000000052',	'FM00000007',	1,		'nl choco',			24),
('FD00000069', 'F000000052',	'FM00000021',	1,		'nl choco',			4),
('FD00000070', 'F000000052',	'FM00000088',	1,		'nl choco',			16),
('FD00000071', 'F000000057',	'FM00000026',	1,		'trái vừa',			1),
('FD00000072', 'F000000053',	'FM00000026',	2,		'trái nhỏ',			1),
('FD00000073', 'F000000056',	'FM00000026',	0.5,	'trái lớn',			1),
('FD00000074', 'F000000054',	'FM00000026',	1,		'trái',				1),
('FD00000075', 'F000000054',	'FM00000003',	1,		'lần',				100),
('FD00000076', 'F000000054',	'FM00000021',	1,		'lần đường',		3.3),
('FD00000077', 'F000000055',	'FM00000010',	1,		'lần',				100),
('FD00000078', 'F000000055',	'FM00000021',	6,		'lần đường',		3.3),
('FD00000079', 'F000000055',	'FM00000029',	1,		'lần',				20),
('FD00000080', 'F000000055',	'FM00000027',	1,		'trái',				1)
go



select * from tbAdmin
go
select * from tbEmployee
go
select * from tbFoodMaterial
go
select * from tbFood
go
select *  from tbFoodDetails
go


