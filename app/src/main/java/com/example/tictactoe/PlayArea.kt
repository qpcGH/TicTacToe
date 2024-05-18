package com.example.tictactoe

import android.content.Intent
import android.os.Build.VERSION_CODES.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast



class PlayArea : AppCompatActivity() {
    private lateinit var reSet: Button
    private lateinit var goBack: Button
    private var temp: String = ""
    private lateinit var TurnDisp: TextView
    private lateinit var b1: TextView
    private lateinit var b2: TextView
    private lateinit var b3: TextView
    private lateinit var b4: TextView
    private lateinit var b5: TextView
    private lateinit var b6: TextView
    private lateinit var b7: TextView
    private lateinit var b8: TextView
    private lateinit var b9: TextView
    private var counter: Int = 1
    private var P1Sign: String = "X"
    private var P2Sign: String = "O"
    private var P1Score: Int = 0
    private var P2Score: Int = 0
    private var Draw: Int = 0
    private lateinit var p1ScoreView: TextView
    private lateinit var p2ScoreView: TextView
    private lateinit var drawView: TextView
    private  var p1Name: String=""
    private  var p2Name: String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_area)
        b1 = findViewById(R.id.box1)
        b2 = findViewById(R.id.box2)
        b3 = findViewById(R.id.box3)
        b4 = findViewById(R.id.box4)
        b5 = findViewById(R.id.box5)
        b6 = findViewById(R.id.box6)
        b7 = findViewById(R.id.box7)
        b8 = findViewById(R.id.box8)
        b9 = findViewById(R.id.box9)
        goBack= findViewById(R.id.back)
        TurnDisp = findViewById(R.id.TurnDisplay)
        p1ScoreView = findViewById(R.id.Player1Score)
        p2ScoreView = findViewById(R.id.Player2Score)
        reSet = findViewById(R.id.btnReset)
        drawView = findViewById(R.id.Draw)
        p1Name= getIntent().getStringExtra("n1").toString();
        p2Name= getIntent().getStringExtra("n2").toString();



        Scores()

        b1.setOnClickListener()
        {
            changeSign(b1)
        }
        b2.setOnClickListener()
        {
            changeSign(b2)
        }
        b3.setOnClickListener()
        {
            changeSign(b3)
        }
        b4.setOnClickListener()
        {
            changeSign(b4)
        }
        b5.setOnClickListener()
        {
            changeSign(b5)
        }
        b6.setOnClickListener()
        {
            changeSign(b6)
        }
        b7.setOnClickListener()
        {
            changeSign(b7)
        }
        b8.setOnClickListener()
        {
            changeSign(b8)
        }
        b9.setOnClickListener()
        {
            changeSign(b9)
        }
        reSet.setOnClickListener()
        {
            counter = 1;
            b1.text = " "
            b2.text = " "
            b3.text = " "
            b4.text = " "
            b5.text = " "
            b6.text = " "
            b7.text = " "
            b8.text = " "
            b9.text = " "


        }
        goBack.setOnClickListener()
        {
            var intentBack = Intent(this,MainActivity::class.java)
            startActivity(intentBack)

        }

    }

    fun changeSign(block: TextView) {
        if (counter <= 9) {
            if (block.text.toString() == " ")//place holder of grid
            {
                if (counter % 2 == 0)//Player 2's Turn
                {
                    TurnDisp.text = "${p1Name + "'s turn:"} $P1Sign"
                    block.text = P2Sign
                    counter++

                } else {

                    TurnDisp.text = "${p2Name + "'s turn:"} $P2Sign"
                    counter++
                    block.text = P1Sign
                }

                checkWin(block)

            } else {
                Toast.makeText(this, "Select any other block", Toast.LENGTH_SHORT).show()

            }
        }
        if (counter == 10) {
          if(counter < 80){
              Toast.makeText(this, "Game Draw", Toast.LENGTH_SHORT).show()
          }

            counter = 99
            Draw++
            Scores()
        }

    }

    fun checkWin(block: TextView) {
        forPlayer(P1Sign)
        forPlayer(P2Sign)


    }

    fun forPlayer(sign: String) {

        //123
        if (getString(b1) == sign && sign == getString(b2) && sign == getString(b3)) {
            if (sign == P1Sign) {
                //Toast.makeText(this, "Player 1 won", Toast.LENGTH_SHORT).show()
                P1Score++
                SendtoFragmnet(p1Name)
            } else {
                P2Score++
               // Toast.makeText(this, "Player 2 won", Toast.LENGTH_SHORT).show()
                SendtoFragmnet(p2Name)
            }
            counter = 99
            Scores()

        }
        //456
        else if (getString(b4) == sign && sign == getString(b5) && sign == getString(b6)) {
            if (sign == P1Sign) {
                P1Score++
                
                SendtoFragmnet(p1Name)
            } else {
                P2Score++
                 
                SendtoFragmnet(p2Name)
            }
            counter = 99
            Scores()
        }

        //789
        else if (getString(b7) == sign && sign == getString(b8) && sign == getString(b9)) {
            if (sign == P1Sign) {
                P1Score++
                
                SendtoFragmnet(p1Name)
            } else {
                P2Score++
                 
                SendtoFragmnet(p2Name)
            }
            counter = 99
            Scores()
        }

        //357
        else if (getString(b3) == sign && sign == getString(b5) && sign == getString(b7)) {
            if (sign == P1Sign) {
                P1Score++
                
                SendtoFragmnet(p1Name)

            } else {
                P2Score++
                 
                SendtoFragmnet(p2Name)
            }
            counter = 99
            Scores()
        }
        //159
        else if (getString(b1) == sign && sign == getString(b5) && sign == getString(b9)) {
            if (sign == P1Sign) {
                P1Score++
                
                SendtoFragmnet(p1Name)

            } else {
                P2Score++
                 
                SendtoFragmnet(p2Name)
            }
            counter = 99
            Scores()

        }

        //147
        else if (getString(b1) == sign && sign == getString(b4) && sign == getString(b7)) {
            if (sign == P1Sign) {
                P1Score++
                
                SendtoFragmnet(p1Name)

            } else {
                P2Score++
                 
                SendtoFragmnet(p2Name)
            }
            counter = 99
            Scores()

        }
        //369
        else if (getString(b3) == sign && sign == getString(b6) && sign == getString(b9)) {
            if (sign == P1Sign) {
                P1Score++
                
                SendtoFragmnet(p1Name)

            } else {
                P2Score++
                 
                SendtoFragmnet(p2Name)
            }
            counter = 99
            Scores()

        }
        //258
        else if (getString(b2) == sign && sign == getString(b5) && sign == getString(b8)) {
            if (sign == P1Sign) {
                P1Score++
                
                SendtoFragmnet(p1Name)

            } else {
                P2Score++
                //Toast.makeText(this, "Player 2 won", Toast.LENGTH_SHORT).show()
                SendtoFragmnet(p2Name)
            }
            counter = 99
            Scores()

        } else {

        }


    }

    fun getString(block: TextView): String {
        var str = ""
        str = block.text.toString();
        return str
    }

    fun Scores() {
        val p1PlaceHolder = p1Name
        val p2PlaceHolder = p2Name
        // p1ScoreView.text =  p1PlaceHolder.toString()  + P1Score
        // p2ScoreView.text =  p2PlaceHolder  + P2Score
        p1ScoreView.text = "${p1PlaceHolder + " "} $P1Score"
        p2ScoreView.text = "${p2PlaceHolder + " "} $P2Score"
        drawView.text = "${"Draws: "} $Draw"
    }
    fun SendtoFragmnet(name: String)
    {
        var dialog = PlayerWinPopUp()
        dialog.show(supportFragmentManager,"customDialog")
        //dialog.put
        var bundle = Bundle()
        bundle.putString("data", name)
        dialog.setArguments(bundle)
    }
//////// saving state
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("p1S", P1Score)
        outState.putInt("p2S", P2Score)
        outState.putString("p1N",p1Name)
        outState.putString("p2N",p2Name)
        outState.putInt("dr",Draw)

        super.onSaveInstanceState(outState)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        p1ScoreView.text = savedInstanceState.getString("p1S")
        P1Score=savedInstanceState.getInt("p1S")
        p2ScoreView.text = savedInstanceState.getString("p2S")
        P2Score=savedInstanceState.getInt("p2S")
        p1Name = savedInstanceState.getString("p1N").toString()
        p2Name = savedInstanceState.getString("p2N").toString()
        drawView.text = savedInstanceState.getString("dr")
        Draw=savedInstanceState.getInt("dr")

    }

}
