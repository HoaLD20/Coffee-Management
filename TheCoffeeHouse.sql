USE [master]
GO
/****** Object:  Database [TheCoffeeHouse]    Script Date: 4/2/2020 5:21:18 PM ******/
CREATE DATABASE [TheCoffeeHouse]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'TheCoffee', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.MSSQLSERVER\MSSQL\DATA\TheCoffee.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'TheCoffee_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.MSSQLSERVER\MSSQL\DATA\TheCoffee_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [TheCoffeeHouse] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [TheCoffeeHouse].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [TheCoffeeHouse] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [TheCoffeeHouse] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [TheCoffeeHouse] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [TheCoffeeHouse] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [TheCoffeeHouse] SET ARITHABORT OFF 
GO
ALTER DATABASE [TheCoffeeHouse] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [TheCoffeeHouse] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [TheCoffeeHouse] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [TheCoffeeHouse] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [TheCoffeeHouse] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [TheCoffeeHouse] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [TheCoffeeHouse] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [TheCoffeeHouse] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [TheCoffeeHouse] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [TheCoffeeHouse] SET  ENABLE_BROKER 
GO
ALTER DATABASE [TheCoffeeHouse] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [TheCoffeeHouse] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [TheCoffeeHouse] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [TheCoffeeHouse] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [TheCoffeeHouse] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [TheCoffeeHouse] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [TheCoffeeHouse] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [TheCoffeeHouse] SET RECOVERY FULL 
GO
ALTER DATABASE [TheCoffeeHouse] SET  MULTI_USER 
GO
ALTER DATABASE [TheCoffeeHouse] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [TheCoffeeHouse] SET DB_CHAINING OFF 
GO
ALTER DATABASE [TheCoffeeHouse] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [TheCoffeeHouse] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [TheCoffeeHouse] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'TheCoffeeHouse', N'ON'
GO
ALTER DATABASE [TheCoffeeHouse] SET QUERY_STORE = OFF
GO
USE [TheCoffeeHouse]
GO
/****** Object:  Table [dbo].[Administrator]    Script Date: 4/2/2020 5:21:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Administrator](
	[Username] [varchar](50) NOT NULL,
	[Password] [varchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Customer]    Script Date: 4/2/2020 5:21:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customer](
	[IDCus] [int] IDENTITY(100000,1) NOT NULL,
	[IdentityCard] [varchar](20) NOT NULL,
	[CusName] [nvarchar](50) NULL,
	[DateAdd] [varchar](20) NULL,
	[Phone] [varchar](20) NULL,
	[Email] [varchar](50) NULL,
	[Quantity] [int] NULL,
	[Discount] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IDCus] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[IdentityCard] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Employee]    Script Date: 4/2/2020 5:21:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Employee](
	[UsernameEmp] [varchar](50) NOT NULL,
	[Password] [varchar](20) NULL,
	[NameEmp] [nvarchar](50) NULL,
	[Gender] [nvarchar](10) NULL,
	[Birthday] [varchar](20) NULL,
	[Phone] [varchar](20) NULL,
	[Email] [varchar](50) NULL,
	[Address] [nvarchar](max) NULL,
	[Hinh] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[UsernameEmp] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Order]    Script Date: 4/2/2020 5:21:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Order](
	[IDOrder] [varchar](20) NOT NULL,
	[DateOrder] [varchar](20) NULL,
	[TimeOrder] [varchar](20) NULL,
	[UsernameEmp] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[IDOrder] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderDetails]    Script Date: 4/2/2020 5:21:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetails](
	[IDOrder] [varchar](20) NOT NULL,
	[IDProduct] [varchar](20) NOT NULL,
	[CusName] [nvarchar](50) NULL,
	[Quantity] [int] NULL,
	[NamePromo] [nvarchar](50) NULL,
 CONSTRAINT [PK_OrderDetails] PRIMARY KEY CLUSTERED 
(
	[IDOrder] ASC,
	[IDProduct] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Product]    Script Date: 4/2/2020 5:21:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[IDProduct] [varchar](20) NOT NULL,
	[ProductName] [nvarchar](100) NULL,
	[IDType] [varchar](10) NULL,
	[Price] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IDProduct] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ProductType]    Script Date: 4/2/2020 5:21:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ProductType](
	[IDType] [varchar](10) NOT NULL,
	[TypeName] [nvarchar](50) NULL,
	[Size] [nvarchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IDType] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Promotions]    Script Date: 4/2/2020 5:21:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Promotions](
	[IDPromo] [int] IDENTITY(1,1) NOT NULL,
	[NamePromo] [nvarchar](50) NOT NULL,
	[DiscountPromo] [int] NULL,
	[StartPromo] [varchar](20) NULL,
	[EndPromo] [varchar](20) NULL,
	[Description] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[IDPromo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[NamePromo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Revenue]    Script Date: 4/2/2020 5:21:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Revenue](
	[IDRevenue] [int] IDENTITY(1,1) NOT NULL,
	[Date] [varchar](20) NULL,
	[Money] [varchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[IDRevenue] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Order]  WITH CHECK ADD FOREIGN KEY([UsernameEmp])
REFERENCES [dbo].[Employee] ([UsernameEmp])
GO
ALTER TABLE [dbo].[OrderDetails]  WITH CHECK ADD FOREIGN KEY([IDOrder])
REFERENCES [dbo].[Order] ([IDOrder])
GO
ALTER TABLE [dbo].[OrderDetails]  WITH CHECK ADD FOREIGN KEY([IDProduct])
REFERENCES [dbo].[Product] ([IDProduct])
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD FOREIGN KEY([IDType])
REFERENCES [dbo].[ProductType] ([IDType])
GO
USE [master]
GO
ALTER DATABASE [TheCoffeeHouse] SET  READ_WRITE 
GO
