package gamervault;

import java.sql.*;
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

        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir jogo: " + e.getMessage());
        }
    }

    public List<Jogo> listar() {
        List<Jogo> lista = new ArrayList<>();
        String sql = "SELECT * FROM jogos ORDER BY id DESC";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(new Jogo(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("genero"),
                        rs.getString("plataforma"),
                        rs.getInt("horas")
                ));
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar jogos: " + e.getMessage());
        }

        return lista;
    }

    public List<Jogo> listarTodos() {
        return listar();
    }

    public List<Jogo> buscarPorNome(String nome) {
        List<Jogo> lista = new ArrayList<>();
        String sql = "SELECT * FROM jogos WHERE nome LIKE ? ORDER BY id DESC";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, "%" + nome + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                lista.add(new Jogo(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("genero"),
                        rs.getString("plataforma"),
                        rs.getInt("horas")
                ));
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar jogo: " + e.getMessage());
        }

        return lista;
    }

    public void atualizar(Jogo jogo) {
        String sql = "UPDATE jogos SET nome=?, genero=?, plataforma=?, horas=? WHERE id=?";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, jogo.getNome());
            stmt.setString(2, jogo.getGenero());
            stmt.setString(3, jogo.getPlataforma());
            stmt.setInt(4, jogo.getHorasJogadas());
            stmt.setInt(5, jogo.getId());
            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar jogo: " + e.getMessage());
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM jogos WHERE id=?";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar jogo: " + e.getMessage());
        }
    }
}