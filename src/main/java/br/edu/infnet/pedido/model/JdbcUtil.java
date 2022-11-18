package br.edu.infnet.pedido.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.edu.infnet.pedido.exception.ErroAoConectarException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j @NoArgsConstructor(access = AccessLevel.PRIVATE) public class JdbcUtil {

    public static Connection obterConexao() {
        log.info("Inciando conexao com o banco de dados PostgreSql");
        String password = "Alura2022+";
        String user = "postgres";
        String url = "jdbc:postgresql://localhost:5432/Persistencia";
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            log.error("Erro ao conectar no banco: {}", url);
            throw new ErroAoConectarException("Erro ao conectar", e);
        }
    }
}
