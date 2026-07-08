package gamervault.service;

import gamervault.dao.JogoDAO;
import gamervault.model.Jogo;

import java.util.List;

public class JogoService {

    private final JogoDAO jogoDAO;

    public JogoService() {
        this.jogoDAO = new JogoDAO();
    }

    public void cadastrar(Jogo jogo) {

        validarJogo(jogo);

        jogoDAO.inserir(jogo);

    }

    public List<Jogo> listar() {

        return jogoDAO.listar();

    }

    public List<Jogo> buscarPorNome(String nome) {

        return jogoDAO.buscarPorNome(nome);

    }

    public void atualizar(Jogo jogo) {

        validarJogo(jogo);

        jogoDAO.atualizar(jogo);

    }

    public void excluir(int id) {

        jogoDAO.deletar(id);

    }

    private void validarJogo(Jogo jogo) {

        if (jogo == null) {
            throw new IllegalArgumentException("Jogo inválido.");
        }

        if (jogo.getNome() == null || jogo.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do jogo é obrigatório.");
        }

        if (jogo.getPlataforma() == null || jogo.getPlataforma().trim().isEmpty()) {
            throw new IllegalArgumentException("A plataforma é obrigatória.");
        }

        if (jogo.getHorasJogadas() < 0) {
            throw new IllegalArgumentException("Horas jogadas não podem ser negativas.");
        }

    }

}