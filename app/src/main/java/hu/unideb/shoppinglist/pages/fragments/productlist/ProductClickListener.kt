package hu.unideb.shoppinglist.pages.fragments.productlist

import hu.unideb.shoppinglist.database.model.Product

class ProductClickListener(val clickListener: (productId: Long) -> Unit) {
    fun onClick(product: Product) = clickListener(product.id)
}