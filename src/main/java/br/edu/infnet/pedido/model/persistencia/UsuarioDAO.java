package br.edu.infnet.pedido.model.persistencia;

import br.edu.infnet.pedido.model.entidade.Usuario;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO extends JdbcDAO<Usuario> {

    @Override public Boolean salvar(Usuario usuario) {
        String sql = "insert into usuario(nome, email, senha, data_criacao) values (?,?,?,?)";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getEmail());
            pstm.setString(3, usuario.getSenha());
            pstm.setTimestamp(4, usuario.getDataCriacao());
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override public Boolean atualizar(Usuario usuario) {
        String sql = "update usuario set nome = ?, email = ?, senha = ?" + " where id = ?";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getEmail());
            pstm.setString(3, usuario.getSenha());
            pstm.setLong(4, usuario.getId());
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override public Boolean deletar(Usuario usuario) {
        String sql = "delete from usuario where id = ?";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setLong(1, usuario.getId());
            int i = pstm.executeUpdate();
            System.out.println(i);
            return i > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override public Usuario obter(Long id) {
        String sql = "select id, nome, email, senha, data_criacao from usuario where id = ?";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setLong(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                return getUsuario();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override public List<Usuario> listarTodos() {
        String sql = "select id, nome, email, senha, data_criacao from usuario";
        List<Usuario> usuarios = new ArrayList<>();
        try {
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                usuarios.add(getUsuario());
            }
            return usuarios;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Usuario getUsuario() throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setId(rs.getLong(1));
        usuario.setNome(rs.getString(2));
        usuario.setEmail(rs.getString(3));
        usuario.setSenha(rs.getString(4));
        usuario.setDataCriacao(rs.getTimestamp(5));
        return usuario;
    }

}
