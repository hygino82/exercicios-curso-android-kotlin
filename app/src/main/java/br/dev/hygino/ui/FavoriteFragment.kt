package br.dev.hygino.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import br.dev.hygino.databinding.FragmentFavoriteBinding
import br.dev.hygino.viewmodels.FavoriteViewModel

// Toda fragment extende de Fragment e não de Activity
class FavoriteFragment : Fragment() {
    // A fragment precisa de uma activity para existir
    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!// binding não tem tratamento de null safe

    private val viewModel: FavoriteViewModel by viewModels()

    override fun onCreateView(// responsável por criar o layout da fragment
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}