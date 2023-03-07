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
            if (estreno1.IsMouseCaptured) { 
            
            }
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
    }
}
