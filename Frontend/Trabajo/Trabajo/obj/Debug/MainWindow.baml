   M S B A M L   `   `   `  ????B  >Trabajo, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null!clr-namespace:TrabajoTrabajo  5   	       Trabajo.MainWindow   5   	   R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   'localclr-namespace:Trabajo     5   	     ? WindowState$  	Maximized=?5   	    ? Title$ 
MainWindow??5	   	   $	??450??6   $	??800??6)   .??5
      ? .+?5   
   ?? $
??Fill=?6   $w??qhttps://cdn2.actitudfem.com/media/files/styles/16x9_large/public/images/2020/05/servicios-de-streaming-gratis.jpg??6   6?   ? 5   
    ? ColumnDefinitions 5      ?? 5      6%    ? RowDefinitions 5      ?? 5      $	??30* ?6    6/   ?? 5      $	??70* ?6    6/   .+?5      ?? $??0??6   ._?5      ?? $??40,0,0,0q?6   $^??Xhttps://github.com/Dmlsito/NosaDede/blob/master/Documentacion/logo_nosadede.png?raw=true??6+   $??Center=?6?   $
??2000??6?   $	??400??6?   6?   5      ?? 5      $??1??6   $	??800??6$   $	??500??61   ???#eee$??0, 0, 0, 100q?6R    J? BitmapEffect 5      F? 5       F? Color$
 #fff??6-    F? 	Direction$	 270Q?6:    F? ShadowDepth$ 3Q?6J    F? Opacity$ 1Q?6Z   	 F? Softness$	 2Q?6f   ._?5      ?? ??5      ?? 5      ??5!   "   ? 
 ? Offset$	
 0.0Q?6/    ? Color$
 #fff??5"   /   ? 5#   "   $	
 1.0Q?6/   $ #596CFA??5$   /   5&      .+?5(      ?? $??Log in??6   $??50(?6/   $??Center=?6=   $??0, 100, 0, 0q?6Z   ???#596CFA$
??Bold"?6?    J? Effect 5)      3  -System.Windows.Media.Effects.DropShadowEffect  5*         ShadowDepth$ 4Q?5+   !      	Direction$	 330Q?5,   !      Color$ Black??5-   !      Opacity$	 0.5Q?5.   !      
BlurRadius$ 4Q?5/   !   50       52      ?? 54      -   5        $??userBox??54      $??56??6-   $	??340??69   $??20(?6E   $??0, 50, 0, 10q?6T   $??10q?6l   ???#fff$
??Bold"?6?   ???#82abff.??6?    ? 	Resources 55       ?? 
TargetType ?? Property ?? Value??%_   '??       ?? 56      " ??6$   .?57   "   ??  ?@??CornerRadius$ 22??6A   59      5:      .??61    5;        5<      $ 4Q?5=   "   $	 330Q?5>   "   $
 #222??5?   "   $	 0.6Q?5@   "   $ 9Q?5A   "   .??5B   *   5C      ?? 5F      -   5        $??passBox??5F      $??56??6-   $	??340??69   $??20(?6E   $??10q?6S   ???#fff$
??Bold"?6r   ???#82abff.??6?    5G      ??%_   '??       ?? 5H      " ??6$   .?5I   "   ??  ?@??CornerRadius$ 22??6A   5J      5K      .??6-    5L        5M      $ 4Q?5N   "   $	 330Q?5O   "   $
 #222??5P   "   $	 0.6Q?5Q   "   $ 9Q?5R   "   .??5S   *   5T      ?? 5V      $??0, 20, 0, 0q?6   $	??170??64   $??20(?6@   $
??Bold"?6O   ???#fff???#596CFA.??6?   Login 5W      ??%_   '??       ?? 5X      " ??6$   .?5Y   "   ??  ?@??CornerRadius$ 22??6B   5Z      5[       5\        5]      $ 4Q?5^   !   $	 330Q?5_   "   $
 #222??5`   "   $	 0.6Q?5a   "   $ 9Q?5b   "   5d      5f      ?? 5i      $??¿No tienes cuenta? ??6     ?? TextAlignment$
 Left=?6;   $??0, 100, 0,0 q?6P   $??25(?6h   ???#fff$??Center=?6?    ?? Padding$ 10q?6?   ?? 5j      -   5         ?? TextDecorations$
 none{?5j   J   .?6b   Registrarse6o   5k      5m      5n      5o      5q      5r      