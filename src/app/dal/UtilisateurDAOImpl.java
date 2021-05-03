package app.dal;


import app.bo.Note;
import app.bo.Utilisateurs;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("DuplicatedCode")
public class UtilisateurDAOImpl  implements DAO<Utilisateurs> {


    private final String SELECT_BY_ID = "USE ENCHERES SELECT * FROM Utilisateurs WHERE no_utilisateur=?";
    private final String SELECT_ALL = "USE ENCHERES SELECT * FROM Utilisateurs";
    private final String UPDATE = "USE ENCHERES UPDATE Utilisateurs SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?, ville = ?, mot_de_passe = ?, credit = ?, administrateur = ? WHERE no_utilisateur= ?";
    private final String INSERT = "USE ENCHERES INSERT INTO Utilisateurs (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur ) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    private final String DELETE = "USE ENCHERES DELETE FROM Utilisateurs WHERE no_utilisateur= ?";


    private Connection connect() {
        try {
            // Je vais chercher le fichier context.xml
            Context context = new InitialContext();
            // Je vais lire le fichier context.xml
            DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
            // J'ouvre une connection
            Connection cnx = ds.getConnection();
            return cnx;
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

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
}
