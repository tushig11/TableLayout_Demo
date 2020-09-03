package com.example.tablayout

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){
        val table = findViewById<TableLayout>(R.id.dataTable)
        val row = createStaticRow(TableRow(this), "5.0 - 5.1.1", "Lolipop", )
        val row2 = createStaticRow(TableRow(this), "4.4 - 4.4.4", "KitKat", )
        table.addView(row)
        table.addView(row2)
    }

    private fun createStaticRow(row: TableRow, version:String, name:String): TableRow{
        row.layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT)
        val col1 = designRow(TextView(this), name)
        val col2 = designRow(TextView(this), version)
        row.addView(col1)
        row.addView(col2)
        return row
    }

    private fun designRow(textView: TextView, data: String): TextView{
        var layout = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT,1.0f)
        layout.setMargins(0,10,0,0)
        textView.layoutParams = (layout)
        textView.setPadding(10,10,10,10)
        textView.setTypeface(textView.typeface, Typeface.ITALIC);
        textView.textSize = 15F
        textView.text = data
        textView.setBackgroundColor(Color.parseColor("#ff4d9d"))
        return textView
    }

    fun addRow(view: View){
        if(TextUtils.isEmpty(versionInput.text) || TextUtils.isEmpty(nameInput.text)) {
            Toast.makeText(this, "Please enter either version and name", Toast.LENGTH_LONG).show()
        }else{
            val table = findViewById<TableLayout>(R.id.dataTable)
            val newRow = createStaticRow(TableRow(this), versionInput.text.toString(), nameInput.text.toString())
            table.addView(newRow)
        }
    }
}