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
    /// Lógica de interacción para Detalles.xaml
    /// </summary>
    public partial class Detalles : Window
    {
        public Detalles()
        {
            InitializeComponent();
            this.WindowState = WindowState.Maximized;

            tamañoimg.Height = new GridLength((System.Windows.SystemParameters.PrimaryScreenHeight * 0.6));
        }


        private void Window_StateChanged(object sender, EventArgs e)
        {
            
            tamañoimg.Height = new GridLength((System.Windows.SystemParameters.PrimaryScreenHeight * 0.6));
            titulo.Text = sender.ToString() + " -- " + e.ToString();
        }
    }
}
