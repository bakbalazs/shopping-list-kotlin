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

@BindingAdapter("productQuantity")
fun TextView.setProductQuantity(item: Product?) {
    item?.let {
        text = item.productQuantity.toString()
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

@BindingAdapter("productsNumber")
fun TextView.setProductsNumber(item:List<Product>?) {
    item?.let {
        text = item.size.toString()
    }
}

@BindingAdapter("purchasedProductsNumber")
fun TextView.setPurchasedProductsNumber(item:List<Product>?) {
    item?.let {
        text = item.size.toString()
    }
}

