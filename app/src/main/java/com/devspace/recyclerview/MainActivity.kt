package com.devspace.recyclerview

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvlist = findViewById<RecyclerView>(R.id.rv_list)
        val ivGrid = findViewById<ImageView>(R.id.iv_grid)
        val ivList = findViewById<ImageView>(R.id.iv_list)
        val adapter = ContactListAdapter()

        rvlist.adapter = adapter
        rvlist.layoutManager = LinearLayoutManager(this)
        adapter.submitList(contacts)

        ivGrid.setOnClickListener {
            rvlist.layoutManager = GridLayoutManager(this, 2)
        }

        ivList.setOnClickListener {
            rvlist.layoutManager = LinearLayoutManager(this)
        }

        adapter.setOnClickListener { contact ->
            val intent = Intent(this, ContactDetailActivity::class.java)
            intent.putExtra("name", contact.name)
            intent.putExtra("phone", contact.phone)
            intent.putExtra("icon", contact.icon)
            startActivity(intent)
        }

    }
}

val contacts = listOf(
    Contact(
        "Ana",
        "+55 (81) 98765-1234",
        R.drawable.sample1
    ),
    Contact(
        "Andre",
        "+55 (81) 96578-4309",
        R.drawable.sample2
    ),
    Contact(
        "Claudia",
        "+55 (81) 97786-0987",
        R.drawable.sample3
    ),
    Contact(
        "Daniela",
        "+55 (81) 98745-5432",
        R.drawable.sample4
    ),
    Contact(
        "Marcela",
        "+55 (81) 98885-7654",
        R.drawable.sample5
    ),
    Contact(
        "Julia",
        "+55 (81) 98995-1113",
        R.drawable.sample6
    ),
    Contact(
        "Gabriela",
        "+55 (81) 99965-0984",
        R.drawable.sample7
    ),
    Contact(
        "Enzo",
        "+55 (81) 99824-2424",
        R.drawable.sample8
    ),
    Contact(
        "Paulo",
        "+55 (81) 97779-0944",
        R.drawable.sample9
    ),
    Contact(
        "Marcio",
        "+55 (81) 98875-0276",
        R.drawable.sample10
    ),
    Contact(
        "Sheila",
        "+55 (81) 99987-5429",
        R.drawable.sample11
    ),
    Contact(
        "Hugo",
        "+55 (81) 98887-6543",
        R.drawable.sample12
    ),
    Contact(
        "Michele",
        "+55 (81) 999881-5432",
        R.drawable.sample13
    ),
    Contact(
        "Heitor",
        "+55 (81) 98761-0024",
        R.drawable.sample14
    ),
    Contact(
        "Luana",
        "+55 (81) 98951-8741",
        R.drawable.sample15
    ),
    Contact(
        "Joana",
        "+55 (81) 98987-6531",
        R.drawable.sample16
    )
)