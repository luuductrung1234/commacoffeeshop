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
    + vừa cập nhật thêm chức năng thay đổi cấu hình đăng nhập database, sau khi chỉnh sửa và đăng nhập thành công, chương trình tự động lưu dữ liệu của database đó (lần sau không cần điều chỉnh nữa). Thông tin database sẽ được lưu vào databaseinfo.txt
    
  - FrEmployeeWorkspace:
    + đã xong : đăng nhập/xuất của nhân viên. Tự động chấm công và phát sinh lịch làm việc trong ngày, bảng lương của tháng hiện tại vào trong database
    + đã xong : Phân chia cửa sổ đã hoàn thành
    + đã xong : các cửa sổ xuất menu (thêm ảnh cho món ăn nếu cần)
    + đã xong : cửa sổ nhập bill order, sau khi khách hàng tính tiền sẽ tự động sinh dữ liệu Order và OrderDetails trong database
    + chưa hoàn thành : In bill thông qua printer
    + đã xong : xây dựng cửa sổ nhập đơn hàng, sau khi nhân viên nhập đơn hàng sẽ tự động sinh dữ liệu ReceitpNote và ReceiptNoteDetails trong database
    + đã xong : xây dựng của sổ Setting cho các tuỳ chỉnh trong EmployeeWorkspace, các tuỳ chỉnh lưu vào settinginfo.txt
    + đã xong : xây dựng cửa sổ Empoyee Info cho phép nhân viên chỉnh sủa tài khoản cá nhân

(*) dự kiến : sẽ thêm chức năng Internationalization (cho ngôn ngữ Anh, Việt, Hàn), tạo hiệu ứng annimation trong quá trình chờ load chương trình (bằng processing). Bổ sung thông tin khách hàng, thêm chức năng xuất thông tin và hình ảnh nhận diện khách hàng quen thuộc
    
  - FrAdminWorkspace(đã submit code):
    + đã xong: đăng nhập đăng xuất Admin
    + đã xong: Phân chia cửa sổ
    + đã xong: các cửa sổ quản lý Employee, Customer, Food, Food Material, Receipt Note, Order, Profile Admin(đã bao gồm tìm kiếm đơn giản). Cụ thể có thể nhập xuất, thay đổi dữ liệu
    
  
(*)  - FrAudit dùng để thực hiện các chức năng kiểm toán thu chi theo ngày/tháng/năm. Chức năng đồ hoạ vẽ biểu đồ thu nhập (bằng JFreeChart, datascient library)
  
  
# Login Frame
  ![alt text](https://github.com/luuductrung1234/commacoffeeshop/blob/master/login_image.png)


# Employee Workspace Frame
  ![alt text](https://github.com/luuductrung1234/commacoffeeshop/blob/master/ScreenShot_20170713140604.png)


# Admin Workspace Frame
  ---update soon---
  
  ![alt text]()
  
  
# Audit Frame
  ---update soon---
  
  ![alt text]()
