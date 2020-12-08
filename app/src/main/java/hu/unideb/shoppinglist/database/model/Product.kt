package hu.unideb.shoppinglist.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "product")
data class Product(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0L,

    @ColumnInfo(name = "product_name")
    val productName: String,

//    @ColumnInfo(name = "product_piece")
//    val productPiece: Number,
//
//    @ColumnInfo(name = "shop_name")
//    val shopName: String,
//
//    @ColumnInfo(name = "add_date")
//    val addDate:Date,
//
//    @ColumnInfo(name = "purchase_date")
//    val purchaseDate: Date

)