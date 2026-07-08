package gamervault.dao;

import gamervault.database.ConnectionFactory;
import gamervault.model.Jogo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JogoDAO {

    public void inserir(Jogo jogo) {

        String sql = "INSERT INTO jogos (nome, genero, plataforma, horas) VALUES (?, ?, ?, ?)";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, jogo.getNome());
            stmt.setString(2, jogo.getGenero());
            stmt.setString(3, jogo.getPlataforma());
            stmt.setInt(4, jogo.getHorasJogadas());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir jogo.", e);
        }
    }

    public List<Jogo> listar() {

        List<Jogo> jogos = new ArrayList<>();

        String sql = "SELECT * FROM jogos ORDER BY id DESC";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Jogo jogo = new Jogo(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("genero"),
                        rs.getString("plataforma"),
                        rs.getInt("horas")
                );

                jogos.add(jogo);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar jogos.", e);
        }

        return jogos;
    }

    public List<Jogo> listarTodos() {
        return listar();
    }

    public List<Jogo> buscarPorNome(String nome) {

        List<Jogo> jogos = new ArrayList<>();

        String sql = "SELECT * FROM jogos WHERE nome LIKE ? ORDER BY id DESC";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, "%" + nome + "%");

            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {

                    Jogo jogo = new Jogo(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("genero"),
                            rs.getString("plataforma"),
                            rs.getInt("horas")
                    );

                    jogos.add(jogo);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar jogo.", e);
        }

        return jogos;
    }

    public void atualizar(Jogo jogo) {

        String sql = """
                UPDATE jogos
                   SET nome = ?,
                       genero = ?,
                       plataforma = ?,
                       horas = ?
                 WHERE id = ?
                """;

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, jogo.getNome());
            stmt.setString(2, jogo.getGenero());
            stmt.setString(3, jogo.getPlataforma());
            stmt.setInt(4, jogo.getHorasJogadas());
            stmt.setInt(5, jogo.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar jogo.", e);
        }
    }

    public void deletar(int id) {

        String sql = "DELETE FROM jogos WHERE id = ?";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir jogo.", e);
        }
    }

}