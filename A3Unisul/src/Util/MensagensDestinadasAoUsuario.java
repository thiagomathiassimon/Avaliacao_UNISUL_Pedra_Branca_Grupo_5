package Util;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import static javax.swing.JOptionPane.PLAIN_MESSAGE;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import static javax.swing.JOptionPane.DEFAULT_OPTION;

public class MensagensDestinadasAoUsuario {

    public static void mensagemSucesso(String message) {
        URL imagem = MensagensDestinadasAoUsuario.class.getResource("/Assets/Sucess.png");
        Image icone = Toolkit.getDefaultToolkit().getImage(imagem);
        JOptionPane.showMessageDialog(null, message, "Sucesso", PLAIN_MESSAGE, new ImageIcon(icone));
    }

    public static void mensagemSucesso(String message, String title) {
        URL imagem = MensagensDestinadasAoUsuario.class.getResource("/Assets/Sucess.png");
        Image icone = Toolkit.getDefaultToolkit().getImage(imagem);
        JOptionPane.showMessageDialog(null, message, title, PLAIN_MESSAGE, new ImageIcon(icone));
    }

    public static void mensagemErro(String message) {
        JOptionPane.showMessageDialog(null, message, "Erro", ERROR_MESSAGE);
    }

    public static void mensagemErro(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, ERROR_MESSAGE);
    }

    public static void mensagemAlerta(String message) {
        JOptionPane.showMessageDialog(null, message, "Alerta", WARNING_MESSAGE);
    }

    public static void mensagemAlerta(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, WARNING_MESSAGE);
    }

    public static void mensagemInformacao(String message) {
        JOptionPane.showMessageDialog(null, message, "Informação", PLAIN_MESSAGE);
    }

    public static void mensagemInformacao(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, PLAIN_MESSAGE);
    }

    public static int mensagemConfirmacao(String message) {

        Object[] options = {"Sim", "Não"};
        return JOptionPane.showOptionDialog(null, message, "Solicitação de confirmação", DEFAULT_OPTION, WARNING_MESSAGE,
                null, options, options[0]);
    }

    public static int mensagemConfirmacao(String message, String title) {
        Object[] options = {"Sim", "Não"};
        return JOptionPane.showOptionDialog(null, message, title, DEFAULT_OPTION, WARNING_MESSAGE,
                null, options, options[0]);
    }

}
