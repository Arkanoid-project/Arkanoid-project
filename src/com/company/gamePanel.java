package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.Timer;
import java.util.TimerTask;

public class gamePanel extends JPanel implements Runnable{
    final int GameWidth=800;
    final int GameHeight=600;
    final int menuindex = 0;
    final int gameindex = 1;
    final int settingsindex=2;
    public int live_index = 0;
    int lives = 3;
    int liveScore=0;
    //power up
    boolean powerup_here=false;
    powerup []P=new powerup[15];
    powerup recentP;
    int num_of_powerups=0;
    int secondsPassed=0;
    Image standard_img;
    boolean dlaser=false;
    powerup [] l=new powerup[8];
    Image backButton ;
    Image prv_Button1 ;
    Image prv_Button2 ;
    Image nxt_Button1 ;
    Image nxt_Button2 ;
    Image bignxt_Button ;
    Image bigprv_Button ;
    Timer Pwrtimer=new Timer();


    Menu gameMenu;
    Image backg;
    Image settingsBG;
    Image[] healthImage;
    Paddle paddle;
    Ball ball;
    Thread GameThread;
    boolean isInversed = false;
    Dimension gameSize;

    Level lvl1;
    levels[] selectedLvl;

    int[][] settingsBtns_positions = {
            {60,50}, // back button postion
            {180, 280}, // prv button 1 postion Lel ball
            {180, 480}, // prv button 2 postion  lel ball
            {530, 280},  // nxt button 1 postion
            {530,480}   // nxt button 2 postion
    };
    boolean []entered_settings_btns={false,false,false,false,false};

    gamePanel(){
        gameMenu = new Menu(live_index);
    //set panel size
        gameSize = new Dimension(GameWidth,GameHeight);
        this.setPreferredSize(gameSize);

        settingsBG =  new ImageIcon("settingsBG.jpg").getImage();
        // set back & next buttons
        backButton = new ImageIcon("back_Button.png").getImage();
        prv_Button1 = new ImageIcon("prv_Button1.png").getImage() ;
        prv_Button2 = new ImageIcon("prv_Button2.png").getImage();
        nxt_Button1 =  new ImageIcon("next_Button2.png").getImage() ;
        nxt_Button2 =  new ImageIcon("next_Button3.png").getImage();
        bignxt_Button =  new ImageIcon("big_next_Button2.png").getImage();
        bigprv_Button =  new ImageIcon("big_back_Button.png").getImage();


     //Game Background set
     backg = new ImageIcon("background1.jpg").getImage();

     healthImage = new Image[3];
     for(int i=0;i<lives;i++)
         healthImage[i]= new ImageIcon("Health.png").getImage();

    //set ball nad paddle
     paddle = new Paddle(GameWidth,GameHeight);
     ball = new Ball(0,paddle,live_index);
     standard_img=paddle.getPaddleImage();

        //create new levels
     selectedLvl = new levels[6];
       for(int i=0;i<6;i++) {
           selectedLvl[i] = new levels();
       }
       setInitialLevelsSeq();
       //set start level
       lvl1 = new Level(selectedLvl[Level.current_lvl]);

        GameThread=new Thread(this);
        GameThread.start();
    }

//Game draw
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if (live_index == menuindex) {
            gameMenu.draw(g2d);
            live_index = gameMenu.live_index;
            ball.setIndex(live_index);
        } else if(live_index == gameindex){
            g2d.drawImage(backg, 0, 0, null);
            for (int i = 0; i < lives; i++)
                g2d.drawImage(healthImage[i], 10 + (healthImage[i].getWidth(null) * i), 560, null);
            g2d.setColor(Color.white);
            g2d.setFont(new Font("serif", Font.BOLD, 25));
            g2d.drawString("Your Score: " + liveScore, 600, 580);
            paddle.draw(g2d);
            lvl1.draw(g2d);
            ball.draw(g2d);
            if(powerup_here){
              for (int i=0;i<num_of_powerups;i++) {
                    P[i].draw(g);
              }
            }
            if (dlaser){
                for (int i=0;i<powerup.lnum;i++){
                l[i].draw(g);
                }
            }

        }
        else if(live_index==settingsindex){

            g.drawImage(settingsBG, 0,0, null);

            g.drawImage(backButton,settingsBtns_positions[0][0],settingsBtns_positions[0][1],null);
            g.drawImage(prv_Button1,settingsBtns_positions[1][0], settingsBtns_positions[1][1],null);
            g.drawImage(prv_Button2,settingsBtns_positions[2][0], settingsBtns_positions[2][1],null);
            g.drawImage(nxt_Button1,settingsBtns_positions[3][0], settingsBtns_positions[3][1],null);
            g.drawImage(nxt_Button2,settingsBtns_positions[4][0], settingsBtns_positions[4][1],null);

            if(entered_settings_btns[0])
            {
                g.drawImage(bigprv_Button,settingsBtns_positions[0][0],settingsBtns_positions[0][1],null);
            }
            else if (entered_settings_btns[1])
            {
                g.drawImage(bigprv_Button,settingsBtns_positions[1][0], settingsBtns_positions[1][1],null);
            }
            else if(entered_settings_btns[2])
            {
                g.drawImage(bigprv_Button,settingsBtns_positions[2][0], settingsBtns_positions[2][1],null);
            }
            else if(entered_settings_btns[3])
            {
                g.drawImage(bignxt_Button,settingsBtns_positions[3][0], settingsBtns_positions[3][1],null);
            }
            else if(entered_settings_btns[4])
            {
                g.drawImage(bignxt_Button,settingsBtns_positions[4][0], settingsBtns_positions[4][1],null);
            }
            settings s = new settings();
        }
    }

    public void move(){
       isInversed = ball.move(isInversed);
        paddle.move();
    }

    public void checkCollision() {
        //paddle with window borders
        if (paddle.paddle_xp <= 0) {
            paddle.paddle_xp = 0;
        }
        if (paddle.paddle_xp >= GameWidth - paddle.paddleImage.getWidth(null)) {
            paddle.paddle_xp = GameWidth - paddle.paddleImage.getWidth(null);
        }
        //Death check
        if (ball.ball_yp > GameHeight) {
            if (lives > 0) {
                lives--;
                ball.ball_speed = 0;
                ball.ball_xv = -1;
                ball.ball_yv = -1;
                paddle.setPaddleInitialPosition(GameWidth, GameHeight);
                ball.setBallInitialPos(paddle);
                ball.setIndex(live_index);
            }
        }
        //paddle with ball check
        Rectangle paddleCollider = new Rectangle(paddle.paddle_xp, paddle.paddle_yp, paddle.paddleImage.getWidth(null), paddle.paddleImage.getHeight(null));
        Rectangle ballCollider = new Rectangle(ball.ball_xp, ball.ball_yp, ball.ballImage[0].getWidth(null), ball.ballImage[0].getHeight(null));
        if (paddleCollider.intersects(ballCollider)) {

            if(ballCollider.getX()<=paddleCollider.getX()+paddle.paddleImage.getWidth(null)/3) {
                if (ball.ball_xv >= 0 && !isInversed) {
                    ball.ball_xv = -1;
                    ball.ball_yv = -1;
                    isInversed = true;
                } else {
                    if(! isInversed) {
                        ball.ball_yv = -1;
                        isInversed = true;
                    }
                }
            }
            else if(ballCollider.getX()>paddleCollider.getX()+paddle.paddleImage.getWidth(null)/3 &&
                    ballCollider.getX()<paddleCollider.getX()+paddle.paddleImage.getWidth(null)*2/3 && ball.ball_speed != 0){
                if(!isInversed) {
                    ball.ball_yv = -1;
                    ball.ball_xv = 0;
                    isInversed = true;
                }
            }
            else if(ballCollider.getX()>=paddleCollider.getX()+paddle.paddleImage.getWidth(null)*2/3){
                if(ball.ball_xv <=0 && !isInversed) {
                    ball.ball_xv = 1;
                    ball.ball_yv = -1;
                    isInversed = true;
                }

                else {
                    if (!isInversed) {
                        ball.ball_yv = -1;
                        isInversed = true;
                    }
                }
            }
        }
    //ball with blocks

            A:for(int i =0;i<lvl1.currentLvlBlock.length;i++) {
                for (int j =0;j<lvl1.currentLvlBlock[i].length;j++) {
                    Rectangle blockCollider = new Rectangle(lvl1.currentLvlBlock[i][j].px,lvl1.currentLvlBlock[i][j].py,lvl1.currentLvlBlock[i][j].getBlockWidth(),lvl1.currentLvlBlock[i][j].getBlockHeight());
                    if(ballCollider.intersects(blockCollider)) {
                        recentP = new powerup(lvl1.currentLvlBlock[i][j]);
                        if(lvl1.currentLvlBlock[i][j].has_powerup){
                            P[num_of_powerups] = new powerup(lvl1.currentLvlBlock[i][j]);
                            powerup_here=true;
                            num_of_powerups++;
                        }
                        isInversed = false;
                        liveScore += 5;
                        lvl1.currentLvlBlock[i][j].setBlockShape(0);
                        selectedLvl[Level.current_lvl].lvl[i][j] = 0;
                        if((ballCollider.x + ballCollider.getWidth()-2 <= blockCollider.getX()
                            || ballCollider.x+2 >= blockCollider.getX()+blockCollider.getWidth())){
                            ball.ball_xv *= -1;
                        }else{
                            ball.ball_yv *= -1;
                            break A;
                        }
                    }

                 }
            }
        for(int i =0;i<num_of_powerups;i++) {
            if(P[i].Px+P[i].width<=paddleCollider.x+paddleCollider.width&&P[i].Px>=paddleCollider.x){
                if(P[i].Py+P[i].height>=paddleCollider.y&&P[i].Py<=600){
                    P[i].Py=900;
                    System.out.println("collide");
                    switch (P[i].power_index){
                        case 0 :
                            //paddle width power up
                            secondsPassed =0;
                            Pwrtimer.scheduleAtFixedRate(new TimerTask() {
                                @Override
                                public void run() {
                                    secondsPassed++;
                                    System.out.println("seconds "+secondsPassed);
                                }
                            }, 1000, 1000);
                            paddle.paddleImage = new ImageIcon("Paddleplusplus.png").getImage();
                            System.out.println("paddle plus plus");
                            //done
                            break;
                        case 1 :
                            //laser power up
                            dlaser=true;
                            l[powerup.lnum]=new powerup(paddle);
                            System.out.println("laser");
                            //waiting for the intersection tba
                            break;
                        case 2 :
                            //speedy ball power up
                            ball.ball_speed+=1;
                            System.out.println("speed up");
                            //done
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + P[i].power_index);
                    }
                }
            }
        }
        if (secondsPassed>6) {
            paddle.paddleImage =standard_img;
            secondsPassed=0;

        }
        for(int i =0;i<lvl1.currentLvlBlock.length;i++) {
            for (int j = 0; j < lvl1.currentLvlBlock[i].length; j++) {
                Rectangle blockCollider = new Rectangle(lvl1.currentLvlBlock[i][j].px, lvl1.currentLvlBlock[i][j].py, lvl1.currentLvlBlock[i][j].getBlockWidth(), lvl1.currentLvlBlock[i][j].getBlockHeight());

                if (dlaser) {
                    for (int m = 0; m < powerup.lnum; m++) {
                        if (l[m].intersects(blockCollider)) {
                            System.out.println("blockcollider");
                        }
                    }
                }
            }
        }
    }

    public void setInitialLevelsSeq() {
        int[][] Tarr = {
                {1,0,1,0,0,1,0,1},
                {1,0,1,0,0,1,0,1},
                {0,2,0,0,0,0,2,0},
                {0,2,0,0,0,0,2,0},
                {1,0,1,0,0,1,0,1},
                {1,0,1,0,0,1,0,1},
                {1,0,1,0,0,1,0,1},
                {0,0,0,0,0,0,0,0}
        };
for(int i=0;i<8;i++){
    System.arraycopy(Tarr[i], 0, selectedLvl[0].lvl[i], 0, 8);
}
    }
    // game loop
    public void run(){
        //Game Loop
        long lastTime = System.nanoTime();
        double amountOfTicks= 60.0;
        double ns = 1000000000/amountOfTicks;
        double delta =0;
        while (true) {
            long now =System.nanoTime();
            delta +=(now-lastTime)/ns;
            lastTime=now;
            if(delta>=1){
            move();
            checkCollision();
            repaint();
                delta--;
            }
        }

    }

    public class  ActionL extends KeyAdapter {
        public void keyPressed(KeyEvent e){
        paddle.getBallStatus(ball.isBallLaunched);
            paddle.keyPressed(e);

        }
        public void keyReleased(KeyEvent e){
paddle.keyReleased(e);
        }
    }
}

class settings extends gamePanel implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getX() < backButton.getWidth(null) + 60 && e.getX() > 60) {
            if (e.getY() < backButton.getHeight(null) + 70 && e.getY() > 50) {
                System.out.println("Back Button");
                live_index = 0;
            }
        }

        if (e.getX() < prv_Button1.getWidth(null) + 366 && e.getX() > 366) {
            if (e.getY() < prv_Button1.getHeight(null) + 481 && e.getY() > 451) {
                System.out.println("Prv ball");
            }
        }
        if (e.getX() < nxt_Button1.getWidth(null) + 666 && e.getX() > 666) {
            if (e.getY() < nxt_Button1.getHeight(null) + 270 && e.getY() > 240) {
                System.out.println("next ball");
            }
        }
        if (e.getX() < prv_Button2.getWidth(null) + 666 && e.getX() > 666) {
            if (e.getY() < prv_Button2.getHeight(null) + 143 && e.getY() > 113) {
                System.out.println("prv paddle");
            }


        }
        if (e.getX() < nxt_Button2.getWidth(null) + 666 && e.getX() > 666) {
            if (e.getY() < nxt_Button2.getHeight(null) + 390 && e.getY() > 370) {
                System.out.println("next paddle");
            }
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}