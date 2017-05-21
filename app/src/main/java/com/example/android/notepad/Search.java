package com.example.android.notepad;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.SearchView;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import static com.example.android.notepad.R.styleable.View;

public class Search extends Activity {

    private String[] mStrs = {NotePad.Notes.COLUMN_NAME_TITLE};
    private SearchView mSearchView;
    private ListView mListView;
    private SimpleCursorAdapter mSimpleCursorAdapter;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mSearchView = (SearchView) findViewById(R.id.searchView);
        mListView = (ListView) findViewById(R.id.listview);


        mSimpleCursorAdapter = new SimpleCursorAdapter(this, R.layout.noteslist_item, cursor,
                new String[] {NotePad.Notes.COLUMN_NAME_TITLE}, new int[] { android.R.id.text1});
        mListView.setAdapter(mSimpleCursorAdapter);
        mSearchView.setIconifiedByDefault(false);

        // 设置搜索文本监听
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            // 当点击搜索按钮时触发该方法
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            // 当搜索内容改变时触发该方法
            @Override
            public boolean onQueryTextChange(String newText) {
                String selection = NotePad.Notes.COLUMN_NAME_TITLE + " LIKE '%" + newText + "%' ";
                Intent intent = getIntent();

                // If there is no data associated with the Intent, sets the data to the default URI, which
                // accesses a list of notes.
                if (intent.getData() == null) {
                    intent.setData(NotePad.Notes.CONTENT_URI);
                }
                cursor = managedQuery(
                        getIntent().getData(),            // Use the default content URI for the provider.
                        NotesList.PROJECTION,                       // Return the note ID and title for each note.
                        selection,                             // No where clause, return all records.
                        null,                             // No where clause, therefore no where column values.
                        NotePad.Notes.DEFAULT_SORT_ORDER  // Use the default sort order.
                );
                mSimpleCursorAdapter.swapCursor(cursor);
                return true;
            }
        });
    }
    }
