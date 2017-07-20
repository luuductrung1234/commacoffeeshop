# commacoffeeshop
Project 2: Commacofffeshop (C-System)
Phần mềm quản lý cửa hàng (các dịch vụ ăn uống, kho trữ,...)
  - Phục vụ đặt hàng/gọi món, nhập đơn hàng kho, Cho phép nhên viên đăng nhập và tự động chấm công khi đăng xuất
  - Quản lý nguyên vật liệu trong kho (giám sát/thông báo các trạng thái nguyên vật liệu: còn, hết)
  - Phần mềm được chia cấp: dành cho nhân viên và dành cho quản lý
    + Employee: thực hiện order, điều chỉnh tài khoản của bản thân, nhập hoá đơn nguyên liệu nhập kho, thực hiện order cho khách hàng,...
    + Admin: quản lý nhân viên, lương, lịch làm việc, nguyên liệu trong kho, menu sản phẩm (món ăn,...), tài khoản các admin khác
  - Thống kê Thu chi theo tuần/tháng/năm


**Note:**
 - file "nn" là file rỗng, bù nhìn, giúp giữ cho folder tồn tại khi mà folder không chưa file nào khác
 - folder "Testcommacoffee" là một netbean project, nên khi clone mã nguồn về lập trình viên có thể open ngay folder "Testcommacoffe" vào NetbeanIDE để code (không cần phải copy và ghi đè folder "src" nữa)


# Project's procession:
  - **FrLogin**:
    + đã xong : đăng nhập cho nhân viên và quản lý
    + đã xong : cập nhật thêm chức năng thay đổi cấu hình đăng nhập database, sau khi chỉnh sửa và đăng nhập thành công, chương trình tự động lưu dữ liệu của database đó (lần sau không cần điều chỉnh nữa). Thông tin database sẽ được lưu vào databaseinfo.txt
    
  - **FrEmployeeWorkspace**:
    + đã xong : đăng nhập/xuất của nhân viên. Tự động chấm công và phát sinh lịch làm việc trong ngày, bảng lương của tháng hiện tại vào trong database
    + đã xong : Phân chia cửa sổ đã hoàn thành
    + đã xong : các cửa sổ xuất menu (thêm ảnh cho món ăn nếu cần)
    + đã xong : cửa sổ nhập bill order, sau khi khách hàng tính tiền sẽ tự động sinh dữ liệu Order và OrderDetails trong database
    + đã xong : xây dựng cửa sổ nhập đơn hàng, sau khi nhân viên nhập đơn hàng sẽ tự động sinh dữ liệu ReceitpNote và ReceiptNoteDetails trong database
    + đã xong : xây dựng của sổ Setting cho các tuỳ chỉnh trong EmployeeWorkspace, các tuỳ chỉnh lưu vào settinginfo.txt
    + đã xong : xây dựng cửa sổ Empoyee Info cho phép nhân viên chỉnh sủa tài khoản cá nhân
    + đã xong : In bill thông qua printer. Tính năng tuỳ chỉnh hiển thị văn bản in trước khi in
    + chưa hoàn thành : In report (theo dạng tài liệu pdf hoặc dạng hoá đơn liệt kê) sau một ngày làm việc
    + chưa hàng thành : thêm giá mặc định cho các nguyên liệu (FoodMaterials) => Sẽ cần phải điều chỉnh database, entities class, model class query, giao diện của FrEmployeeWorkspace và FrAdminWorkspace
    + chưa hoàn thành : tách code
    + đã xong : thêm chức năng lưu nhật kí phòng trường hợp chương trình bị đóng đột ngột (Nhưng lưu thông tin nhân viên thì chưa khả thi)

(*) dự kiến : sẽ thêm chức năng Internationalization (cho ngôn ngữ Anh, Việt, Hàn), tạo hiệu ứng annimation trong quá trình chờ load chương trình (bằng processing). Bổ sung thông tin khách hàng, thêm chức năng xuất thông tin và hình ảnh nhận diện khách hàng quen thuộc

  - **FrAdminWorkspace**:		(yêu cầu thành viên cập nhập)
  	+ ? : Employee information form (giao diện/xem/xoá/sửa thông tin)
  	+ ? : Salary Note information form (giao diện/xem/xoá/sửa thông tin)
  	+ ? : Customer information form (giao diện/xem/xoá/sửa thông tin)
  	+ ? : Food information form (giao diện/xem/xoá/sửa thông tin)
  	+ ? : Food Materials information form (giao diện/xem/xoá/sửa thông tin)
  	+ ? : Receipt Note information form (giao diện/xem/xoá/sửa thông tin)
  	+ ? : Order information form (giao diện/xem/xoá/sửa thông tin)
  	+ ? : Admin profile information form (giao diện/xem/xoá/sửa thông tin)


(*)  - FrAudit dùng để thực hiện các chức năng kiểm toán thu chi theo ngày/tháng/năm. Chức năng đồ hoạ vẽ biểu đồ thu nhập (bằng JFreeChart, datascient library). Có chức năng xuất 1 report cuối ngày list ra tất cả các món với số lượng đã được bán trong ngày
  
  
# Login Frame
  ![alt text](https://github.com/luuductrung1234/commacoffeeshop/blob/master/repo%20picture/login_image.png)


# Employee Workspace Frame
  ![alt text](https://github.com/luuductrung1234/commacoffeeshop/blob/master/repo%20picture/emp_workspace.png)


# Admin Workspace Frame  
  ![alt text](https://github.com/luuductrung1234/commacoffeeshop/blob/master/repo%20picture/admin_workspace.png)
  
  
# Audit Frame
  ---update soon---
  
  ![alt text]()
