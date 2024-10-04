package br.com.fiap.dao;

import java.sql.Connection;

// Abstract = Não podemos criar objetos dentro dela
public abstract class Repository {

    // Atributos
    // Protected = Somente as classes no mesmo pacote podem usar o atributo
    protected Connection connection;


    // Construtor vazio
    public Repository() {

        getConnection();

    }


    // Método getter
    public Connection getConnection() {

        try {

            connection = ConnectionFactory.getInstance().getConexao();

            return connection;

        } catch (Exception e) {

            System.out.println("Erro: " + e.getMessage());

        }

        return null;

    }


    // Método da classe
    public void closeConnection() {

        try {

            if (!connection.isClosed()) {

                connection.close();

            }

        } catch (Exception e) {

            System.out.println("Erro: " + e.getMessage());

        }

    }

}
