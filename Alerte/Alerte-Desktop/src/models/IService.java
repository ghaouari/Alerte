package models;

import java.sql.SQLException;

public interface IService<T> {
    void update(T t) throws SQLException;
    boolean delete(T t) throws SQLException;
}