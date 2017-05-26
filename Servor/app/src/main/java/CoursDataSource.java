import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import CommonClasses.*;


public class CoursDataSource {
    // Champs de la base de données
    private SQLiteDatabase database;
    private DataBase dbHelper;
    private String[] allColumns = {DataBase.COLUMN_COURS_ID, DataBase.COLUMN_COURS_MATIERE_ID, DataBase.COLUMN_COURS_INTITULE_ID, DataBase.COLUMN_COURS_NOM, DataBase.COLUMN_COURS_FORMAT, DataBase.COLUMN_COURS_PATH};

    public CoursDataSource(Context context) {
        dbHelper = new DataBase(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Cours createCours(Cours cours)
    {
        ContentValues values = new ContentValues();

        values.put(DataBase.COLUMN_COURS_MATIERE_ID, cours.getMatiere().ordinal());
        values.put(DataBase.COLUMN_COURS_INTITULE_ID, );
        values.put(DataBase.COLUMN_COURS_NOM, cours.getNom());
        values.put(DataBase.COLUMN_COURS_FORMAT, cours.getFormat().name());
        values.put(DataBase.COLUMN_COURS_PATH, cours.getPath());

        long insertId = database.insert(DataBase.TABLE_MATIERE, null, values);
        Cursor cursor = database.query(DataBase.TABLE_MATIERE, allColumns, DataBase.COLUMN_MATIERE_ID + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        Cours newCours = cursorToCours(cursor);
        cursor.close();
        return newCours;
    }

    public void deleteCours(Cours cours) {
        long id = cours.getId();
        System.out.println("Cours deleted with id: " + id);
        database.delete(DataBase.TABLE_UTILISATEUR, DataBase.COLUMN_UTILISATEUR_IDMAIL + " = " + id, null);
    }

    public List<Cours> getAllCours() {
        List<Cours> listCours = new ArrayList<Cours>();

        Cursor cursor = database.query(DataBase.TABLE_UTILISATEUR,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Cours cours = cursorToCours(cursor);
            listCours.add(cours);
            cursor.moveToNext();
        }
        // assurez-vous de la fermeture du curseur
        cursor.close();
        return listCours;
    }

    private Cours cursorToCours(Cursor cursor) {
        Cours cours = new Cours();
        cours.setId(cursor.getLong(0));
        cours.setMatiere(Matiere.valueOf(cursor.getString(1)));
        cours.setIntitule(cursor.getString(2));
        cours.setNom(cursor.getString(3));
        cours.setAnneeAuthorisee(cursor.getString(4));
        cours.setFormat(Format.valueOf(cursor.getString(5)));
        cours.setPath(cursor.getString(6));
        return cours;
    }
}
