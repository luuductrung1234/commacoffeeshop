# commacoffeeshop
Project 2: Commacofffeshop (C-System)
Phần mềm quản lý cửa hàng (các dịch vụ ăn uống, kho trữ,...)
  - Phục vụ đặt hàng/gọi món, nhập đơn hàng kho, Cho phép nhên viên đăng nhập và tự động chấm công khi đăng xuất
  - Quản lý nguyên vật liệu trong kho (giám sát/thông báo các trạng thái nguyên vật liệu: còn, hết)
  - Phần mềm được chia cấp: dành cho nhân viên và dành cho quản lý
    + Employee: thực hiện order, điều chỉnh tài khoản của bản thân, nhập hoá đơn nguyên liệu nhập kho, thực hiện order cho khách hàng,...
    + Admin: quản lý nhân viên, lương, lịch làm việc, nguyên liệu trong kho, menu sản phẩm (món ăn,...), tài khoản các admin khác
  - Thống kê Thu chi theo tuần/tháng/năm


Note:
 - file "nn" là file rỗng, bù nhìn, giúp giữ cho folder tồn tại khi mà folder không chưa file nào khác


# Project's procession:
  - FrLogin đã xong
    + vừa cập nhật thêm chức năng thay đổi cấu hình đăng nhập database
    
  - FrEmployeeWorkspace:
    + đã xong : đăng nhập/xuất của nhân viên. Tự động chấm công và phát sinh lịch làm việc trong ngày cũng như bẳng lương trong tháng hiện tại vào trong database
    + đã xong : Phân chia cửa sổ đã hoàn thành
    + đã xong : các cửa sổ xuất menu (thêm ảnh cho món ăn nếu cần)
    + đã xong : cửa sổ nhập bill order, sau khi khách hàng tính tiền sẽ tự động sinh dữ liệu Order và OrderDetails trong database
    + chưa hoàn thành : In bill thông qua printer
    + đã xong : xây dựng cửa sổ nhập ReceitpNote
    + chưa hoàn thành : xây dựng của sổ Setting cho các tuỳ chỉnh trong EmployeeWorkspace
    + chưa hoàn thành : xây dựng cửa sổ Empoyee Info cho phép nhân viên chỉnh sủa tài khoản cá nhân
(*) dự kiến : sẽ thêm chức năng Internationalization (cho ngôn ngữ Anh, Việt, Hàn), tạo hiệu ứng annimation trong quá trình chờ load chương trình (bằng processing). Bổ sung thông tin khách hàng, thêm chức năng xuất thông tin và hình ảnh nhận diện khách hàng quen thuộc
    
  - FrAdminWorkspace chưa submit source code (thành viên đảm nhiệm nhớ ghi rõ mô tả và tiến trình phát triển mã nguồn sau khi update code)
  
(*)  - FrAudit dùng để thực hiện các chức năng kiểm toán thu chi theo ngày/tháng/năm. Chức năng đồ hoạ vẽ biểu đồ thu nhập (bằng JFreeChart, datascient library)
  
  
# Login Form
  ![alt text](https://github.com/luuductrung1234/commacoffeeshop/blob/master/login_image.png)

# Employee Workspace Form
  ![alt text](https://github.com/luuductrung1234/commacoffeeshop/blob/master/ScreenShot_20170713140604.png)

# Admin Workspace Form
  ---blank---
  ![alt text]()
