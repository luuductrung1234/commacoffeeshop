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