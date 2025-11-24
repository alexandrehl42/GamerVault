package gamervault;

import javax.swing.table.DefaultTableModel;
import javax.swing.border.EmptyBorder;
import java.util.List;

public class TelaListaJogos extends javax.swing.JFrame {

    private JogoDAO jogoDAO = new JogoDAO();

    public TelaListaJogos() {
        initComponents();
        setLocationRelativeTo(null);
        atualizarTabela();
    }

    private void atualizarTabela() {
        DefaultTableModel model = (DefaultTableModel) tabelaJogos.getModel();
        model.setRowCount(0);

        try {
            List<Jogo> lista = jogoDAO.listarTodos();

            for (Jogo j : lista) {
                model.addRow(new Object[]{
                    j.getNome(),
                    j.getGenero(),
                    j.getPlataforma(),
                    j.getHorasJogadas()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        Fundo = new javax.swing.JPanel();
        Cadastro = new javax.swing.JButton();
        Home = new javax.swing.JButton();
        Sair = new javax.swing.JButton();
        BarraPesquisa = new javax.swing.JTextField();
        Pesquisar = new javax.swing.JButton();
        listajogostitulo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaJogos = new javax.swing.JTable();
        Logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Fundo.setBackground(new java.awt.Color(16, 16, 16));
        Fundo.setMinimumSize(new java.awt.Dimension(700, 600));

        Cadastro.setBackground(new java.awt.Color(0, 255, 255));
        Cadastro.setFont(new java.awt.Font("Impact", 0, 18));
        Cadastro.setForeground(new java.awt.Color(16, 16, 16));
        Cadastro.setText("Novo Cadastro");
        Cadastro.setBorder(null);
        Cadastro.addActionListener(evt -> CadastroActionPerformed(evt));

        Home.setBackground(new java.awt.Color(255, 204, 102));
        Home.setFont(new java.awt.Font("Impact", 0, 18));
        Home.setForeground(new java.awt.Color(16, 16, 16));
        Home.setText("Home");
        Home.setBorder(null);

        Sair.setBackground(new java.awt.Color(255, 51, 51));
        Sair.setFont(new java.awt.Font("Impact", 0, 18));
        Sair.setForeground(new java.awt.Color(16, 16, 16));
        Sair.setText("Sair");
        Sair.setBorder(null);
        Sair.addActionListener(evt -> SairActionPerformed(evt));

        Pesquisar.setBackground(new java.awt.Color(204, 204, 204));
        Pesquisar.setText("Pesquisar");
        Pesquisar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Pesquisar.addActionListener(evt -> PesquisarActionPerformed(evt));

        listajogostitulo.setEditable(false);
        listajogostitulo.setBackground(new java.awt.Color(16, 16, 16));
        listajogostitulo.setFont(new java.awt.Font("Impact", 0, 36));
        listajogostitulo.setForeground(new java.awt.Color(204, 204, 204));
        listajogostitulo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        listajogostitulo.setText("Lista de Jogos");
        listajogostitulo.setBorder(null);

        tabelaJogos.setBackground(new java.awt.Color(204, 204, 204));
        tabelaJogos.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Nome do Jogo", "Gênero", "Plataforma", "Horas Jogadas"
                }
        ));
        jScrollPane1.setBorder(new EmptyBorder(0, 0, 15, 0));
        jScrollPane1.setViewportView(tabelaJogos);

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logo_smaller.png")));

        javax.swing.GroupLayout FundoLayout = new javax.swing.GroupLayout(Fundo);
        Fundo.setLayout(FundoLayout);
        FundoLayout.setHorizontalGroup(
            FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(FundoLayout.createSequentialGroup()
                    .addGap(54)
                    .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(listajogostitulo)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE))
                    .addContainerGap(59, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FundoLayout.createSequentialGroup()
                    .addContainerGap(90, Short.MAX_VALUE)
                    .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FundoLayout.createSequentialGroup()
                            .addComponent(Logo)
                            .addGap(210, 210, 210))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FundoLayout.createSequentialGroup()
                            .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(FundoLayout.createSequentialGroup()
                                    .addComponent(Home, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18)
                                    .addComponent(Cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18)
                                    .addComponent(Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(BarraPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(Pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(111))))
        );

        FundoLayout.setVerticalGroup(
            FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(FundoLayout.createSequentialGroup()
                    .addGap(40)
                    .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Home, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addComponent(Logo)
                    .addGap(18)
                    .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BarraPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(33)
                    .addComponent(listajogostitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Fundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Fundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

    private void CadastroActionPerformed(java.awt.event.ActionEvent evt) {
        new TelaCadastroJogos().setVisible(true);
        this.dispose();
    }

    private void SairActionPerformed(java.awt.event.ActionEvent evt) {
        new TelaEncerramento().setVisible(true);
        this.dispose();
    }

    private void PesquisarActionPerformed(java.awt.event.ActionEvent evt) {
        String termo = BarraPesquisa.getText().trim().toLowerCase();

        DefaultTableModel model = (DefaultTableModel) tabelaJogos.getModel();
        model.setRowCount(0);

        try {
            List<Jogo> lista = jogoDAO.buscarPorNome(termo);

            for (Jogo j : lista) {
                model.addRow(new Object[]{
                    j.getNome(),
                    j.getGenero(),
                    j.getPlataforma(),
                    j.getHorasJogadas()
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new TelaListaJogos().setVisible(true));
    }

    private javax.swing.JTextField BarraPesquisa;
    private javax.swing.JButton Cadastro;
    private javax.swing.JPanel Fundo;
    private javax.swing.JButton Home;
    private javax.swing.JLabel Logo;
    private javax.swing.JButton Pesquisar;
    private javax.swing.JButton Sair;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField listajogostitulo;
    private javax.swing.JTable tabelaJogos;
}