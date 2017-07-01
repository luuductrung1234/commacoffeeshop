CREATE DATABASE COMMACOFFEESHOP_Ver2
GO

USE COMMACOFFEESHOP_Ver2
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
	name varchar(50) not null,
	birth date not null,
	startday date not null,
	addr varchar(50) not null,
	email varchar(50) not null,
	phone varchar(12) not null,
	em_role int						constraint chk_employeerole check(em_role = 1 or em_role = 2),   -- 1: nhân viên quầy nước, 2: nhân viên bếp
	manager varchar(20) not null		constraint fk_manager foreign key references tbAdmin(ad_id)
)
go

create table tbEmpschedule(
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
create table tbMenuFood(
	food_id varchar(10)				constraint pk_menufoodid primary key,
	name varchar(50) not null,
	info varchar(100) not null,
	price money not null,
	isdrink tinyint not null		constraint chk_isdrink_or_eat check (isdrink = 1 or isdrink = 0)     -- 1: thức ăn, 0: thức uống
)
go


create table tbFoodMaterial (
	fm_id varchar(10) not null		constraint pk_itemfoodid primary key,
	name varchar(50) not null,
	info varchar(100) null,
	price money not null,
	isfordrink tinyint not null		constraint chk_ismaterial_fordrink_or_eat check (isfordrink = 1 or isfordrink = 0)     -- 1: nguyên liệu thức ăn, 0: nguyên liệu thức uống
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
	food_id varchar(10) not null		constraint fk_foodinmenu foreign key references tbMenuFood(food_id),
										constraint pk_orderdetails primary key (order_id, food_id),
	quan int not null					constraint chk_order_quantity check(quan >= 0)
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
	work_hour int not null	constraint chk_workhour check(work_hour >= 0)
)
go
-- END EXPOSE


