package br.edu.infnet.pedido;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.infnet.pedido.model.JdbcUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j public class App {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = JdbcUtil.obterConexao();
        log.info("Hello!");
        connection.close();

    }
}
