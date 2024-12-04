package com.rega.heallink.ui.add

import Note
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.rega.heallink.R
import com.rega.heallink.ViewModelFactory
import com.rega.heallink.databinding.FragmentNoteAddBinding
import com.rega.heallink.di.Injection

class NoteAddFragment : Fragment() {

    private var _binding: FragmentNoteAddBinding? = null
    private val binding get() = _binding!!

    private val noteAddViewModel: NoteAddViewModel by viewModels {
        ViewModelFactory(Injection.provideRepository(requireContext()))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentNoteAddBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Set up button click listener for inserting a note
        binding.btnSubmit.setOnClickListener {
            insertNote()
        }

        return root
    }

    private fun insertNote() {
        val title = binding.edtTitle.text.toString().trim()
        val description = binding.edtDescription.text.toString().trim()

        // Validate input
        if (title.isEmpty() || description.isEmpty()) {
            Toast.makeText(requireContext(), R.string.fill_all_fields, Toast.LENGTH_SHORT).show()
            return
        }

        // Create a new Note object
        val note = Note(
            title = title,
            description = description,
            date = System.currentTimeMillis().toString() // Example: store the current timestamp as a string
        )

        // Call insert in ViewModel
        noteAddViewModel.insert(note)

        // Show success message
        Toast.makeText(requireContext(), R.string.note_added, Toast.LENGTH_SHORT).show()

        requireView().findNavController().popBackStack()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
