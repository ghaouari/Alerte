package controllers;




import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import models.DataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {

    @FXML
    private TextField txtName;


    @FXML
    private TextField txtPrenom;

    @FXML
    private TextField txtMail;

    @FXML
    private TextField txtTel;

    @FXML
    private TextField txtType;

    @FXML
    private TextField txtPassword;

    private Alert alert = new Alert(Alert.AlertType.INFORMATION);

    private String nom,prenom,adresse,tel,type,password;
    private Connection InsConn=null;
    private Statement InsSt=null;
    private String SQLQuery=null;
    private Alert ialert = new Alert(Alert.AlertType.INFORMATION);


    private void getUserData(){
        nom = txtName.getText();
        prenom = txtPrenom.getText();
        adresse = txtMail.getText();
        tel = txtTel.getText();
        type = txtType.getText();
        password = txtPassword.getText();

    }
    private boolean ValidateUserData(){
        getUserData();
        System.out.println("LOG :: Entering Validation Stage");
        


        if(nom.isEmpty()){
            System.out.println("\n Champs de nom est vide");
            alert.setTitle("Informations incomplètes");
            alert.setHeaderText("Champ vide");
            alert.setContentText("Ajouter les informations manquantes");
            alert.showAndWait();
            return false;
        }

        if(prenom.isEmpty()){
            System.out.println("\n Champs de prenom est vide");
            alert.setTitle("Informations incomplètes");
            alert.setHeaderText("Champ vide");
            alert.setContentText("Ajouter les informations manquantes");
            alert.showAndWait();
            return false;
        }


        if(adresse.isEmpty()){
            System.out.println("\n Champs d'adresse est vide");
            alert.setTitle("Informations incomplètes");
            alert.setHeaderText("Champ vide");
            alert.setContentText("Ajouter les informations manquantes");
            alert.showAndWait();
            return false;
        }


        if(tel.isEmpty()){
            System.out.println("\n Champs de numéro de tel est vide");
            alert.setTitle("Informations incomplètes");
            alert.setHeaderText("Champ vide");
            alert.setContentText("Ajouter les informations manquantes");
            alert.showAndWait();
            return false;
        }


        if(type.isEmpty()){
            System.out.println("\n Champs de type est vide");
            alert.setTitle("Informations incomplètes");
            alert.setHeaderText("Champ vide");
            alert.setContentText("Ajouter les informations manquantes");
            alert.showAndWait();
            return false;
        }
        if(password.isEmpty()){
            System.out.println("\n Champs de password est vide");
            alert.setTitle("Informations incomplètes");
            alert.setHeaderText("Champ vide");
            alert.setContentText("Ajouter les informations manquantes");
            alert.showAndWait();
            return false;
        }


        else{
            return true;
        }
    }

    private void InsertDataIntoDB() throws SQLException{

        try {
            InsConn = DataSource.getInstance().getConnection();
            InsSt=InsConn.createStatement();

            SQLQuery = "INSERT INTO utilisateur (nom, prenom, adresse, tel, typeofuser, password) values('"+nom+"','"+prenom+"','"+adresse+"','"+tel+"','"+type+"','"+password+"');";
            InsSt.executeUpdate(SQLQuery);
            System.out.println("\n LOG :: Informations ajoutées");
        }catch (SQLException e){
            System.err.print(e);}}
      /*  }finally {
            if(InsSt!=null){
                InsSt.close();
            }
            if(InsConn!=null){
                InsConn.close();
            }
        } */

    
    public void Register() throws SQLException{
        boolean valResult = ValidateUserData();
        if(valResult){
            InsertDataIntoDB();
            ialert.setTitle("Données ajoutées avec succés");
            ialert.setHeaderText(null);
            ialert.setContentText("informations insérées");
            ialert.showAndWait();
        }
        else{
            ialert.setTitle("Echec d'insertion de données");
            ialert.setHeaderText(null);
            ialert.setContentText("Verifiez les champs");
            ialert.showAndWait();
        }
    }

}