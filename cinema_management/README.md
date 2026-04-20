# Hệ Thống Quản Lý Rạp Chiếu Phim T3L

## Hướng Dẫn Sử Dụng

### 1. Chạy Ứng Dụng
- Chạy file `App.java` để khởi động ứng dụng
- Giao diện đăng nhập sẽ hiện lên

### 2. Tài Khoản Test

#### Tài Khoản Nhân Viên (Quản Lý)
- **Email**: `admin@cinema.com`
- **Mật khẩu**: `admin123`
- **Quyền**: Truy cập Admin Dashboard (Quản lý Phim, Phòng, Suất Chiếu, etc.)

Hoặc:
- **Email**: `nv001@cinema.com`
- **Mật khẩu**: `nv123456`

#### Tài Khoản Khách Hàng
- **Email**: `customer@example.com`
- **Mật khẩu**: `customer123`
- **Quyền**: Truy cập Customer Dashboard (Xem phim, Mua vé, Lịch sử vé)

Hoặc:
- **Email**: `user123@example.com`
- **Mật khẩu**: `user123456`

### 3. Chức Năng Chính

#### Admin Dashboard (Nhân Viên)
- **Quản Lý Phim**: Thêm, sửa, xóa thông tin phim
- **Quản Lý Phòng**: Quản lý các phòng chiếu
- **Quản Lý Suất Chiếu**: Tạo lịch chiếu cho các phim
- **Quản Lý Nhân Viên**: Quản lý thông tin nhân viên
- **Quản Lý Khách Hàng**: Xem danh sách khách hàng
- **Quản Lý Khuyến Mãi**: Tạo và quản lý chương trình khuyến mãi
- **Thống Kê**: Xem báo cáo doanh thu và thống kê

#### Customer Dashboard (Khách Hàng)
- **Duyệt Phim**: Xem danh sách phim đang chiếu
- **Lịch Chiếu**: Xem lịch chiếu các phim
- **Mua Vé**: Chọn suất chiếu, chọn ghế, thanh toán
- **Lịch Sử Vé**: Xem các vé đã mua
- **Khuyến Mãi**: Xem các chương trình khuyến mãi

### 4. Cấu Trúc Project

```
cinema_management/
├── src/
│   ├── App.java                    # Main application entry point
│   ├── connect/
│   │   └── DatabaseConnection.java # Database connection
│   ├── entity/                     # Entity classes
│   │   ├── Phim.java
│   │   ├── PhongChieu.java
│   │   ├── SuatChieu.java
│   │   ├── Ve.java
│   │   ├── NhanVien.java
│   │   ├── KhachHang.java
│   │   ├── KhuyenMai.java
│   │   ├── HoaDon.java
│   │   ├── Ghe.java
│   │   ├── Thue.java
│   │   └── ChiTietHoaDon.java
│   ├── services/                   # Service classes
│   │   └── AuthService.java        # Authentication service
│   ├── dao/                        # DAO classes
│   │   ├── DAO.java                # Base DAO interface
│   │   ├── PhimDAO.java
│   │   ├── PhongDAO.java
│   │   ├── SuatChieuDAO.java
│   │   ├── NhanVienDAO.java
│   │   ├── KhachHangDAO.java
│   │   └── KhuyenMaiDAO.java
│   └── ui/                         # UI classes
│       ├── CuaSoChinhMoi.java      # Main window
│       ├── BangDangNhap.java       # Login panel
│       ├── BangDangKy.java         # Register panel
│       ├── AdminDashboard.java     # Admin dashboard
│       ├── CustomerDashboard.java  # Customer dashboard
│       ├── BangDieuKhienQuanLy.java
│       ├── BangDieuKhienKhachHang.java
│       ├── BangQuanLyPhim.java
│       ├── BangDanhSachPhim.java
│       ├── BangChonSuatChieu.java
│       ├── BangChonGhe.java
│       ├── BangLichSuVe.java
│       └── BangThanhToan.java
└── resources/                      # Resource files

```

### 5. Luồng Ứng Dụng

1. **Khởi động** → **Màn hình Đăng Nhập**
2. **Đăng nhập Nhân Viên** → **Admin Dashboard** → Quản lý dữ liệu
3. **Đăng nhập Khách Hàng** → **Customer Dashboard** → Mua vé
4. **Đăng xuất** → Quay lại **Màn hình Đăng Nhập**

### 6. Dữ Liệu Mặc Định

Hệ thống đi kèm với dữ liệu mẫu để kiểm tra:
- 5 phim mẫu
- 3 phòng chiếu mẫu
- 10 suất chiếu mẫu
- 3 khuyến mãi mẫu

### 7. Ghi Chú

- **Hiện tại**: Sử dụng HashMap để lưu trữ dữ liệu (tài khoản)
- **Sắp tới**: Kết nối PostgreSQL database để lưu trữ dữ liệu thực
- **DAO Classes**: Đã được tạo sẵn, chỉ cần kích hoạt kết nối database

### 8. Hỗ Trợ

Nếu gặp lỗi:
1. Kiểm tra console output
2. Đảm bảo tài khoản test đúng (xem mục 2)
3. Kiểm tra kết nối database (nếu cần)
