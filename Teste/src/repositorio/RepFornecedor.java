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
import classes.Fornecedor;
import javax.swing.JOptionPane;

        
        
public class RepFornecedor {
    
    Connection con;

    public boolean inserir(Fornecedor fornecedor){
        
        con = ConexaoMySql.getConexao(); 
        
        String sql = "insert into fornecedor ("
                 + "Nome_Fornecedor, Nome_Verdadeiro_Fornecedor, Senha_Fornecedor, Telefone_Fornecedor, Email_Fornecedor, CPF_Fornecedor, DataDeNasc_Fornecedor, Estado_Fornecedor, Cidade_Fornecedor, Rua_Fornecedor) values "
                 + "(?,?,?,?,?,?,?,?,?,?)";
        
     //   não mexa nessa parte do codigo
     
         try{
             con.setAutoCommit(false);
             PreparedStatement stmt = con.prepareStatement(sql);
             
             stmt.setString(1, fornecedor.getFornecedor());
             stmt.setString(2, fornecedor.getNomeCompleto());
             stmt.setString(3, fornecedor.getSenha());
             stmt.setString(4, fornecedor.getTelefone());
             stmt.setString(5, fornecedor.getEmail());
             stmt.setString(6, fornecedor.getCpf());
             stmt.setString(7, fornecedor.getDataDeNascimento());
             stmt.setString(8, fornecedor.getEstado());
             stmt.setString(9, fornecedor.getCidade());
             stmt.setString(10, fornecedor.getRua());
             
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
    
    public int TotalDeFornecedores(){
          
     int retorno = 0;
     
      con = ConexaoMySql.getConexao();
    
      
      String sql = "select count(*) as Total from fornecedor";
      
     
      
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

  public List<Fornecedor> retornar(){
      
      con = ConexaoMySql.getConexao();
      List<Fornecedor> fornecedores = new ArrayList<>();
      
      String sql = "select * from fornecedor order by Id_Fornecedor desc";
      
      try{
          Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery(sql);
          while(rs.next()){
              
              Fornecedor fornecedor = new Fornecedor();
              
              fornecedor.setId(rs.getString("id_Fornecedor"));
              fornecedor.setFornecedor(rs.getString("Nome_Fornecedor"));
              fornecedor.setNomeCompleto(rs.getString("Nome_Verdadeiro_Fornecedor"));
              fornecedor.setSenha(rs.getString("Senha_Fornecedor"));
              fornecedor.setTelefone(rs.getString("Telefone_Fornecedor"));
              fornecedor.setEmail(rs.getString("Email_Fornecedor"));
              fornecedor.setCpf(rs.getString("CPF_Fornecedor"));
              fornecedor.setDataDeNascimento(rs.getString("DataDeNasc_Fornecedor"));
              fornecedor.setEstado(rs.getString("Estado_Fornecedor"));
              fornecedor.setCidade(rs.getString("Cidade_Fornecedor"));
              fornecedor.setRua(rs.getString("Rua_Fornecedor"));
              
              
              fornecedores.add(fornecedor);
          }            
      }catch(SQLException ex){
          return null;
      }
      
      ConexaoMySql.fecharConexao();
      
      return fornecedores;
  }  
 
     
      public boolean atualizar(Fornecedor fornecedor) {

        con = ConexaoMySql.getConexao();
        String sql = "update fornecedor set Nome_Fornecedor = ?"
                + "Senha_Forncedor = ?, Nome_Verdadeiro_Fornecedor = ?, Telefone_Do_Usuario = ?, Email_Usuario = ?, CPF_Fornecedor = ?, DataDeNasc_Usuario = ?, Estado_Fornecedor = ?, Cidade_Fornecedor = ?, Rua_Fornecedor = ? where id = ?";
        
        try {
            con.setAutoCommit(false);
            PreparedStatement stmt = con.prepareStatement(sql);
            
            
            stmt.setString(1, fornecedor.getFornecedor());
            stmt.setString(2, fornecedor.getNomeCompleto());
            stmt.setString(3, fornecedor.getSenha());
            stmt.setString(4, fornecedor.getTelefone());
            stmt.setString(5, fornecedor.getEmail());
            stmt.setString(6, fornecedor.getCpf());
            stmt.setString(7, fornecedor.getDataDeNascimento());
            stmt.setString(8, fornecedor.getEstado());
            stmt.setString(9, fornecedor.getCidade());
            stmt.setString(10, fornecedor.getRua());
            
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
    
  public List<Fornecedor> pesquisa(String valor, String tipoPesquisa){
      
      con = ConexaoMySql.getConexao();
      List<Fornecedor> fornecedores = new ArrayList<>();
      
   
      
      String sql = "select * from fornecedor where Nome_Fornecedor like '"+valor+"%'";
      
      try{
          Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery(sql);
          while(rs.next()){
              
              Fornecedor fornecedor = new Fornecedor();
              
              fornecedor.setId(rs.getString("id_Fornecedor"));
              fornecedor.setFornecedor(rs.getString("Nome_Fornecedor"));
              fornecedor.setNomeCompleto(rs.getString("Nome_Verdadeiro_Fornecedor"));
              fornecedor.setSenha(rs.getString("Senha_Fornecedor"));
              fornecedor.setTelefone(rs.getString("Telefone_Fornecedor"));
              fornecedor.setEmail(rs.getString("Email_Fornecedor"));
              fornecedor.setCpf(rs.getString("CPF_Fornecedor"));
              fornecedor.setDataDeNascimento(rs.getString("DataDeNasc_Fornecedor"));
              fornecedor.setEstado(rs.getString("Estado_Fornecedor"));
              fornecedor.setCidade(rs.getString("Cidade_Fornecedor"));
              fornecedor.setRua(rs.getString("Rua_Fornecedor"));
              
              fornecedores.add(fornecedor);
          }            
      }catch(SQLException ex){
          return null;
      }
      
      ConexaoMySql.fecharConexao();
      
      return fornecedores;
  }  
    
  
  
  public boolean excluir(int id){
      
      con = ConexaoMySql.getConexao();
      String sql = "delete from forncedor where Id_Fornecedor = ?";
      
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

    public Iterable<Fornecedor> pesquisa(String valor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
  


}

 

