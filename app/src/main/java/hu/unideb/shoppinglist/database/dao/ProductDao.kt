package hu.unideb.shoppinglist.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import hu.unideb.shoppinglist.database.model.Product

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(product: Product)

    @Update
    suspend fun update(product: Product)

    @Query("SELECT * FROM product")
    fun getAllProducts(): LiveData<List<Product>>

    @Query("SELECT * FROM product where user_id = :userId order by id DESC")
    fun getAllProductsByUserId(userId: String): LiveData<List<Product>>

    @Query("SELECT * from product where id = :id")
    fun getProductWithId(id: Long): LiveData<Product>

//    @Query("SELECT * FROM product where user_id = :userId AND purchased = 'true' ")
//    suspend fun getPurchasedProduct(userId: String)
}