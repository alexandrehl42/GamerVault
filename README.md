GamerVault – Sistema de Gerenciamento de Jogos
Status do Projeto: Em desenvolvimento
Versão: 1.0
Tecnologias: Java, Swing, MySQL, JDBC, Git/GitHub, UML
========================
Descrição do Projeto
========================
O GamerVault é um sistema desktop desenvolvido em Java voltado para organização, cadastro e consulta de jogos digitais.
Ele permite que o usuário controle seus títulos jogados, plataformas, horas dedicadas e gêneros, funcionando como uma “biblioteca pessoal de games”.
O software foi criado como parte do Projeto Integrador da faculdade, abordando desde documentação técnica, modelagem UML, interface, até integração com banco de dados e versionamento.
========================
Usuários do Sistema
========================
O sistema é destinado principalmente a:
Jogadores que desejam organizar sua biblioteca de jogos
Usuários que querem acompanhar horas jogadas e progresso
Pessoas que buscam um controle simples, rápido e funcional
========================
Objetivo do Software
========================
Oferecer uma ferramenta simples e intuitiva para:
Cadastrar jogos
Consultar a lista completa de títulos
Registrar plataforma, gênero e horas jogadas
Facilitar o controle pessoal da coleção de jogos
========================
Tecnologias Utilizadas
========================
Java SE 8+
Swing (interfaces)
MySQL Workbench
JDBC
NetBeans
UML (draw.io)
Git + GitHub
========================
Arquitetura do Sistema
========================
Interface desenvolvida em Swing
Camada DAO responsável pela persistência
Banco de dados MySQL integrando cadastro, consulta e listagem
MVC simples
UML com classes:
Jogo
JogoDAO
Conexao
TelaCadastroJogos
TelaListaJogos
========================
Funcionalidades do Sistema
(Requisitos Funcionais)
========================
Cadastro de jogos
Validação de campos obrigatórios
Salvamento no MySQL usando DAO + JDBC
Listagem completa de jogos na TelaListaJogos
Listagem de jogos cadastrados recentemente na TelaCadastroJogos
Navegação entre telas
Estrutura inicial de experiência do usuário (UX/UI
Tela de login

Funcionalidades previstas / futuras
Edição de jogos
Exclusão de jogos
Configurações do usuário
Histórico de jogos jogados recentemente
========================
Requisitos Não Funcionais
========================
Interface intuitiva e acessível
Compatibilidade com Windows
Banco de dados persistente
Código organizado seguindo MVC
Usabilidade projetada com UX/UI (wireframes + paleta de cores)
========================
Time de Desenvolvedores
========================
Alexandre Henrique Libera – Desenvolvimento, documentação, UI/UX, banco de dados (Projeto individual)
