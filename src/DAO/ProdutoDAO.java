package DAO;

import Modelo.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pedro Alcantara
 */
public class ProdutoDAO extends ExecuteSQL {
    
    public ProdutoDAO(Connection con) {
        super(con);
    }
       
    public String Inserir_Produto(Produto a) {
        String sql = "insert into produto values(0,?,?,?,?)";
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, a.getNome());
            ps.setInt(2, a.getQuantidade());
            ps.setInt(3, a.getPreco());
            ps.setInt(4, a.getCodpro());
            
            
            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso";
            }else {
                return "Erro ao inserir";
            }
            
            
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    
   
    public List<Produto> ListarProduto() {
        String sql = "select id, nome, quantidade, preco, codpro from produto";
        List<Produto> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (ps != null) {
                while (rs.next()) {                    
                    Produto a = new Produto();
                    a.setCod(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setQuantidade(rs.getInt(3));
                    a.setPreco(rs.getInt(4));
                    a.setCodpro(rs.getInt(5));
                    
                    lista.add(a);
                }
                
                return lista;
            }else {
                return null;
            }
            
        } catch (Exception e) {
            return null;
        }
    }
    
    
 
    public List<Produto> Pesquisar_Nome_Produto(String nome) {
        String sql = "select id,nome,quantidade,preco,codpro" + "from Produto where nome Like '"+ nome + "%'";
        List<Produto> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (ps != null) {
                while (rs.next()) {                    
                    Produto a = new Produto();
                    a.setCod(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setQuantidade(rs.getInt(3));
                    a.setPreco(rs.getInt(4));
                    a.setCodpro(rs.getInt(5));
                    
                    
                    lista.add(a);
                }
                
                return lista;
            }else {
                return null;
            }
            
        } catch (Exception e) {
            return null;
        }
        
    }
        
    public List<Produto> CapturarProduto(int cod) {
        String sql = "select * from produto where id =" + cod + " ";
        List<Produto> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {                    
                    Produto a = new Produto();
                    a.setCod(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setQuantidade(rs.getInt(3));
                    a.setPreco(rs.getInt(4));
                    a.setCodpro(rs.getInt(5));
                    lista.add(a);
                }
                return lista;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    
   
    public String Alterar_Produto(Produto a) {
        String sql = "update produto set nome = ?, quantidade = ?, preco = ?, codpro = ? where id = ?";
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, a.getNome());
            ps.setInt(2, a.getQuantidade());
            ps.setInt(3, a.getPreco());
            ps.setInt(4, a.getCodpro());
            ps.setInt(5, a.getCod());
            
            
            
            if (ps.executeUpdate() > 0) {
                return "Atualizado com sucesso";
            } else {
                return "Erro ao atualizar";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public List<Produto> ListarComboProduto() {
        String sql = "select nome from produto order by nome asc";
        List<Produto> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {                    
                    Produto a = new Produto();
                    a.setNome(rs.getString(1));
                    lista.add(a);
                }
                return lista;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Produto> ConsultarCodigoProduto(String nome) {
        String sql = "select * from produto where nome = '" + nome + "'";
        List<Produto> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {                    
                    Produto a = new Produto();
                    a.setPreco(rs.getInt(4));
                    lista.add(a);
                }
                return lista;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    public String Excluir_Produto(Produto a) {
        String sql = "delete from produto where id = ? and nome = ? ";
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, a.getCod());
            ps.setString(2, a.getNome());
            
            if (ps.executeUpdate() > 0) {
                return "Excluido com sucesso";
            } else {
                return "Erro ao excluir";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    public boolean testar_Produto(int cod) {
        boolean Resultado = false;
        
        try {
            String sql = "select * from produto where id = " + cod + "";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {                    
                    Resultado = true;
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        
        return Resultado;
    }
    
}
