package br.dev.hygino.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import br.dev.hygino.databinding.ItemBookBinding
import br.dev.hygino.entity.BookEntity
import br.dev.hygino.ui.viewholder.BookViewHolder


class BookAdapter : Adapter<BookViewHolder>() {
    private var bookList : List<BookEntity> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookViewHolder(view)
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(bookList[position])
    }

    fun updateBooks(list:List<BookEntity>){
        bookList=list
    }
}