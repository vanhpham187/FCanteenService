USE [master]
DROP DATABASE IF EXISTS [test_db]
GO
/****** Object:  Database [test_db]    Script Date: 7/17/2022 9:15:40 PM ******/
CREATE DATABASE [test_db]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'test_db', FILENAME = N'D:\SQL\test_db.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'test_db_log', FILENAME = N'D:\SQL\test_db_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [test_db] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [test_db].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [test_db] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [test_db] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [test_db] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [test_db] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [test_db] SET ARITHABORT OFF 
GO
ALTER DATABASE [test_db] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [test_db] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [test_db] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [test_db] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [test_db] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [test_db] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [test_db] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [test_db] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [test_db] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [test_db] SET  ENABLE_BROKER 
GO
ALTER DATABASE [test_db] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [test_db] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [test_db] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [test_db] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [test_db] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [test_db] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [test_db] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [test_db] SET RECOVERY FULL 
GO
ALTER DATABASE [test_db] SET  MULTI_USER 
GO
ALTER DATABASE [test_db] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [test_db] SET DB_CHAINING OFF 
GO
ALTER DATABASE [test_db] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [test_db] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [test_db] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [test_db] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'test_db', N'ON'
GO
ALTER DATABASE [test_db] SET QUERY_STORE = OFF
GO
USE [test_db]
GO
/****** Object:  Table [dbo].[dish]    Script Date: 7/17/2022 9:15:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[dish](
	[dish_id] [int] NOT NULL,
	[store_id] [int] NULL,
	[dish_name] [char](100) NULL,
	[description] [char](200) NULL,
	[image_url] [char](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[dish_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[kiosk]    Script Date: 7/17/2022 9:15:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[kiosk](
	[kiosk_id] [int] IDENTITY(1,1) NOT NULL,
	[location] [varchar](200) NULL,
	[owner_name] [char](100) NULL,
	[owner_phone] [char](15) NULL,
	[rental_fee] [money] NULL,
PRIMARY KEY CLUSTERED 
(
	[kiosk_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[order_detail]    Script Date: 7/17/2022 9:15:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[order_detail](
	[order_id] [int] NULL,
	[user_id] [int] NULL,
	[dish_id] [int] NULL,
	[quantity] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[orders]    Script Date: 7/17/2022 9:15:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[orders](
	[order_id] [int] IDENTITY(1,1) NOT NULL,
	[ammount] [money] NULL,
	[date_time] [datetime] NULL,
	[note] [varchar](1000) NULL,
PRIMARY KEY CLUSTERED 
(
	[order_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[roles]    Script Date: 7/17/2022 9:15:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[roles](
	[id] [int] NOT NULL,
	[name] [varchar](30) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[store]    Script Date: 7/17/2022 9:15:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[store](
	[store_id] [int] IDENTITY(1,1) NOT NULL,
	[manager_id] [int] NULL,
	[hotline] [char](15) NULL,
	[kiosk_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[store_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[users]    Script Date: 7/17/2022 9:15:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[first_name] [varchar](30) NULL,
	[last_name] [varchar](30) NULL,
	[username] [varchar](50) NULL,
	[email] [varchar](255) NULL,
	[phone] [varchar](15) NULL,
	[address] [text] NULL,
	[password] [varchar](255) NULL,
	[salary] [float] NULL,
	[balance] [float] NULL,
	[store_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[users_roles]    Script Date: 7/17/2022 9:15:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users_roles](
	[user_id] [int] NOT NULL,
	[role_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[user_id] ASC,
	[role_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[dish]  WITH CHECK ADD FOREIGN KEY([store_id])
REFERENCES [dbo].[store] ([store_id])
GO
ALTER TABLE [dbo].[order_detail]  WITH CHECK ADD FOREIGN KEY([dish_id])
REFERENCES [dbo].[dish] ([dish_id])
GO
ALTER TABLE [dbo].[order_detail]  WITH CHECK ADD FOREIGN KEY([order_id])
REFERENCES [dbo].[orders] ([order_id])
GO
ALTER TABLE [dbo].[order_detail]  WITH CHECK ADD FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[store]  WITH CHECK ADD FOREIGN KEY([kiosk_id])
REFERENCES [dbo].[kiosk] ([kiosk_id])
GO
ALTER TABLE [dbo].[store]  WITH CHECK ADD FOREIGN KEY([manager_id])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[users_roles]  WITH CHECK ADD FOREIGN KEY([role_id])
REFERENCES [dbo].[roles] ([id])
GO
ALTER TABLE [dbo].[users_roles]  WITH CHECK ADD FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([id])
GO
USE [master]
GO
ALTER DATABASE [test_db] SET  READ_WRITE 
GO
use [test_db]
go
INSERT INTO [users] (first_name, last_name,username, password, email, phone, address)
Values('Anh', 'Pham', 'latdat', '$2a$10$4/1Gz0I/t.TeRRaqU1QXWeQcC03vfCaLbMb8FEaC7ICh4nbVYGcTq', 'anhptvhe150038@fpt.edu.vn', '0987654321', 'Hai Duong'),
('Phuong', 'Nguyen', 'phuongnh', '$2a$10$4/1Gz0I/t.TeRRaqU1QXWeQcC03vfCaLbMb8FEaC7ICh4nbVYGcTq', 'phuongnhhe150172@fpt.edu.vn', '0987654321', 'Ha Noi')
GO
INSERT INTO [roles] (id, name)
VALUES(1,'ROLE_ADMIN'),
(2,'ROLE_USER')
GO
INSERT INTO users_roles(user_id, role_id)
VALUES(1, 1),
(2, 2)
go
use master
