/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Compra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pedro Alcantara
 */
public class CompraDAO extends ExecuteSQL {

    public CompraDAO(Connection con) {
        super(con);
    }
    
    
   
    public String Inserir_Compra(Compra a) {
        String sql = "insert into compra values(0,?,?,?)";
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, a.getNomecli());
            ps.setInt(2, a.getDivida());
            ps.setString(3, a.getProduto());
            

            
            
            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso";
            }else {
                return "Erro ao inserir";
            }
            
            
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    
   
    public List<Compra> ListarCompra() {
        String sql = "select id,nomecli,divida,produto from compra";
        List<Compra> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (ps != null) {
                while (rs.next()) {                    
                    Compra a = new Compra();
                    a.setCod(rs.getInt(1));
                    a.setNomecli(rs.getString(2));
                    a.setDivida(rs.getInt(3));
                    a.setProduto(rs.getString(4));
                    
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
    
    
 
    public List<Compra> Pesquisar_Nome_Compra(String nome) {
        String sql = "select idCompra,nome,RG,CPF,Telefone,Email" + "from Compra where nome Like '"+ nome + "%'";
        List<Compra> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (ps != null) {
                while (rs.next()) {                    
                    Compra a = new Compra();
//                    a.setCodigo(rs.getInt(1));
//                    a.setNome(rs.getString(2));
//                    a.setRG(rs.getString(3));
//                    a.setCPF(rs.getString(4));
//                    a.setTelefone(rs.getString(5));
//                    a.setEmail(rs.getString(6));
                    
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
    
    
   
    public List<Compra> Pesquisar_Cod_Compra(int cod) {
        String sql = "select idCompra,nome,RG,CPF,Telefone,Email" + "from Compra where idCompra = '" + cod + "'";
        List<Compra> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (ps != null) {
                while (rs.next()) {                    
                    Compra a = new Compra();
//                    a.setCodigo(rs.getInt(1));
//                    a.setNome(rs.getString(2));
//                    a.setRG(rs.getString(3));
//                    a.setCPF(rs.getString(4));
//                    a.setTelefone(rs.getString(5));
//                    a.setEmail(rs.getString(6));
                    
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
    
    
  
    public boolean testar_Compra(int cod) {
        boolean Resultado = false;
        
        try {
            String sql = "select * from compra where id = " + cod + "";
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
    
    
    
    
    public List<Compra> CapturarCompra(int cod) {
        String sql = "select * from compra where id =" + cod + " ";
        List<Compra> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {                    
                    Compra a = new Compra();
                    a.setCod(rs.getInt(1));
                    a.setNomecli(rs.getString(2));
                    a.setDivida(rs.getInt(3));
                    a.setProduto(rs.getString(4));
               
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
    
    
   
    public String Alterar_Compra(Compra a) {
        String sql = "update compra set nomecli = ?, divida = ?, produto = ? where id = ?";
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, a.getNomecli());
            ps.setInt(2, a.getDivida());
            ps.setString(3, a.getProduto());
            ps.setInt(4, a.getCod());
            
            if (ps.executeUpdate() > 0) {
                return "Atualizado com sucesso";
            } else {
                return "Erro ao atualizar";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public List<Compra> ListarComboCompra() {
        String sql = "select nomecli from compra order by nomecli asc";
        List<Compra> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {                    
                    Compra a = new Compra();
                    a.setNomecli(rs.getString(1));
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
    
    public List<Compra> ConsultarCodigoCompra(String nome) {
        String sql = "select id from compra where nomecli = '" + nome + "'";
        List<Compra> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {                    
                    Compra a = new Compra();
                    a.setCod(rs.getInt(1));
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
    
    public String Excluir_Compra(Compra a) {
        String sql = "delete from compra where id = ? and nomecli = ? ";
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, a.getCod());
            ps.setString(2, a.getNomecli());
            
            if (ps.executeUpdate() > 0) {
                return "Excluido com sucesso";
            } else {
                return "Erro ao excluir";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
