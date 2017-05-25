import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class UtilisateurDataSource
{

    // Champs de la base de données
    private SQLiteDatabase database;
    private DataBase dbHelper;
    private String[] allColumns = {DataBase.COLUMN_UTILISATEUR_IDMAIL, DataBase.COLUMN_UTILISATEUR_NOM, DataBase.COLUMN_UTILISATEUR_PRENOM, DataBase.COLUMN_UTILISATEUR_TYPE, DataBase.COLUMN_UTILISATEUR_MDP, DataBase.COLUMN_UTILISATEUR_ANNEE};

    public UtilisateurDataSource(Context context) {
        dbHelper = new DataBase(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Utilisateur createUtilisateur(String nom, String prenom, String type, String mdp, String annee)
    {
        ContentValues values = new ContentValues();

        values.put(DataBase.COLUMN_UTILISATEUR_NOM, nom);
        values.put(DataBase.COLUMN_UTILISATEUR_PRENOM, prenom);
        values.put(DataBase.COLUMN_UTILISATEUR_TYPE, type);
        values.put(DataBase.COLUMN_UTILISATEUR_MDP, mdp);
        values.put(DataBase.COLUMN_UTILISATEUR_ANNEE_ID, annee);

        long insertId = database.insert(DataBase.TABLE_UTILISATEUR, null, values);
        Cursor cursor = database.query(DataBase.TABLE_UTILISATEUR, allColumns, DataBase.COLUMN_UTILISATEUR_IDMAIL + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        Utilisateur newUtilisateur = cursorToUtilisateur(cursor);
        cursor.close();
        return newUtilisateur;
    }

    public void deleteUtilisateur(Utilisateur utilisateur) {
        long id = utilisateur.getId();
        System.out.println("Comment deleted with id: " + id);
        database.delete(DataBase.TABLE_UTILISATEUR, DataBase.COLUMN_UTILISATEUR_IDMAIL + " = " + id, null);
    }

    public List<Utilisateur> getAllUtilisateur() {
        List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();

        Cursor cursor = database.query(DataBase.TABLE_UTILISATEUR,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Utilisateur utilisateur = cursorToUtilisateur(cursor);
            utilisateurs.add(utilisateur);
            cursor.moveToNext();
        }
        // assurez-vous de la fermeture du curseur
        cursor.close();
        return utilisateurs;
    }

    private Utilisateur cursorToUtilisateur(Cursor cursor) {
        Utilisateur comment = new Utilisateur();
        comment.setId(cursor.getLong(0));
        comment.setComment(cursor.getString(1));
        return comment;
    }
}

