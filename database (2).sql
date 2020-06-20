create database cattoc30shinelan2

create table KhachHang(
	makh int identity primary key not null,
	email char(20) not null,
	hoten nvarchar(30) not null,
	ngaysinh date not null,
	diachi nvarchar(50)
)

create table khuvuc(
	tentp nvarchar(30) not null, 
	tenqh nvarchar(30) not null,
	primary key(tentp,tenqh)
)

create table salon(
	masalon int identity not null,
	tentp nvarchar(30) not null, 
	tenqh nvarchar(30) not null,
	diachi nvarchar(50),
	primary key(masalon),
	foreign key(tentp,tenqh) references khuvuc(tentp,tenqh)
)

create table stylist(
	mastylist int identity not null,
	masalon int not null,
	name nvarchar(30)
	primary key(mastylist)
	foreign key(masalon) references salon(masalon)
)

create table lichcat_stylist(
	ngay date not null,
	mastylist int not null,
	gio char(8),
	primary key(ngay,mastylist,gio),
	foreign key(mastylist) references stylist(mastylist)

)
create table dichvu(
	madv int identity not null,
	gia int,
	chitiet nvarchar(50),
	primary key(madv)
)

create table hoadon(
	mahd int identity not null,
	makh int not null,
	tongtien int,
	primary key(mahd)
)
create table chitiethoadon(
	mahd int not null,
	makh int not null,
	masalon int not null,
	mastylist int not null,
	thoigian date,
	madv int not null,
	primary key(mahd,makh),
	foreign key(mahd) references hoadon(mahd),
	foreign key(makh) references khachhang(makh),
	foreign key(masalon) references salon(masalon),
	foreign key(mastylist) references stylist(mastylist),
	foreign key(madv) references dichvu(madv)
)


create table DM_ManHinh(
	MaManHinh char(50) not null,
	TenManHinh nvarchar(50)
	primary key(MaManHinh),
	
)
create table ql_NguoiDung(
	TenDangNhap char(50) not null,
	MatKhau char(50),
	HoatDong int,
	primary key(TenDangNhap)
)
create table ql_PhanQuyen(
	MaNhomNguoiDung char(50) not null,
	MaManHinh char(50),
	CoQuyen int,
	primary key(MaNhomNguoiDung,MaManHinh),
	foreign key(MaManHinh) references DM_ManHinh(MaManHinh)
)
create table ql_NhomNguoiDung(
	MaNhom char(50) not null,
	TenNhom char(50),
	GhiChu int,
	primary key(MaNhom)

)
create table ql_NguoiDungNhomNguoiDung(
	TenDangNhap char(50) not null,
	MaNhomNguoiDung char(50),
	GhiChu int,
	primary key(TenDangNhap,MaNhomNguoiDung),
	foreign key(TenDangNhap) references ql_NguoiDung(TenDangNhap),


)
