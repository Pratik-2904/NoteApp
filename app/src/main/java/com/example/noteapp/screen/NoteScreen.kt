package com.example.noteapp.screen

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.noteapp.component.NoteButton
import com.example.noteapp.component.NoteInputTextField
import com.example.noteapp.data.NotesDataSource
import com.example.noteapp.model.Note
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun NoteScreen(
    notes: List<Note> = NotesDataSource().loadNotes(),
    onAddNote: (Note) -> Unit = {},
    onRemoveNote: (Note) -> Unit = {}
) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(
            modifier = Modifier.border(
                width = 1.dp,
                color = Color.Gray
            ), title = {
                    Text(text = "Notes")
            },
            actions = {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Notifications"
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Transparent
            )
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NoteInputTextField(
                modifier = Modifier.padding(
                    top = 6.dp
                ),
                text = title,
                label = "Title",
                maxLine = 1,
                onTextChange = {
                    if (it.all { char ->
                            char.isLetter() || char.isWhitespace()
                        }) title = it
                }
            )
            NoteInputTextField(
                modifier = Modifier.padding(
                    top = 4.dp
                ),
                text = description,
                label = "Description",
                onTextChange = {
                    if (it.all { char ->
                            char.isLetter() || char.isWhitespace()
                        }) description = it


                }
            )
            NoteButton(
                modifier = Modifier.padding(top = 6.dp),
                text = "Save",
                onClick = {
                    if (title.isNotEmpty() && description.isNotEmpty()) {
                        //Todo
                        onAddNote(Note(title = title, description = description))
                        title = ""
                        description = ""

                        //TODO if successfully addition make Toast "success or failure"
                    }
                }
            )

        }

        HorizontalDivider(modifier = Modifier.padding(10.dp))
        LazyColumn {
            items(notes) { note ->
                NoteRow(note = note,
                    onNoteClicked = { onRemoveNote(it) })
            }
        }

    }

}


@Preview(showBackground = true)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NoteRow(
    modifier: Modifier = Modifier,
    note: Note = NotesDataSource().loadNotes()[0],
    onNoteClicked: (Note) -> Unit = {}
) {
    val context = LocalContext.current
    Surface(
        modifier = modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(topEnd = 33.dp, bottomStart = 33.dp))
            .fillMaxWidth(),
        color = Color(0xFFDFE6EB),
        tonalElevation = 6.dp
    ) {
        Column(
            modifier = modifier
                .padding(horizontal = 14.dp, vertical = 6.dp)
                .combinedClickable(
                    onLongClick = {
                        onNoteClicked(note)
                    },
                    onClick = {
                        Toast.makeText(context,"Clicked ${note.id}",Toast.LENGTH_SHORT).show()
                    }
                ),
            horizontalAlignment = Alignment.Start) {
            Text(
                text = note.title,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(text = note.description, style = MaterialTheme.typography.bodySmall)
//            Text(
//                //                text = note.entryDate.format(
////                    DateTimeFormatter.ofPattern("EEE, d MMM")
////                    //jul 18
////                ),
//                text = note.entryDate,
//                style = MaterialTheme.typography.bodySmall
//            )


        }


    }

}