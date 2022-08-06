package com.example.nailfood.Adaptor

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nailfood.Activity.ShowDetailActivity
import com.example.nailfood.Domain.FoodDomain
import com.example.nailfood.R


class PopularAdaptor(private val popularList: List<FoodDomain>) :
    RecyclerView.Adapter<PopularAdaptor.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.titleFood)
        val fee: TextView = itemView.findViewById(R.id.fee)
        val pic: ImageView = itemView.findViewById(R.id.pic)
        val addBtn: TextView = itemView.findViewById(R.id.addBtn)
//        val mainLayout: ConstraintLayout = itemView.findViewById(R.id.mainLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate =
            LayoutInflater.from(parent.context).inflate(R.layout.viewholder_popular, parent, false)

        return ViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = popularList[position].title
        holder.fee.text = popularList[position].fee.toString()

        val drawableResourceId = holder.itemView.context.resources.getIdentifier(
            popularList[position].pic,
            "drawable",
            holder.itemView.context.packageName
        )

        Glide.with(holder.itemView.context).load(drawableResourceId).into(holder.pic)

        holder.addBtn.setOnClickListener {
            val intent = Intent(holder.itemView.context, ShowDetailActivity::class.java)
            intent.putExtra("object", popularList[position])
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return popularList.size
    }
}