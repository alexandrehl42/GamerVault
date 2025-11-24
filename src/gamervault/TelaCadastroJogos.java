package gamervault;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaCadastroJogos extends javax.swing.JFrame {

    private JogoDAO dao = new JogoDAO();

    public TelaCadastroJogos() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void atualizarTabela() {
        DefaultTableModel model = (DefaultTableModel) tabelaJogos.getModel();
        model.setRowCount(0);

        try {
            List<Jogo> lista = dao.listar();
            for (Jogo j : lista) {
                model.addRow(new Object[]{
                    j.getNome(),
                    j.getGenero(),
                    j.getPlataforma(),
                    j.getHorasJogadas()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao listar jogos: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void salvarJogo() {
        try {
            String nome = txtNome.getText().trim();
            String genero = txtGenero.getText().trim();
            String plataforma = txtPlataforma.getText().trim();
            String horasStr = txtHoras.getText().trim();

            if (nome.isEmpty() || plataforma.isEmpty() || horasStr.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Nome, Plataforma e Horas são obrigatórios!");
                return;
            }

            int horas = Integer.parseInt(horasStr);

            Jogo novo = new Jogo(nome, genero, plataforma, horas);
            dao.inserir(novo);

            JOptionPane.showMessageDialog(this, "Jogo salvo com sucesso!");

            txtNome.setText("");
            txtGenero.setText("");
            txtPlataforma.setText("");
            txtHoras.setText("");

            atualizarTabela();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Horas jogadas deve ser um número inteiro.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            txtHoras.requestFocus();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao salvar jogo: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

          jPanel1 = new javax.swing.JPanel();
        Home2 = new javax.swing.JButton();
        Cadastro1 = new javax.swing.JButton();
        Sair1 = new javax.swing.JButton();
        Logo = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblGenero = new javax.swing.JLabel();
        lblPlataforma = new javax.swing.JLabel();
        lblHoras = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtGenero = new javax.swing.JTextField();
        txtPlataforma = new javax.swing.JTextField();
        txtHoras = new javax.swing.JTextField();
        Cancelar = new javax.swing.JButton();
        Limpar = new javax.swing.JButton();
        Salvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaJogos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Jogos");

        jPanel1.setBackground(new java.awt.Color(16, 16, 16));
        jPanel1.setMinimumSize(new java.awt.Dimension(700, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 600));

        Home2.setBackground(new java.awt.Color(255, 204, 102));
        Home2.setFont(new java.awt.Font("Impact", 0, 18)); 
        Home2.setForeground(new java.awt.Color(16, 16, 16));
        Home2.setText("Home");
        Home2.setBorder(null);
        Home2.addActionListener(evt -> {
            new TelaListaJogos().setVisible(true);
            this.dispose();
        });

        Cadastro1.setBackground(new java.awt.Color(0, 255, 255));
        Cadastro1.setFont(new java.awt.Font("Impact", 0, 18)); 
        Cadastro1.setForeground(new java.awt.Color(16, 16, 16));
        Cadastro1.setText("Novo Cadastro");
        Cadastro1.setBorder(null);

        Sair1.setBackground(new java.awt.Color(255, 51, 51));
        Sair1.setFont(new java.awt.Font("Impact", 0, 18)); 
        Sair1.setForeground(new java.awt.Color(16, 16, 16));
        Sair1.setText("Sair");
        Sair1.setBorder(null);
        Sair1.addActionListener(evt -> {
            new TelaEncerramento().setVisible(true);
            this.dispose();
        });

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logo_smaller.png"))); 

        lblNome.setFont(new java.awt.Font("Impact", 0, 18)); 
        lblNome.setForeground(new java.awt.Color(255, 255, 255));
        lblNome.setText("Nome do Jogo");

        lblGenero.setFont(new java.awt.Font("Impact", 0, 18)); 
        lblGenero.setForeground(new java.awt.Color(255, 255, 255));
        lblGenero.setText("Gênero");

        lblPlataforma.setFont(new java.awt.Font("Impact", 0, 18)); 
        lblPlataforma.setForeground(new java.awt.Color(255, 255, 255));
        lblPlataforma.setText("Plataforma");

        lblHoras.setFont(new java.awt.Font("Impact", 0, 18)); 
        lblHoras.setForeground(new java.awt.Color(255, 255, 255));
        lblHoras.setText("Horas Jogadas");

        txtNome.setBackground(new java.awt.Color(16, 16, 16));
        txtNome.setForeground(new java.awt.Color(255, 255, 255));

        txtGenero.setBackground(new java.awt.Color(16, 16, 16));
        txtGenero.setForeground(new java.awt.Color(255, 255, 255));

        txtPlataforma.setBackground(new java.awt.Color(16, 16, 16));
        txtPlataforma.setForeground(new java.awt.Color(255, 255, 255));

        txtHoras.setBackground(new java.awt.Color(16, 16, 16));
        txtHoras.setForeground(new java.awt.Color(255, 255, 255));

        Cancelar.setBackground(new java.awt.Color(204, 204, 204));
        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(evt -> {
            new TelaListaJogos().setVisible(true);
            this.dispose();
        });

        Limpar.setBackground(new java.awt.Color(204, 204, 204));
        Limpar.setText("Limpar");
        Limpar.addActionListener(evt -> {
            txtNome.setText("");
            txtGenero.setText("");
            txtPlataforma.setText("");
            txtHoras.setText("");
        });

        Salvar.setBackground(new java.awt.Color(204, 204, 204));
        Salvar.setText("Salvar");
        Salvar.addActionListener(evt -> salvarJogo());

        tabelaJogos.setBackground(new java.awt.Color(204, 204, 204));
        tabelaJogos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Nome do Jogo", "Gênero", "Plataforma", "Horas Jogadas"
            }
        ));
        tabelaJogos.setGridColor(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(tabelaJogos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblGenero)
                            .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblPlataforma)
                            .addComponent(txtPlataforma, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblHoras)
                            .addComponent(txtHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(Limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Logo))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER, false)
                    .addComponent(Home2, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                    .addComponent(Cadastro1, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                    .addComponent(Sair1, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Home2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Cadastro1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Sair1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Logo))
                .addGap(30, 30, 30)
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGenero)
                    .addComponent(lblPlataforma)
                    .addComponent(lblHoras))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPlataforma, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new TelaCadastroJogos().setVisible(true));
    }

    private javax.swing.JButton Cadastro1;
    private javax.swing.JButton Cancelar;
    private javax.swing.JButton Home2;
    private javax.swing.JButton Limpar;
    private javax.swing.JLabel Logo;
    private javax.swing.JButton Sair1;
    private javax.swing.JButton Salvar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblHoras;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPlataforma;
    private javax.swing.JTable tabelaJogos;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtHoras;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPlataforma;
}