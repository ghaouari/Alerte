package controllers;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.DataSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateData {

    @FXML
    TextField txtNom;
    @FXML
    TextField txtPrenom;
    @FXML
    TextField txtMail;
    @FXML
    TextField txtTel;
    @FXML
    TextField txtType;

    private FXMLLoader fxmlLoader = null;
    private Parent root1 = null;
    private Stage stage = null;
    private String nom=null;
    private String prenom=null;
    private String mail=null;
    private String tel=null;
    private String type=null;

    private String checkQuery=null;
    private String SQLQuery=null;
    private Connection updateConn=null;
    private PreparedStatement updateSt=null;
    private ResultSet updateRs=null;
    private Alert ualert = new Alert(Alert.AlertType.INFORMATION);

    @FXML
    private void ShowDetails() throws IOException {
        try {
            fxmlLoader = new FXMLLoader(getClass().getResource("ReadDataWindow.fxml"));
            root1 = (Parent) fxmlLoader.load();
            stage = new Stage();
            stage.setTitle("Read Data");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            System.err.print(e);
        }
    }

    private void getUpdateDetails(){
        nom=txtNom.getText();
        prenom=txtPrenom.getText();
        mail=txtMail.getText();
        tel=txtTel.getText();
        type=txtType.getText();
    }

    private boolean validateUpdateDetails(){
        getUpdateDetails();
        if(nom.isEmpty()){
            ualert.setTitle("Incomplete Data Input");
            ualert.setHeaderText(null);
            ualert.setContentText("Please fill data in nom field");
            ualert.showAndWait();
            return false;
        }
        else if(prenom.isEmpty()){
            ualert.setTitle("Incomplete Data Input");
            ualert.setHeaderText(null);
            ualert.setContentText("Please fill data in prenom field");
            ualert.showAndWait();
            return false;
        }
        else if(mail.isEmpty()){
            ualert.setTitle("Incomplete Data Input");
            ualert.setHeaderText(null);
            ualert.setContentText("Please fill data in Email field");
            ualert.showAndWait();
            return false;
        }

        else if(tel.isEmpty()){
            ualert.setTitle("Incomplete Data Input");
            ualert.setHeaderText(null);
            ualert.setContentText("Please fill data in tel field");
            ualert.showAndWait();
            return false;
        }        
        else if(type.isEmpty()){
            ualert.setTitle("Incomplete Data Input");
            ualert.setHeaderText(null);
            ualert.setContentText("Please fill data in type field");
            ualert.showAndWait();
            return false;
        }
        else {
            return true;
        }
    }

    @FXML
    private void updateRequiredData() throws SQLException{
        getUpdateDetails();
        checkQuery="SELECT * FROM utilisateur WHERE nom='"+nom+"';";
        SQLQuery="UPDATE utilisateur SET nom='"+nom+"', prenom='"+prenom+"' , adresse='"+mail+"' , tel='"+tel+"', typeofuser='"+type+"' WHERE nom='"+nom+"';";
        try {
            updateConn = DataSource.getInstance().getConnection();
            updateRs = updateConn.createStatement().executeQuery(checkQuery);
            if(updateRs.next()){
                updateSt = updateConn.prepareStatement(SQLQuery);
                updateSt.executeUpdate();
                ualert.setTitle("Data Updated Successfully");
                ualert.setHeaderText(null);
                ualert.setContentText("Required Data Updated");
                ualert.showAndWait();
            }
            else {
                ualert.setTitle("Data Updating Failed");
                ualert.setHeaderText(null);
                ualert.setContentText("Required Data Cannot be Updated");
                ualert.showAndWait();
            }
        }catch (SQLException e){
            e.printStackTrace();}
        /* }finally {
            if(updateSt!=null){
                updateSt.close();
            }
            if (updateRs!=null){
                updateRs.close();
            }
            if (updateConn!=null){
                updateConn.close();
            }
        }*/
    }

    @FXML
    private void updateDetails() throws SQLException{
        boolean checkStatus=validateUpdateDetails();
        if(checkStatus){
            updateRequiredData();
        }
    }
}