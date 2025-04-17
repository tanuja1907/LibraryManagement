package dao;

import dbconnection.DBConnection;
import entity.Patrons;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PatronDao {
    public boolean addPatron(Patrons patron){
        try(Connection connection= DBConnection.getConnection()){
            String query="INSERT INTO patrons(name) VALUES(?)";
            PreparedStatement ps=connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, patron.getName());
            if( ps.executeUpdate()>0){
                ResultSet rs= ps.getGeneratedKeys();
                if(rs.next()){
                    int generatedKey=rs.getInt(1);
                    patron.setId(generatedKey);
                    System.out.println("Patron added with id: "+generatedKey);
                }
                return  true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public Patrons getPatronByID(int patronID){

        try(Connection connection=DBConnection.getConnection()){
            String query="SELECT * FROM patrons where id=?";
            PreparedStatement ps=connection.prepareStatement(query);
            ps.setInt(1,patronID);
            ResultSet resultSet=ps.executeQuery(query);
            if(resultSet.next()){
                return new Patrons(resultSet.getInt("id"),
                        resultSet.getString("name"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<Patrons> getAllPatrons(){
        List<Patrons> patrons=new ArrayList<>();
        try(Connection connection=DBConnection.getConnection()){
            String query="SELECT * FROM patrons";
            Statement st=connection.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
               patrons.add(new Patrons(rs.getInt("id"),
                        rs.getString("name")));

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return  patrons;
    }

}
