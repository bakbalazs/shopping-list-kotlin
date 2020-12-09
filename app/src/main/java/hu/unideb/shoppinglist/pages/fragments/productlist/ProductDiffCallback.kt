package hu.unideb.shoppinglist.pages.fragments.productlist

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

class ProductDiffCallback : DiffUtil.ItemCallback<ProductDataItem>() {
    override fun areItemsTheSame(oldItem: ProductDataItem, newItem: ProductDataItem): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: ProductDataItem, newItem: ProductDataItem): Boolean {
        return oldItem == newItem
    }
}