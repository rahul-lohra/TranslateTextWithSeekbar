package com.rahul.seekbarwithtext

import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var seekBarWidth = 0
        appCompatSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

                if (seekBar != null) {
                    if(seekBarWidth == 0)
                        seekBarWidth = seekBar.width - seekBar.paddingLeft - seekBar.paddingRight
                    val displacement = seekBarWidth * (seekBar.progress/seekBar.max.toFloat())
                    print("onProgressChanged sw = $seekBarWidth, dis = $displacement, p = ${seekBar.progress}, max = ${seekBar.max} , m = ${(seekBar.progress/seekBar.max).toFloat()}")
                    textView.translationX = displacement
                }

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                print("onStartTrackingTouch ${seekBar?.x}")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                print("onStopTrackingTouch ${seekBar?.x}")
            }
        })
    }

    fun print(msg: String) {
        Log.wtf("SEEK", msg)
    }
}
