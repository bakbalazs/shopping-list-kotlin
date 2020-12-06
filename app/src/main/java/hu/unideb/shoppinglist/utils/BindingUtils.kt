package hu.unideb.shoppinglist.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import hu.unideb.shoppinglist.database.model.Product

@BindingAdapter("productString")
fun TextView.setProductString(item: Product?) {
    item?.let {
        text = item.productName
    }
}