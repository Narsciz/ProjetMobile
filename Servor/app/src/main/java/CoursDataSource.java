import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class CoursDataSource {
    // Champs de la base de données
    private SQLiteDatabase database;
    private DataBase dbHelper;
    private String[] allColumns = {DataBase.COLUMN_MATIERE_ID, DataBase.COLUMN_MATIERE_NOM};

    public CoursDataSource(Context context) {
        dbHelper = new DataBase(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Cours createCours(String nom)
    {
        ContentValues values = new ContentValues();

        values.put(DataBase.COLUMN_MATIERE_NOM, nom);

        long insertId = database.insert(DataBase.TABLE_MATIERE, null, values);
        Cursor cursor = database.query(DataBase.TABLE_MATIERE, allColumns, DataBase.COLUMN_MATIERE_ID + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        Cours newMatiere = cursorToCours(cursor);
        cursor.close();
        return newMatiere;
    }

    public void deleteCours(Cours matiere) {
        long id = matiere.getId();
        System.out.println("Comment deleted with id: " + id);
        database.delete(DataBase.TABLE_UTILISATEUR, DataBase.COLUMN_UTILISATEUR_IDMAIL + " = " + id, null);
    }

    public List<Cours> getAllCours() {
        List<Cours> matieres = new ArrayList<Cours>();

        Cursor cursor = database.query(DataBase.TABLE_UTILISATEUR,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Cours matiere = cursorToCours(cursor);
            matieres.add(matiere);
            cursor.moveToNext();
        }
        // assurez-vous de la fermeture du curseur
        cursor.close();
        return matieres;
    }

    private Cours cursorToCours(Cursor cursor) {
        Cours matiere = new Cours();
        matiere.setId(cursor.getLong(0));
        matiere.setComment(cursor.getString(1));
        return matiere;
    }
}
