package controllers;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.DataSource;
import models.User;

public class ReadData {

    @FXML
    TableView<User> tableUser;
    @FXML
    private TableColumn<User, String> columNId;
    @FXML
    private TableColumn<User, String> columnName;
    @FXML
    private TableColumn<User, String> columnPrenom;
    @FXML
    private TableColumn<User, String> columnEmail;
    @FXML
    private TableColumn<User, String> columnTel;
    @FXML
    private TableColumn<User, String> columnType;
    private ObservableList<User> data;
    private Connection ReadConn=null;

    public void loadDataFromDatabase() throws SQLException {
        try {
            ReadConn = DataSource.getInstance().getConnection();
            data = FXCollections.observableArrayList();
            ResultSet rs = ReadConn.createStatement().executeQuery("SELECT * FROM utilisateur");
            while (rs.next()) {
                data.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
            }
        } catch (SQLException ex) {
            System.err.println("Error"+ex);}
       /* }finally {
            if(ReadConn!=null){
                ReadConn.close();
            }
        }*/
        columNId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("nom"));
        columnPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        columnTel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        columnType.setCellValueFactory(new PropertyValueFactory<>("typeofuser"));

        tableUser.setItems(null);
        tableUser.setItems(data);
    }

    }