package com.example.offlinetestapplication.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.offlinetestapplication.R
import com.example.offlinetestapplication.data.roomdb.ProfileEntity
import kotlinx.android.synthetic.main.profile_fragment.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class ProfileFragment : Fragment(), KodeinAware {

    override val kodein by kodein()
    private val factory: MyViewModelFactory by instance()

    private lateinit var viewModel: ListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.profile_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this,factory).get(ListViewModel::class.java)

        btSubmitProfile.setOnClickListener {

            if (!edPhoneNo.text.toString().isEmpty() && !edName.text.toString().isEmpty() && !edCity.text.toString().isEmpty() && !edState.text.toString().isEmpty() && !edPinCode.text.toString().isEmpty()) {
                var ProfileEntity = ProfileEntity(
                    edPhoneNo.text.toString(),
                    edName.text.toString(),
                    edCity.text.toString(),
                    edState.text.toString(),
                    edPinCode.text.toString().toInt()
                )
                viewModel.SaveNewProfile(ProfileEntity)
                findNavController().navigateUp()
            }
            else{
                Toast.makeText(context,"Please Enter all details",Toast.LENGTH_LONG).show()
            }
        }
    }

}