package com.example.affirmations.adapter

import android.app.Application
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.R
import com.example.affirmations.databinding.ListItemBinding
import com.example.affirmations.model.Affirmation
import java.util.zip.Inflater

class ItemAdapter(private  val context: Context, private val dataset: List<Affirmation>):
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {


    class ItemViewHolder(private val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root){
        val itemTitle: TextView = binding.itemTitle
        val itemImage: ImageView = binding.itemImage
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        return ItemViewHolder(
            ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )


    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val affirmation = dataset[position]
        holder.itemTitle.text = context.resources.getString(affirmation.stringResourceId)
        holder.itemImage.setImageResource(affirmation.imageResourceId)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

}