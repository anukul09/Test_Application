package com.example.offlinetestapplication.data.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.offlinetestapplication.MvvmApplication
import com.example.offlinetestapplication.R
import com.example.offlinetestapplication.data.roomdb.ProfileEntity

class ProfilesAdapter(var cProfileList: ArrayList<ProfileEntity>?) : RecyclerView.Adapter<ProfilesAdapter.Viewholder>(){

    override fun getItemCount(): Int {
        return cProfileList!!.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_profile, parent, false)
        return Viewholder(v)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {

        holder.profileName.text = cProfileList!![position].name
        holder.profilePinCode.text = cProfileList!![position].pinCode.toString()
        holder.profileLocationCity.text = cProfileList!![position].city
        holder.profileLocationState.text = cProfileList!![position].state

        holder.profileCall.setOnClickListener {
            dialContactPhone(cProfileList!![position].phoneNo)
        }
    }

    class Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profileName = itemView.findViewById<TextView>(R.id.tvFullName)
        val profilePinCode = itemView.findViewById<TextView>(R.id.tvPinCode)
        val profileLocationCity = itemView.findViewById<TextView>(R.id.tvCity)
        val profileLocationState = itemView.findViewById<TextView>(R.id.tvState)
        val profileCall = itemView.findViewById<ImageView>(R.id.ivCall)
    }

    private fun dialContactPhone(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:" + phoneNumber)
        MvvmApplication.context.startActivity(intent)
    }
}