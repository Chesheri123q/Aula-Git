package repositorio;
//' or 1=1
import com.mysql.jdbc.MySQLConnection;
import conexao.ConexaoMySql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import classes.Chat;
import classes.Chat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class RepChat {
    

    Connection con;

    public boolean inserir(Chat chat){
        
        con = ConexaoMySql.getConexao(); 
        
        String sql = "insert into Chat ("
                 + "Usuario_Chat, Mensagem) values "
                 + "(?,?)";
        
     //   não mexa nessa parte do codigo
     
         try{
             con.setAutoCommit(false);
             PreparedStatement stmt = con.prepareStatement(sql);
             
             
             stmt.setString(1, chat.getUsuario());
             stmt.setString(2, chat.getMensagem());
          
             
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
    
    public int TotalDeMensagens(){
          
     int retorno = 0;
     
      con = ConexaoMySql.getConexao();
    
      
      String sql = "select count(*) as Total from Chat";
      
     
      
      try{
          Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery(sql);
          while(rs.next()){
              
              
              retorno = rs.getInt("Total");
              
            
              
            
          
          }            
      }catch(SQLException ex){
        
         JOptionPane.showMessageDialog(null, ex.getMessage());
          return retorno;
          
      }
      
      ConexaoMySql.fecharConexao();
      
      return retorno;
  }  
    
    
    
 
  public List<Chat> retornar() {
      
      con = ConexaoMySql.getConexao();
      List<Chat> chats = new ArrayList<>();
      
      String sql = "select * from Chat order by id_Chat desc";
      
      try{
          Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery(sql);
          while(rs.next()){
              
              Chat chat = new Chat();
              
              chat.setId(rs.getString("id_Chat"));
             
              chat.setMensagem(rs.getString("Mensagem"));
             chat.setUsuario(rs.getString("Usuario_Chat"));

              
              chats.add(chat);
          }            
      }catch(SQLException ex){
          return null;
      }
      
      ConexaoMySql.fecharConexao();
      
      return chats;
  }  

      public boolean atualizar(Chat chat) {

        con = ConexaoMySql.getConexao();
        String sql = "update Chat set Usuario_Chat = ?, update Mensagem set Mensagem = ?"
                + "where id = ?";
        
        try {
            con.setAutoCommit(false);
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, chat.getId());
            stmt.setString(2, chat.getUsuario());
            stmt.setString(3, chat.getMensagem());
           
            
             
            stmt.execute();

            con.commit();
            ConexaoMySql.fecharConexao();

            return true;

        } catch (SQLException ex) {
            try {
                con.rollback();
                System.err.println(ex);
                return false;
            } catch (SQLException ex1) {
                System.err.println(ex1);
            }

            return false;
        }

    }  
   /*  
  public List<Cliente> pesquisa(String valor, String tipoPesquisa){
      
      con = ConexaoMySql.getConexao();
      List<Cliente> usuario = new ArrayList<>();
      
      String sql = "";
      
      if(tipoPesquisa.equals("comeca")){
       sql = "select * from clientes where nome like '"+valor+"%'";
      }else if(tipoPesquisa.equals("contem")){
       sql = "select * from clientes where nome like '%"+valor+"%'";
      }else if(tipoPesquisa.equals("cpf")){
       sql = "select * from clientes where cpf = '"+valor+"'";
      }
      
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
              
              usuario.add(cliente);
          }            
      }catch(SQLException ex){
          return null;
      }
      
      ConexaoMySql.fecharConexao();
      
      return usuario;
  }  
    
  
  
  public boolean excluir(int id){
      
      con = ConexaoMySql.getConexao();
      String sql = "delete from usuario where id = ?";
      
      try{
          
          con.setAutoCommit(false);
          PreparedStatement stmt = con.prepareStatement(sql);
          
          stmt.setInt(1, id);
          
          stmt.execute();
          con.commit();
          ConexaoMySql.fecharConexao();
      
          return true;   
      }catch(SQLException ex){
          
          return false;
      }
        
  }
    
    
   */ 


}
