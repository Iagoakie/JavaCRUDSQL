/****** Object:  Table [dbo].[__EFMigrationsHistory]    Script Date: 07/02/2022 22:35:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[__EFMigrationsHistory](
	[MigrationId] [nvarchar](150) NOT NULL,
	[ProductVersion] [nvarchar](32) NOT NULL,
 CONSTRAINT [PK___EFMigrationsHistory] PRIMARY KEY CLUSTERED 
(
	[MigrationId] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DestinoUser]    Script Date: 07/02/2022 22:35:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DestinoUser](
	[Id_Destino] [int] IDENTITY(1,1) NOT NULL,
	[País] [nvarchar](max) NOT NULL,
	[Cidade] [nvarchar](max) NOT NULL,
	[DataSaida] [nvarchar](max) NOT NULL,
	[DataChegada] [nvarchar](max) NOT NULL,
 CONSTRAINT [PK_DestinoUser] PRIMARY KEY CLUSTERED 
(
	[Id_Destino] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NovoUsers]    Script Date: 07/02/2022 22:35:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NovoUsers](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Nome] [nvarchar](max) NOT NULL,
	[CPF] [nvarchar](max) NOT NULL,
	[Email] [nvarchar](max) NOT NULL,
	[DestinoUserId_Destino] [int] NOT NULL,
 CONSTRAINT [PK_NovoUsers] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
ALTER TABLE [dbo].[NovoUsers]  WITH CHECK ADD  CONSTRAINT [FK_NovoUsers_DestinoUser_DestinoUserId_Destino] FOREIGN KEY([DestinoUserId_Destino])
REFERENCES [dbo].[DestinoUser] ([Id_Destino])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[NovoUsers] CHECK CONSTRAINT [FK_NovoUsers_DestinoUser_DestinoUserId_Destino]
GO
