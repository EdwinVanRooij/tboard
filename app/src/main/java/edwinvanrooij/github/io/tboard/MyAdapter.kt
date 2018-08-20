package edwinvanrooij.github.io.tboard

import android.media.MediaPlayer
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MyAdapter(private val myDataset: Array<Item>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

  // Provide a reference to the views for each data item
  // Complex data items may need more than one view per item, and
  // you provide access to all the views for a data item in a view holder.
  // Each data item is just a string in this case that is shown in a TextView.
  class ViewHolder(val item: CardView) : RecyclerView.ViewHolder(item)

  // Create new views (invoked by the layout manager)
  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): MyAdapter.ViewHolder {

    val item =
      LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false) as CardView

    // set the view's size, margins, paddings and layout parameters

    return ViewHolder(item)
  }

  // Replace the contents of a view (invoked by the layout manager)
  override fun onBindViewHolder(
    holder: ViewHolder,
    position: Int
  ) {
    // - get element from your dataset at this position
    // - replace the contents of the view with that element
    val item: Item = myDataset[position]

    val linearLayout: LinearLayout = holder.item.findViewById(R.id.linearLayout)
    val linearLayoutNested: LinearLayout = linearLayout.findViewById(R.id.linearLayoutNested)

    linearLayoutNested.findViewById<TextView>(R.id.textViewTitle)
        .text = item.title
    linearLayoutNested.findViewById<TextView>(R.id.textViewDescription)
        .text = item.description

    linearLayout.findViewById<Button>(R.id.playSound)
        .setOnClickListener {
          MediaPlayer.create(linearLayout.context, item.soundId).start()
        }
  }

  // Return the size of your dataset (invoked by the layout manager)
  override fun getItemCount() = myDataset.size
}
