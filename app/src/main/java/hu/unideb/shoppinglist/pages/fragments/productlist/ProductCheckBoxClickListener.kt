package hu.unideb.shoppinglist.pages.fragments.productlist

import hu.unideb.shoppinglist.database.model.Product

class ProductCheckBoxClickListener(val clickListener: (product: Product) -> Unit) {
    fun onClick(product: Product) = clickListener(product)
}