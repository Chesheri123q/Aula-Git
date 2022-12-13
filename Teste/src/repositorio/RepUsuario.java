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
import classes.Usuario;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

        
public class RepUsuario {
    
    Connection con;

    public boolean inserir(Usuario usuario){
        
        con = ConexaoMySql.getConexao(); 
        
        String sql = "insert into usuario ("
                 + "Nome_Usuario, Nome_Verdadeiro_Usuario, Senha_Usuario, Telefone_Usuario, Email_Usuario, CPF_Usuario, DataDeNasc_Usuario, Estado_Usuario, Cidade_Usuario, Rua_Usuario) values "
                 + "(?,?,?,?,?,?,?,?,?,?)";
        
     //   não mexa nessa parte do codigo
     
         try{
             con.setAutoCommit(false);
             PreparedStatement stmt = con.prepareStatement(sql);
             
             stmt.setString(1, usuario.getUsuario());
             stmt.setString(2, usuario.getNomeCompleto());
             stmt.setString(3, usuario.getSenha());
             stmt.setString(4, usuario.getTelefone());
             stmt.setString(5, usuario.getEmail());
             stmt.setString(6, usuario.getCpf());
             stmt.setString(7, usuario.getDataDeNascimento());
             stmt.setString(8, usuario.getEstado());
             stmt.setString(9, usuario.getCidade());
             stmt.setString(10, usuario.getRua());
             
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
    
    
    

            
            
    
     
    
    
  public List<Usuario> retornar(){
      
      con = ConexaoMySql.getConexao();
      List<Usuario> usuarios = new ArrayList<>();
      
      String sql = "select * from usuario order by Id_usuario desc";
      
      try{
          Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery(sql);
          while(rs.next()){
              
              Usuario usuario = new Usuario();
              
             usuario.setId(rs.getString("Id_Usuario"));
              usuario.setUsuario(rs.getString("Nome_Usuario"));
              usuario.setNomeCompleto(rs.getString("Nome_Verdadeiro_Usuario"));
              usuario.setSenha(rs.getString("Senha_Usuario"));
              usuario.setTelefone(rs.getString("Telefone_Usuario"));
              usuario.setEmail(rs.getString("Email_Usuario"));
              usuario.setCpf(rs.getString("CPF_Usuario"));
              usuario.setDataDeNascimento(rs.getString("DataDeNasc_Usuario"));
              usuario.setEstado(rs.getString("Estado_Usuario"));
              usuario.setCidade(rs.getString("Cidade_Usuario"));
              usuario.setRua(rs.getString("Rua_Usuario"));
              
              usuarios.add(usuario);
          }            
      }catch(SQLException ex){
          return null;
      }
      
      ConexaoMySql.fecharConexao();
      
      return usuarios;
  }  
 
      public boolean atualizar(Usuario usuario) {

        con = ConexaoMySql.getConexao();
        String sql = "update usuario set Nome_Usuario = ?"
                + "Senha_Usuario = ?, Nome_Verdadeiro_Usuario = ?, Telefone_Usuario = ?, Email_Usuario = ?, CPF_Usuario = ?, DataDeNasc_Usuario = ?, Estado_Usuario = ?, Cidade_Usuario = ?, Rua_Usuario = ? where id = ?";
        
        try {
            con.setAutoCommit(false);
            PreparedStatement stmt = con.prepareStatement(sql);
            
             
             stmt.setString(1, usuario.getUsuario());
             stmt.setString(2, usuario.getNomeCompleto());
             stmt.setString(3, usuario.getSenha());
             stmt.setString(4, usuario.getTelefone());
             stmt.setString(5, usuario.getEmail());
             stmt.setString(6, usuario.getCpf());
             stmt.setString(7, usuario.getDataDeNascimento());
             stmt.setString(8, usuario.getEstado());
             stmt.setString(9, usuario.getCidade());
             stmt.setString(10, usuario.getRua());
            
            
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
      
      
      public int TotalDeUsuarios(){
          
     int retorno = 0;
     
      con = ConexaoMySql.getConexao();
    
      
      String sql = "select count(*) as Total from usuario";
      
     
      
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
      
    public int RetornarDados(){
          
     int retorno = 0;
     
      con = ConexaoMySql.getConexao();
    
      
      String sql = "select Nome_Usuario, Nome_Verdadeiro_Usuario, Senha_Usuario, Telefone_Usuario, Email_Usuario, CPF_Usuario, DataDeNasc_Usuario, Estado_Usuario, Cidade_Usuario, Rua_Usuario from usuario where Id_Usuario = ?";
     
      
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

  public List<Usuario> pesquisa(String valor){
      
      con = ConexaoMySql.getConexao();
      List<Usuario> usuarios = new ArrayList<>();
      
      String sql = "select * from usuario where Nome_Usuario like '"+valor+"%'";
    
      
      try{
          Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery(sql);
          while(rs.next()){
              
              Usuario usuario = new Usuario();
              
             
              usuario.setId(rs.getString("Id_Usuario"));
              usuario.setUsuario(rs.getString("Nome_Usuario"));
              usuario.setNomeCompleto(rs.getString("Nome_Verdadeiro_Usuario"));
              usuario.setSenha(rs.getString("Senha_Usuario"));
              usuario.setTelefone(rs.getString("Telefone_Usuario"));
              usuario.setEmail(rs.getString("Email_Usuario"));
              usuario.setCpf(rs.getString("CPF_Usuario"));
              usuario.setDataDeNascimento(rs.getString("DataDeNasc_Usuario"));
              usuario.setEstado(rs.getString("Estado_Usuario"));
              usuario.setCidade(rs.getString("Cidade_Usuario"));
              usuario.setRua(rs.getString("Rua_Usuario"));
              
              
              usuarios.add(usuario);
          }            
      }catch(SQLException ex){
         
          JOptionPane.showMessageDialog(null, ex.getMessage());
          return null;
      }
      
      ConexaoMySql.fecharConexao();
      
      return usuarios;
  }  
    
  
  
  public boolean excluir(int id){
      
      con = ConexaoMySql.getConexao();
      String sql = "delete from usuario where Id_Usuario = ?";
      
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

 

