/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Digital;

/**
 *
 * @author Administrator
 */
public class DigitalDB {

    // return a digital new
    public Digital getDigitalNew() throws Exception {
        DBContext context = new DBContext();
        
        String query = "SELECT TOP (1) [id]\n"
                + "      ,[title]\n"
                + "      ,[image]\n"
                + "      ,[notes]\n"
                + "      ,[author]\n"
                + "      ,[date]\n"
                + "      ,[short notes]\n"
                + "  FROM [Digital].[dbo].[digital]\n"
                + "ORDER BY date desc";
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = context.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Digital d = new Digital();
                d.setId(rs.getInt("id"));
                d.setTitle(rs.getString("title"));
                d.setImage(rs.getString("image"));
                d.setNotes(rs.getString("notes"));
                d.setAuthor(rs.getString("author"));
                d.setDate(rs.getTimestamp("date"));
                d.setShortNotes(rs.getString("short notes"));
                return d;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            context.closeConnection(rs, ps, conn);
        }

        return null;
    }

    // return a digital by id
    public Digital selectDigitalById(int id) throws Exception {
        DBContext context = new DBContext();
        
        String query = "SELECT [id]\n"
                + "      ,[title]\n"
                + "      ,[image]\n"
                + "      ,[notes]\n"
                + "      ,[author]\n"
                + "      ,[date]\n"
                + "      ,[short notes]\n"
                + "  FROM [Digital].[dbo].[digital]\n"
                + "  WHERE id = ?";
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = context.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Digital d = new Digital();
                d.setId(rs.getInt("id"));
                d.setTitle(rs.getString("title"));
                d.setImage(rs.getString("image"));
                d.setNotes(rs.getString("notes"));
                d.setAuthor(rs.getString("author"));
                d.setDate(rs.getTimestamp("date"));
                d.setShortNotes(rs.getString("short notes"));
                
                return d;
            }
        } catch (Exception ex) {
            throw ex;
        }

        return null;
    }

    // return a list digital with top and different digital new
    public List<Digital> selectTop(int top) throws Exception {
        DBContext context = new DBContext();
        List<Digital> list = new ArrayList<>();
        
        String query = "SELECT TOP (?) [id]\n"
                + "      ,[title]\n"
                + "      ,[image]\n"
                + "      ,[notes]\n"
                + "      ,[author]\n"
                + "      ,[date]\n"
                + "      ,[short notes]\n"
                + "  FROM [Digital].[dbo].[digital]\n"
                + "  WHERE date not in(select max(date) from digital)\n"
                + "ORDER BY date desc";
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = context.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, top);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Digital d = new Digital();
                d.setId(rs.getInt("id"));
                d.setTitle(rs.getString("title"));
                d.setImage(rs.getString("image"));
                d.setNotes(rs.getString("notes"));
                d.setAuthor(rs.getString("author"));
                d.setDate(rs.getTimestamp("date"));
                d.setShortNotes(rs.getString("short notes"));
                
                list.add(d);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            context.closeConnection(rs, ps, conn);
        }

        return list;
    }

    
    // return number(s) digital by title
    public int countDigital(String title) throws Exception {
        DBContext context = new DBContext();
        String query = "SELECT COUNT(*)\n"
                + "  FROM [Digital].[dbo].[digital]\n"
                + "  WHERE title like '%' + ? + '%'";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = context.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, title);
            rs = ps.executeQuery();
            while (rs.next()) {
                rows = rs.getInt(1);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            context.closeConnection(rs, ps, conn);
        }
        return rows;
    }

    // return a list digital from - to with title
    public List<Digital> digitalFromTo(int from, int to, String title) throws Exception {
        DBContext context = new DBContext();
        List<Digital> p = new ArrayList<>();
        
        String query = " SELECT	 [id]\n"
                + "		,[title]\n"
                + "		,[image]\n"
                + "		,[notes]\n"
                + "		,[author]\n"
                + "		,[date]\n"
                + "		,[short notes] \n"
                + "FROM ( \n"
                + "  SELECT *, ROW_NUMBER() OVER (ORDER BY id) as row \n"
                + "  FROM [Digital].[dbo].[digital] a\n"
                + "  WHERE title like '%' + ? + '%'\n"
                + " ) a WHERE a.row >= ? and a.row <= ?";
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, title);
            ps.setInt(2, from);
            ps.setInt(3, to);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Digital d = new Digital();
                d.setId(rs.getInt("id"));
                d.setTitle(rs.getString("title"));
                d.setImage(rs.getString("image"));
                d.setNotes(rs.getString("notes"));
                d.setAuthor(rs.getString("author"));
                d.setDate(rs.getTimestamp("date"));
                d.setShortNotes(rs.getString("short notes"));
                
                p.add(d);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            context.closeConnection(rs, ps, conn);
        }

        return p;
    }
}
