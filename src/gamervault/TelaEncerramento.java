
package gamervault;

public class TelaEncerramento extends javax.swing.JFrame {

    public TelaEncerramento() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        DesejaSair = new javax.swing.JTextField();
        Home2 = new javax.swing.JButton();
        Sair1 = new javax.swing.JButton();
        Logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(16, 16, 16));
        jPanel1.setMinimumSize(new java.awt.Dimension(700, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 600));

        DesejaSair.setEditable(false);
        DesejaSair.setBackground(new java.awt.Color(16, 16, 16));
        DesejaSair.setFont(new java.awt.Font("Impact", 2, 24)); 
        DesejaSair.setForeground(new java.awt.Color(204, 204, 204));
        DesejaSair.setText("Deseja mesmo sair?");
        DesejaSair.setToolTipText("");
        DesejaSair.setBorder(null);
        DesejaSair.setDisabledTextColor(new java.awt.Color(255, 255, 255));

        Home2.setBackground(new java.awt.Color(255, 204, 102));
        Home2.setFont(new java.awt.Font("Impact", 0, 18)); 
        Home2.setForeground(new java.awt.Color(16, 16, 16));
        Home2.setText("Home");
        Home2.setBorder(null);
        Home2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Home2ActionPerformed(evt);
            }
        });

        Sair1.setBackground(new java.awt.Color(255, 51, 51));
        Sair1.setFont(new java.awt.Font("Impact", 0, 18)); 
        Sair1.setForeground(new java.awt.Color(16, 16, 16));
        Sair1.setText("Sair");
        Sair1.setBorder(null);
        Sair1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sair1ActionPerformed(evt);
            }
        });

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logo_small.png"))); 

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(248, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DesejaSair, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Home2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(Sair1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(248, 248, 248))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(DesejaSair, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Home2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Sair1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(156, 156, 156))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }

    private void Home2ActionPerformed(java.awt.event.ActionEvent evt) {                                      
        new TelaListaJogos().setVisible(true);
        this.dispose();
    }                                     

    private void Sair1ActionPerformed(java.awt.event.ActionEvent evt) {                                      
        System.exit(0);
    }                                     

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEncerramento().setVisible(true);
            }
        });
    }

    private javax.swing.JTextField DesejaSair;
    private javax.swing.JButton Home2;
    private javax.swing.JLabel Logo;
    private javax.swing.JButton Sair1;
    private javax.swing.JPanel jPanel1;
}