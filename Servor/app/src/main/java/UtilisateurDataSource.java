import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

    public class UtilisateurDataSource {

        // Champs de la base de données
        private SQLiteDatabase database;
        private DataBase dbHelper;
        private String[] allColumns = { DataBase.COLUMN_QCM_UTILISATEUR_ID,
                DataBase.COLUMN_COMMENT };

        public UtilisateurDataSource(Context context) {
            dbHelper = new DataBase(context);
        }

        public void open() throws SQLException {
            database = dbHelper.getWritableDatabase();
        }

        public void close() {
            dbHelper.close();
        }

        public Comment createComment(String comment) {
            ContentValues values = new ContentValues();
            values.put(DataBase.COLUMN_COMMENT, comment);
            long insertId = database.insert(DataBase.TABLE_COMMENTS, null,
                    values);
            Cursor cursor = database.query(DataBase.TABLE_COMMENTS,
                    allColumns, DataBase.COLUMN_ID + " = " + insertId, null,
                    null, null, null);
            cursor.moveToFirst();
            Comment newComment = cursorToComment(cursor);
            cursor.close();
            return newComment;
        }

        public void deleteComment(Comment comment) {
            long id = comment.getId();
            System.out.println("Comment deleted with id: " + id);
            database.delete(DataBase.TABLE_COMMENTS, DataBase.COLUMN_ID
                    + " = " + id, null);
        }

        public List<Comment> getAllComments() {
            List<Comment> comments = new ArrayList<Comment>();

            Cursor cursor = database.query(DataBase.TABLE_COMMENTS,
                    allColumns, null, null, null, null, null);

            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Comment comment = cursorToComment(cursor);
                comments.add(comment);
                cursor.moveToNext();
            }
            // assurez-vous de la fermeture du curseur
            cursor.close();
            return comments;
        }

        private Comment cursorToComment(Cursor cursor) {
            Comment comment = new Comment();
            comment.setId(cursor.getLong(0));
            comment.setComment(cursor.getString(1));
            return comment;
        }
    }
}
