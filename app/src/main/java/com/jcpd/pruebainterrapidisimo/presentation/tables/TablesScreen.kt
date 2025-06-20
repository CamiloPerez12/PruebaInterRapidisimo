package com.jcpd.pruebainterrapidisimo.presentation.tables

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.jcpd.pruebainterrapidisimo.R
import com.jcpd.pruebainterrapidisimo.databinding.TablesFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TablesScreen : Fragment() {
    private val tablesViewModel by viewModels<TablesViewModel>()
    private var _binding: TablesFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var tableListAdapter: TableListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.app_name_tables_fragment)
        _binding = TablesFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeState()
    }

    private fun observeState() {
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                tablesViewModel.state.collect {
                    tableListAdapter = TableListAdapter(it)
                    binding.recyclerViewTables.adapter = tableListAdapter
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}