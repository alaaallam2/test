package com.example.myapplication.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
@AndroidEntryPoint
class FavoriteFragment : BaseFragment() {

    private lateinit var binding: FragmentFavoriteBinding
    private val viewModel: FavoriteViewModel by viewModels()
    private lateinit var adapter: FavoriteAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        setDirectionView()
        setTitle(binding.toolbarCon.toolbarCon, findNavController(), getString(R.string.favorite), true)
        setContentView()
        observeViewModel()
        return binding.root
    }

    private fun setDirectionView() {
        val activity = requireActivity()
        val toolbar = binding.toolbarCon.toolbarCon
        val navController = findNavController()
        setTitle(toolbar, navController, getString(R.string.favorite), true)
    }

    private fun setContentView() {
        adapter = FavoriteAdapter()
        binding.recyclerViewDoctors.adapter = adapter
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
    }

    private fun observeViewModel() {
        viewModel.favoriteDoctors.observe(viewLifecycleOwner, Observer {
            adapter.setList(it)
        })
    }
}