document.addEventListener("DOMContentLoaded", function() {
    
    // ==========================================================================
    // 1. TELA DE LOGIN (Navegação ao clicar no fundo)
    // ==========================================================================
    const fundoLogin = document.getElementById("fundo-login");
    if (fundoLogin) {
        fundoLogin.addEventListener("click", function() {
            window.location.href = "dashboard.html";
        });
    }

    // ==========================================================================
    // 2. TELA DE LISTAGEM (Mecanismo de Busca e Carregamento do Banco)
    // ==========================================================================
    const tabelaCorpo = document.getElementById("tabela-jogos-corpo");
    const barraPesquisa = document.getElementById("barraPesquisa");

    // Função para renderizar as linhas dinâmicas vindas da API Java
    function preencherTabelaGeral(jogos) {
        if (!tabelaCorpo) return;
        tabelaCorpo.innerHTML = '';

        if (jogos.length === 0) {
            tabelaCorpo.innerHTML = `<tr><td colspan="4" style="text-align:center; color:var(--neon-pink);">Nenhum registro encontrado.</td></tr>`;
            return;
        }

        jogos.forEach(jogo => {
            const linha = document.createElement('tr');
            linha.innerHTML = `
                <td>${jogo.nome}</td>
                <td>${jogo.genero || '-'}</td>
                <td>${jogo.plataforma}</td>
                <td>${jogo.horas}h</td>
            `;
            tabelaCorpo.appendChild(linha);
        });
    }

    // Carrega os dados reais do banco de dados
    function carregarJogos() {
        fetch('/api/jogos')
            .then(response => response.json())
            .then(data => {
                preencherTabelaGeral(data);
                preencherTabelaCadastro(data);
            })
            .catch(error => console.error('Erro ao carregar banco de dados:', error));
    }

    // Se estiver no dashboard, puxa os dados do Spring Boot automaticamente
    if (tabelaCorpo) {
        carregarJogos();
    }

    // Filtro e busca em tempo real conectados ao Back-end
    if (barraPesquisa) {
        barraPesquisa.addEventListener('input', () => {
            const termo = barraPesquisa.value.trim();
            if (termo === '') {
                carregarJogos();
            } else {
                fetch(`/api/jogos/pesquisar?nome=${encodeURIComponent(termo)}`)
                    .then(response => response.json())
                    .then(data => preencherTabelaGeral(data))
                    .catch(error => console.error('Erro ao pesquisar:', error));
            }
        });
    }

    // ==========================================================================
    // 3. TELA DE CADASTRO (Envio de dados para o Spring e Espelho Dinâmico)
    // ==========================================================================
    const formCadastro = document.getElementById("form-cadastro-jogo");
    const tabelaCadastroCorpo = document.getElementById("tabela-cadastro-corpo");
    const btnCancelar = document.getElementById("btnCancelar");

    // Preenche a tabela espelho que fica embaixo do formulário
    function preencherTabelaCadastro(jogos) {
        if (!tabelaCadastroCorpo) return;
        tabelaCadastroCorpo.innerHTML = '';
        
        jogos.forEach(jogo => {
            const linha = document.createElement('tr');
            linha.innerHTML = `
                <td>${jogo.nome}</td>
                <td>${jogo.genero || '-'}</td>
                <td>${jogo.plataforma}</td>
                <td>${jogo.horas}h</td>
            `;
            tabelaCadastroCorpo.appendChild(linha);
        });
    }

    if (tabelaCadastroCorpo) {
        carregarJogos();
    }

    if (formCadastro) {
        formCadastro.addEventListener("submit", function(e) {
            e.preventDefault();

            // IDs atualizados conforme o HTML real do formulário
            const nome = document.getElementById("txtNomeJogo").value.trim();
            const genero = document.getElementById("txtGenero").value.trim();
            const plataforma = document.getElementById("txtPlataforma").value.trim();
            const horasValue = document.getElementById("txtHorasJogadas").value.trim();

            if (nome === "" || plataforma === "" || horasValue === "") {
                alert("Nome, Plataforma e Horas são obrigatórios!");
                return;
            }

            const horas = parseInt(horasValue, 10) || 0;
            if (horas < 0) {
                alert("Horas jogadas não podem ser negativas.");
                return;
            }

            // Cria o objeto JSON idêntico ao modelo Jogo.java
            const novoJogo = {
                nome: nome,
                genero: genero,
                plataforma: plataforma,
                horas: horas
            };

            // Dispara a requisição de gravação para a API REST
            fetch('/api/jogos', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(novoJogo)
            })
            .then(response => {
                if (response.ok) {
                    alert("Jogo sincronizado e gravado com sucesso!");
                    window.location.href = "dashboard.html";
                } else {
                    alert("Falha na comunicação com o servidor.");
                }
            })
            .catch(error => console.error('Erro ao salvar registro:', error));
        });

        if (btnCancelar) {
            btnCancelar.addEventListener("click", function() {
                window.location.href = "dashboard.html";
            });
        }
    }

    // ==========================================================================
    // 4. TELA DE ENCERRAMENTO (Simulação de Saída do Sistema)
    // ==========================================================================
    const btnConfirmarSaida = document.getElementById("btnSairEncerramento");
    if (btnConfirmarSaida) {
        btnConfirmarSaida.addEventListener("click", function() {
            document.body.innerHTML = `
                <div style="height:100vh; background:#101010; display:flex; justify-content:center; align-items:center; text-align:center;">
                    <h1 style="font-family:'Impact',sans-serif; color:#ff3333; letter-spacing:2px; text-shadow: 0 0 15px #ff3333; font-style: italic;">
                        SISTEMA ENCERRADO.<br><span style="font-size: 1.5rem; color: #999;">ATÉ LOGO!</span>
                    </h1>
                </div>
            `;
        });
    }

    const botoesSairDoSistema = document.querySelectorAll("#btnSair, #btnSair2");
    botoesSairDoSistema.forEach(botao => {
        botao.addEventListener("click", function(e) {
            e.preventDefault();
            window.location.href = "encerramento.html";
        });
    });
});