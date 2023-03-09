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
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Trabajo
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            
            InitializeComponent();
           
            userBox.Text = "Usuario";

            userBox.GotFocus += RemoveTextUser;
            userBox.LostFocus += AddTextUser;


            passBox.Text = "Contraseña";

            passBox.GotFocus += RemoveTextPass;
            passBox.LostFocus += AddTextPass;
        }

        public void RemoveTextUser(object sender, EventArgs e)
        {
            if (userBox.Text == "Usuario")
            {
                userBox.Text = "";
            }
        }

        public void AddTextUser(object sender, EventArgs e)
        {
            if (string.IsNullOrWhiteSpace(userBox.Text))
                userBox.Text = "Usuario";

        }

        public void RemoveTextPass(object sender, EventArgs e)
        {

            if (passBox.Text == "Contraseña")
            {
                passBox.Text = "";
            }
        }

        public void AddTextPass(object sender, EventArgs e)
        {

            if (string.IsNullOrWhiteSpace(passBox.Text))
                passBox.Text = "Contraseña";
        }

        /*private void mostrarPantallaRegistro(object sender, EventArgs e) {

            Register registro = new Register();
            registro.Show();
        }
        */


        //Boton de iniciar sesion
        private void Button_Click(object sender, RoutedEventArgs e)
        {

        }

        private void mostrarPantallaRegister(object sender, RoutedEventArgs e) {
            Register registro = new Register();
            registro.Show();
        }

        //Boton de registrarte
        private void Button_Click_1(object sender, RoutedEventArgs e)
        {

        }
    }
}
