package br.com.fiap.reservas.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UsuarioEntityTest {

    @Test
    void validaIdNulo() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new UsuarioEntity(null, "nome", "email", "senha"),
                "Id Inválido"
        );
    }

    @Test
    void validaIdMenorQueZero() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new UsuarioEntity(-1L, "nome", "email", "senha"),
                "Id Inválido"
        );
    }

    @Test
    void validaNome() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new UsuarioEntity(null, "email", "senha"),
                "Nome Inválido"
        );
    }

    @Test
    void validaEmail() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new UsuarioEntity("nome", null, "senha"),
                "Email Inválido"
        );
    }

    @Test
    void validaSenha() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new UsuarioEntity("nome", "email", null),
                "Senha Inválida"
        );
    }

    @Test
    void criaUsuarioComSucesso_SemId() {
        UsuarioEntity usuario = new UsuarioEntity("nome", "email", "senha");

        assertEquals("nome", usuario.getNome());
        assertEquals("email", usuario.getEmail());
        assertEquals("senha", usuario.getSenha());
    }

    @Test
    void criaUsuarioComSucesso_ComId() {
        UsuarioEntity usuario = new UsuarioEntity(1L, "nome", "email", "senha");

        assertEquals(1L, usuario.getId());
        assertEquals("nome", usuario.getNome());
        assertEquals("email", usuario.getEmail());
        assertEquals("senha", usuario.getSenha());
    }
}
