package gamervault;

public class Main {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                TelaLogin tela = new TelaLogin();
                tela.setLocationRelativeTo(null);
                tela.setVisible(true);
            }
        });
    }
}
