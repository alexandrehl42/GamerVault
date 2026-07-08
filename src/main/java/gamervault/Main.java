package gamervault;

import gamervault.view.TelaLogin;

public class Main {

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(() -> {

            TelaLogin tela = new TelaLogin();

            tela.setLocationRelativeTo(null);
            tela.setVisible(true);

        });

    }
}