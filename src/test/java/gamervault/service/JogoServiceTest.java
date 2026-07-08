package gamervault.service;

import gamervault.model.Jogo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JogoServiceTest {

    @Test
    public void deveCriarJogoValido() {

        Jogo jogo = new Jogo(
                "The Witcher 3",
                "RPG",
                "PC",
                120
        );

        assertEquals("The Witcher 3", jogo.getNome());
        assertEquals("RPG", jogo.getGenero());
        assertEquals("PC", jogo.getPlataforma());
        assertEquals(120, jogo.getHorasJogadas());
    }

    @Test
    public void naoDevePermitirNomeVazio() {

        JogoService service = new JogoService();

        Jogo jogo = new Jogo(
                "",
                "RPG",
                "PC",
                10
        );

        IllegalArgumentException exception =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> service.cadastrar(jogo)
                );

        assertEquals(
                "O nome do jogo é obrigatório.",
                exception.getMessage()
        );

    }

    @Test
    public void naoDevePermitirPlataformaVazia() {

        JogoService service = new JogoService();

        Jogo jogo = new Jogo(
                "Minecraft",
                "Sandbox",
                "",
                50
        );

        IllegalArgumentException exception =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> service.cadastrar(jogo)
                );

        assertEquals(
                "A plataforma é obrigatória.",
                exception.getMessage()
        );

    }

    @Test
    public void naoDevePermitirHorasNegativas() {

        JogoService service = new JogoService();

        Jogo jogo = new Jogo(
                "Cyberpunk 2077",
                "RPG",
                "PC",
                -10
        );

        IllegalArgumentException exception =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> service.cadastrar(jogo)
                );

        assertEquals(
                "Horas jogadas não podem ser negativas.",
                exception.getMessage()
        );

    }

    @Test
    public void naoDevePermitirJogoNulo() {

        JogoService service = new JogoService();

        IllegalArgumentException exception =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> service.cadastrar(null)
                );

        assertEquals(
                "Jogo inválido.",
                exception.getMessage()
        );

    }

}

