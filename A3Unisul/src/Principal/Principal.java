package Principal;

import View.TelaInicial;

import java.io.IOException;
import java.sql.SQLException;

public class Principal {

    public static void main(String[] args) throws SQLException, IOException {

        TelaInicial objeto = new TelaInicial();
        objeto.setVisible(true);

    }
}
