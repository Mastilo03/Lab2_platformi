package mk.ukim.finki.lab_2.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NoteViewModel : ViewModel() {


    private val poraka = MutableLiveData<String>()


    val note: LiveData<String> get() = poraka


    fun updateNote(newNote: String) {
        poraka.value = newNote
    }

    init {
        poraka.value = ""
    }
}