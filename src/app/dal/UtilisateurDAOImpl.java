package app.dal;


import app.bo.Utilisateurs;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("DuplicatedCode")
public class UtilisateurDAOImpl extends MaConnexion  implements DAOConnect {


    private final String SELECT_BY_ID = "USE ENCHERES SELECT * FROM Utilisateurs WHERE no_utilisateur=?";
    private final String SELECT_ALL = "USE ENCHERES SELECT * FROM Utilisateurs";
    private final String UPDATE = "USE ENCHERES UPDATE Utilisateurs SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?, ville = ?, mot_de_passe = ?, credit = ?, administrateur = ? WHERE no_utilisateur= ?";
    private final String INSERT = "USE ENCHERES INSERT INTO Utilisateurs (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur ) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    private final String DELETE = "USE ENCHERES DELETE FROM Utilisateurs WHERE no_utilisateur= ?";
    private final String CONNECT =  "USE ENCHERES SELECT * FROM Utilisateurs WHERE ( email=? or pseudo=? )and mot_de_passe=?";


    @Override
    public Utilisateurs selectById(int id) throws DALException {
        Utilisateurs utilisateur = null;
        try {
            Connection cnx = connect();
            //
            PreparedStatement stmt = cnx.prepareStatement(SELECT_BY_ID);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                utilisateur = new Utilisateurs();
                utilisateur.setNo_utilisateur(rs.getInt("no_article"));
                utilisateur.setPseudo(rs.getString("pseudo"));
                utilisateur.setNom(rs.getString("nom"));
                utilisateur.setNom(rs.getString("prenom"));
                utilisateur.setNom(rs.getString("email"));
                utilisateur.setNom(rs.getString("telephone"));
                utilisateur.setNom(rs.getString("rue"));
                utilisateur.setNom(rs.getString("code_postal"));
                utilisateur.setNom(rs.getString("ville"));
                utilisateur.setNom(rs.getString("mot_de_passe"));
                utilisateur.setNom(rs.getString("credit"));
                utilisateur.setNom(rs.getString("administrateur"));


            }
            cnx.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Problème dans la sélection d'un utilisateur par son ID");
        }
        return utilisateur;
    }

    @Override
    public List<Utilisateurs> selectAll() throws DALException {
        List<Utilisateurs> utilisateursList = new ArrayList<Utilisateurs>();
        try {
            Connection cnx = connect();
            //
            PreparedStatement stmt = cnx.prepareStatement(SELECT_ALL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
               Utilisateurs utilisateur = new Utilisateurs();
                utilisateur.setNo_utilisateur(rs.getInt("no_article"));
                utilisateur.setPseudo(rs.getString("pseudo"));
                utilisateur.setNom(rs.getString("nom"));
                utilisateur.setNom(rs.getString("prenom"));
                utilisateur.setNom(rs.getString("email"));
                utilisateur.setNom(rs.getString("telephone"));
                utilisateur.setNom(rs.getString("rue"));
                utilisateur.setNom(rs.getString("code_postal"));
                utilisateur.setNom(rs.getString("ville"));
                utilisateur.setNom(rs.getString("mot_de_passe"));
                utilisateur.setNom(rs.getString("credit"));
                utilisateur.setNom(rs.getString("administrateur"));

                utilisateursList.add(utilisateur);

            }
            cnx.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Problème dans la sélection de tous les utilisateurs");
        }
        return utilisateursList;
    }

    @Override
    public void update(Utilisateurs utilisateurs) throws DALException {
        try {
            Connection cnx = connect();
            //pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur
            PreparedStatement stmt = cnx.prepareStatement(UPDATE);
            stmt.setString(1, utilisateurs.getPseudo());
            stmt.setString(2, utilisateurs.getNom());
            stmt.setString(3, utilisateurs.getPrenom());
            stmt.setString(4, utilisateurs.getEmail());
            stmt.setString(5, utilisateurs.getTelephone());
            stmt.setString(6, utilisateurs.getRue());
            stmt.setString(7, utilisateurs.getCode_postal());
            stmt.setString(8, utilisateurs.getVille());
            stmt.setString(9,utilisateurs.getMot_de_passe());
            stmt.setInt(10,utilisateurs.getCredit());
            stmt.setBoolean(11,utilisateurs.isAdministrateur());
            stmt.setInt(12, utilisateurs.getNo_utilisateur());
            stmt.executeUpdate();
            cnx.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Problème dans la mise à jour d'un utilisateur");
        }
    }

    @Override
    public Utilisateurs insert(Utilisateurs utilisateurs) throws DALException {
        try {
            Connection cnx = connect();
            //
            PreparedStatement stmt = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, utilisateurs.getPseudo());
            stmt.setString(2, utilisateurs.getNom());
            stmt.setString(3, utilisateurs.getPrenom());
            stmt.setString(4, utilisateurs.getEmail());
            stmt.setString(5, utilisateurs.getTelephone());
            stmt.setString(6, utilisateurs.getRue());
            stmt.setString(7, utilisateurs.getCode_postal());
            stmt.setString(8, utilisateurs.getVille());
            stmt.setString(9,utilisateurs.getMot_de_passe());
            stmt.setInt(10,utilisateurs.getCredit());
            stmt.setBoolean(11,utilisateurs.isAdministrateur());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            utilisateurs.setNo_utilisateur(generatedKey);

            cnx.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Problème dans l'insertion d'un utilisateur");
        }
        return utilisateurs;
    }

    @Override
    public void delete(int id) throws DALException {
        try {
            Connection cnx = connect();
            //
            PreparedStatement stmt = cnx.prepareStatement(DELETE);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            cnx.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Problème dans la suppression d'un utilisateur");

        }
    }




    @Override
    public Utilisateurs connect(String mail, String password) throws DALException{
        Utilisateurs utilisateur = null;
        try {
            Connection cnx = connect();
            PreparedStatement stmt = cnx.prepareStatement(CONNECT);
            stmt.setString(1, mail);
            stmt.setString(2, mail);
            stmt.setString(3, password);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                utilisateur = new Utilisateurs();
                utilisateur.setNo_utilisateur(rs.getInt("no_utilisateur"));
                utilisateur.setPseudo(rs.getString("pseudo"));
                utilisateur.setNom(rs.getString("nom"));
                utilisateur.setPrenom(rs.getString("prenom"));
                utilisateur.setEmail(rs.getString("email"));
                utilisateur.setTelephone(rs.getString("telephone"));
                utilisateur.setRue(rs.getString("rue"));
                utilisateur.setCode_postal(rs.getString("code_postal"));
                utilisateur.setVille(rs.getString("ville"));
                utilisateur.setMot_de_passe(rs.getString("mot_de_passe"));
                utilisateur.setCredit(rs.getInt("credit"));
                utilisateur.setAdministrateur(rs.getBoolean("administrateur"));


            }
            if (utilisateur == null)
                throw new DALException("Il n'y a pas d'utilisateur avec ces indentifiants");
            cnx.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Problème dans la connexion d'un utilisateur");
        }
        return utilisateur;
    }
}
