
package Util;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class MensagensDestinadasAoUsuario {

    
    
    public static void mensagemSucesso(String message) {
        URL imagem = MensagensDestinadasAoUsuario.class.getResource("/Assets/Check.jpeg");
        Image icone = Toolkit.getDefaultToolkit().getImage(imagem);
        JOptionPane.showMessageDialog(null, message, "Sucesso", JOptionPane.PLAIN_MESSAGE, new ImageIcon(icone));
    }

    /*public static void mensagemSucesso(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title,);
    }*/
    public static void mensagemErro(String message) {
        JOptionPane.showMessageDialog(null, message, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static void mensagemErro(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }

    public static void mensagemAlerta(String message) {
        JOptionPane.showMessageDialog(null, message, "Alerta", JOptionPane.WARNING_MESSAGE);
    }

    public static void mensagemAlerta(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE);
    }

    public static void mensagemInformacao(String message) {
        JOptionPane.showMessageDialog(null, message, "Informação", JOptionPane.PLAIN_MESSAGE);
    }

    public static void mensagemInformacao(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
    }

    public static void mensagemConfirmacao(String message) {

        Object[] options = {"Sim", "Não"};
        JOptionPane.showOptionDialog(null, message, "Solicitação de confirmação", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                null, options, options[0]);
    }

    public static void mensagemConfirmacao(String message, String title) {
        Object[] options = {"Sim", "Não"};
        JOptionPane.showOptionDialog(null, message, title, JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                null, options, options[0]);
    }

}
