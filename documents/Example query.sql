use COMMACOFFEESHOP
go

select * from tbAdmin
go
select * from tbEmployee
go

select count(sche_id) as 'schedule' from tbEmpSchedule
go
select count(sn_id) as 'salara note' from tbSalaryNote
go
select * from tbEmpSchedule
go
select * from tbSalaryNote
go



select * from tbOrder
go
select * from tbOrderDetails
go


select * from tbReceiptNote
go
select * from tbReceiptNoteDetails
go


select * from tbFoodMaterial
go



select AVG(total_amount) from tbReceiptNote
where rday = '2017-07-14'
go

select AVG(price) from tbOrder
where ordertime = '2017-07-14'
go

select COUNT(order_id) from tbOrder
where ordertime = '2017-07-14'
go

select * from tbOrder
where ordertime = convert(date, getdate())
go

select * from tbFood
go


select * from tbEmpSchedule
where workday = '2017-07-31'
go

select * from tbSalaryNote
where for_month = 7 and for_year = 2017
go

select * from tbSalaryNote
where em_id = 'EM00000001' and for_year = 2017
go

select * from tbSalaryNote
where for_year = 2017
go

select sum(price) from tbOrder
where year(ordertime) = 2017 and month(ordertime) = 7
go

select sum((endhour-starthour) + (endminute-startminute)/convert(float,60)) from tbEmpSchedule
where em_id = 'EM00000001' and year(workday) = 2017 and month(workday) = 7 and day(workday) = 30
go


select sum(item_price * quan * 1000) from tbReceiptNoteDetails
where rn_id in (select rn_id from tbReceiptNote 
					where day(rday) = 8 and month(rday) = 8 and year(rday) = 2017)
				and fm_id in (select fm_id from tbFoodMaterial where usefor = 0)
go