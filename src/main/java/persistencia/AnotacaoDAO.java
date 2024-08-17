package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import org.postgresql.core.ConnectionFactory;

import negocio.Anotacao;

public class AnotacaoDAO {

    public void inserir(Anotacao anotacao) throws SQLException {
        String sql = "insert into googlekeep (titulo, texto, cor) values (?,?,?);";
        Connection conexao = new ConexaoPostgreSQL().getConexao();
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setString(1, anotacao.getTitulo());
        preparedStatement.setString(2, anotacao.getTexto());
        preparedStatement.setString(3, anotacao.getCor());
        preparedStatement.execute();
        preparedStatement.close();
        conexao.close();
    }

    public ArrayList<Anotacao> listar() throws SQLException {
        ArrayList<Anotacao> anotacoes = new ArrayList<Anotacao>();
        String sql = "select * from googlekeep";
        Connection conexao = new ConexaoPostgreSQL().getConexao();
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            Anotacao anotacao = new Anotacao();
            anotacao.setId(rs.getInt("id"));
            anotacao.setTitulo(rs.getString("titulo"));
            anotacao.setTexto(rs.getString("texto"));
            anotacao.setCor(rs.getString("cor"));
            anotacao.setDatahora(rs.getTimestamp("data_hora").toLocalDateTime());
            anotacao.setFoto(rs.getBytes("foto"));
            anotacoes.add(anotacao);
        }
        preparedStatement.close();
        conexao.close();
        return anotacoes;
    }

    public Anotacao obterPorId(int id) throws SQLException {
        Anotacao anotacao = new Anotacao();
        String sql = "select * from googlekeep where id = ?";
        Connection conexao = new ConexaoPostgreSQL().getConexao();
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            anotacao.setId(rs.getInt("id"));
            anotacao.setTitulo(rs.getString("titulo"));
            anotacao.setTexto(rs.getString("texto"));
            anotacao.setCor(rs.getString("cor"));
            anotacao.setDatahora(rs.getTimestamp("data_hora").toLocalDateTime());
            anotacao.setFoto(rs.getBytes("foto"));
        }
        preparedStatement.close();
        conexao.close();
        return anotacao;
    }

    public boolean atualizar(Anotacao anotacao) throws SQLException {
        String sql = "update googlekeep set titulo=?, texto=?, cor=?, foto=? where id=?";
        Connection conexao = new ConexaoPostgreSQL().getConexao();
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setString(1, anotacao.getTitulo());
        preparedStatement.setString(2, anotacao.getTexto());
        preparedStatement.setString(3, anotacao.getCor());
        preparedStatement.setBytes(4, anotacao.getFoto());
        preparedStatement.setInt(5, anotacao.getId());
        int resultado = preparedStatement.executeUpdate();
        preparedStatement.close();
        conexao.close();
        return resultado == 1;
    }

    public boolean deletar(int id) throws SQLException {
        String sql = "delete from googlekeep where id=?";
        Connection conexao = new ConexaoPostgreSQL().getConexao();
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        int resultado = preparedStatement.executeUpdate();
        preparedStatement.close();
        conexao.close();
        return resultado == 1;
    }

}
