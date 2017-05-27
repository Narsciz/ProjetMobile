import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteQueryBuilder;
import android.os.Bundle;
import android.widget.Toast;

import com.coursenligne.servor.R;


public class DataBaseTuto extends Activity {
    // The database
    private SQLiteDatabase db;
    // The database creator and updater helper
    DBOpenHelper dbOpenHelper;

    // Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create or retrieve the database
        dbOpenHelper = new DBOpenHelper(this, DBOpenHelper.Constants.DATABASE_NAME, null,
                DBOpenHelper.Constants.DATABASE_VERSION);

        // open the database
        openDB();

        // Insert a new record
        // -------------------
        ContentValues contentValues = new ContentValues();
        long rowId = insertRecord(contentValues);

        // update that line
        // ----------------
        rowId = updateRecord(contentValues, rowId);

        // Query that line
        // ---------------
        queryTheDatabase();

        // And then delete it:
        // -------------------
        deleteRecord(rowId);
    }

    /*********************************************************************************/
    /** Managing LifeCycle and database open/close operations *********************************/
    /*********************************************************************************/
    @Override
    protected void onResume() {
        super.onResume();
        openDB();
    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDB();
    }

    /**
     * * Open the database* *
     *
     * @throws SQLiteException
     */
    public void openDB() throws SQLiteException {
        try {
            db = dbOpenHelper.getWritableDatabase();
        } catch (SQLiteException ex) {
            db = dbOpenHelper.getReadableDatabase();
        }
    }

    /** *Close Database */
    public void closeDB() {
        db.close();
    }

    /****************************************************************************************/
    /** Managing Records **********************************************************************/
    /****************************************************************************************/
    /**
     * Insert a record
     *
     * @param contentValues
     *            (an empty contentValues)
     * @return the inserted row id
     */
    private long insertRecord(ContentValues contentValues) {
        // Assign the values for each column.
        contentValues.put(DBOpenHelper.Constants.KEY_COL_NAME, "name");
        contentValues.put(DBOpenHelper.Constants.KEY_COL_FIRSTNAME, "firstName");
        contentValues.put(DBOpenHelper.Constants.KEY_COL_EYES_COLOR, "green");
        contentValues.put(DBOpenHelper.Constants.KEY_COL_HAIR_COLOR, "blond");
        contentValues.put(DBOpenHelper.Constants.KEY_COL_AGE, 6);

        // Insert the line in the database
        long rowId = db.insert(DBOpenHelper.Constants.MY_TABLE, null, contentValues);

        // Test to see if the insertion was ok
        if (rowId == -1) {
            Toast.makeText(this, "Error when creating an human",
                    Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Human created and stored in database",
                    Toast.LENGTH_LONG).show();
        }
        return rowId;
    }

    /**
     * * Update a record
     *
     * @param contentValues
     * @param rowId
     * @return the updated row id
     */
    private long updateRecord(ContentValues contentValues, long rowId) {
        contentValues.clear();
        contentValues.put(DBOpenHelper.Constants.KEY_COL_NAME, "Georges");
        contentValues.put(DBOpenHelper.Constants.KEY_COL_FIRSTNAME, "Walter Bush");
        // update the database
        rowId = db.update(DBOpenHelper.Constants.MY_TABLE, contentValues,
                DBOpenHelper.Constants.KEY_COL_ID + "=" + rowId, null);
        // test to see if the insertion was ok
        if (rowId == -1) {
            Toast.makeText(this, "Error when updating an human",
                    Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Human updated in database", Toast.LENGTH_LONG)
                    .show();
        }
        return rowId;
    }

    /**
     * * Delete a Record *
     *
     * @param rowId
     */
    private void deleteRecord(long rowId) {
        rowId = db.delete(DBOpenHelper.Constants.MY_TABLE,
                DBOpenHelper.Constants.KEY_COL_ID + "=" + rowId, null);
        if (rowId == -1) {
            Toast.makeText(this, "Error when deleting an human",
                    Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Human deleted in database", Toast.LENGTH_LONG)
                    .show();
        }
    }

    /**
     * Query a the database
     */
    private void queryTheDatabase() {
        // Using man made query
        // The projection define what are the column you want to retrieve
        String[] projections = new String[] { DBOpenHelper.Constants.KEY_COL_ID,
                DBOpenHelper.Constants.KEY_COL_NAME, DBOpenHelper.Constants.KEY_COL_FIRSTNAME };
        // And then store the column index answered by the request (we present
        // an other way to
        // retireve data)
        final int cursorIdColNumber = 0, cursorNameColNumber = 1, cursorFirstNameColNumber = 2;
        // To add a Where clause you can either do that:
        // qb.appendWhere(Constants.KEY_COL_HAIR_COLOR+ "=blond");
        // Or that:
        String selection = DBOpenHelper.Constants.KEY_COL_HAIR_COLOR + "=?";
        String[] selectionArg = new String[] { "blond" };
        // The groupBy clause:
        String groupBy = DBOpenHelper.Constants.KEY_COL_EYES_COLOR;
        // The having clause
        String having = null;
        // The order by clause (column name followed by Asc or DESC)
        String orderBy = DBOpenHelper.Constants.KEY_COL_AGE + "  ASC";
        // Maximal size of the results list
        String maxResultsListSize = "60";
        Cursor cursor = db.query(DBOpenHelper.Constants.MY_TABLE, projections, selection,
                selectionArg, groupBy, having, orderBy, maxResultsListSize);
        displayResults(cursor);

        // Using the QueryBuilder
        // Create a Query SQLite object
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(DBOpenHelper.Constants.MY_TABLE);
        // qb.appendWhere(Constants.KEY_COL_HAIR_COLOR+ "=blond");
        qb.setDistinct(true);
        cursor = qb.query(db, projections, selection, selectionArg, groupBy,
                having, orderBy);
        displayResults(cursor);
    }

    /**
     * Display the results stored in the cursor
     *
     * @param cursor
     */
    private void displayResults(Cursor cursor) {
        // then browse the result:
        if (cursor.moveToFirst()) {
            // The elements to retrieve
            Integer colId;
            String name;
            String firstname;
            // The associated index within the cursor
            int indexId = cursor.getColumnIndex(DBOpenHelper.Constants.KEY_COL_ID);
            int indexName = cursor.getColumnIndex(DBOpenHelper.Constants.KEY_COL_NAME);
            int indexFirstName = cursor
                    .getColumnIndex(DBOpenHelper.Constants.KEY_COL_FIRSTNAME);
            // Browse the results list:
            int count = 0;
            do {
                colId = cursor.getInt(indexId);
                name = cursor.getString(indexName);
                firstname = cursor.getString(indexFirstName);
                Toast.makeText(
                        this,
                        "Retrieve element :" + name + "," + firstname + " ("
                                + colId + ")", Toast.LENGTH_LONG).show();
                count++;
            } while (cursor.moveToNext());
            Toast.makeText(this,
                    "The number of elements retrieved is " + count,
                    Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "No element found : ", Toast.LENGTH_LONG)
                    .show();
        }
    }
}
