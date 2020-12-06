package hu.unideb.shoppinglist.pages.fragments.productlist

import android.os.Build
import android.text.Html
import android.text.Spanned
import androidx.core.text.HtmlCompat
import hu.unideb.shoppinglist.database.model.Product

fun formatProductList(products: List<Product>) : Spanned {
    val sb = StringBuilder()
    sb.apply {
        append("LISTA")
        products.forEach {
            append("<br>")
            append("Név:")
            append("\t${it.productName}<br>")
        }
    }

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
    } else {
        return HtmlCompat.fromHtml(sb.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}