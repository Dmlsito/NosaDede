using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace Trabajo
{
    /// <summary>
    /// Lógica de interacción para principal.xaml
    /// </summary>
    public partial class principal : Window
    {
        int scroll = 0;
        int scroll1 = 0;
        int scroll2 = 0;
        public principal()
        {
            InitializeComponent();
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            if (scroll>=0) {
                scroll -= 160;
            }
           
            scestreno.ScrollToHorizontalOffset(scroll);
        }

        private void Button_Click_1(object sender, RoutedEventArgs e)
        {
            if (scroll<=scestreno.ScrollableWidth) {
                scroll += 160;
            }
            
            scestreno.ScrollToHorizontalOffset(scroll);
        }

        private void Button_Click_2(object sender, RoutedEventArgs e)
        {
            if (scroll1 >= 0)
            {
                scroll1 -= 160;
            }

            recomendado.ScrollToHorizontalOffset(scroll1);
        }

        private void Button_Click_3(object sender, RoutedEventArgs e)
        {
            if (scroll1 <= recomendado.ScrollableWidth)
            {
                scroll1 += 160;
            }

            recomendado.ScrollToHorizontalOffset(scroll1);
        }

        private void Button_Click_4(object sender, RoutedEventArgs e)
        {
            if (scroll2 >= 0)
            {
                scroll2 -= 160;
            }

            srecomendado.ScrollToHorizontalOffset(scroll2);
        }

        private void Button_Click_5(object sender, RoutedEventArgs e)
        {
            if (scroll2 <= srecomendado.ScrollableWidth)
            {
                scroll2 += 160;
            }

            srecomendado.ScrollToHorizontalOffset(scroll2);
        }

        private void estreno1_MouseEnter(object sender, MouseEventArgs e)
        {
            datosEstrenos1.Visibility = Visibility.Visible;
            notaEstreno1.Visibility = Visibility.Visible;
        }

        private void estreno1_MouseLeave(object sender, MouseEventArgs e)
        {
            datosEstrenos1.Visibility = Visibility.Hidden;
            notaEstreno1.Visibility = Visibility.Hidden;
        }

        private void estreno2_MouseEnter(object sender, MouseEventArgs e)
        {
            datosEstrenos2.Visibility = Visibility.Visible;
            notaEstreno2.Visibility = Visibility.Visible;
        }

        private void estreno2_MouseLeave(object sender, MouseEventArgs e)
        {
            datosEstrenos2.Visibility = Visibility.Hidden;
            notaEstreno2.Visibility = Visibility.Hidden;
        }

        private void estreno3_MouseEnter(object sender, MouseEventArgs e)
        {
            datosEstrenos3.Visibility = Visibility.Visible;
            notaEstreno3.Visibility = Visibility.Visible;
        }

        private void estreno3_MouseLeave(object sender, MouseEventArgs e)
        {
            datosEstrenos3.Visibility = Visibility.Hidden;
            notaEstreno3.Visibility = Visibility.Hidden;
        }

        private void estreno4_MouseEnter(object sender, MouseEventArgs e)
        {
            datosEstrenos4.Visibility = Visibility.Visible;
            notaEstreno4.Visibility = Visibility.Visible;
        }

        private void estreno4_MouseLeave(object sender, MouseEventArgs e)
        {
            datosEstrenos4.Visibility = Visibility.Hidden;
            notaEstreno4 .Visibility = Visibility.Hidden;
        }

        private void estreno5_MouseEnter(object sender, MouseEventArgs e)
        {
            datosEstrenos5.Visibility = Visibility.Visible;
            notaEstreno5.Visibility = Visibility.Visible;
        }

        private void estreno5_MouseLeave(object sender, MouseEventArgs e)
        {
            datosEstrenos5.Visibility = Visibility.Hidden;
            notaEstreno5.Visibility = Visibility.Hidden;
        }

        private void estreno6_MouseEnter(object sender, MouseEventArgs e)
        {
            datosEstrenos6.Visibility = Visibility.Visible;
            notaEstreno6.Visibility = Visibility.Visible;
        }

        private void estreno6_MouseLeave(object sender, MouseEventArgs e)
        {
            datosEstrenos6.Visibility = Visibility.Hidden;
            notaEstreno6.Visibility = Visibility.Hidden;
        }

        private void estreno7_MouseEnter(object sender, MouseEventArgs e)
        {
            datosEstrenos7.Visibility = Visibility.Visible;
            notaEstreno7.Visibility = Visibility.Visible;
        }

        private void estreno7_MouseLeave(object sender, MouseEventArgs e)
        {
            datosEstrenos7.Visibility = Visibility.Hidden;
            notaEstreno7.Visibility = Visibility.Hidden;
        }

        private void estreno8_MouseEnter(object sender, MouseEventArgs e)
        {
            datosEstrenos8.Visibility = Visibility.Visible;
            notaEstreno8.Visibility = Visibility.Visible;
        }

        private void estreno8_MouseLeave(object sender, MouseEventArgs e)
        {
            datosEstrenos8.Visibility = Visibility.Hidden;
            notaEstreno8.Visibility = Visibility.Hidden;
        }

        private void estreno9_MouseEnter(object sender, MouseEventArgs e)
        {
            datosEstrenos9.Visibility = Visibility.Visible;
            notaEstreno9.Visibility = Visibility.Visible;
        }

        private void estreno9_MouseLeave(object sender, MouseEventArgs e)
        {
            datosEstrenos9.Visibility = Visibility.Hidden;
            notaEstreno9.Visibility = Visibility.Hidden;
        }

        private void estreno10_MouseEnter(object sender, MouseEventArgs e)
        {
            datosEstrenos10.Visibility = Visibility.Visible;
            notaEstreno10.Visibility = Visibility.Visible;
        }

        private void estreno10_MouseLeave(object sender, MouseEventArgs e)
        {
            datosEstrenos10.Visibility = Visibility.Hidden;
            notaEstreno10.Visibility = Visibility.Hidden;
        }

        private void recomendacion1_MouseEnter(object sender, MouseEventArgs e)
        {
            datosRecomendacion1.Visibility = Visibility.Visible;
            notaRecomendacion1.Visibility = Visibility.Visible;
        }

        private void recomendacion1_MouseLeave(object sender, MouseEventArgs e)
        {
            datosRecomendacion1.Visibility = Visibility.Hidden;
            notaRecomendacion1.Visibility = Visibility.Hidden;
        }

        private void recomendacion2_MouseEnter(object sender, MouseEventArgs e)
        {
            datosRecomendacion2.Visibility = Visibility.Visible;
            notaRecomendacion2.Visibility = Visibility.Visible;
        }

        private void recomendacion2_MouseLeave(object sender, MouseEventArgs e)
        {
            datosRecomendacion2.Visibility = Visibility.Hidden;
            notaRecomendacion2.Visibility = Visibility.Hidden;
        }

        private void recomendacion3_MouseEnter(object sender, MouseEventArgs e)
        {
            datosRecomendacion3.Visibility = Visibility.Visible;
            notaRecomendacion3.Visibility = Visibility.Visible;
        }

        private void recomendacion3_MouseLeave(object sender, MouseEventArgs e)
        {
            datosRecomendacion3.Visibility = Visibility.Hidden;
            notaRecomendacion3.Visibility = Visibility.Hidden;
        }

        private void recomendacion4_MouseEnter(object sender, MouseEventArgs e)
        {
            datosRecomendacion4.Visibility = Visibility.Visible;
            notaRecomendacion4.Visibility = Visibility.Visible;
        }

        private void recomendacion4_MouseLeave(object sender, MouseEventArgs e)
        {
            datosRecomendacion4.Visibility = Visibility.Hidden;
            notaRecomendacion4.Visibility = Visibility.Hidden;
        }
        private void recomendacion5_MouseEnter(object sender, MouseEventArgs e)
        {
            datosRecomendacion5.Visibility = Visibility.Visible;
            notaRecomendacion5.Visibility = Visibility.Visible;
        }

        private void recomendacion5_MouseLeave(object sender, MouseEventArgs e)
        {
            datosRecomendacion5.Visibility = Visibility.Hidden;
            notaRecomendacion5.Visibility = Visibility.Hidden;
        }
        private void recomendacion6_MouseEnter(object sender, MouseEventArgs e)
        {
            datosRecomendacion6.Visibility = Visibility.Visible;
            notaRecomendacion6.Visibility = Visibility.Visible;
        }

        private void recomendacion6_MouseLeave(object sender, MouseEventArgs e)
        {
            datosRecomendacion6.Visibility = Visibility.Hidden;
            notaRecomendacion6.Visibility = Visibility.Hidden;
        }
        private void recomendacion7_MouseEnter(object sender, MouseEventArgs e)
        {
            datosRecomendacion7.Visibility = Visibility.Visible;
            notaRecomendacion7.Visibility = Visibility.Visible;
        }

        private void recomendacion7_MouseLeave(object sender, MouseEventArgs e)
        {
            datosRecomendacion7.Visibility = Visibility.Hidden;
            notaRecomendacion7.Visibility = Visibility.Hidden;
        }

        private void recomendacion8_MouseEnter(object sender, MouseEventArgs e)
        {
            datosRecomendacion8.Visibility = Visibility.Visible;
            notaRecomendacion8.Visibility = Visibility.Visible;
        }

        private void recomendacion8_MouseLeave(object sender, MouseEventArgs e)
        {
            datosRecomendacion8.Visibility = Visibility.Hidden;
            notaRecomendacion8.Visibility = Visibility.Hidden;
        }
        private void recomendacion9_MouseEnter(object sender, MouseEventArgs e)
        {
            datosRecomendacion9.Visibility = Visibility.Visible;
            notaRecomendacion9.Visibility = Visibility.Visible;
        }

        private void recomendacion9_MouseLeave(object sender, MouseEventArgs e)
        {
            datosRecomendacion9.Visibility = Visibility.Hidden;
            notaRecomendacion9.Visibility = Visibility.Hidden;
        }

        private void recomendacion10_MouseEnter(object sender, MouseEventArgs e)
        {
            datosRecomendacion10.Visibility = Visibility.Visible;
            notaRecomendacion10.Visibility = Visibility.Visible;
        }

        private void recomendacion10_MouseLeave(object sender, MouseEventArgs e)
        {
            datosRecomendacion10.Visibility = Visibility.Hidden;
            notaRecomendacion10.Visibility = Visibility.Hidden;
        }

    }
}
