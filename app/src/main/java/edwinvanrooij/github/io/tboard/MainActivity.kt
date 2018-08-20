package edwinvanrooij.github.io.tboard

import android.media.MediaPlayer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class MainActivity : AppCompatActivity() {
  private lateinit var recyclerView: RecyclerView
  private lateinit var viewAdapter: RecyclerView.Adapter<*>
  private lateinit var viewManager: RecyclerView.LayoutManager

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    MediaPlayer.create(this, R.raw.slurp)
        .start()
    val itemArray: Array<Item> = arrayOf(
        Item("Slurp", "Use in case of thirst", R.raw.slurp),
        Item("Robot", "Use in case of matrix", R.raw.robot),
        Item("Slurp 2", "Use in case of more thirst", R.raw.slurp2),
        Item("Tuinslang", "Use in case of lawn drought", R.raw.tuinslang),
        Item("Ziplinen", "Use in case of feeling zippy", R.raw.ziplinen),
        Item("Bhfff", "Idk man", R.raw.bhfff),
        Item("Arr", "Use in case of piratey", R.raw.arr),
        Item("Moby", "Use in case of chasing whales(/duck mascots)", R.raw.moby),
        Item("Pvvvwvvv", "Use in case of meer / minder marrokanen", R.raw.pvvvwvvv)
    )

    viewManager = LinearLayoutManager(this)
    viewAdapter = MyAdapter(itemArray)

    recyclerView = findViewById<RecyclerView>(R.id.my_recycler_view).apply {
      // use this setting to improve performance if you know that changes
      // in content do not change the layout size of the RecyclerView
      setHasFixedSize(true)

      // use a linear layout manager
      layoutManager = viewManager

      // specify an viewAdapter (see also next example)
      adapter = viewAdapter

    }
  }
}
