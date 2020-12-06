package hu.unideb.shoppinglist.pages.fragments.productlist

import hu.unideb.shoppinglist.database.model.Product

sealed class ProductDataItem {
    data class ProductItem(val product: Product): ProductDataItem() {
        override val id = product.id
    }

    object Header: ProductDataItem() {
        override val id = Long.MIN_VALUE
    }

    abstract val id: Long
}
