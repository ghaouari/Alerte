package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class PanelAdminController {
    

        private FXMLLoader fxmlLoader = null;
        private Parent root1=null;
        private Stage stage=null;
    
        @FXML
        private void create() throws IOException{
            try {
                fxmlLoader = new FXMLLoader(getClass().getResource("../views/Insert.fxml"));
                root1 = (Parent) fxmlLoader.load();
                stage = new Stage();
                stage.setTitle("Ajouter un utilisateur");
                stage.setScene(new Scene(root1));
                stage.show();
            }catch (Exception e){
                System.err.print(e);
            }
        }
    
        @FXML
        private void read() throws IOException{
            try {
                fxmlLoader = new FXMLLoader(getClass().getResource("../views/read.fxml"));
                root1 = (Parent) fxmlLoader.load();
                stage = new Stage();
                stage.setTitle("Afficher les détails d'un utilisateur ");
                stage.setScene(new Scene(root1));
                stage.show();
            }catch (Exception e){
                System.err.print(e);
            }
        }
    
        @FXML
        private void delete() throws IOException{
            try {
                fxmlLoader = new FXMLLoader(getClass().getResource("../views/delete.fxml"));
                root1 = (Parent) fxmlLoader.load();
                stage = new Stage();
                stage.setTitle("Supprimer un utilisateur");
                stage.setScene(new Scene(root1));
                stage.show();
            }catch (Exception e){
                System.err.print(e);
            }
        }
    
        @FXML
        private void update() throws IOException{
            try {
                fxmlLoader = new FXMLLoader(getClass().getResource("../views/update.fxml"));
                root1 = (Parent) fxmlLoader.load();
                stage = new Stage();
                stage.setTitle("Modifier un utilisateur");
                stage.setScene(new Scene(root1));
                stage.show();
            }catch (Exception e){
                System.err.print(e);
            }
        }
    }
