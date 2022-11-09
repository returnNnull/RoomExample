package com.bam.roomexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.room.Room
import com.bam.roomexample.databinding.FragmentUserListBinding
import com.bam.roomexample.room.DbConnection
import com.bam.roomexample.room.UserRepository

class UserListFragment : Fragment() {

    private lateinit var binding: FragmentUserListBinding;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserListBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db = Room.databaseBuilder(requireContext(), DbConnection::class.java, "db").build()
        val repository = UserRepository(db)
        val adapter = UserListAdapter()

        repository.users.observe(viewLifecycleOwner) {
            adapter.updateList(it)
        }

        binding.userListRecyclerView.adapter = adapter


    }


}