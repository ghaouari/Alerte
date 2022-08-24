package models;

public class User {
    private int id;
    private String nom;
    private String prenom;
    private String adresse;
    private String tel;
    private String typeofuser;
    private String password;

    public User(int id, String nom, String prenom, String adresse, String tel, String typeofuser, String password) {
        this.id = id;
        this.nom= nom;
        this.prenom = prenom;
        this.adresse= adresse;
        this.tel = tel;
        this.typeofuser = typeofuser;
        this.password=password;
        
    }

    public User(){}

    public User(int id, String nom, String prenom, String adresse, String tel, String typeofuser) {
        this.id = id;
        this.nom= nom;
        this.prenom = prenom;
        this.adresse= adresse;
        this.tel = tel;
        this.typeofuser = typeofuser;
        
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTypeofuser() {
        return typeofuser;
    }

    public void setTypeOfUser(String typeofuser) {
        this.typeofuser = typeofuser;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", adresse email=" + adresse + ", nom=" + nom + ", prenom=" + prenom
                + ", password=" + password + ", numero de tel=" + tel + ", type Of User=" + typeofuser + "]";
    }

}