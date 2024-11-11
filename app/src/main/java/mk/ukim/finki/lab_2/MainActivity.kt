package mk.ukim.finki.lab_2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import mk.ukim.finki.lab_2.viewModel.NoteViewModel



class MainActivity : AppCompatActivity() {

    private lateinit var noteViewModel: NoteViewModel
    private lateinit var noteTextView : TextView
    private lateinit var saveButton : Button
    private lateinit var noteEditText : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        noteTextView= findViewById(R.id.noteTextView)
        noteEditText= findViewById(R.id.noteEditText)
        saveButton= findViewById(R.id.saveButton)


        noteViewModel = ViewModelProvider(this)[NoteViewModel::class.java]


        noteViewModel.note.observe(this, Observer { newNote ->
            noteTextView.text = newNote

        })

        saveButton.setOnClickListener {
            val newNote = noteEditText.text.toString()
            noteViewModel.updateNote(newNote)
        }
    }
}