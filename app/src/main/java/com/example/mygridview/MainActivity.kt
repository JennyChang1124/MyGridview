package com.example.mygridview

import android.content.Context
import android.content.Intent
import android.graphics.ColorSpace.Model
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import java.security.AccessControlContext
import java.text.ParsePosition
import java.util.jar.Attributes.Name
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var modalList=ArrayList<Modal>()
    var names=arrayOf(
        "image1",
        "image2",
        "image3",
        "image4"
    )
    var images = intArrayOf(R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        for (i in names.indices) {
            modalList.add(Modal(names[i], images[i]))
        }
        var CustomAdapter = CustomAdapter(modalList, this);

        gridView.adapter = CustomAdapter;

        gridView.setOnItemClickListener { adapterView, view, i, l ->
           var intent =Intent(this,ViewActivity::class.java)
            intent.putExtra("data",modalList[i])
            startActivity(intent);
        }
    }
    class CustomAdapter(
        var itemModel:ArrayList<Modal>,
        var context: Context
    ):BaseAdapter(){
        override fun getView(position: Int,view : View?, viewGroup:ViewGroup?): View {
            var view=view;
            if (view==null){
                view=layoutInflater.inflate(R.layout.row_items,viewGroup,false);
            }
            var tvImageName=view?.findViewById<TextView>(R.id.imageName)
            var ImageView=view?.findViewById<ImageView>(R.id.imageView)

            tvImageName?.text=itemModel[position].name;
            ImageView?.setImageResource(itemModel[position].image!!)
            return view!!
        }

        var layoutInflater =context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        override fun getCount(): Int {
            return itemModel.size
        }

        override fun getItem(p0: Int): Any {
           return itemModel[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }


    }
}