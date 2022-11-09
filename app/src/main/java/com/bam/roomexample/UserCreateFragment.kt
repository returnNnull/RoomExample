package com.bam.roomexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.room.Room
import com.bam.roomexample.databinding.FragmentUserCreateBinding
import com.bam.roomexample.room.DbConnection
import com.bam.roomexample.room.User
import com.bam.roomexample.room.UserRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UserCreateFragment : Fragment() {

    private lateinit var binding: FragmentUserCreateBinding;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentUserCreateBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.button.setOnClickListener {
            var login = binding.editTextTextPersonName.text.toString()
            var pass = binding.editTextTextPassword.text.toString()

            val db = Room.databaseBuilder(requireContext(), DbConnection::class.java, "db").build()
            val repository = UserRepository(db)
            GlobalScope.launch {
                repository.insert(User(login, pass))
            }

            Navigation.findNavController(it).navigate(R.id.action_userCreateFragment_to_userListFragment)
        }

    }

}