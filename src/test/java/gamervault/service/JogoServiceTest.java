package gamervault.service;

import gamervault.model.Jogo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JogoServiceTest {

    @Test
    public void testValidarJogoComSucesso() {
        JogoService service = new JogoService();
        Jogo jogoValido = new Jogo();
        
        // Configurando um jogo com dados corretos
        // NOTA: Ajuste os métodos set abaixo se os nomes no seu Jogo.java forem diferentes
        jogoValido.setNome("The Witcher 3");
        jogoValido.setPlataforma("PC");
        jogoValido.setHorasJogadas(50);

        // Como o método não retorna nada e não deve lançar exception, usamos assertDoesNotThrow
        assertDoesNotThrow(() -> {
            service.validarJogo(jogoValido);
        }, "O jogo deveria ser considerado válido.");
    }

    @Test
    public void testValidarJogoComHorasNegativas() {
        JogoService service = new JogoService();
        Jogo jogoInvalido = new Jogo();
        
        jogoInvalido.setNome("Cyberpunk 2077");
        jogoInvalido.setPlataforma("PS5");
        jogoInvalido.setHorasJogadas(-10); // Horas negativas (Inválido!)

        // O teste espera que uma IllegalArgumentException seja lançada
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.validarJogo(jogoInvalido);
        });

        // Verifica se a mensagem da exceção é a que você definiu na service
        assertEquals("Horas jogadas não podem ser negativas.", exception.getMessage());
    }
}