USE [QL_Salon30Shines]
GO
/****** Object:  Table [dbo].[chitiethoadon]    Script Date: 8/7/2020 9:19:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[chitiethoadon](
	[mahd] [int] NOT NULL,
	[madv] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[mahd] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ChucVu]    Script Date: 8/7/2020 9:19:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChucVu](
	[machucvu] [int] IDENTITY(1,1) NOT NULL,
	[tenchucvu] [nvarchar](50) NULL,
 CONSTRAINT [PK_ChucVu] PRIMARY KEY CLUSTERED 
(
	[machucvu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[dichvu]    Script Date: 8/7/2020 9:19:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[dichvu](
	[madv] [int] IDENTITY(1,1) NOT NULL,
	[gia] [int] NULL,
	[chitiet] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[madv] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[hoadon]    Script Date: 8/7/2020 9:19:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[hoadon](
	[mahd] [int] IDENTITY(1,1) NOT NULL,
	[makh] [int] NULL,
	[tongtien] [int] NULL,
	[thoigian] [date] NULL,
	[tinhtrang] [nvarchar](40) NULL,
	[masalon] [int] NOT NULL,
	[mastylist] [int] NOT NULL,
	[gio] [char](8) NULL,
	[ngaybatdau] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[mahd] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 8/7/2020 9:19:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[KhachHang](
	[makh] [int] IDENTITY(1,1) NOT NULL,
	[email] [char](20) NOT NULL,
	[sdt] [char](11) NOT NULL,
	[hoten] [nvarchar](30) NOT NULL,
	[ngaysinh] [date] NOT NULL,
	[diachi] [nvarchar](50) NULL,
	[taikhoan] [char](20) NULL,
	[matkhau] [char](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[makh] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[khuvuc]    Script Date: 8/7/2020 9:19:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[khuvuc](
	[tentp] [nvarchar](30) NOT NULL,
	[tenqh] [nvarchar](30) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[tentp] ASC,
	[tenqh] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[lichcat_stylist]    Script Date: 8/7/2020 9:19:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[lichcat_stylist](
	[ngay] [date] NOT NULL,
	[mastylist] [int] NOT NULL,
	[gio] [char](8) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ngay] ASC,
	[mastylist] ASC,
	[gio] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ManHinh]    Script Date: 8/7/2020 9:19:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ManHinh](
	[mamh] [int] IDENTITY(1,1) NOT NULL,
	[tenmh] [nvarchar](50) NULL,
 CONSTRAINT [PK_ManHinh] PRIMARY KEY CLUSTERED 
(
	[mamh] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[nhanvien]    Script Date: 8/7/2020 9:19:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[nhanvien](
	[manv] [int] IDENTITY(1,1) NOT NULL,
	[hoten] [nvarchar](50) NULL,
	[sdt] [char](11) NULL,
	[masalon] [int] NULL,
	[tendangnhap] [char](50) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PhanQuyen]    Script Date: 8/7/2020 9:19:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhanQuyen](
	[machucvu] [int] NOT NULL,
	[mamh] [int] NOT NULL,
 CONSTRAINT [PK_PhanQuyen] PRIMARY KEY CLUSTERED 
(
	[machucvu] ASC,
	[mamh] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[salon]    Script Date: 8/7/2020 9:19:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[salon](
	[masalon] [int] IDENTITY(1,1) NOT NULL,
	[tentp] [nvarchar](30) NOT NULL,
	[tenqh] [nvarchar](30) NOT NULL,
	[diachi] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[masalon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[stylist]    Script Date: 8/7/2020 9:19:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[stylist](
	[mastylist] [int] IDENTITY(1,1) NOT NULL,
	[masalon] [int] NOT NULL,
	[name] [nvarchar](30) NULL,
	[sdt] [char](15) NULL,
PRIMARY KEY CLUSTERED 
(
	[mastylist] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 8/7/2020 9:19:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[TenDangNhap] [char](50) NOT NULL,
	[MatKhau] [char](50) NULL,
	[HoatDong] [int] NULL,
	[machucvu] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[TenDangNhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[ChucVu] ON 

INSERT [dbo].[ChucVu] ([machucvu], [tenchucvu]) VALUES (1, N'Quản lí')
INSERT [dbo].[ChucVu] ([machucvu], [tenchucvu]) VALUES (2, N'Nhân viên thu ngân')
INSERT [dbo].[ChucVu] ([machucvu], [tenchucvu]) VALUES (3, N'Nhân viên kế toán')
SET IDENTITY_INSERT [dbo].[ChucVu] OFF
SET IDENTITY_INSERT [dbo].[dichvu] ON 

INSERT [dbo].[dichvu] ([madv], [gia], [chitiet]) VALUES (1, 100000, N'Combo 7 bocws chăm sóc da')
INSERT [dbo].[dichvu] ([madv], [gia], [chitiet]) VALUES (2, 150000, N'Combo tạo kiểu , chăm sóc da')
INSERT [dbo].[dichvu] ([madv], [gia], [chitiet]) VALUES (3, 200000, N'Combo cắt tóc + duỗi')
INSERT [dbo].[dichvu] ([madv], [gia], [chitiet]) VALUES (4, 250, N'Combo cắt tóc +uốn')
SET IDENTITY_INSERT [dbo].[dichvu] OFF
SET IDENTITY_INSERT [dbo].[hoadon] ON 

INSERT [dbo].[hoadon] ([mahd], [makh], [tongtien], [thoigian], [tinhtrang], [masalon], [mastylist], [gio], [ngaybatdau]) VALUES (1, 1, 150000, CAST(0x66410B00 AS Date), N'Đã thanh toán', 5, 1, NULL, NULL)
INSERT [dbo].[hoadon] ([mahd], [makh], [tongtien], [thoigian], [tinhtrang], [masalon], [mastylist], [gio], [ngaybatdau]) VALUES (2, 2, 150000, CAST(0x66410B00 AS Date), N'Đã thanh toán', 5, 1, NULL, NULL)
INSERT [dbo].[hoadon] ([mahd], [makh], [tongtien], [thoigian], [tinhtrang], [masalon], [mastylist], [gio], [ngaybatdau]) VALUES (3, 2, 150000, CAST(0x66410B00 AS Date), N'Đã thanh toán', 5, 1, NULL, NULL)
INSERT [dbo].[hoadon] ([mahd], [makh], [tongtien], [thoigian], [tinhtrang], [masalon], [mastylist], [gio], [ngaybatdau]) VALUES (9, 2, 150000, CAST(0x66410B00 AS Date), N'Đã thanh toán', 5, 1, NULL, NULL)
INSERT [dbo].[hoadon] ([mahd], [makh], [tongtien], [thoigian], [tinhtrang], [masalon], [mastylist], [gio], [ngaybatdau]) VALUES (10, 2, 200000, CAST(0x66410B00 AS Date), N'Đã thanh toán', 5, 1, NULL, NULL)
INSERT [dbo].[hoadon] ([mahd], [makh], [tongtien], [thoigian], [tinhtrang], [masalon], [mastylist], [gio], [ngaybatdau]) VALUES (11, 2, 200000, CAST(0x66410B00 AS Date), N'Đã thanh toán', 5, 1, NULL, NULL)
INSERT [dbo].[hoadon] ([mahd], [makh], [tongtien], [thoigian], [tinhtrang], [masalon], [mastylist], [gio], [ngaybatdau]) VALUES (24, 1, 200000, CAST(0x66410B00 AS Date), N'Đã thanh toán', 1, 7, NULL, NULL)
INSERT [dbo].[hoadon] ([mahd], [makh], [tongtien], [thoigian], [tinhtrang], [masalon], [mastylist], [gio], [ngaybatdau]) VALUES (26, 1, 200000, CAST(0x67410B00 AS Date), N'Đã thanh toán', 5, 1, NULL, NULL)
INSERT [dbo].[hoadon] ([mahd], [makh], [tongtien], [thoigian], [tinhtrang], [masalon], [mastylist], [gio], [ngaybatdau]) VALUES (27, 2, 200000, CAST(0x68410B00 AS Date), N'Đã thanh toán', 1, 7, N'8:30    ', CAST(0x68410B00 AS Date))
INSERT [dbo].[hoadon] ([mahd], [makh], [tongtien], [thoigian], [tinhtrang], [masalon], [mastylist], [gio], [ngaybatdau]) VALUES (30, 2, 200000, CAST(0x6A410B00 AS Date), N'Chưa thanh toán', 1, 7, N'12:30   ', CAST(0x69410B00 AS Date))
INSERT [dbo].[hoadon] ([mahd], [makh], [tongtien], [thoigian], [tinhtrang], [masalon], [mastylist], [gio], [ngaybatdau]) VALUES (31, 2, 200000, CAST(0x6B410B00 AS Date), N'Chưa thanh toán', 1, 7, N'9:30    ', CAST(0x69410B00 AS Date))
INSERT [dbo].[hoadon] ([mahd], [makh], [tongtien], [thoigian], [tinhtrang], [masalon], [mastylist], [gio], [ngaybatdau]) VALUES (36, 2, 200000, CAST(0x69410B00 AS Date), N'Chưa thanh toán', 5, 1, N'12:30   ', CAST(0x6A410B00 AS Date))
INSERT [dbo].[hoadon] ([mahd], [makh], [tongtien], [thoigian], [tinhtrang], [masalon], [mastylist], [gio], [ngaybatdau]) VALUES (37, 2, 200000, CAST(0x69410B00 AS Date), N'Chưa thanh toán', 5, 1, N'13:00   ', CAST(0x6A410B00 AS Date))
INSERT [dbo].[hoadon] ([mahd], [makh], [tongtien], [thoigian], [tinhtrang], [masalon], [mastylist], [gio], [ngaybatdau]) VALUES (38, 2, 200000, CAST(0x69410B00 AS Date), N'Chưa thanh toán', 5, 1, N'9:00    ', CAST(0x6A410B00 AS Date))
INSERT [dbo].[hoadon] ([mahd], [makh], [tongtien], [thoigian], [tinhtrang], [masalon], [mastylist], [gio], [ngaybatdau]) VALUES (39, 2, 150000, CAST(0x69410B00 AS Date), N'Chưa thanh toán', 5, 1, N'13:00   ', CAST(0x6B410B00 AS Date))
INSERT [dbo].[hoadon] ([mahd], [makh], [tongtien], [thoigian], [tinhtrang], [masalon], [mastylist], [gio], [ngaybatdau]) VALUES (40, 2, 150000, CAST(0x69410B00 AS Date), N'Chưa thanh toán', 5, 1, N'13:00   ', CAST(0x6B410B00 AS Date))
INSERT [dbo].[hoadon] ([mahd], [makh], [tongtien], [thoigian], [tinhtrang], [masalon], [mastylist], [gio], [ngaybatdau]) VALUES (41, 2, 250, CAST(0x69410B00 AS Date), N'Chưa thanh toán', 5, 1, N'13:30   ', CAST(0x6A410B00 AS Date))
INSERT [dbo].[hoadon] ([mahd], [makh], [tongtien], [thoigian], [tinhtrang], [masalon], [mastylist], [gio], [ngaybatdau]) VALUES (42, 2, 200000, CAST(0x69410B00 AS Date), N'Chưa thanh toán', 5, 1, N'14:00   ', CAST(0x6A410B00 AS Date))
INSERT [dbo].[hoadon] ([mahd], [makh], [tongtien], [thoigian], [tinhtrang], [masalon], [mastylist], [gio], [ngaybatdau]) VALUES (43, 2, 250, CAST(0x69410B00 AS Date), N'Chưa thanh toán', 5, 1, N'9:30    ', CAST(0x6B410B00 AS Date))
INSERT [dbo].[hoadon] ([mahd], [makh], [tongtien], [thoigian], [tinhtrang], [masalon], [mastylist], [gio], [ngaybatdau]) VALUES (44, 2, 250, CAST(0x69410B00 AS Date), N'Chưa thanh toán', 5, 1, N'10:00   ', CAST(0x6B410B00 AS Date))
INSERT [dbo].[hoadon] ([mahd], [makh], [tongtien], [thoigian], [tinhtrang], [masalon], [mastylist], [gio], [ngaybatdau]) VALUES (45, 2, 200000, CAST(0x6A410B00 AS Date), N'Chưa thanh toán', 5, 2, N'9:30    ', CAST(0x6A410B00 AS Date))
INSERT [dbo].[hoadon] ([mahd], [makh], [tongtien], [thoigian], [tinhtrang], [masalon], [mastylist], [gio], [ngaybatdau]) VALUES (46, 2, 150000, CAST(0x6B410B00 AS Date), N'Chưa thanh toán', 5, 1, N'9:00    ', CAST(0x6C410B00 AS Date))
SET IDENTITY_INSERT [dbo].[hoadon] OFF
SET IDENTITY_INSERT [dbo].[KhachHang] ON 

INSERT [dbo].[KhachHang] ([makh], [email], [sdt], [hoten], [ngaysinh], [diachi], [taikhoan], [matkhau]) VALUES (1, N'quan12yt@gmail.com  ', N'0961148368 ', N'Phạm Văn Quân', CAST(0xEE220B00 AS Date), N'Hồ Chí Minh', N'quan12yt            ', N'123                 ')
INSERT [dbo].[KhachHang] ([makh], [email], [sdt], [hoten], [ngaysinh], [diachi], [taikhoan], [matkhau]) VALUES (2, N'quan@gmail.com      ', N'123        ', N'Huỳnh Thanh Tuấn', CAST(0xC4240B00 AS Date), N'Hồ Chí Minh', N'toan                ', N'123                 ')
INSERT [dbo].[KhachHang] ([makh], [email], [sdt], [hoten], [ngaysinh], [diachi], [taikhoan], [matkhau]) VALUES (3, N'lechitoan@gmail.com ', N'08771212   ', N'Lê Chí Toàn', CAST(0x66230B00 AS Date), N'Hồ Chí Minh', N'len                 ', N'123                 ')
INSERT [dbo].[KhachHang] ([makh], [email], [sdt], [hoten], [ngaysinh], [diachi], [taikhoan], [matkhau]) VALUES (4, N'quan12yt@gmail.com  ', N'1234       ', N'Phạm Quang Minh', CAST(0x66410B00 AS Date), N'Bình Chánh, Hồ Chí Minh', N'quan12yta           ', N'123                 ')
SET IDENTITY_INSERT [dbo].[KhachHang] OFF
INSERT [dbo].[khuvuc] ([tentp], [tenqh]) VALUES (N'Hà Nội', N'Ba Đình')
INSERT [dbo].[khuvuc] ([tentp], [tenqh]) VALUES (N'Hà Nội', N'Hoàn Kiếm')
INSERT [dbo].[khuvuc] ([tentp], [tenqh]) VALUES (N'Hồ Chí Minh', N'Bình Chánh')
INSERT [dbo].[khuvuc] ([tentp], [tenqh]) VALUES (N'Hồ Chí Minh', N'Bình Tân')
INSERT [dbo].[khuvuc] ([tentp], [tenqh]) VALUES (N'Hồ Chí Minh', N'Nhà Bè')
INSERT [dbo].[khuvuc] ([tentp], [tenqh]) VALUES (N'Hồ Chí Minh', N'Quận 1')
INSERT [dbo].[khuvuc] ([tentp], [tenqh]) VALUES (N'Hồ Chí Minh', N'Quận 4')
INSERT [dbo].[lichcat_stylist] ([ngay], [mastylist], [gio]) VALUES (CAST(0xB6400B00 AS Date), 8, N'9:00    ')
INSERT [dbo].[lichcat_stylist] ([ngay], [mastylist], [gio]) VALUES (CAST(0x66410B00 AS Date), 1, N'11:30   ')
INSERT [dbo].[lichcat_stylist] ([ngay], [mastylist], [gio]) VALUES (CAST(0x66410B00 AS Date), 1, N'12:30   ')
INSERT [dbo].[lichcat_stylist] ([ngay], [mastylist], [gio]) VALUES (CAST(0x66410B00 AS Date), 1, N'8:30    ')
INSERT [dbo].[lichcat_stylist] ([ngay], [mastylist], [gio]) VALUES (CAST(0x66410B00 AS Date), 1, N'9:30    ')
INSERT [dbo].[lichcat_stylist] ([ngay], [mastylist], [gio]) VALUES (CAST(0x66410B00 AS Date), 2, N'12:30   ')
INSERT [dbo].[lichcat_stylist] ([ngay], [mastylist], [gio]) VALUES (CAST(0x66410B00 AS Date), 2, N'13:30   ')
INSERT [dbo].[lichcat_stylist] ([ngay], [mastylist], [gio]) VALUES (CAST(0x66410B00 AS Date), 3, N'21:00   ')
INSERT [dbo].[lichcat_stylist] ([ngay], [mastylist], [gio]) VALUES (CAST(0x66410B00 AS Date), 7, N'8:30    ')
INSERT [dbo].[lichcat_stylist] ([ngay], [mastylist], [gio]) VALUES (CAST(0x66410B00 AS Date), 8, N'8:00    ')
INSERT [dbo].[lichcat_stylist] ([ngay], [mastylist], [gio]) VALUES (CAST(0x66410B00 AS Date), 8, N'8:30    ')
INSERT [dbo].[lichcat_stylist] ([ngay], [mastylist], [gio]) VALUES (CAST(0x67410B00 AS Date), 1, N'9:00    ')
INSERT [dbo].[lichcat_stylist] ([ngay], [mastylist], [gio]) VALUES (CAST(0x68410B00 AS Date), 7, N'8:30    ')
INSERT [dbo].[lichcat_stylist] ([ngay], [mastylist], [gio]) VALUES (CAST(0x69410B00 AS Date), 1, N'12:00   ')
INSERT [dbo].[lichcat_stylist] ([ngay], [mastylist], [gio]) VALUES (CAST(0x69410B00 AS Date), 1, N'12:30   ')
INSERT [dbo].[lichcat_stylist] ([ngay], [mastylist], [gio]) VALUES (CAST(0x69410B00 AS Date), 1, N'13:00   ')
INSERT [dbo].[lichcat_stylist] ([ngay], [mastylist], [gio]) VALUES (CAST(0x69410B00 AS Date), 1, N'13:30   ')
INSERT [dbo].[lichcat_stylist] ([ngay], [mastylist], [gio]) VALUES (CAST(0x69410B00 AS Date), 1, N'14:00   ')
INSERT [dbo].[lichcat_stylist] ([ngay], [mastylist], [gio]) VALUES (CAST(0x69410B00 AS Date), 1, N'8:30    ')
INSERT [dbo].[lichcat_stylist] ([ngay], [mastylist], [gio]) VALUES (CAST(0x69410B00 AS Date), 1, N'9:30    ')
INSERT [dbo].[lichcat_stylist] ([ngay], [mastylist], [gio]) VALUES (CAST(0x69410B00 AS Date), 7, N'12:30   ')
INSERT [dbo].[lichcat_stylist] ([ngay], [mastylist], [gio]) VALUES (CAST(0x69410B00 AS Date), 7, N'9:30    ')
INSERT [dbo].[lichcat_stylist] ([ngay], [mastylist], [gio]) VALUES (CAST(0x6A410B00 AS Date), 2, N'9:30    ')
INSERT [dbo].[lichcat_stylist] ([ngay], [mastylist], [gio]) VALUES (CAST(0x6B410B00 AS Date), 1, N'10:00   ')
INSERT [dbo].[lichcat_stylist] ([ngay], [mastylist], [gio]) VALUES (CAST(0x6C410B00 AS Date), 1, N'9:00    ')
SET IDENTITY_INSERT [dbo].[ManHinh] ON 

INSERT [dbo].[ManHinh] ([mamh], [tenmh]) VALUES (1, N'Stylist')
INSERT [dbo].[ManHinh] ([mamh], [tenmh]) VALUES (2, N'Đặt lịch')
INSERT [dbo].[ManHinh] ([mamh], [tenmh]) VALUES (3, N'Khách hàng')
INSERT [dbo].[ManHinh] ([mamh], [tenmh]) VALUES (4, N'Salon')
INSERT [dbo].[ManHinh] ([mamh], [tenmh]) VALUES (5, N'Nhân viên')
INSERT [dbo].[ManHinh] ([mamh], [tenmh]) VALUES (6, N'Thống kê')
SET IDENTITY_INSERT [dbo].[ManHinh] OFF
SET IDENTITY_INSERT [dbo].[nhanvien] ON 

INSERT [dbo].[nhanvien] ([manv], [hoten], [sdt], [masalon], [tendangnhap]) VALUES (2, N'Phạm Văn Quân', N'0961148368 ', 1, N'quan12yta                                         ')
INSERT [dbo].[nhanvien] ([manv], [hoten], [sdt], [masalon], [tendangnhap]) VALUES (3, N'Hồ Quang Nguyên', N'0872323121 ', 2, N'quan12yt                                          ')
SET IDENTITY_INSERT [dbo].[nhanvien] OFF
INSERT [dbo].[PhanQuyen] ([machucvu], [mamh]) VALUES (1, 1)
INSERT [dbo].[PhanQuyen] ([machucvu], [mamh]) VALUES (1, 4)
INSERT [dbo].[PhanQuyen] ([machucvu], [mamh]) VALUES (1, 6)
INSERT [dbo].[PhanQuyen] ([machucvu], [mamh]) VALUES (2, 2)
INSERT [dbo].[PhanQuyen] ([machucvu], [mamh]) VALUES (2, 3)
INSERT [dbo].[PhanQuyen] ([machucvu], [mamh]) VALUES (3, 6)
SET IDENTITY_INSERT [dbo].[salon] ON 

INSERT [dbo].[salon] ([masalon], [tentp], [tenqh], [diachi]) VALUES (1, N'Hồ Chí Minh', N'Bình Chánh', N'14, Nữ Dân Công')
INSERT [dbo].[salon] ([masalon], [tentp], [tenqh], [diachi]) VALUES (2, N'Hồ Chí Minh', N'Quận 1', N'455, Nguyễn Đình Chiểu')
INSERT [dbo].[salon] ([masalon], [tentp], [tenqh], [diachi]) VALUES (3, N'Hồ Chí Minh', N'Bình Chánh', N'16,Võ Văn Vân')
INSERT [dbo].[salon] ([masalon], [tentp], [tenqh], [diachi]) VALUES (4, N'Hồ Chí Minh', N'Bình Chánh', N'45,Nguyễn Thị Tú')
INSERT [dbo].[salon] ([masalon], [tentp], [tenqh], [diachi]) VALUES (5, N'Hà Nội', N'Ba Đình', N'56, Nguyễn Trãi')
INSERT [dbo].[salon] ([masalon], [tentp], [tenqh], [diachi]) VALUES (6, N'Hà Nội', N'Hoàn Kiếm', N'75, Lí Tuấn Kiệt')
INSERT [dbo].[salon] ([masalon], [tentp], [tenqh], [diachi]) VALUES (7, N'Hà Nội', N'Ba Đình', N'167, Nguyễn Văn Cừ')
SET IDENTITY_INSERT [dbo].[salon] OFF
SET IDENTITY_INSERT [dbo].[stylist] ON 

INSERT [dbo].[stylist] ([mastylist], [masalon], [name], [sdt]) VALUES (1, 5, N'Lê Chí Toàn', N'098123213      ')
INSERT [dbo].[stylist] ([mastylist], [masalon], [name], [sdt]) VALUES (2, 5, N'Phạm Văn Quân', N'0961148368     ')
INSERT [dbo].[stylist] ([mastylist], [masalon], [name], [sdt]) VALUES (3, 5, N'Hồ Chí Lên', N'094625671      ')
INSERT [dbo].[stylist] ([mastylist], [masalon], [name], [sdt]) VALUES (4, 5, N'Nguyễn Hồng Ánh', N'098123213      ')
INSERT [dbo].[stylist] ([mastylist], [masalon], [name], [sdt]) VALUES (7, 1, N'Trần Quang Huy', N'098123213      ')
INSERT [dbo].[stylist] ([mastylist], [masalon], [name], [sdt]) VALUES (8, 1, N'Nguyễn Quang Hải', N'098123213      ')
INSERT [dbo].[stylist] ([mastylist], [masalon], [name], [sdt]) VALUES (9, 1, N'Trần Thị ĐỊnh', N'098123213      ')
INSERT [dbo].[stylist] ([mastylist], [masalon], [name], [sdt]) VALUES (10, 2, N'Lê Bảo Nam', N'098123213      ')
INSERT [dbo].[stylist] ([mastylist], [masalon], [name], [sdt]) VALUES (11, 2, N'Nguyễn Gia Bảo', N'0961148368     ')
INSERT [dbo].[stylist] ([mastylist], [masalon], [name], [sdt]) VALUES (12, 2, N'Lê Ý Nhi', N'0961148368     ')
INSERT [dbo].[stylist] ([mastylist], [masalon], [name], [sdt]) VALUES (13, 3, N'Hà Văn Đạt', N'0961148368     ')
INSERT [dbo].[stylist] ([mastylist], [masalon], [name], [sdt]) VALUES (14, 3, N'Huỳnh Thanh Võ', N'0961148368     ')
INSERT [dbo].[stylist] ([mastylist], [masalon], [name], [sdt]) VALUES (15, 3, N'Trịnh Nhật Hào', N'0961148368     ')
INSERT [dbo].[stylist] ([mastylist], [masalon], [name], [sdt]) VALUES (16, 4, N'Nguyễn Đỗ Diễm', N'0961148368     ')
INSERT [dbo].[stylist] ([mastylist], [masalon], [name], [sdt]) VALUES (17, 4, N'Trần Anh Tuấn', N'0876821622     ')
INSERT [dbo].[stylist] ([mastylist], [masalon], [name], [sdt]) VALUES (18, 4, N'Nguyễn Quang Hà', N'098123213      ')
INSERT [dbo].[stylist] ([mastylist], [masalon], [name], [sdt]) VALUES (21, 4, N'Nguyễn Tuấn Anh', N'098123213      ')
INSERT [dbo].[stylist] ([mastylist], [masalon], [name], [sdt]) VALUES (22, 1, N'Trịnh Nhật Hào', N'0987112309     ')
SET IDENTITY_INSERT [dbo].[stylist] OFF
INSERT [dbo].[TaiKhoan] ([TenDangNhap], [MatKhau], [HoatDong], [machucvu]) VALUES (N'quan                                              ', N'123                                               ', 1, 3)
INSERT [dbo].[TaiKhoan] ([TenDangNhap], [MatKhau], [HoatDong], [machucvu]) VALUES (N'quan12yt                                          ', N'123                                               ', 0, 2)
INSERT [dbo].[TaiKhoan] ([TenDangNhap], [MatKhau], [HoatDong], [machucvu]) VALUES (N'quan12yta                                         ', N'123                                               ', 1, 1)
ALTER TABLE [dbo].[chitiethoadon]  WITH CHECK ADD FOREIGN KEY([madv])
REFERENCES [dbo].[dichvu] ([madv])
GO
ALTER TABLE [dbo].[chitiethoadon]  WITH CHECK ADD FOREIGN KEY([mahd])
REFERENCES [dbo].[hoadon] ([mahd])
GO
ALTER TABLE [dbo].[hoadon]  WITH CHECK ADD FOREIGN KEY([makh])
REFERENCES [dbo].[KhachHang] ([makh])
GO
ALTER TABLE [dbo].[hoadon]  WITH CHECK ADD FOREIGN KEY([masalon])
REFERENCES [dbo].[salon] ([masalon])
GO
ALTER TABLE [dbo].[hoadon]  WITH CHECK ADD FOREIGN KEY([mastylist])
REFERENCES [dbo].[stylist] ([mastylist])
GO
ALTER TABLE [dbo].[lichcat_stylist]  WITH CHECK ADD FOREIGN KEY([mastylist])
REFERENCES [dbo].[stylist] ([mastylist])
GO
ALTER TABLE [dbo].[nhanvien]  WITH CHECK ADD  CONSTRAINT [FK_nhanvien_salon] FOREIGN KEY([masalon])
REFERENCES [dbo].[salon] ([masalon])
GO
ALTER TABLE [dbo].[nhanvien] CHECK CONSTRAINT [FK_nhanvien_salon]
GO
ALTER TABLE [dbo].[nhanvien]  WITH CHECK ADD  CONSTRAINT [FK_nhanvien_TaiKhoan] FOREIGN KEY([tendangnhap])
REFERENCES [dbo].[TaiKhoan] ([TenDangNhap])
GO
ALTER TABLE [dbo].[nhanvien] CHECK CONSTRAINT [FK_nhanvien_TaiKhoan]
GO
ALTER TABLE [dbo].[PhanQuyen]  WITH CHECK ADD  CONSTRAINT [FK_PhanQuyen_ChucVu] FOREIGN KEY([machucvu])
REFERENCES [dbo].[ChucVu] ([machucvu])
GO
ALTER TABLE [dbo].[PhanQuyen] CHECK CONSTRAINT [FK_PhanQuyen_ChucVu]
GO
ALTER TABLE [dbo].[PhanQuyen]  WITH CHECK ADD  CONSTRAINT [FK_PhanQuyen_ManHinh] FOREIGN KEY([mamh])
REFERENCES [dbo].[ManHinh] ([mamh])
GO
ALTER TABLE [dbo].[PhanQuyen] CHECK CONSTRAINT [FK_PhanQuyen_ManHinh]
GO
ALTER TABLE [dbo].[salon]  WITH CHECK ADD FOREIGN KEY([tentp], [tenqh])
REFERENCES [dbo].[khuvuc] ([tentp], [tenqh])
GO
ALTER TABLE [dbo].[stylist]  WITH CHECK ADD FOREIGN KEY([masalon])
REFERENCES [dbo].[salon] ([masalon])
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD  CONSTRAINT [FK_TaiKhoan_ChucVu] FOREIGN KEY([machucvu])
REFERENCES [dbo].[ChucVu] ([machucvu])
GO
ALTER TABLE [dbo].[TaiKhoan] CHECK CONSTRAINT [FK_TaiKhoan_ChucVu]
GO
