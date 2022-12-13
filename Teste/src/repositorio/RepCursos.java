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
import classes.Curso;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

        
public class RepCursos {
    
    Connection con;

    public boolean inserir(Curso curso){
        
        con = ConexaoMySql.getConexao(); 
        
        String sql = "insert into curso ("
                 + "Nome_Curso, Valor_Do_Curso) values "
                 + "(?,?)";
        
     //   não mexa nessa parte do codigo
     
         try{
             con.setAutoCommit(false);
             PreparedStatement stmt = con.prepareStatement(sql);
             
             
             stmt.setString(1, curso.getNome());
             stmt.setString(2, curso.getValor());
          
             
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
    
    public int TotalDeCursos(){
          
     int retorno = 0;
     
      con = ConexaoMySql.getConexao();
    
      
      String sql = "select count(*) as Total from curso";
      
     
      
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
    
    
    public List<Curso> pesquisar(String valor) {
        con = ConexaoMySql.getConexao();
      List<Curso> cursos = new ArrayList<>();
      
    String sql = "select * from curso where Nome_Curso like '"+valor+"%'";
      
      try{
          Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery(sql);
          while(rs.next()){
              
              Curso curso = new Curso();
              
              curso.setId(rs.getString("Id_Curso"));
              curso.setNome(rs.getString("Nome_Curso"));
              curso.setValor(rs.getString("Valor_Do_Curso"));
              
              
              cursos.add(curso);
          }            
      }catch(SQLException ex){
         
          return null;
      }
      
      ConexaoMySql.fecharConexao();
      
      return cursos;
    }
 
  public List<Curso> retornar() {
      
      con = ConexaoMySql.getConexao();
      List<Curso> cursos = new ArrayList<>();
      
      String sql = "select * from curso order by Id_Curso desc";
      
      try{
          Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery(sql);
          while(rs.next()){
              
              Curso curso = new Curso();
              
              curso.setId(rs.getString("Id_Curso"));
              curso.setNome(rs.getString("Nome_Curso"));
              curso.setValor(rs.getString("Valor_Do_Curso"));
             

              
              cursos.add(curso);
          }            
      }catch(SQLException ex){
          return null;
      }
      
      ConexaoMySql.fecharConexao();
      
      return cursos;
  }  
 
      public boolean atualizar(Curso curso) {

        con = ConexaoMySql.getConexao();
        String sql = "update curso set Nome_Curso = ?"
                + "Valor_Do_Curso = ? where Id_Curso = ?";
        
        try {
            con.setAutoCommit(false);
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, curso.getId());
            stmt.setString(2, curso.getNome());
            stmt.setString(3, curso.getValor());
           
            
             
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
    
 
    
  
  
  public boolean excluir(int id){
      
      con = ConexaoMySql.getConexao();
      String sql = "delete from curso where Id_Curso = ?";
      
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

    
    
 


}

 

