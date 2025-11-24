package gamervault;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

public class TelaLogin extends javax.swing.JFrame {

    public TelaLogin() {
        initComponents();
        setLocationRelativeTo(null);
        configurarCliqueParaAvancar();
    }

    private void configurarCliqueParaAvancar() {
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                abrirListaJogos();
            }
        });
        
        getContentPane().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                abrirListaJogos();
            }
        });
    }

    private void abrirListaJogos() {
        TelaListaJogos tela = new TelaListaJogos();
        tela.setVisible(true);
        dispose();
    }
    @SuppressWarnings("unchecked")
    private void initComponents() {

        Fundo = new javax.swing.JPanel();
        bemvindo = new javax.swing.JTextField();
        cliquenatela = new javax.swing.JTextField();
        Logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 600));

        Fundo.setBackground(new java.awt.Color(16, 16, 16));
        Fundo.setMinimumSize(new java.awt.Dimension(700, 600));
        Fundo.setPreferredSize(new java.awt.Dimension(700, 600));
        Fundo.setVerifyInputWhenFocusTarget(false);

        bemvindo.setEditable(false);
        bemvindo.setBackground(new java.awt.Color(16, 16, 16));
        bemvindo.setFont(new java.awt.Font("Impact", 2, 24));
        bemvindo.setForeground(new java.awt.Color(204, 204, 204));
        bemvindo.setText("Olá, seja bem-vindo!");
        bemvindo.setToolTipText("");
        bemvindo.setBorder(null);
        bemvindo.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        bemvindo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bemvindoActionPerformed(evt);
            }
        });

        cliquenatela.setEditable(false);
        cliquenatela.setBackground(new java.awt.Color(16, 16, 16));
        cliquenatela.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 18));
        cliquenatela.setForeground(new java.awt.Color(153, 153, 153));
        cliquenatela.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cliquenatela.setText("Clique na tela para continuar");
        cliquenatela.setToolTipText("");
        cliquenatela.setBorder(null);
        cliquenatela.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        cliquenatela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cliquenatelaActionPerformed(evt);
            }
        });

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logo_small.png")));

        javax.swing.GroupLayout FundoLayout = new javax.swing.GroupLayout(Fundo);
        Fundo.setLayout(FundoLayout);
        FundoLayout.setHorizontalGroup(
            FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FundoLayout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 121, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FundoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FundoLayout.createSequentialGroup()
                        .addComponent(cliquenatela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(253, 253, 253))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FundoLayout.createSequentialGroup()
                        .addComponent(bemvindo, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(241, 241, 241))))
        );
        FundoLayout.setVerticalGroup(
            FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FundoLayout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(bemvindo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123)
                .addComponent(cliquenatela, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );

        Logo.getAccessibleContext().setAccessibleName("Logo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Fundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Fundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }

    private void bemvindoActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void cliquenatelaActionPerformed(java.awt.event.ActionEvent evt) {
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    private javax.swing.JPanel Fundo;
    private javax.swing.JLabel Logo;
    private javax.swing.JTextField bemvindo;
    private javax.swing.JTextField cliquenatela;
}