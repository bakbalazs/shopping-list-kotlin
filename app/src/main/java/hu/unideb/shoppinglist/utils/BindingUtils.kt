package hu.unideb.shoppinglist.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import hu.unideb.shoppinglist.database.model.Product

@BindingAdapter("productName")
fun TextView.setProductName(item: Product?) {
    item?.let {
        text = item.productName
    }
}

@BindingAdapter("productPiece")
fun TextView.setProductPiece(item: Product?) {
    item?.let {
        text = item.productPiece.toString()
    }
}

@BindingAdapter("shopName")
fun TextView.setShopName(item: Product?) {
    item?.let {
        text = item.shopName
    }
}

@BindingAdapter("addDate")
fun TextView.setProductAddDate(item: Product?) {
    item?.let {
        text = item.addDate
    }
}

@BindingAdapter("purchaseDate")
fun TextView.setPurchaseDate(item: Product?) {
    item?.let {
        text = item.purchaseDate
    }
}

