package models;

import java.sql.*;




public class ServiceUser implements IService <User> {

    //private Connection connection = DataSource.getInstance().getConnection();
    //private Statement statement;

    @Override
    public void update(User t) throws SQLException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean delete(User t) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

}