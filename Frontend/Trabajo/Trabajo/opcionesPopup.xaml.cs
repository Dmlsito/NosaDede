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
    /// Lógica de interacción para opcionesPopup.xaml
    /// </summary>
    public partial class opcionesPopup : Window
    {
        public opcionesPopup()
        {
            InitializeComponent();
            sp.Background = new SolidColorBrush(Color.FromArgb(255, 41, 41, 41));
        }

        private void bt1_Click(object sender, RoutedEventArgs e)
        {
            opciones.IsOpen = true;
        }
    }
}
