package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean isTurnYellow=true;

    /*2:- empty
      0:- Yellow
      1:- Red */
    //All Empty Innitially
    int state[]={2,2,2,2,2,2,2,2,2};
    int pos[][]={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridLayout layout=(GridLayout)findViewById(R.id.layout);
    }
    public void resetGame(View view){
//    ImageView img1 = (ImageView) findViewById(R.id.a);
//    ImageView img2 = (ImageView) findViewById(R.id.b);
//    ImageView img3 = (ImageView) findViewById(R.id.c);
//    ImageView img4 = (ImageView) findViewById(R.id.d);
//    ImageView img5 = (ImageView) findViewById(R.id.e);
//    ImageView img6 = (ImageView) findViewById(R.id.f);
//    ImageView img7 = (ImageView) findViewById(R.id.g);
//    ImageView img8 = (ImageView) findViewById(R.id.h);
//    ImageView img9 = (ImageView) findViewById(R.id.i);
//    img1.setTranslationY(-1500);
//    img2.setTranslationY(-1500);
//    img3.setTranslationY(-1500);
//    img4.setTranslationY(-1500);
//    img5.setTranslationY(-1500);
//    img6.setTranslationY(-1500);
//    img7.setTranslationY(-1500);
//    img8.setTranslationY(-1500);
//    img9.setTranslationY(-1500);
//
//    for(int i=0;i<9;i++){
//        state[i]=2;
//    }
//    TextView board = (TextView) findViewById(R.id.winnerPrint);
//    board.setText("");
//    board.setVisibility(View.INVISIBLE);
//
//
//    Button btn = (Button) findViewById((R.id.reload));
//    btn.setVisibility(View.INVISIBLE);
        this.recreate();

    }
    public void winnerCall(int index,int i,int j,int k){

        //i,j,k are winner indexes

        TextView winnerPrint=(TextView)findViewById((R.id.winnerPrint));
        if(index==0){
            //Yellow is winner
            winnerPrint.setText("Yellow is the winner");
        }
        else{
            //Red is winner
            winnerPrint.setText("Red is the winner");
        }
    ImageView img1 = (ImageView) findViewById(R.id.a);
    ImageView img2 = (ImageView) findViewById(R.id.b);
    ImageView img3 = (ImageView) findViewById(R.id.c);
    ImageView img4 = (ImageView) findViewById(R.id.d);
    ImageView img5 = (ImageView) findViewById(R.id.e);
    ImageView img6 = (ImageView) findViewById(R.id.f);
    ImageView img7 = (ImageView) findViewById(R.id.g);
    ImageView img8 = (ImageView) findViewById(R.id.h);
    ImageView img9 = (ImageView) findViewById(R.id.i);
        if(i==0 || j==0 || k==0){
            img1.setImageResource(R.drawable.winner);
        }if(i==1 || j==1 || k==1){
            img2.setImageResource(R.drawable.winner);
        }if(i==2 || j==2 || k==2){
            img3.setImageResource(R.drawable.winner);
        }if(i==3 || j==3 || k==3){
            img4.setImageResource(R.drawable.winner);
        }if(i==4 || j==4 || k==4){
            img5.setImageResource(R.drawable.winner);
        }if(i==5 || j==5 || k==5){
            img6.setImageResource(R.drawable.winner);
        }if(i==6 || j==6 || k==6){
            img7.setImageResource(R.drawable.winner);
        }if(i==7 || j==7 || k==7){
            img8.setImageResource(R.drawable.winner);
        }if(i==8 || j==8 || k==8){
            img9.setImageResource(R.drawable.winner);
        }

//        //Setting all states to filled now
//        for(int idx=0;idx<8;idx++){
//            state[idx]=0;
//        }
        Button btn=(Button)findViewById(R.id.reload);
        btn.setVisibility(View.VISIBLE);
    }
    public void checkWinner(int number){

        for(int i=0;i<8;i++) {
            boolean won=true;
            for (int j = 0; j < 3; j++) {
                if (state[pos[i][j]] != number) {
                    won = false;
                    break;
                }
            }
            if (won) {
                winnerCall(number,pos[i][0],pos[i][1],pos[i][2]);
            }
        }
    }
    public void matchTie(){
        Button btn=(Button)findViewById(R.id.reload);
        TextView txt=(TextView)findViewById(R.id.winnerPrint);
        txt.setText("Game is Tied");
        txt.setVisibility(View.VISIBLE);
        btn.setVisibility(View.VISIBLE);
    }
    public void fillIn(View view) {
//        Log.i("tag","clicked");
        //filling with images
        ImageView current = (ImageView) view;
        String tagHere = current.getTag().toString();
        int index = Integer.parseInt(tagHere);


        if(state[index]==2){
            //fill yellow
            if(isTurnYellow) {
                state[index]=0;
                current.setImageResource(R.drawable.yellow);
                isTurnYellow=!isTurnYellow;
                checkWinner(0);
            }
            else{
                state[index]=1;
                current.setImageResource(R.drawable.red);
                isTurnYellow=!isTurnYellow;
                checkWinner(1);
            }
            current.setTranslationY(-1500);
            current.animate().translationYBy(1500).alpha(1).setDuration(300);
            boolean canPlay=false;
            for(int i=0;i<9;i++){
                if(state[i]==2){
                    canPlay=true;
                }
            }
            if(!canPlay){
                matchTie();
            }
        }
        else{
            Toast.makeText(this,"Please Click on empty Spaces Only",Toast.LENGTH_SHORT).show();
        }

    }
}