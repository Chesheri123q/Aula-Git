package repositorio;

import com.mysql.jdbc.MySQLConnection;
import conexao.ConexaoMySql;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import javax.swing.JOptionPane;

public class RepClientes {
    
    Connection con;

    public boolean inserir(Cliente cliente){
        
        con = ConexaoMySql.getConexao(); 
        
        String sql = "insert into clientes (nome,"
                 + "cpf,telefone,endereco,bairro,cidade) values "
                 + "(?,?,?,?,?,?)";
         try{
             con.setAutoCommit(false);
             PreparedStatement stmt = con.prepareStatement(sql);
             
             stmt.setString(1, cliente.getNome());
             stmt.setString(2, cliente.getCpf());
             stmt.setString(3, cliente.getTelefone());
             stmt.setString(4, cliente.getEndereco());
             stmt.setString(5, cliente.getBairro());
             stmt.setString(6, cliente.getCidade());
             
             stmt.execute();
             con.commit();
             ConexaoMySql.fecharConexao();
             
            return true;
         }catch(SQLException ex){
             try{
                 con.rollback();
                 System.err.println(ex.getMessage());
                 JOptionPane.showMessageDialog(null, ex.getMessage());
                 return false;
             }catch(SQLException exSql){
                 System.err.println(exSql.getMessage());
             }
         }
         
       return true;
    }
    
  public List<Cliente> retornar(){
      
      con = ConexaoMySql.getConexao();
      List<Cliente> clientes = new ArrayList<>();
      
      String sql = "select * from clientes order by id desc";
      
      try{
          Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery(sql);
          while(rs.next()){
              
              Cliente cliente = new Cliente();
              
              cliente.setId(rs.getInt("id"));
              cliente.setNome(rs.getString("nome"));
              cliente.setCpf(rs.getString("cpf"));
              cliente.setTelefone(rs.getString("telefone"));
              cliente.setEndereco(rs.getString("endereco"));
              cliente.setBairro(rs.getString("bairro"));
              cliente.setCidade(rs.getString("cidade"));
              
              clientes.add(cliente);
          }            
      }catch(SQLException ex){
          JOptionPane.showMessageDialog(null, ex.getMessage());
          return null;
      }
      
      ConexaoMySql.fecharConexao();
      
      return clientes;
  }  
  
      public boolean atualizar(Cliente cliente) {

        con = ConexaoMySql.getConexao();
        String sql = "update clientes set nome = ?, "
                + "cpf = ?, telefone = ?,endereco = ?,bairro = ?, cidade = ? where id = ?";
        try {
            con.setAutoCommit(false);
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEndereco());
            stmt.setString(5, cliente.getBairro());
            stmt.setString(6, cliente.getCidade());
            stmt.setInt(7, cliente.getId());
             
            stmt.execute();

            con.commit();
            ConexaoMySql.fecharConexao();

            return true;

        } catch (SQLException ex) {
            try {
                con.rollback();
                System.err.println(ex);
                JOptionPane.showMessageDialog(null, ex.getMessage());
                return false;
            } catch (SQLException ex1) {
                System.err.println(ex1);
            }

            return false;
        }

    }  
      
    public int retornaTotalClientes(){
      
      int retorno = 0;
      con = ConexaoMySql.getConexao();      
      String sql = "SELECT COUNT(*) AS TOTAL FROM CLIENTES";
      try{
          Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery(sql);
          while(rs.next()){
            retorno = rs.getInt("TOTAL");
          }            
      }catch(SQLException ex){
          
          JOptionPane.showMessageDialog(null, ex.getMessage());
          return retorno;
      }
      
      ConexaoMySql.fecharConexao();
      

      return retorno;
  }  
    
  
  public List<Cliente> pesquisar(String valor){
      
      con = ConexaoMySql.getConexao();
      List<Cliente> clientes = new ArrayList<>();
     
      String sql = "select * from clientes where nome like '"+valor+"%'";
     
      try{
          Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery(sql);
          while(rs.next()){
              
              Cliente cliente = new Cliente();
              
              cliente.setId(rs.getInt("id"));
              cliente.setNome(rs.getString("nome"));
              cliente.setCpf(rs.getString("cpf"));
              cliente.setTelefone(rs.getString("telefone"));
              cliente.setEndereco(rs.getString("endereco"));
              cliente.setBairro(rs.getString("bairro"));
              cliente.setCidade(rs.getString("cidade"));
              
              clientes.add(cliente);
          }            
      }catch(SQLException ex){
          
          JOptionPane.showMessageDialog(null, ex.getMessage());
          return null;
      }
      
      ConexaoMySql.fecharConexao();
      
      return clientes;
  }  
    
  
  public boolean excluir(int id){
      
      con = ConexaoMySql.getConexao();
      String sql = "delete from clientes where id = ?";
      
      try{
          
          con.setAutoCommit(false);
          PreparedStatement stmt = con.prepareStatement(sql);
          
          stmt.setInt(1, id);
          
          stmt.execute();
          con.commit();
          ConexaoMySql.fecharConexao();
      
          return true;   
      }catch(SQLException ex){
          JOptionPane.showMessageDialog(null, ex.getMessage());
          return false;
      }
        
  }
    
    
}
