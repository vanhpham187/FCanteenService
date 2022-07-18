USE [test_db]
GO
SET IDENTITY_INSERT [dbo].[kiosk] ON 
GO
INSERT [dbo].[kiosk] ([kiosk_id], [location], [owner_name], [owner_phone], [rental_fee]) VALUES (1, N'Hanoi', N'Ha Noi pho                                                                                          ', N'09123456       ', 10000000.0000)
GO
INSERT [dbo].[kiosk] ([kiosk_id], [location], [owner_name], [owner_phone], [rental_fee]) VALUES (2, N'Hanoi', N'Quang Anh                                                                                           ', N'097123456      ', 15000000.0000)
GO
INSERT [dbo].[kiosk] ([kiosk_id], [location], [owner_name], [owner_phone], [rental_fee]) VALUES (3, N'Hanoi', N'Mango                                                                                               ', N'098123456      ', 12000000.0000)
GO
INSERT [dbo].[kiosk] ([kiosk_id], [location], [owner_name], [owner_phone], [rental_fee]) VALUES (4, N'Hanoi', N'An Viet                                                                                             ', N'096123456      ', 13000000.0000)
GO
SET IDENTITY_INSERT [dbo].[kiosk] OFF
GO
SET IDENTITY_INSERT [dbo].[store] ON 
GO
INSERT [dbo].[store] ([store_id], [manager_id], [hotline], [kiosk_id]) VALUES (1, 1, N'09123456       ', 1)
GO
INSERT [dbo].[store] ([store_id], [manager_id], [hotline], [kiosk_id]) VALUES (2, 1, N'097123456      ', 2)
GO
INSERT [dbo].[store] ([store_id], [manager_id], [hotline], [kiosk_id]) VALUES (3, 1, N'098123456      ', 3)
GO
INSERT [dbo].[store] ([store_id], [manager_id], [hotline], [kiosk_id]) VALUES (4, 1, N'096123456      ', 4)
GO
SET IDENTITY_INSERT [dbo].[store] OFF
GO
INSERT [dbo].[dish] ([dish_id], [store_id], [dish_name], [description], [image_url]) VALUES (1, 1, N'Bun bo hue                                                                                          ', N'35000                                                                                                                                                                                                   ', N'https://www.thatlangon.com/wp-content/uploads/2021/02/15523img_6035a6a9109f1.jpg                                                                                                                        ')
GO
INSERT [dbo].[dish] ([dish_id], [store_id], [dish_name], [description], [image_url]) VALUES (2, 1, N'Pho bo                                                                                              ', N'35000                                                                                                                                                                                                   ', N'http://cdn.tgdd.vn/Files/2022/01/25/1412805/cach-nau-pho-bo-nam-dinh-chuan-vi-thom-ngon-nhu-hang-quan-202201250230038502.jpg                                                                            ')
GO
INSERT [dbo].[dish] ([dish_id], [store_id], [dish_name], [description], [image_url]) VALUES (3, 1, N'Bun ca                                                                                              ', N'35000                                                                                                                                                                                                   ', N'https://cdn.tgdd.vn/Files/2021/09/11/1381884/cach-nau-bun-ca-ha-noi-thom-ngon-chuan-vi-202109111452323215.jpg                                                                                           ')
GO
INSERT [dbo].[dish] ([dish_id], [store_id], [dish_name], [description], [image_url]) VALUES (4, 2, N'Banh bao nhan thap cam                                                                              ', N'12000                                                                                                                                                                                                   ', N'https://img-global.cpcdn.com/recipes/2d03044e17027eac/680x482cq70/banh-bao-nhan-th%E1%BA%ADp-c%E1%BA%A9m-recipe-main-photo.jpg                                                                          ')
GO
INSERT [dbo].[dish] ([dish_id], [store_id], [dish_name], [description], [image_url]) VALUES (5, 2, N'Banh bao nhan xa xiu                                                                                ', N'15000                                                                                                                                                                                                   ', N'https://thophat.com/wp-content/uploads/2022/03/BB-Xa-Xiu-1.jpg                                                                                                                                          ')
GO
INSERT [dbo].[dish] ([dish_id], [store_id], [dish_name], [description], [image_url]) VALUES (6, 2, N'Banh my thap cam                                                                                    ', N'20000                                                                                                                                                                                                   ', N'https://webreview.vn/images/items/117365.jpg                                                                                                                                                            ')
GO
INSERT [dbo].[dish] ([dish_id], [store_id], [dish_name], [description], [image_url]) VALUES (7, 3, N'My xao bo                                                                                           ', N'35000                                                                                                                                                                                                   ', N'https://cdn.tgdd.vn/2021/03/CookProduct/miaoboraucai-1200x676.jpg                                                                                                                                       ')
GO
INSERT [dbo].[dish] ([dish_id], [store_id], [dish_name], [description], [image_url]) VALUES (8, 3, N'Khoai tay chien                                                                                     ', N'15000                                                                                                                                                                                                   ', N'https://image-us.eva.vn/upload/2-2022/images/2022-05-11/image4-1652235506-477-width600height367.jpg                                                                                                     ')
GO
INSERT [dbo].[dish] ([dish_id], [store_id], [dish_name], [description], [image_url]) VALUES (9, 3, N'Hamburger                                                                                           ', N'25000                                                                                                                                                                                                   ', N'https://cdn.beptruong.edu.vn/wp-content/uploads/2013/04/hamburger-han-quoc-thanh-pham-ngon-600x400.jpg                                                                                                  ')
GO
INSERT [dbo].[dish] ([dish_id], [store_id], [dish_name], [description], [image_url]) VALUES (10, 4, N'Coca                                                                                                ', N'10000                                                                                                                                                                                                   ', N'https://fujimart.vn/image/cache/catalog/%C4%90%E1%BB%93%20u%E1%BB%91ng/nuoc%20coca%20light%20sleek%20330ml-600x315.png                                                                                  ')
GO
INSERT [dbo].[dish] ([dish_id], [store_id], [dish_name], [description], [image_url]) VALUES (11, 4, N'Tra chanh                                                                                           ', N'15000                                                                                                                                                                                                   ', N'https://www.unileverfoodsolutions.com.vn/dam/global-ufs/mcos/phvn/vietnam/calcmenu/recipes/VN-recipes/other/energizing-lemon-tea/main-header.jpg                                                        ')
GO
INSERT [dbo].[dish] ([dish_id], [store_id], [dish_name], [description], [image_url]) VALUES (12, 4, N'Sting                                                                                               ', N'10000                                                                                                                                                                                                   ', N'https://cdn.tgdd.vn/Products/Images/3226/76520/bhx/nuoc-tang-luc-sting-huong-dau-330ml-201909031559004919.jpg                                                                                           ')
GO
