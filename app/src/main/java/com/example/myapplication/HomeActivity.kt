package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.navigation.NavigationView
import java.lang.Math.abs


class HomeActivity : AppCompatActivity() {

    private lateinit var mDrawerLayout: DrawerLayout
    private lateinit var viewPager2: ViewPager2
    val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        var toolbarText: TextView? = null
        var ivCart: ImageView? = null
        var menu: ImageView? = null

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        ivCart = findViewById(R.id.ivCart)
        toolbarText = findViewById(R.id.toolbarText)
        viewPager2 = findViewById(R.id.viewpagerImageSlider)

        ivCart.visibility = View.VISIBLE

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val model: ArrayList<HomeModel> = ArrayList<HomeModel>()
        model.add(HomeModel(R.drawable.dresses, "Dresses"))
        model.add(HomeModel(R.drawable.watch, "Women Watches"))
        model.add(HomeModel(R.drawable.womensbags, "Bags"))
        model.add(HomeModel(R.drawable.menswatch, "Men Watches"))
        model.add(HomeModel(R.drawable.tshirts, "T-Shirts"))

        val adapter = HomeAdapter(model)
        recyclerView.adapter = adapter

        val sliderImageModel: ArrayList<SliderModel> = ArrayList<SliderModel>()
        sliderImageModel.add(SliderModel(R.drawable.blackonepiecedress,"Black Dress"))
        sliderImageModel.add(SliderModel(R.drawable.pinkdresses1,"Pink Dress"))
        sliderImageModel.add(SliderModel(R.drawable.white,"White Dress"))
        sliderImageModel.add(SliderModel(R.drawable.reddress,"Red Dress"))
        sliderImageModel.add(SliderModel(R.drawable.yellowdress,"Yellow Dress"))
        sliderImageModel.add(SliderModel(R.drawable.greendress,"Green Long Dress"))
        val sliderAdapter = SliderAdapter(sliderImageModel, viewPager2)
        viewPager2.adapter = sliderAdapter
        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.offscreenPageLimit = 2
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(30))
        compositePageTransformer.addTransformer(ViewPager2.PageTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = (0.50f + r * 0.20f)
        })
        viewPager2.setPageTransformer(compositePageTransformer)
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable,3000)
            }

        })

        val watchRecyclerView = findViewById<RecyclerView>(R.id.rvWomenWatches)
        val watchSliderModel: ArrayList<WatchSliderModel> = ArrayList<WatchSliderModel>()

        watchSliderModel.add(WatchSliderModel(R.drawable.watch2, "NGunmetal Watch","1400"))
        watchSliderModel.add(WatchSliderModel(R.drawable.watch3, "Rose Gold Watches","2000"))
        watchSliderModel.add(WatchSliderModel(R.drawable.watch5, "Black Color Forest Watch","1179"))
        watchSliderModel.add(WatchSliderModel(R.drawable.menswatch, "Light Blue Silver Tone Watch","2067"))

        val watchAdapter = WatchAdapter(watchSliderModel)
        val layoutManager = GridLayoutManager(this, 2)
        watchRecyclerView.layoutManager = layoutManager
        watchRecyclerView.adapter = watchAdapter

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setTitle("Online Shopping")
        val actionbar: ActionBar? = supportActionBar
        actionbar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24)
        }

        mDrawerLayout = findViewById(R.id.my_drawer_layout)

        val navigationView: NavigationView = findViewById(R.id.nav_view)

        navigationView.setNavigationItemSelectedListener { menuItem ->
            // set item as selected to persist highlight
            menuItem.isChecked = true
            // close drawer when item is tapped
            mDrawerLayout.closeDrawers()

            // Handle navigation view item clicks here.
            when (menuItem.itemId) {

                R.id.nav_home -> {
                    val intent = Intent(this,HomeActivity::class.java)
                    startActivity(intent)
                }
                R.id.nav_shop -> {
                    Toast.makeText(this, "Wallet", Toast.LENGTH_LONG).show()
                }
                R.id.nav_search -> {
                    Toast.makeText(this, "Offer", Toast.LENGTH_LONG).show()
                }
                R.id.nav_cart -> {
                    Toast.makeText(this, "Setting", Toast.LENGTH_LONG).show()
                }
                R.id.nav_account -> {
                    Toast.makeText(this, "Setting", Toast.LENGTH_LONG).show()
                }
            }
            // Add code here to update the UI based on the item selected
            // For example, swap UI fragments here

            true
        }
    }

    //appbar - toolbar button click
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                mDrawerLayout.openDrawer(GravityCompat.START)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    var runnable:Runnable = Runnable {
        viewPager2.setCurrentItem(viewPager2.currentItem+1)
    }


    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(runnable,3000)
    }

}