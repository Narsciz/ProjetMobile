import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "CoursEnLigne.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_UTILISATEUR = "Utilisateur";
        public static final String COLUMN_UTILISATEUR_IDMAIL = "_idmail";
        public static final String COLUMN_UTILISATEUR_NOM = "Nom";
        public static final String COLUMN_UTILISATEUR_PRENOM = "Prenom";
        public static final String COLUMN_UTILISATEUR_TYPE = "Type";
        public static final String COLUMN_UTILISATEUR_MDP = "MotDePasse";
        public static final String COLUMN_UTILISATEUR_ANNEE = "Annee";

    public static final String TABLE_COURS = "Cours";
        public static final String COLUMN_COURS_ID = "_id";
        public static final String COLUMN_COURS_MATIERE_ID = "Matiere_id";
        public static final String COLUMN_COURS_INTITULE_ID = "Intitule_id";
        public static final String COLUMN_COURS_NOM = "Nom";
        public static final String COLUMN_COURS_FORMAT = "Format";
        public static final String COLUMN_COURS_PATH = "Path";


    public static final String TABLE_MATIERE = "Matiere";
        public static final String COLUMN_MATIERE_ID = "_id";
        public static final String COLUMN_MATIERE_NOM = "Nom";


    public static final String TABLE_INTITULE = "Intitulé";
        public static final String COLUMN_INTITULE_ID = "_id";
        public static final String COLUMN_INTITULE_MATIERE_ID = "Matiere_id";
        public static final String COLUMN_INTITULE_NOM = "Nom";


    public static final String TABLE_QCM = "QCM";
        public static final String COLUMN_QCM_ID = "_id";
        public static final String COLUMN_QCM_UTILISATEUR_ID = "Utilisateur_id";
        public static final String COLUMN_QCM_NOM = "Nom";

    public static final String TABLE_QUESTION = "Question";
        public static final String COLUMN_QUESTION_ID = "_id";
        public static final String COLUMN_QUESTION_QCM_ID = "QCM_id";
        public static final String COLUMN_QUESTION_TEXTE = "Texte";

    public static final String TABLE_REPONSE = "Réponse";
    public static final String COLUMN_REPONSE_ID = "_id";
    public static final String COLUMN_REPONSE_QCM_ID = "QCM_id";
    public static final String COLUMN_REPONSE_QUESTION_ID = "Question_id";
    public static final String COLUMN_REPONSE_TEXTE = "Texte";
    public static final String COLUMN_REPONSE_VRAI = "Vrai";


    // Commande sql pour la création de la base de données
    private static final String DATABASE_CREATE_UTILISATEUR = "create table "
            + TABLE_UTILISATEUR + "("
            + COLUMN_UTILISATEUR_IDMAIL + " varchar(50) primary key, "
            + COLUMN_UTILISATEUR_NOM + " text not null, "
            + COLUMN_UTILISATEUR_PRENOM + " text not null, "
            + COLUMN_UTILISATEUR_TYPE + " text not null, "
            + COLUMN_UTILISATEUR_MDP + " text not null, "
            + COLUMN_UTILISATEUR_ANNEE + " text not null);";

    private static final String DATABASE_CREATE_COURS = "create table "
            + TABLE_COURS + "("
            + COLUMN_COURS_ID + " integer primary key autoincrement, "
            + COLUMN_COURS_MATIERE_ID + "integer, "
            + COLUMN_COURS_INTITULE_ID + "integer, "
            + COLUMN_COURS_NOM + " text not null, "
            + COLUMN_COURS_FORMAT + " text not null, "
            + COLUMN_COURS_PATH + " text not null, "
            + "constraint fk_Matiere_id foreign key("+ COLUMN_COURS_MATIERE_ID + ") references " + TABLE_MATIERE + "(" + COLUMN_MATIERE_ID + "), "
            + "constraint fk_Intitule_id foreign key("+ COLUMN_COURS_INTITULE_ID + ") references " + TABLE_INTITULE + "(" + COLUMN_INTITULE_ID + ")"
            + "); ";

    private static final String DATABASE_CREATE_MATIERE = "create table "
            + TABLE_MATIERE + "("
            + COLUMN_MATIERE_ID + " integer primary key autoincrement, "
            + COLUMN_MATIERE_NOM + " text not null);";

    private static final String DATABASE_CREATE_INTITULE = "create table "
            + TABLE_INTITULE + "("
            + COLUMN_INTITULE_ID + " integer primary key autoincrement, "
            + COLUMN_INTITULE_MATIERE_ID + "integer, "
            + COLUMN_INTITULE_NOM + " text not null, "
            + "constraint fk_Matiere_id foreign key("+ COLUMN_INTITULE_MATIERE_ID + ") references " + TABLE_MATIERE + "(" + COLUMN_MATIERE_ID + ")"
            +");";

    private static final String DATABASE_CREATE_QCM = "create table "
            + TABLE_QCM + "("
            + COLUMN_QCM_ID + " integer primary key autoincrement, "
            + COLUMN_QCM_UTILISATEUR_ID + "integer, "
            + COLUMN_QCM_NOM + " text not null"
            + "constraint fk_Utilisateur_id foreign key("+ COLUMN_QCM_UTILISATEUR_ID + ") references " + TABLE_UTILISATEUR + "(" + COLUMN_UTILISATEUR_IDMAIL + ")"
            +");";

    private static final String DATABASE_CREATE_QUESTION = "create table "
            + TABLE_QUESTION + "("
            + COLUMN_QUESTION_ID + " integer primary key autoincrement, "
            + COLUMN_QUESTION_QCM_ID + "integer, "
            + COLUMN_QCM_NOM + " text not null, "
            +"constraint fk_QCM_id foreign key("+ COLUMN_QUESTION_QCM_ID + ") references " + TABLE_QCM + "(" + COLUMN_QCM_ID + ")"
            + ");";

    private static final String DATABASE_CREATE_REPONSE = "create table "
            + TABLE_REPONSE + "("
            + COLUMN_REPONSE_ID + " integer primary key autoincrement, "
            + COLUMN_REPONSE_QCM_ID + " integer, "
            + COLUMN_REPONSE_QUESTION_ID + "integer, "
            + COLUMN_REPONSE_TEXTE + " text not null, "
            + COLUMN_REPONSE_VRAI + "boolean, "
            + "constraint fk_QCM_id foreign key("+ COLUMN_REPONSE_QCM_ID + ") references " + TABLE_QCM + "(" + COLUMN_QCM_ID + "), "
            + "constraint fk_Question_id foreign key("+ COLUMN_REPONSE_QUESTION_ID + ") references " + TABLE_QUESTION + "(" + COLUMN_QUESTION_ID + ")"
            + ");";

    public DataBase(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_UTILISATEUR);
        db.execSQL(DATABASE_CREATE_COURS);
        db.execSQL(DATABASE_CREATE_MATIERE);
        db.execSQL(DATABASE_CREATE_INTITULE);
        db.execSQL(DATABASE_CREATE_QCM);
        db.execSQL(DATABASE_CREATE_QUESTION);
        db.execSQL(DATABASE_CREATE_REPONSE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DataBase.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_UTILISATEUR + ";");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COURS + ";");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MATIERE + ";");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_INTITULE + ";");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QCM + ";");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTION + ";");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REPONSE + ";");
        onCreate(db);
    }
}
