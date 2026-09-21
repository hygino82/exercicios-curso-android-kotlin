package br.dev.hygino.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import br.dev.hygino.databinding.FragmentDashboardBinding
// Toda fragment extende de Fragment e não de Activity
class DashboardFragment : Fragment() {
    // A fragment precisa de uma activity para existir
    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!// binding não tem tratamento de null safe

    override fun onCreateView(// responsável por criar o layout da fragment
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}