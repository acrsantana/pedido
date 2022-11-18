package br.edu.infnet.pedido.model.persistencia;

import br.edu.infnet.pedido.model.JdbcUtil;
import br.edu.infnet.pedido.model.entidade.Usuario;
import lombok.SneakyThrows;
import org.junit.*;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

public class UsuarioDAOTest {

    @SneakyThrows @BeforeClass
    public static void populate(){
        System.out.println("BeforeClass");
        Connection connection = JdbcUtil.obterConexao();
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("insert into usuario (nome, email, senha, data_criacao) " +
            "values ('Cezar Vilela', 'cezar@email.com', '12345', current_timestamp)");
        stmt.executeUpdate("insert into usuario (nome, email, senha, data_criacao) " +
            "values ('Joice Camara', 'joice@email.com', '12345', current_timestamp)");
        stmt.executeUpdate("insert into usuario (nome, email, senha, data_criacao) " +
            "values ('Luna Carvalho', 'luna@email.com', '12345', current_timestamp)");
        stmt.executeUpdate("insert into usuario (nome, email, senha, data_criacao) " +
            "values ('Artur Ribeiro', 'artur@email.com', '12345', current_timestamp)");
        stmt.executeUpdate("insert into usuario (nome, email, senha, data_criacao) " +
            "values ('Anderson Costa', 'anderson@email.com', '12345', current_timestamp)");
    }

    @Test public void testInserirNovoUsuario() {
        IDAO<Usuario> usuarioDAO = new UsuarioDAO();
        Usuario usuario = new Usuario();
        usuario.setNome("Inserindo Usuario Novo");
        usuario.setEmail("usuarionovo@email.com");
        usuario.setSenha("12345");
        usuario.setDataCriacao(Timestamp.from(Instant.now()));
        boolean validacao = usuarioDAO.salvar(usuario);
        Assert.assertTrue(validacao);
    }

    @Test public void testUpdateUsuarioExistenteComIdIgualA1() {
        IDAO<Usuario> usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.listarTodos().get(0);
        usuario.setNome("Este usuario agora tem nome");
        usuario.setEmail("usuarocomnome@email.com");
        usuario.setSenha("agoraasenhae12345");
        Assert.assertTrue(usuarioDAO.atualizar(usuario));
    }

    @Test public void testDeleteUsuarioExistenteComIdIgualA5() {
        IDAO<Usuario> usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.listarTodos().get(0);
        Assert.assertTrue(usuarioDAO.deletar(usuario));
    }

    @Test public void testListaUsuarios() {
        IDAO<Usuario> usuarioDAO = new UsuarioDAO();
        List<Usuario> lista = usuarioDAO.listarTodos();
        Assert.assertTrue(lista.size() > 4);
    }

    @Test public void testObterUsuarioComIdIgualAoPrimeiroItemDaLista() {
        IDAO<Usuario> usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.listarTodos().get(0);
        Usuario usuarioValidacao = usuarioDAO.obter(usuario.getId());
        Assert.assertNotNull(usuarioValidacao);
        Assert.assertEquals(usuario.getId(), usuarioValidacao.getId());
        Assert.assertEquals(usuario.getNome(), usuarioValidacao.getNome());
    }

    @SneakyThrows @AfterClass
    public static void destroy(){
        Connection connection = JdbcUtil.obterConexao();
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("delete from usuario");
    }
}
