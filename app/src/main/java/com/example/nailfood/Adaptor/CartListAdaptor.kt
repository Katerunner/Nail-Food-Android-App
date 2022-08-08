package com.example.nailfood.Adaptor

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nailfood.Activity.ShowDetailActivity
import com.example.nailfood.Domain.FoodDomain
import com.example.nailfood.Helper.ManagmentCart
import com.example.nailfood.Interface.ChangeNumberItemsListener
import com.example.nailfood.R
import kotlin.math.roundToInt

class CartListAdaptor(
    private val foodDomains: ArrayList<FoodDomain>,
    private val context: Context,
    private val changeNumberItemsListener: ChangeNumberItemsListener
) :
    RecyclerView.Adapter<CartListAdaptor.ViewHolder>() {

    private val managementCart: ManagmentCart = ManagmentCart(context)

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.titleCartTxt)
        val feeEachItem: TextView = itemView.findViewById(R.id.feeEachItem)
        val pic: ImageView = itemView.findViewById(R.id.picCart)
        val totalEachItem: TextView = itemView.findViewById(R.id.totalEachItem)
        val num: TextView = itemView.findViewById(R.id.numberItemTxt)
        val plusBtn: ImageView = itemView.findViewById(R.id.plusCartBtn)
        val minusBtn: ImageView = itemView.findViewById(R.id.minusCartBtn)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate =
            LayoutInflater.from(parent.context).inflate(R.layout.viewholder_cart, parent, false)

        return ViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = foodDomains[position].title
        holder.feeEachItem.text = foodDomains[position].fee.toString()
        holder.totalEachItem.text =
            ((foodDomains[position].numberInCart!! * foodDomains[position].fee * 100) / 100).roundToInt()
                .toString()
        holder.num.text = foodDomains[position].numberInCart.toString()

        val drawableResourseId = holder.itemView.context.resources.getIdentifier(
            foodDomains[position].pic,
            "drawable",
            holder.itemView.context.packageName
        )

        Glide.with(holder.itemView.context).load(drawableResourseId).into(holder.pic)

        holder.plusBtn.setOnClickListener {
            managementCart.plusNumberFood(foodDomains, position,
                object : ChangeNumberItemsListener {
                    override fun changed() {
                        notifyDataSetChanged()
                        changeNumberItemsListener.changed()
                    }
                })
        }

        holder.minusBtn.setOnClickListener {
            managementCart.minusNumberFood(foodDomains, position,
                object : ChangeNumberItemsListener {
                    override fun changed() {
                        notifyDataSetChanged()
                        changeNumberItemsListener.changed()
                    }
                })
        }
    }

    override fun getItemCount(): Int {
        return foodDomains.size
    }
}