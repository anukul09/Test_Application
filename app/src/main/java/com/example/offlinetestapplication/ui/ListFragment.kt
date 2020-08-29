package com.example.offlinetestapplication.ui

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.offlinetestapplication.MvvmApplication
import com.example.offlinetestapplication.R
import com.example.offlinetestapplication.data.adapter.ProfilesAdapter
import com.example.offlinetestapplication.data.roomdb.ProfileEntity
import kotlinx.android.synthetic.main.list_fragment.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class ListFragment : Fragment(), KodeinAware {

    override val kodein by kodein()
    private val factory: MyViewModelFactory by instance()

    private lateinit var viewModel: ListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_fragment, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this,factory).get(ListViewModel::class.java)

        viewModel.getAllProfiles()

        viewModel.mProfilesReponse.observe(viewLifecycleOwner, Observer {

            rvDisplayProfiles.apply {
                layoutManager = GridLayoutManager(activity,2)
                var cProfilesList = it as ArrayList<ProfileEntity>
                var adapter = ProfilesAdapter(cProfilesList)
                rvDisplayProfiles.adapter = adapter
            }
        })

        m_cAddBtn.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment3_to_profileFragment)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.optionmenu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when(id){
            R.id.action_name -> viewModel.getProfilesByName()
            R.id.action_sort_Phone -> viewModel.getProfilesByPhoneNo()
        }
        return super.onOptionsItemSelected(item)
    }


}