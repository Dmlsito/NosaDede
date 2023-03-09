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
    /// Lógica de interacción para Register.xaml
    /// </summary>
    public partial class Register : Window
    {
        public Register()
        {
            InitializeComponent();
            userBox.Text = "Usuario";
            userBox.GotFocus += RemoveTextUser;
            userBox.LostFocus += AddTextUser;

            emailBox.Text = "E-mail";
            emailBox.GotFocus += RemoveTextEmail;
            emailBox.LostFocus += AddTextEmail;


            passBox.Text = "Contraseña";
            passBox.GotFocus += RemoveTextPass;
            passBox.LostFocus += AddTextPass;


            rePassBox.Text = "Repetir Contraseña";
            rePassBox.GotFocus += RemoveTextRePass;
            rePassBox.LostFocus += AddTextRePass;
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

        public void RemoveTextEmail(object sender, EventArgs e)
        {

            if (emailBox.Text == "E-mail")
            {
                emailBox.Text = "";
            }
        }

        public void AddTextEmail(object sender, EventArgs e)
        {

            if (string.IsNullOrWhiteSpace(emailBox.Text))
                emailBox.Text = "E-mail";
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

        public void RemoveTextRePass(object sender, EventArgs e)
        {

            if (rePassBox.Text == "Repetir Contraseña")
            {
                rePassBox.Text = "";
            }
        }

        public void AddTextRePass(object sender, EventArgs e)
        {

            if (string.IsNullOrWhiteSpace(rePassBox.Text))
                rePassBox.Text = "Repetir Contraseña";
        }

        private void mostrarPantallaLogin(object sender, RoutedEventArgs e)
        {
            MainWindow mainWindow = new MainWindow();
            mainWindow.Show();
            
        }


    }

    
}
