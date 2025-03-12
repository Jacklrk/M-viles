package com.example.ejercicio2


import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejercicio2.BookAdapter
import com.example.ejercicio2.databinding.ActivityMainBinding
import com.example.ejercicio2.Book
import com.example.ejercicio2.BookResponse
import com.example.ejercicio2.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var bookAdapter: BookAdapter
    private var bookList: MutableList<Book> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        bookAdapter = BookAdapter(bookList) { book ->
            // Acción al seleccionar un libro
        }
        binding.recyclerView.adapter = bookAdapter

        fetchBooks("android") // Cargar libros por defecto
    }

    private fun fetchBooks(query: String) {
        RetrofitClient.instance.searchBooks(query).enqueue(object : Callback<BookResponse> {
            override fun onResponse(call: Call<BookResponse>, response: Response<BookResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    bookList.clear()
                    bookList.addAll(response.body()?.docs ?: emptyList())
                    bookAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<BookResponse>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        val searchItem: MenuItem? = menu?.findItem(R.id.action_search)
        val searchView = searchItem?.actionView as? SearchView

        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { fetchBooks(it) }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })

        return true
    }
}
