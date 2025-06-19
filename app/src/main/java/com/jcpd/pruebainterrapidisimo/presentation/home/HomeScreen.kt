package com.jcpd.pruebainterrapidisimo.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.jcpd.pruebainterrapidisimo.R
import com.jcpd.pruebainterrapidisimo.databinding.HomeFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeScreen : Fragment(){

    private val homeViewModel by viewModels<HomeViewModel>()

    private var _binding: HomeFragmentBinding? = null
    private val binding get() = _binding!!


    private var user : TextView? = null
    private var name : TextView? = null
    private var id : TextView? = null
    private var version : TextView? = null
    private var buttonTables : Button? = null
    private var buttonLocations : Button? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeViews()
        observeState()

    }

    private fun observeState() {
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle ( Lifecycle.State.STARTED ) {
                homeViewModel.version.collect {
                    version?.text = it
                }
            }
        }
    }

    private fun initializeViews() {
        user = binding.User
        name = binding.Name
        id = binding.Id
        version = binding.Version
        buttonTables = binding.buttonTables
        buttonLocations = binding.buttonLocations

        user?.text = "meh"
        name?.text = "meh2"
        id?.text = "meh3"
        buttonTables?.text = "Tables"
        buttonLocations?.text = "Locations"

        buttonTables?.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_tableFragment)
        }

        buttonLocations?.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_locationsFragment)
        }

    }


}