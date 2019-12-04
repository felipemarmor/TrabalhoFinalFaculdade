package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Usuario;

/**
 *
 * @author assparremberger
 */
public class UsuarioDAO {
    
    public static void inserir(Usuario usuario){
        String query = "INSERT INTO usuario ( nome, tipo, senha ) "
                + " VALUES ('" + usuario.getNome() + "' , "
                        + " '" + usuario.getTipo() + "' , "
                        + " '" + usuario.getSenha() + "' ) ";
        Conexao.executar( query );
    }
    
    public static void editar(Usuario usuario){
        String query = "UPDATE usario SET "
                     + " nome =  '" + usuario.getNome() + "' , "
                     + " tipo =  '" + usuario.getTipo() + "' , "
                     + " senha = '" + usuario.getSenha() + "' "
                     + " WHERE id = " + usuario.getId();
        Conexao.executar( query );
    }
    
    public static void excluir(int idUsuario){
        String query = "DELETE FROM usuario  "
                     + " WHERE id = " + idUsuario;
        Conexao.executar( query );
    }
    
    public static List<Usuario> getUsuarios(){
        List<Usuario> lista = new ArrayList<>();
        String query = "SELECT id, nome, tipo, senha FROM usuario ORDER BY tipo";
        ResultSet rs = Conexao.consultar( query );
        
        if( rs != null ){
           
            try {
                while ( rs.next() ) {                    
                    Usuario usu = new Usuario();
                    usu.setId( rs.getInt( 1 ) );
                    usu.setNome( rs.getString( 2 ) );
                    usu.setTipo( rs.getInt( 3 ) );
                    usu.setSenha( rs.getString( 4 ) );
                    lista.add(usu);
                }
            } catch (Exception e) {
                
            }
        }
        return lista;
    }
    
    public static Usuario getUsuarioById( int idUsuario ){
 
        String query = "SELECT id, nome, tipo, senha FROM usuario "
                     + " WHERE id = " + idUsuario;
        ResultSet rs = Conexao.consultar( query );
        if( rs != null ){
            try {
                rs.next();                   
                Usuario usu = new Usuario();
                usu.setId( rs.getInt( 1 ) );
                usu.setNome( rs.getString( 2 ) );
                usu.setTipo( rs.getInt( 3 ) );
                usu.setSenha( rs.getString( 4 ) );
                return usu;
            } catch (Exception e) {
                return null;
            }
        }else{
            return null;
        }
    }
    
}
