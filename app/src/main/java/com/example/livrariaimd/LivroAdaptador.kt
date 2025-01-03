import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.livrariaimd.Livro
import com.example.livrariaimd.R

class LivroAdaptador(
    private val livros: List<Livro>,
    private val aoClicarLivro: (Livro) -> Unit
) : RecyclerView.Adapter<LivroAdaptador.LivroViewHolder>() {

    class LivroViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val capa: ImageView = view.findViewById(R.id.iv_capa_livro)
        val titulo: TextView = view.findViewById(R.id.tv_titulo_livro)
        val editora: TextView = view.findViewById(R.id.tv_editora_livro)
        val autor: TextView = view.findViewById(R.id.tv_autor_livro)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LivroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_livro, parent, false)
        return LivroViewHolder(view)
    }

    override fun onBindViewHolder(holder: LivroViewHolder, position: Int) {
        val livro = livros[position]
        holder.titulo.text = livro.titulo
        holder.editora.text = "Editora: ${livro.editora}"
        holder.autor.text = "Autor: ${livro.autor}"

        // Carregar imagem da URL
        Glide.with(holder.itemView.context).load(livro.urlCapa).into(holder.capa)

        // Configurar clique no item
        holder.itemView.setOnClickListener {
            aoClicarLivro(livro)
        }
    }

    override fun getItemCount(): Int = livros.size
}
