USE [NosaDD]
GO
/****** Object:  Table [dbo].[Actores]    Script Date: 14/02/2023 14:07:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Actores](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [varchar](50) NOT NULL,
	[Apellidos] [varchar](30) NOT NULL,
	[Imagen_Actor] [varchar](700) NULL,
	[Fecha_Nacimiento] [varchar](20) NULL,
	[Historia] [varchar](1000) NULL,
	[Nacionalidad] [varchar](30) NULL,
	[Valoracion] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ActoresPeliculas]    Script Date: 14/02/2023 14:07:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ActoresPeliculas](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[idActor] [int] NOT NULL,
	[idPelicula] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ActoresSeries]    Script Date: 14/02/2023 14:07:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ActoresSeries](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[idActor] [int] NOT NULL,
	[idSerie] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Directores]    Script Date: 14/02/2023 14:07:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Directores](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [varchar](50) NOT NULL,
	[Apellidos] [varchar](30) NOT NULL,
	[Fecha_Nacimiento] [varchar](20) NULL,
	[Historia] [varchar](1000) NULL,
	[Nacionalidad] [varchar](30) NULL,
	[Valoracion] [int] NULL,
	[Imagen_Director] [varchar](700) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DirectoresPeliculas]    Script Date: 14/02/2023 14:07:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DirectoresPeliculas](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[idDirector] [int] NOT NULL,
	[idPelicula] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DirectoresSeries]    Script Date: 14/02/2023 14:07:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DirectoresSeries](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[idDirector] [int] NOT NULL,
	[idSerie] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Generos]    Script Date: 14/02/2023 14:07:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Generos](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GenerosPeliculas]    Script Date: 14/02/2023 14:07:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GenerosPeliculas](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[idGenero] [int] NOT NULL,
	[idPelicula] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GenerosSeries]    Script Date: 14/02/2023 14:07:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GenerosSeries](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[idGenero] [int] NOT NULL,
	[idSerie] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Peliculas]    Script Date: 14/02/2023 14:07:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Peliculas](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[Titulo] [varchar](50) NOT NULL,
	[Duracion] [varchar](30) NOT NULL,
	[Resumen] [varchar](1000) NULL,
	[Valoracion] [int] NULL,
	[Imagen_Pelicula] [varchar](700) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Series]    Script Date: 14/02/2023 14:07:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Series](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[Titulo] [varchar](50) NOT NULL,
	[Duracion] [varchar](30) NOT NULL,
	[Temporadas] [int] NULL,
	[Capitulos] [int] NULL,
	[Resumen] [varchar](1000) NULL,
	[Valoracion] [int] NULL,
	[Imagen_Serie] [varchar](700) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[UsuarioPeliculas]    Script Date: 14/02/2023 14:07:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UsuarioPeliculas](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[idUsuario] [int] NOT NULL,
	[idPelicula] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Usuarios]    Script Date: 14/02/2023 14:07:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Usuarios](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [varchar](50) NOT NULL,
	[Apellidos] [varchar](50) NOT NULL,
	[Nombre_Usuario] [varchar](50) NOT NULL,
	[Imagen_Usuario] [varchar](700) NULL,
	[Correo_Electronico] [varchar](50) NOT NULL,
	[Contrasena] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[UsuarioSeries]    Script Date: 14/02/2023 14:07:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UsuarioSeries](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[idUsuario] [int] NOT NULL,
	[idSerie] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[ActoresPeliculas]  WITH CHECK ADD FOREIGN KEY([idActor])
REFERENCES [dbo].[Actores] ([id])
GO
ALTER TABLE [dbo].[ActoresPeliculas]  WITH CHECK ADD FOREIGN KEY([idPelicula])
REFERENCES [dbo].[Peliculas] ([id])
GO
ALTER TABLE [dbo].[ActoresSeries]  WITH CHECK ADD FOREIGN KEY([idActor])
REFERENCES [dbo].[Actores] ([id])
GO
ALTER TABLE [dbo].[ActoresSeries]  WITH CHECK ADD FOREIGN KEY([idSerie])
REFERENCES [dbo].[Series] ([id])
GO
ALTER TABLE [dbo].[DirectoresPeliculas]  WITH CHECK ADD FOREIGN KEY([idDirector])
REFERENCES [dbo].[Directores] ([id])
GO
ALTER TABLE [dbo].[DirectoresPeliculas]  WITH CHECK ADD FOREIGN KEY([idPelicula])
REFERENCES [dbo].[Peliculas] ([id])
GO
ALTER TABLE [dbo].[DirectoresSeries]  WITH CHECK ADD FOREIGN KEY([idDirector])
REFERENCES [dbo].[Directores] ([id])
GO
ALTER TABLE [dbo].[DirectoresSeries]  WITH CHECK ADD FOREIGN KEY([idSerie])
REFERENCES [dbo].[Series] ([id])
GO
ALTER TABLE [dbo].[GenerosPeliculas]  WITH CHECK ADD FOREIGN KEY([idGenero])
REFERENCES [dbo].[Generos] ([id])
GO
ALTER TABLE [dbo].[GenerosPeliculas]  WITH CHECK ADD FOREIGN KEY([idPelicula])
REFERENCES [dbo].[Peliculas] ([id])
GO
ALTER TABLE [dbo].[GenerosSeries]  WITH CHECK ADD FOREIGN KEY([idGenero])
REFERENCES [dbo].[Generos] ([id])
GO
ALTER TABLE [dbo].[GenerosSeries]  WITH CHECK ADD FOREIGN KEY([idSerie])
REFERENCES [dbo].[Series] ([id])
GO
ALTER TABLE [dbo].[UsuarioPeliculas]  WITH CHECK ADD FOREIGN KEY([idPelicula])
REFERENCES [dbo].[Peliculas] ([id])
GO
ALTER TABLE [dbo].[UsuarioPeliculas]  WITH CHECK ADD FOREIGN KEY([idUsuario])
REFERENCES [dbo].[Usuarios] ([id])
GO
ALTER TABLE [dbo].[UsuarioSeries]  WITH CHECK ADD FOREIGN KEY([idSerie])
REFERENCES [dbo].[Series] ([id])
GO
ALTER TABLE [dbo].[UsuarioSeries]  WITH CHECK ADD FOREIGN KEY([idUsuario])
REFERENCES [dbo].[Usuarios] ([id])
GO
