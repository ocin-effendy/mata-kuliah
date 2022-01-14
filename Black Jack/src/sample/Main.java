package sample;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.net.*;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Ananda Rizaldy Aristyo, Muhammad Lutfi Syukran, Nico Ardia Effendy
 * @version 1.0
 * @since June 2021
 */

class IPConn {

    String checkIp(){
        try {
            InetAddress address = InetAddress.getLocalHost();
            return address.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return "NO CONNECTION";
        }
    }
}

class Animation {

    TranslateTransition tlt = new TranslateTransition();
    public void setAniY1(ImageView viewImage,double fromY, double fromX, double toY ){
        tlt = new TranslateTransition();
        tlt.setNode(viewImage);
        tlt.setDuration(Duration.millis(350));
        tlt.setFromY(fromY);
        tlt.setFromX(fromX);
        tlt.setByY(toY);
        tlt.play();
    }
    public void setAniY(ImageView viewImage,double fromY, double fromX, double toY ){
        tlt = new TranslateTransition();
        tlt.setNode(viewImage);
        tlt.setDuration(Duration.millis(350));
        tlt.setFromY(fromY);
        tlt.setFromX(fromX);
        tlt.setByY(toY);
        tlt.play();
    }
    public void setAniX(ImageView viewImage,double fromY, double fromX, double toX ){
        tlt = new TranslateTransition();
        tlt.setNode(viewImage);
        tlt.setDuration(Duration.millis(350));
        tlt.setFromY(fromY);
        tlt.setFromX(fromX);
        tlt.setByX(toX);
        tlt.play();
    }
    public void setAniHit(ImageView viewImage,double fromY, double fromX, double toY ){
        tlt = new TranslateTransition();
        tlt.setNode(viewImage);
        tlt.setDuration(Duration.millis(250));
        tlt.setFromY(fromY);
        tlt.setFromX(fromX);
        tlt.setByY(toY);
        tlt.play();
    }
}
class BackSound {
    MediaPlayer mediaPlayer;
    Media media;
    String backSound;
    public void startSong(){
        backSound = "soundEffect/backBj.wav";
        media = new Media(Paths.get(backSound).toUri().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }
    public void stopSong(){
        mediaPlayer.stop();
    }
}
class SoundEffect {

    boolean start = true;
    Clip clip;
    public void setFile(String soundFile){
        try{
            if (start){
                File file = new File(soundFile);
                AudioInputStream sound = AudioSystem.getAudioInputStream(file);
                clip = AudioSystem.getClip();
                clip.open(sound);
                clip.start();
            }else{
                clip.stop();
            }
        }catch (Exception e){
            System.err.println("File Not Founded");
        }
    }
}

class Rand {
    /**
     * Simply randomize an integer that has been limited between 1-52 only
     * @return integer that has been randomized
     */
    int theNumber() {
        Random rand = new Random();
        Decide decide = new Decide();
        int localCardVal = rand.nextInt(53 - 1) + 1;
        boolean numberBanned=true;
        while (numberBanned){
            switch (localCardVal){
                //Cloves 1-13
                case 1 -> {
                    if (decide.getClove1()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                case 2 -> {
                    if (decide.getClove2()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                case 3 -> {
                    if (decide.getClove3()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                case 4 -> {
                    if (decide.getClove4()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                case 5 -> {
                    if (decide.getClove5()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                case 6 -> {
                    if (decide.getClove6()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                case 7 -> {
                    if (decide.getClove7()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                case 8 -> {
                    if (decide.getClove8()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                case 9 -> {
                    if (decide.getClove9()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                case 10 -> {
                    if (decide.getClove10()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                case 11 -> {
                    if (decide.getClove11()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                case 12 -> {
                    if (decide.getClove12()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }case 13 -> {
                    if (decide.getClove13()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                //Hearts 14-26
                case 14 -> {
                    if (decide.getHeart1()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                case 15 -> {
                    if (decide.getHeart2()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                case 16 -> {
                    if (decide.getHeart3()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                case 17 -> {
                    if (decide.getHeart4()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                case 18 -> {
                    if (decide.getHeart5()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                case 19 -> {
                    if (decide.getHeart6()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                case 20 -> {
                    if (decide.getHeart7()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                case 21 -> {
                    if (decide.getHeart8()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                case 22 -> {
                    if (decide.getHeart9()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                case 23 -> {
                    if (decide.getHeart10()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                case 24 -> {
                    if (decide.getHeart11()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                case 25 -> {
                    if (decide.getHeart12()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }case 26 -> {
                    if (decide.getHeart13()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                //Spade 27-39
                case 27 -> {
                    if (decide.getSpade1()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                case 28 -> {
                    if (decide.getSpade2()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                case 29 -> {
                    if (decide.getSpade3()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                case 30 -> {
                    if (decide.getSpade4()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                case 31 -> {
                    if (decide.getSpade5()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                case 32 -> {
                    if (decide.getSpade6()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                case 33 -> {
                    if (decide.getSpade7()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                case 34 -> {
                    if (decide.getSpade8()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                case 35 -> {
                    if (decide.getSpade9()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                case 36 -> {
                    if (decide.getSpade10()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                case 37 -> {
                    if (decide.getSpade11()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                case 38 -> {
                    if (decide.getSpade12()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }case 39 -> {
                    if (decide.getSpade13()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                //Tiles 40-52
                case 40 -> {
                    if (decide.getTile1()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                case 41 -> {
                    if (decide.getTile2()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                case 42 -> {
                    if (decide.getTile3()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                case 43 -> {
                    if (decide.getTile4()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                case 44 -> {
                    if (decide.getTile5()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                case 45 -> {
                    if (decide.getTile6()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                case 46 -> {
                    if (decide.getTile7()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                case 47 -> {
                    if (decide.getTile8()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                case 48 -> {
                    if (decide.getTile9()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                case 49 -> {
                    if (decide.getTile10()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                case 50 -> {
                    if (decide.getTile11()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
                case 51 -> {
                    if (decide.getTile12()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }case 52 -> {
                    if (decide.getTile13()==2){
                        localCardVal = rand.nextInt(53 - 1) + 1;
                    }else numberBanned=false;
                }
            }
        }
        return localCardVal;
    }
}

class Decide {

    //Animation Instance
    Animation ani = new Animation();

    //Hit Normalizer
    int andNormalize(int hitVal){
        switch (hitVal) {
            case 14, 27, 40 -> hitVal = 1;
            case 15, 28, 41 -> hitVal = 2;
            case 16, 29, 42 -> hitVal = 3;
            case 17, 30, 43 -> hitVal = 4;
            case 18, 31, 44 -> hitVal = 5;
            case 19, 32, 45 -> hitVal = 6;
            case 20, 33, 46 -> hitVal = 7;
            case 21, 34, 47 -> hitVal = 8;
            case 22, 35, 48 -> hitVal = 9;
            case 23, 36, 49 -> hitVal = 10;
            case 24, 37, 50 -> hitVal = 11;
            case 25, 38, 51 -> hitVal = 12;
            case 26, 39, 52 -> hitVal = 13;
        }
        return hitVal;
    }

    //SetterGetters
    public int getT0() {
        return t0;
    }
    public int getT1() {
        return t1;
    }
    public int getT2() {
        return t2;
    }
    public void setT0(int t0) {
        this.t0 = t0;
    }
    public void setT1(int t1) {
        this.t1 = t1;
    }
    public void setT2(int t2) {
        this.t2 = t2;
    }
    public int getBjLimit() {
        return bjLimit;
    }
    public void setBjLimit(int bjLimit) {
        this.bjLimit = bjLimit;
    }
    int t0,t1,t2,bjLimit;
    int clove1,clove2,clove3,clove4,clove5,clove6,clove7,clove8,clove9,clove10,clove11,clove12,clove13;
    int heart1,heart2,heart3,heart4,heart5,heart6,heart7,heart8,heart9,heart10,heart11,heart12,heart13;
    int spade1,spade2,spade3,spade4,spade5,spade6,spade7,spade8,spade9,spade10,spade11,spade12,spade13;
    int tile1,tile2,tile3,tile4,tile5,tile6,tile7,tile8,tile9,tile10,tile11,tile12,tile13;
    public int getClove1() {
        return clove1;
    }
    public void setClove1(int clove1) {
        this.clove1 = clove1;
    }
    public int getClove2() {
        return clove2;
    }
    public void setClove2(int clove2) {
        this.clove2 = clove2;
    }
    public int getClove3() {
        return clove3;
    }
    public void setClove3(int clove3) {
        this.clove3 = clove3;
    }
    public int getClove4() {
        return clove4;
    }
    public void setClove4(int clove4) {
        this.clove4 = clove4;
    }
    public int getClove5() {
        return clove5;
    }
    public void setClove5(int clove5) {
        this.clove5 = clove5;
    }
    public int getClove6() {
        return clove6;
    }
    public void setClove6(int clove6) {
        this.clove6 = clove6;
    }
    public int getClove7() {
        return clove7;
    }
    public void setClove7(int clove7) {
        this.clove7 = clove7;
    }
    public int getClove8() {
        return clove8;
    }
    public void setClove8(int clove8) {
        this.clove8 = clove8;
    }
    public int getClove9() {
        return clove9;
    }
    public void setClove9(int clove9) {
        this.clove9 = clove9;
    }
    public int getClove10() {
        return clove10;
    }
    public void setClove10(int clove10) {
        this.clove10 = clove10;
    }
    public int getClove11() {
        return clove11;
    }
    public void setClove11(int clove11) {
        this.clove11 = clove11;
    }
    public int getClove12() {
        return clove12;
    }
    public void setClove12(int clove12) {
        this.clove12 = clove12;
    }
    public int getClove13() {
        return clove13;
    }
    public void setClove13(int clove13) {
        this.clove13 = clove13;
    }
    public int getHeart1() {
        return heart1;
    }
    public void setHeart1(int heart1) {
        this.heart1 = heart1;
    }
    public int getHeart2() {
        return heart2;
    }
    public void setHeart2(int heart2) {
        this.heart2 = heart2;
    }
    public int getHeart3() {
        return heart3;
    }
    public void setHeart3(int heart3) {
        this.heart3 = heart3;
    }
    public int getHeart4() {
        return heart4;
    }
    public void setHeart4(int heart4) {
        this.heart4 = heart4;
    }
    public int getHeart5() {
        return heart5;
    }
    public void setHeart5(int heart5) {
        this.heart5 = heart5;
    }
    public int getHeart6() {
        return heart6;
    }
    public void setHeart6(int heart6) {
        this.heart6 = heart6;
    }
    public int getHeart7() {
        return heart7;
    }
    public void setHeart7(int heart7) {
        this.heart7 = heart7;
    }
    public int getHeart8() {
        return heart8;
    }
    public void setHeart8(int heart8) {
        this.heart8 = heart8;
    }
    public int getHeart9() {
        return heart9;
    }
    public void setHeart9(int heart9) {
        this.heart9 = heart9;
    }
    public int getHeart10() {
        return heart10;
    }
    public void setHeart10(int heart10) {
        this.heart10 = heart10;
    }
    public int getHeart11() {
        return heart11;
    }
    public void setHeart11(int heart11) {
        this.heart11 = heart11;
    }
    public int getHeart12() {
        return heart12;
    }
    public void setHeart12(int heart12) {
        this.heart12 = heart12;
    }
    public int getHeart13() {
        return heart13;
    }
    public void setHeart13(int heart13) {
        this.heart13 = heart13;
    }
    public int getSpade1() {
        return spade1;
    }
    public void setSpade1(int spade1) {
        this.spade1 = spade1;
    }
    public int getSpade2() {
        return spade2;
    }
    public void setSpade2(int spade2) {
        this.spade2 = spade2;
    }
    public int getSpade3() {
        return spade3;
    }
    public void setSpade3(int spade3) {
        this.spade3 = spade3;
    }
    public int getSpade4() {
        return spade4;
    }
    public void setSpade4(int spade4) {
        this.spade4 = spade4;
    }
    public int getSpade5() {
        return spade5;
    }
    public void setSpade5(int spade5) {
        this.spade5 = spade5;
    }
    public int getSpade6() {
        return spade6;
    }
    public void setSpade6(int spade6) {
        this.spade6 = spade6;
    }
    public int getSpade7() {
        return spade7;
    }
    public void setSpade7(int spade7) {
        this.spade7 = spade7;
    }
    public int getSpade8() {
        return spade8;
    }
    public void setSpade8(int spade8) {
        this.spade8 = spade8;
    }
    public int getSpade9() {
        return spade9;
    }
    public void setSpade9(int spade9) {
        this.spade9 = spade9;
    }
    public int getSpade10() {
        return spade10;
    }
    public void setSpade10(int spade10) {
        this.spade10 = spade10;
    }
    public int getSpade11() {
        return spade11;
    }
    public void setSpade11(int spade11) {
        this.spade11 = spade11;
    }
    public int getSpade12() {
        return spade12;
    }
    public void setSpade12(int spade12) {
        this.spade12 = spade12;
    }
    public int getSpade13() {
        return spade13;
    }
    public void setSpade13(int spade13) {
        this.spade13 = spade13;
    }
    public int getTile1() {
        return tile1;
    }
    public void setTile1(int tile1) {
        this.tile1 = tile1;
    }
    public int getTile2() {
        return tile2;
    }
    public void setTile2(int tile2) {
        this.tile2 = tile2;
    }
    public int getTile3() {
        return tile3;
    }
    public void setTile3(int tile3) {
        this.tile3 = tile3;
    }
    public int getTile4() {
        return tile4;
    }
    public void setTile4(int tile4) {
        this.tile4 = tile4;
    }
    public int getTile5() {
        return tile5;
    }
    public void setTile5(int tile5) {
        this.tile5 = tile5;
    }
    public int getTile6() {
        return tile6;
    }
    public void setTile6(int tile6) {
        this.tile6 = tile6;
    }
    public int getTile7() {
        return tile7;
    }
    public void setTile7(int tile7) {
        this.tile7 = tile7;
    }
    public int getTile8() {
        return tile8;
    }
    public void setTile8(int tile8) {
        this.tile8 = tile8;
    }
    public int getTile9() {
        return tile9;
    }
    public void setTile9(int tile9) {
        this.tile9 = tile9;
    }
    public int getTile10() {
        return tile10;
    }
    public void setTile10(int tile10) {
        this.tile10 = tile10;
    }
    public int getTile11() {
        return tile11;
    }
    public void setTile11(int tile11) {
        this.tile11 = tile11;
    }
    public int getTile12() {
        return tile12;
    }
    public void setTile12(int tile12) {
        this.tile12 = tile12;
    }
    public int getTile13() {
        return tile13;
    }
    public void setTile13(int tile13) {
        this.tile13 = tile13;
    }

    /**
     * Exchange the randomized card value into their corresponding card image
     * @param cardVal randomized card value
     * @return card file name in String
     */
    String theCard(int cardVal) {
        String fileName=null;
        switch (cardVal){
            //cloves
            case 1 -> {
                fileName = "File:cardDeck/cloves_ace.png";
                setClove1(getClove1()+1);
            }
            case 2 -> {
                fileName = "File:cardDeck/cloves_two.png";
                setClove2(getClove2()+1);
            }
            case 3 -> {
                fileName = "File:cardDeck/cloves_three.png";
                setClove3(getClove3()+1);
            }
            case 4 -> {
                fileName = "File:cardDeck/cloves_four.png";
                setClove4(getClove4()+1);
            }
            case 5 -> {
                fileName = "File:cardDeck/cloves_five.png";
                setClove5(getClove5()+1);
            }
            case 6 -> {
                fileName = "File:cardDeck/cloves_six.png";
                setClove6(getClove6()+1);
            }
            case 7 -> {
                fileName = "File:cardDeck/cloves_seven.png";
                setClove7(getClove7()+1);
            }
            case 8 -> {
                fileName = "File:cardDeck/cloves_eight.png";
                setClove8(getClove8()+1);
            }
            case 9 -> {
                fileName = "File:cardDeck/cloves_nine.png";
                setClove9(getClove9()+1);
            }
            case 10 -> {
                fileName = "File:cardDeck/cloves_ten.png";
                setClove10(getClove10()+1);
            }
            case 11 -> {
                fileName = "File:cardDeck/cloves_jack.png";
                setClove11(getClove11()+1);
            }
            case 12 -> {
                fileName = "File:cardDeck/cloves_queen.png";
                setClove12(getClove12()+1);
            }
            case 13 -> {
                fileName = "File:cardDeck/cloves_king.png";
                setClove13(getClove13()+1);
            }
            //hearts
            case 14 -> {
                fileName = "File:cardDeck/heart_ace.png";
                setHeart1(getHeart1()+1);
            }
            case 15 -> {
                fileName = "File:cardDeck/heart_two.png";
                setHeart2(getHeart2()+1);
            }
            case 16 -> {
                fileName = "File:cardDeck/heart_three.png";
                setHeart3(getHeart3()+1);
            }
            case 17 -> {
                fileName = "File:cardDeck/heart_four.png";
                setHeart4(getHeart4()+1);
            }
            case 18 -> {
                fileName = "File:cardDeck/heart_five.png";
                setHeart5(getHeart5()+1);
            }
            case 19 -> {
                fileName = "File:cardDeck/heart_six.png";
                setHeart6(getHeart6()+1);
            }
            case 20 -> {
                fileName = "File:cardDeck/heart_seven.png";
                setHeart7(getHeart7()+1);
            }
            case 21 -> {
                fileName = "File:cardDeck/heart_eight.png";
                setHeart8(getHeart8()+1);
            }
            case 22 -> {
                fileName = "File:cardDeck/heart_nine.png";
                setHeart9(getHeart9()+1);
            }
            case 23 -> {
                fileName = "File:cardDeck/heart_ten.png";
                setHeart10(getHeart10()+1);
            }
            case 24 -> {
                fileName = "File:cardDeck/heart_jack.png";
                setHeart11(getHeart11()+1);
            }
            case 25 -> {
                fileName = "File:cardDeck/heart_queen.png";
                setHeart12(getHeart12()+1);
            }
            case 26 -> {
                fileName = "File:cardDeck/heart_king.png";
                setHeart13(getHeart13()+1);
            }
            //spade
            case 27 -> {
                fileName = "File:cardDeck/spade_ace.png";
                setSpade1(getSpade1()+1);
            }
            case 28 -> {
                fileName = "File:cardDeck/spade_two.png";
                setSpade2(getSpade2()+1);
            }
            case 29 -> {
                fileName = "File:cardDeck/spade_three.png";
                setSpade3(getSpade3()+1);
            }
            case 30 -> {
                fileName = "File:cardDeck/spade_four.png";
                setSpade4(getSpade4()+1);
            }
            case 31 -> {
                fileName = "File:cardDeck/spade_five.png";
                setSpade5(getSpade5()+1);
            }
            case 32 -> {
                fileName = "File:cardDeck/spade_six.png";
                setSpade6(getSpade6()+1);
            }
            case 33 -> {
                fileName = "File:cardDeck/spade_seven.png";
                setSpade7(getSpade7()+1);
            }
            case 34 -> {
                fileName = "File:cardDeck/spade_eight.png";
                setSpade8(getSpade8()+1);
            }
            case 35 -> {
                fileName = "File:cardDeck/spade_nine.png";
                setSpade9(getSpade9()+1);
            }
            case 36 -> {
                fileName = "File:cardDeck/spade_ten.png";
                setSpade10(getSpade10()+1);
            }
            case 37 -> {
                fileName = "File:cardDeck/spade_jack.png";
                setSpade11(getSpade11()+1);
            }
            case 38 -> {
                fileName = "File:cardDeck/spade_queen.png";
                setSpade12(getSpade12()+1);
            }
            case 39 -> {
                fileName = "File:cardDeck/spade_king.png";
                setSpade13(getSpade13()+1);
            }
            //tile
            case 40 -> {
                fileName = "File:cardDeck/tile_ace.png";
                setTile1(getTile1()+1);
            }
            case 41 -> {
                fileName = "File:cardDeck/tile_two.png";
                setTile2(getTile2()+1);
            }
            case 42 -> {
                fileName = "File:cardDeck/tile_three.png";
                setTile3(getTile3()+1);
            }
            case 43 -> {
                fileName = "File:cardDeck/tile_four.png";
                setTile4(getTile4()+1);
            }
            case 44 -> {
                fileName = "File:cardDeck/tile_five.png";
                setTile5(getTile5()+1);
            }
            case 45 -> {
                fileName = "File:cardDeck/tile_six.png";
                setTile6(getTile6()+1);
            }
            case 46 -> {
                fileName = "File:cardDeck/tile_seven.png";
                setTile7(getTile7()+1);
            }
            case 47 -> {
                fileName = "File:cardDeck/tile_eight.png";
                setTile8(getTile8()+1);
            }
            case 48 -> {
                fileName = "File:cardDeck/tile_nine.png";
                setTile9(getTile9()+1);
            }
            case 49 -> {
                fileName = "File:cardDeck/tile_ten.png";
                setTile10(getTile10()+1);
            }
            case 50 -> {
                fileName = "File:cardDeck/tile_jack.png";
                setTile11(getTile11()+1);
            }
            case 51 -> {
                fileName = "File:cardDeck/tile_queen.png";
                setTile12(getTile12()+1);
            }
            case 52 -> {
                fileName = "File:cardDeck/tile_king.png";
                setTile13(getTile13()+1);
            }
            default -> System.exit(-1000);
        }
        return fileName;
    }

    /**
     * Decides 3 initial cards
     * @param decide          External method reference for deciding card
     * @param stackReference  exernal stackPane reference
     * @param stackReference2 exernal stackPane reference 2
     * @param cardVal1        randomized card value
     * @param cardVal2        randomized card value 2
     * @param cardVal3        randomized card value 3
     */
    void defaultCard(Decide decide, StackPane stackReference, StackPane stackReference2, int cardVal1, int cardVal2, int cardVal3, int yAxis, int addX, int addY, boolean lanStat) {
        Image kartu = new Image(decide.theCard(cardVal1));
        Image kartu2 = new Image(decide.theCard(cardVal2));
        Image kartu3 = new Image(decide.theCard(cardVal3));
        ImageView viewIp1 = new ImageView(kartu);
        ImageView viewIp2 = new ImageView(kartu2);
        ImageView viewIp3 = new ImageView(kartu3);

        if (!lanStat){
            ani.setAniX(viewIp1, 0, -100, 350);
            ani.setAniY(viewIp2, -350, 330, 350);
            ani.setAniY1(viewIp3, 350, 410, -350);
        }else {
            viewIp1.setTranslateX(290+addX);
            viewIp2.setTranslateX(370+addX);
            viewIp3.setTranslateX(450+addX);
            viewIp1.setTranslateY(addY);
            viewIp2.setTranslateY(addY);
            viewIp3.setTranslateY(addY);
        }
        stackReference.getChildren().addAll(viewIp1, viewIp2, viewIp3);

        viewIp1 = new ImageView(kartu);
        viewIp2 = new ImageView(kartu2);
        viewIp3 = new ImageView(kartu3);

        viewIp1.setTranslateX(250+addX);
        viewIp1.setTranslateY(yAxis+addY);
        viewIp2.setTranslateX(300+addX);
        viewIp2.setTranslateY(yAxis+addY);
        viewIp3.setTranslateX(350+addX);
        viewIp3.setTranslateY(yAxis+addY);
        stackReference2.getChildren().addAll(viewIp1, viewIp2, viewIp3);
    }

    /**
     * shares the three initial cards,
     * fetches decided card from defaultCard method
     * @param randomize method instance to access a method that randomize the card value
     * @param decide Decide class instance
     * @param stackReference  exernal stackPane reference
     * @param stackReference2 exernal stackPane reference 2
     * @param hidden "bandar" player identifier
     * @param yAxis setTranslateY reference
     * @return sum of cards value
     */
    int threeCards(Rand randomize, Decide decide, StackPane stackReference, StackPane stackReference2, boolean bandar, boolean hidden, int yAxis, int addX, int addY, boolean lanStat) {
        int card1 = randomize.theNumber();
        int card2 = randomize.theNumber();
        int card3 = randomize.theNumber();
        int minPix;
        if (bandar) minPix = -100;
        else minPix = 0;
        if (hidden) {
            Image kartu = new Image("File:cardDeck/back.png");
            Image kartu2 = new Image("File:cardDeck/back.png");
            Image kartu3 = new Image("File:cardDeck/back.png");
            ImageView viewIp1 = new ImageView(kartu);
            ImageView viewIp2 = new ImageView(kartu2);
            ImageView viewIp3 = new ImageView(kartu3);
            viewIp1.setTranslateX(290+addX);
            viewIp2.setTranslateX(370+addX);
            viewIp3.setTranslateX(450+addX);
            System.out.println("minPix: "+minPix);
            viewIp1.setTranslateY(minPix+addY);
            viewIp2.setTranslateY(minPix+addY);
            viewIp3.setTranslateY(minPix+addY);
            stackReference.getChildren().addAll(viewIp1, viewIp2, viewIp3);

            kartu = new Image(decide.theCard(card1));
            kartu2 = new Image(decide.theCard(card2));
            kartu3 = new Image(decide.theCard(card3));
            viewIp1 = new ImageView(kartu);
            viewIp2 = new ImageView(kartu2);
            viewIp3 = new ImageView(kartu3);
            viewIp1.setTranslateX(250);
            viewIp1.setTranslateY(yAxis-addY);
            viewIp2.setTranslateX(300);
            viewIp2.setTranslateY(yAxis-addY);
            viewIp3.setTranslateX(350);
            viewIp3.setTranslateY(yAxis-addY);
            stackReference2.getChildren().addAll(viewIp1, viewIp2, viewIp3);

        } else decide.defaultCard(decide, stackReference, stackReference2, card1, card2, card3, yAxis, addX, addY, lanStat);
        switch (card1) {
            case 14, 27, 40 -> card1 = 1;
            case 15, 28, 41 -> card1 = 2;
            case 16, 29, 42 -> card1 = 3;
            case 17, 30, 43 -> card1 = 4;
            case 18, 31, 44 -> card1 = 5;
            case 19, 32, 45 -> card1 = 6;
            case 20, 33, 46 -> card1 = 7;
            case 21, 34, 47 -> card1 = 8;
            case 22, 35, 48 -> card1 = 9;
            case 23, 36, 49 -> card1 = 10;
            case 24, 37, 50 -> card1 = 11;
            case 25, 38, 51 -> card1 = 12;
            case 26, 39, 52 -> card1 = 13;
        }
        switch (card2) {
            case 14, 27, 40 -> card2 = 1;
            case 15, 28, 41 -> card2 = 2;
            case 16, 29, 42 -> card2 = 3;
            case 17, 30, 43 -> card2 = 4;
            case 18, 31, 44 -> card2 = 5;
            case 19, 32, 45 -> card2 = 6;
            case 20, 33, 46 -> card2 = 7;
            case 21, 34, 47 -> card2 = 8;
            case 22, 35, 48 -> card2 = 9;
            case 23, 36, 49 -> card2 = 10;
            case 24, 37, 50 -> card2 = 11;
            case 25, 38, 51 -> card2 = 12;
            case 26, 39, 52 -> card2 = 13;
        }
        switch (card3) {
            case 14, 27, 40 -> card3 = 1;
            case 15, 28, 41 -> card3 = 2;
            case 16, 29, 42 -> card3 = 3;
            case 17, 30, 43 -> card3 = 4;
            case 18, 31, 44 -> card3 = 5;
            case 19, 32, 45 -> card3 = 6;
            case 20, 33, 46 -> card3 = 7;
            case 21, 34, 47 -> card3 = 8;
            case 22, 35, 48 -> card3 = 9;
            case 23, 36, 49 -> card3 = 10;
            case 24, 37, 50 -> card3 = 11;
            case 25, 38, 51 -> card3 = 12;
            case 26, 39, 52 -> card3 = 13;
        }
        return (card1 + card2 + card3);
    }

}

public class Main extends Application {

    int positionP1, positionP2, positionB0;
    int positionP1A, positionP2A;
    SoundEffect se = new SoundEffect();
    BackSound bs = new BackSound();
    Animation ani1 = new Animation();
    String path;

    //dgs&dgp
    public DatagramSocket dgssend;
    public DatagramSocket dgsrece;
    public DatagramPacket dgp1;
    public DatagramPacket dgp2;
    public String message1;
    public String message2;
    public InetAddress ip;
    public int port;

    void sendData(Decide decide, int hitVal, String ipTf, String portTf){
        //other player's screen
        try{
            dgssend = new DatagramSocket();
            dgp1 = null; dgp2 = null;
            message1 = null; message2 = null;
            try {
                message1 = decide.getT1() + " " + decide.theCard(hitVal) ;
                ip = InetAddress.getByName(ipTf);
                port = Integer.parseInt(portTf);
                dgp1 = new DatagramPacket(message1.getBytes(), message1.getBytes().length, ip, port);
                dgssend.send(dgp1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }catch (SocketException socketException){
            socketException.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage){
        bs.startSong();

        //Pane Akhir
        StackPane stAkhir = new StackPane();
        stAkhir.setAlignment(Pos.TOP_LEFT);
        Scene sceneAkhir = new Scene(stAkhir, 1137, 670);

        Rand randomize = new Rand();
        Decide decide = new Decide();
        //default limit
        decide.setBjLimit(30);
        //alert
        Alert blackjackAlert = new Alert(Alert.AlertType.WARNING);
        Alert hangusAlert = new Alert(Alert.AlertType.WARNING);
        blackjackAlert.setHeaderText("BlackJack!");
        hangusAlert.setHeaderText("Hand Card Hangus!");
        blackjackAlert.setContentText("Tidak dapat Hit lagi!\nTekan Hold untuk menyimpan kartu");
        hangusAlert.setContentText("Tidak dapat Hit lagi!\nTekan Hold untuk menyimpan kartu");

        Image iH = new Image("File:etcetera/home.jpg");
        ImageView viewIh = new ImageView(iH);
        viewIh.setFitHeight(1024);
        viewIh.setFitWidth(1280);
        viewIh.setPreserveRatio(true);
        StackPane stackMenu = new StackPane(viewIh);
        stackMenu.setAlignment(Pos.BOTTOM_CENTER);

        Scene sceneMenu = new Scene(stackMenu, 1137, 670);
        primaryStage.setScene(sceneMenu);

        Button maen = new Button("Main");
        Button maenLan = new Button("Main via LAN");
        Button setting = new Button("Setting");
        maen.setPrefSize(100, 30);
        setting.setPrefSize(100, 30);
        HBox boxButton = new HBox(10);
        boxButton.setAlignment(Pos.BOTTOM_CENTER);
        boxButton.getChildren().addAll(maen, maenLan, setting);
        boxButton.setPadding(new Insets(0, 0, 80, 0));
        stackMenu.getChildren().add(boxButton);


        setting.setOnAction(stg -> {
            path = "soundEffect/click.wav";
            se.setFile(path);

            Image iS = new Image("File:etcetera/sett1.jpg");
            ImageView viewIs = new ImageView(iS);
            viewIs.setFitHeight(1024);
            viewIs.setFitWidth(1280);
            viewIs.setPreserveRatio(true);
            StackPane stackSetting = new StackPane(viewIs);
            stackSetting.setAlignment(Pos.CENTER);

            Text settingText = new Text("Game Setting");
            settingText.setFont(Font.font("Tahoma", FontWeight.BOLD, 80));
            settingText.setFill(Color.WHITE);
            HBox textSett = new HBox();
            textSett.getChildren().add(settingText);
            textSett.setPadding(new Insets(120, 0, 0, 40));
            stackSetting.getChildren().add(textSett);

            Text backSoundT = new Text("BackSound");
            backSoundT.setFont(Font.font("Tahoma", FontWeight.SEMI_BOLD, 30));
            backSoundT.setFill(Color.WHITE);
            Button backOn = new Button("On");
            backOn.setPrefSize(70,30);
            Button backOff = new Button("Off");
            backOff.setPrefSize(70,30);
            HBox btnOnOff1 = new HBox(25);
            btnOnOff1.getChildren().addAll(backOn,backOff);
            HBox boxBS = new HBox(240);
            boxBS.getChildren().addAll(backSoundT,btnOnOff1);

            Text soundEffectT = new Text("Sound Effect");
            soundEffectT.setFont(Font.font("Tahoma", FontWeight.SEMI_BOLD, 30));
            soundEffectT.setFill(Color.WHITE);
            Button seOn = new Button("On");
            seOn.setPrefSize(70,30);
            Button seOff = new Button("Off");
            seOff.setPrefSize(70,30);
            HBox btnOnOff2 = new HBox(25);
            btnOnOff2.getChildren().addAll(seOn,seOff);
            HBox boxSE = new HBox(217);
            boxSE.getChildren().addAll(soundEffectT,btnOnOff2);

            Text pointT = new Text("Game Point");
            pointT.setFont(Font.font("Tahoma", FontWeight.SEMI_BOLD, 30));
            pointT.setFill(Color.WHITE);
            Button limit30 = new Button("30");
            limit30.setPrefSize(70,30);
            Button limit21 = new Button("21");
            limit21.setPrefSize(70,30);
            HBox btnOnOff3 = new HBox(25);
            btnOnOff3.getChildren().addAll(limit21,limit30);
            HBox boxPoint = new HBox(233);
            boxPoint.getChildren().addAll(pointT,btnOnOff3);

            Button backTmenu = new Button("Back to Menu");
            backTmenu.setPrefSize(130, 40);
            backTmenu.setTranslateX(-480);
            backTmenu.setTranslateY(300);
            stackSetting.getChildren().add(backTmenu);

            //tampil to layOut
            VBox settAll = new VBox(20);
            settAll.getChildren().addAll(boxBS,boxSE,boxPoint);
            settAll.setTranslateX(55);
            settAll.setTranslateY(260);
            stackSetting.getChildren().add(settAll);

            backOn.setOnAction(on -> bs.startSong());
            backOff.setOnAction(off -> bs.stopSong());
            seOff.setOnAction(stp -> se.start = false);
            seOn.setOnAction(on -> se.start = true);

            limit30.setOnAction(l30 -> {
                path = "soundEffect/click.wav";
                se.setFile(path);
                decide.setBjLimit(30);
            });
            limit21.setOnAction(l21 -> {
                path = "soundEffect/click.wav";
                se.setFile(path);
                decide.setBjLimit(21);
            });

            backTmenu.setOnAction(m -> {
                path = "soundEffect/click.wav";
                se.setFile(path);
                primaryStage.setScene(sceneMenu);
            });

            Scene sceneSetting = new Scene(stackSetting, 1137, 670);
            primaryStage.setScene(sceneSetting);
        });

        maen.setOnAction(p -> {
            path = "soundEffect/click.wav";
            se.setFile(path);
            Image imageAkhir = new Image("File:etcetera/blackjack_background.jpg");
            ImageView viewBGA = new ImageView(imageAkhir);
            stAkhir.getChildren().add(viewBGA);

            Image imageBG = new Image("File:etcetera/blackjack_background.jpg");
            ImageView viewBG = new ImageView(imageBG);
            Image imageBG1 = new Image("File:etcetera/blackjack_background.jpg");
            ImageView viewBG1 = new ImageView(imageBG1);
            Image imageBGB = new Image("File:etcetera/blackjack_background.jpg");
            ImageView viewBGB = new ImageView(imageBGB);
            StackPane stB0 = new StackPane();
            StackPane stP1 = new StackPane();
            StackPane stP2 = new StackPane();
            stB0.setAlignment(Pos.CENTER_LEFT);
            stP1.setAlignment(Pos.CENTER_LEFT);
            stP2.setAlignment(Pos.CENTER_LEFT);
            Scene sceneP0 = new Scene(stB0, 1137, 670);
            Scene sceneP1 = new Scene(stP1, 1137, 670);
            Scene sceneP2 = new Scene(stP2, 1137, 670);
            stP1.getChildren().add(viewBG);
            stP2.getChildren().add(viewBG1);
            stB0.getChildren().add(viewBGB);

            // judul player 1,2 & Bandar turn
            Text p1Turn = new Text("Player 1 Turn");
            p1Turn.setFont(Font.font("Tahoma", FontWeight.NORMAL, 100));
            p1Turn.setTranslateX(230);
            p1Turn.setTranslateY(-250);
            stP1.getChildren().add(p1Turn);

            Text p2Turn = new Text("Player 2 Turn");
            p2Turn.setFont(Font.font("Tahoma", FontWeight.NORMAL, 100));
            p2Turn.setTranslateX(230);
            p2Turn.setTranslateY(-250);
            stP2.getChildren().add(p2Turn);

            Text B0Turn = new Text("Bandar Turn");
            B0Turn.setFont(Font.font("Tahoma", FontWeight.NORMAL, 100));
            B0Turn.setTranslateX(280);
            B0Turn.setTranslateY(-250);
            stB0.getChildren().add(B0Turn);

            // button menu
            Button goBack = new Button("Menu");
            goBack.setPrefSize(200, 60);
            goBack.setTranslateX(930);
            goBack.setTranslateY(600);
            stAkhir.getChildren().add(goBack);

            goBack.setOnAction(gb -> {
                path = "soundEffect/click.wav";
                se.setFile(path);
                primaryStage.setScene(sceneMenu);
            });

            //adegan giliran P1
            Button hit1 = new Button("Hit");
            Button hold1 = new Button("Hold");
            hit1.setPrefSize(150, 60);
            hold1.setPrefSize(150, 60);
            HBox boxHit = new HBox(30);
            boxHit.getChildren().addAll(hit1, hold1);
            boxHit.setTranslateX(400);
            boxHit.setTranslateY(550);
            stP1.getChildren().add(boxHit);

            //set all total 0
            decide.setT0(0);
            decide.setT1(0);
            decide.setT2(0);
            //three initial cards & totals

            // Three Card P1
            decide.setT1(decide.threeCards(randomize, decide, stP1, stAkhir, false, false, 245,0,0,false));
            System.out.println("total p1: " + decide.getT1());

            primaryStage.setScene(sceneP1);

            positionP1 = 490; positionP1A = 400;
            if (decide.getT1() == decide.getBjLimit()){
                path = "soundEffect/bj.wav";
                se.setFile(path);
                blackjackAlert.showAndWait();
            }
            else if (decide.getT1() > decide.getBjLimit() || decide.getT1() == 0) {
                path = "soundEffect/hangus.wav";
                se.setFile(path);
                hangusAlert.showAndWait();
                decide.setT1(0);
            }
            hit1.setOnAction(hi1 -> {
                path = "soundEffect/click.wav";
                se.setFile(path);
                if (decide.getT1() == decide.getBjLimit()) {
                    path = "soundEffect/bj.wav";
                    se.setFile(path);
                    blackjackAlert.showAndWait();
                } else if (decide.getT1() > decide.getBjLimit() || decide.getT1() == 0) {
                    path = "soundEffect/hangus.wav";
                    se.setFile(path);
                    hangusAlert.showAndWait();
                    decide.setT1(0);
                } else {
                    int hitVal = decide.andNormalize(randomize.theNumber());
                    decide.setT1((decide.getT1() + hitVal));
                    Image kartu = new Image(decide.theCard(hitVal));
                    ImageView kartuPlus = new ImageView(kartu);
                    ani1.setAniHit(kartuPlus,350,positionP1,-350);
                    stP1.getChildren().add(kartuPlus);
                    System.out.println(decide.getT1() + "\nHit +" + hitVal);
                    kartuPlus = new ImageView(kartu);
                    kartuPlus.setTranslateX(positionP1A);
                    kartuPlus.setTranslateY(245);
                    stAkhir.getChildren().add(kartuPlus);
                    if (decide.getT1() > decide.getBjLimit()) {
                        path = "soundEffect/hangus.wav";
                        se.setFile(path);
                        hangusAlert.showAndWait();
                        decide.setT1(0);
                    }
                    if (decide.getT1() == decide.getBjLimit()) {
                        path = "soundEffect/bj.wav";
                        se.setFile(path);
                        blackjackAlert.showAndWait();
                    }
                    positionP1 += 80;
                    positionP1A +=50;
                }

            });

            hold1.setOnAction(ho1 -> {
                path = "soundEffect/click.wav";
                se.setFile(path);
                GridPane gridConfirm = new GridPane();
                Scene sceneConfirm = new Scene(gridConfirm, 0, 0);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Player 2 Ready?");
                alert.setTitle("Player Turn Transition");
                alert.setContentText("Klik OK saat sudah siap");
                primaryStage.setScene(sceneConfirm);
                alert.showAndWait();

                // Three Card P2
                decide.setT2(decide.threeCards(randomize, decide, stP2, stAkhir, false, false, 460,0,0,false));
                System.out.println("total p2: " + decide.getT2());

                //adegan giliran P2
                Button hit2 = new Button("Hit");
                Button hold2 = new Button("Hold");
                hit2.setPrefSize(150, 60);
                hold2.setPrefSize(150, 60);

                HBox boxHit2 = new HBox(30);
                boxHit2.getChildren().addAll(hit2, hold2);
                boxHit2.setTranslateX(400);
                boxHit2.setTranslateY(550);
                stP2.getChildren().add(boxHit2);

                primaryStage.setScene(sceneP2);

                positionP2 = 490; positionP2A = 400;
                if (decide.getT2() == decide.getBjLimit()){
                    path = "soundEffect/bj.wav";
                    se.setFile(path);
                    blackjackAlert.showAndWait();
                }
                else if (decide.getT2() > decide.getBjLimit() || decide.getT2() == 0) {
                    path = "soundEffect/hangus.wav";
                    se.setFile(path);
                    hangusAlert.showAndWait();
                    decide.setT2(0);
                }
                hit2.setOnAction(hi2 -> {
                    path = "soundEffect/click.wav";
                    se.setFile(path);
                    if (decide.getT2() == decide.getBjLimit()){
                        path = "soundEffect/bj.wav";
                        se.setFile(path);
                        blackjackAlert.showAndWait();
                    }
                    else if (decide.getT2() > decide.getBjLimit() || decide.getT2() == 0) {
                        path = "soundEffect/hangus.wav";
                        se.setFile(path);
                        hangusAlert.showAndWait();
                        decide.setT2(0);
                    } else {
                        int hitVal = decide.andNormalize(randomize.theNumber());
                        Image kartu = new Image(decide.theCard(hitVal));
                        ImageView kartuPlus = new ImageView(kartu);
                        ani1.setAniHit(kartuPlus,350,positionP2,-350);
                        stP2.getChildren().add(kartuPlus);
                        decide.setT2((decide.getT2() + hitVal));
                        System.out.println(decide.getT2() + "\nHit +" + hitVal);
                        kartuPlus = new ImageView(kartu);
                        kartuPlus.setTranslateX(positionP2A);
                        kartuPlus.setTranslateY(460);
                        stAkhir.getChildren().add(kartuPlus);
                        if (decide.getT2() > decide.getBjLimit()) {
                            path = "soundEffect/hangus.wav";
                            se.setFile(path);
                            hangusAlert.showAndWait();
                            decide.setT2(0);
                        }
                        if (decide.getT2() == decide.getBjLimit()) {
                            path = "soundEffect/bj.wav";
                            se.setFile(path);
                            blackjackAlert.showAndWait();
                        }

                        positionP2 += 80;
                        positionP2A += 50;
                    }
                });
                hold2.setOnAction(ho2 -> {
                    path = "soundEffect/click.wav";
                    se.setFile(path);

                    // Three Card Bandar
                    decide.setT0(decide.threeCards(randomize, decide, stB0, stAkhir, true, true, 30,0,0,false));
                    System.out.println("total P0: " + decide.getT0());

                    //adegan giliran Bandar
                    Button lanjut = new Button("Reveal the Result");
                    lanjut.setPrefSize(200, 60);
                    HBox hBoxB = new HBox(10);
                    hBoxB.getChildren().add(lanjut);
                    hBoxB.setTranslateX(930);
                    hBoxB.setTranslateY(600);
                    stB0.getChildren().add(hBoxB);

                    primaryStage.setScene(sceneP0);
                    boolean loop = true;
                    positionB0 = 530;
                    int temptP = 400;
                    if (decide.getT0() == decide.getBjLimit()) System.out.println("-BlackJack!");
                    else if (decide.getT0() > decide.getBjLimit() || decide.getT0() == 0) {
                        System.out.println("-Hangus");
                        decide.setT0(0);
                    } else {
                        int heldByBandar = 3;
                        while (loop) {
                            if ((decide.getT0() < (decide.getBjLimit() - 3) && heldByBandar < 7)) {
                                int hitVal = decide.andNormalize(randomize.theNumber());
                                decide.setT0((decide.getT0() + hitVal));
                                System.out.println("\nHit +" + hitVal);
                                Image kartu = new Image("File:cardDeck/back.png");
                                ImageView kartuPlus = new ImageView(kartu);
                                kartuPlus.setTranslateX(positionB0);
                                kartuPlus.setTranslateY(-100);
                                stB0.getChildren().add(kartuPlus);
                                kartu = new Image(decide.theCard(hitVal));
                                kartuPlus = new ImageView(kartu);
                                kartuPlus.setTranslateX(temptP);
                                kartuPlus.setTranslateY(30);
                                stAkhir.getChildren().add(kartuPlus);

                                heldByBandar++;
                            } else if (decide.getT0() == decide.getBjLimit()) {
                                System.out.println("-BlackJack!");
                                loop = false;
                            } else if (decide.getT0() > decide.getBjLimit()) {
                                System.out.println("-Hangus");
                                decide.setT0(0);
                                loop = false;
                            } else {
                                System.out.println("-Hold");
                                loop = false;
                            }
                            positionB0 += 80;
                            temptP += 50;
                        }
                    }


                    lanjut.setOnAction(rev -> {
                        path = "soundEffect/click.wav";
                        se.setFile(path);

                        String winningCond;

                        if (decide.getT0() == decide.getT1() && decide.getT1() == decide.getT2())
                            winningCond = "Bandar Win!!";
                        else if (decide.getT0() >= decide.getT1() && decide.getT0() >= decide.getT2())
                            winningCond = "Bandar Win!!";
                        else if (decide.getT0() < decide.getT2() && decide.getT1() == decide.getT2())
                            winningCond = "Seri!";
                        else if (decide.getT0() >= decide.getT1() && decide.getT0() <= decide.getT2())
                            winningCond = "Player 2 Win!!";
                        else if (decide.getT0() <= decide.getT1() && decide.getT0() >= decide.getT2())
                            winningCond = "Player 1 Win!!";
                        else if (decide.getT0() <= decide.getT1() && decide.getT1() < decide.getT2())
                            winningCond = "Player 2 Win!!";
                        else if (decide.getT0() < decide.getT2()) winningCond = "Player 1 Win!!";
                        else winningCond = "no one wins (just in case)";

                        Text hasiltitle = new Text(winningCond);
                        hasiltitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 40));
                        Text p0Hand = new Text("B: " + decide.getT0());
                        Text p1Hand = new Text("P1: " + decide.getT1());
                        Text p2Hand = new Text("P2: " + decide.getT2());
                        p0Hand.setFont(Font.font("Tahoma", FontWeight.NORMAL, 60));
                        p1Hand.setFont(Font.font("Tahoma", FontWeight.NORMAL, 60));
                        p2Hand.setFont(Font.font("Tahoma", FontWeight.NORMAL, 60));

                        hasiltitle.setTranslateX(760);
                        hasiltitle.setTranslateY(50);
                        p0Hand.setTranslateX(30);
                        p0Hand.setTranslateY(85);
                        p1Hand.setTranslateX(30);
                        p1Hand.setTranslateY(300);
                        p2Hand.setTranslateX(30);
                        p2Hand.setTranslateY(515);
                        stAkhir.getChildren().add(hasiltitle);
                        stAkhir.getChildren().addAll(p0Hand, p1Hand, p2Hand);

                        primaryStage.setScene(sceneAkhir);


                    });

                });
            });

        });

        maenLan.setOnAction(pLan -> {
            StackPane stackLanConfig = new StackPane();
            stackLanConfig.setAlignment(Pos.CENTER);
            Scene sceneLanConfig = new Scene(stackLanConfig, 1137, 670);
            primaryStage.setScene(sceneLanConfig);
            Button playAs1 = new Button("Play as Player 1");
            Button playAs2 = new Button("Play as Player 2");

            IPConn ipConn = new IPConn();
            Label myIpLabel = new Label("Your Local IP: "+ ipConn.checkIp());
            TextField ipTf = new TextField("127.0.0.1");
            TextField portTf = new TextField("8888");
            HBox ipConfig = new HBox(10);
            ipConfig.setAlignment(Pos.BOTTOM_CENTER);
            ipConfig.getChildren().addAll(myIpLabel,ipTf,portTf);
            ipConfig.setPadding(new Insets(0, 1, 60, 0));
            stackLanConfig.getChildren().addAll(ipConfig);

            HBox P1orP2 = new HBox(10);
            P1orP2.setAlignment(Pos.BOTTOM_CENTER);
            P1orP2.getChildren().addAll(playAs1,playAs2);
            P1orP2.setPadding(new Insets(0, 1, 100, 0));
            stackLanConfig.getChildren().add(P1orP2);

            //PlayTable
            StackPane stackMejaLan = new StackPane();
            stackMejaLan.setAlignment(Pos.BOTTOM_LEFT);
            Scene sceneMejaLan = new Scene(stackMejaLan, 1137, 670);

            playAs1.setOnAction(ap1 -> {



                primaryStage.setScene(sceneMejaLan);
                decide.setT0(0);decide.setT1(0);decide.setT2(0);
                decide.setT1(decide.threeCards(randomize, decide, stackMejaLan, stAkhir, false, false, 245,-200,-100,true));
                decide.setT2(decide.threeCards(randomize, decide, stackMejaLan, stAkhir, false, true, 245,400,-100,true));
                decide.setT0(decide.threeCards(randomize, decide, stackMejaLan, stAkhir, true, true, 245,150,-300,true));

                //Buttons
                Button hit = new Button("Hit");
                Button hold = new Button("Hold");
                Button refresh = new Button("Refresh Table");
                HBox hitHold = new HBox(10);
                hitHold.setAlignment(Pos.BOTTOM_CENTER);
                hitHold.getChildren().addAll(hit,hold,refresh);
                hitHold.setPadding(new Insets(0, 1, 50, 0));
                stackMejaLan.getChildren().add(hitHold);

                refresh.setOnAction(f5 -> {
                    while(true){
                        try {
                            byte[] buf = new byte[1024];
                            DatagramPacket dgpread = new DatagramPacket(buf, buf.length);
                            dgsrece.receive(dgpread);
                            String readmessage = new String(dgpread.getData(), 0, dgpread.getLength());
                            System.out.println(readmessage);
                            String[] splitted = readmessage.split("\\s");
                            decide.setT2(Integer.parseInt(splitted[0]));
                            System.out.println("spl1: " + splitted[0]);
                            System.out.println("spl2: " + splitted[1]);
                            System.out.println("-->filepath" + splitted[1]);
                            Image receivedCard = new Image(splitted[1]);
                            ImageView receivedCardView = new ImageView(receivedCard);
                            HBox hBox = new HBox();
                            hBox.getChildren().addAll(receivedCardView);
                            stackMejaLan.getChildren().addAll(hBox);
                        } catch (Exception e) {
                            e.getStackTrace();
                        }
                    }
                });

                //dgsPORT
                try {
                    dgsrece = new DatagramSocket(8888);
                } catch (SocketException e) {
                    e.printStackTrace();
                }
                hit.setOnAction(hitAct -> {
                    //this screen
                    if (decide.getT1() == decide.getBjLimit()) {
                        path = "soundEffect/bj.wav";
                        se.setFile(path);
                        blackjackAlert.showAndWait();
                    } else if (decide.getT1() > decide.getBjLimit() || decide.getT1() == 0) {
                        path = "soundEffect/hangus.wav";
                        se.setFile(path);
                        hangusAlert.showAndWait();
                        decide.setT1(0);
                    } else {
                        int hitVal = decide.andNormalize(randomize.theNumber());
                        decide.setT1((decide.getT1() + hitVal));
                        Image kartu = new Image(decide.theCard(hitVal));
                        ImageView kartuPlus = new ImageView(kartu);
                        kartuPlus.setTranslateX(positionP1A+320);
                        kartuPlus.setTranslateY(-100);
                        stackMejaLan.getChildren().add(kartuPlus);
                        System.out.println(decide.getT1() + "\nHit +" + hitVal);
                        kartuPlus = new ImageView(kartu);
                        kartuPlus.setTranslateX(positionP1A);
                        kartuPlus.setTranslateY(245);
                        stAkhir.getChildren().add(kartuPlus);
                        if (decide.getT1() > decide.getBjLimit()) {
                            path = "soundEffect/hangus.wav";
                            se.setFile(path);
                            hangusAlert.showAndWait();
                            decide.setT1(0);
                        }
                        if (decide.getT1() == decide.getBjLimit()) {
                            path = "soundEffect/bj.wav";
                            se.setFile(path);
                            blackjackAlert.showAndWait();
                        }
                        positionP1 += 80;
                        positionP1A +=50;
                        sendData(decide,hitVal,ipTf.getText(),portTf.getText());
                    }

                });

                hold.setOnAction(holdAct -> {

                });

            });

            playAs2.setOnAction(ap2 -> {
                primaryStage.setScene(sceneMejaLan);
                decide.setT0(0);decide.setT1(0);decide.setT2(0);
                decide.setT1(decide.threeCards(randomize, decide, stackMejaLan, stAkhir, false, true, 245,0,-100,true));
                decide.setT2(decide.threeCards(randomize, decide, stackMejaLan, stAkhir, false, false, 245,300,-100,true));
                //T0 card Set request to P1

                //buttons
                Button hit = new Button("Hit");
                Button hold = new Button("Hold");
                Button refresh = new Button("Refresh Table");
                HBox hitHold = new HBox(10);
                hitHold.setAlignment(Pos.BOTTOM_CENTER);
                hitHold.getChildren().addAll(hit,hold,refresh);
                hitHold.setPadding(new Insets(0, 1, 50, 0));
                stackMejaLan.getChildren().add(hitHold);

                //readThread
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        try{
                            byte[] buf = new byte[1024];
                            DatagramPacket dgpread = new DatagramPacket(buf,buf.length);
                            dgsrece.receive(dgpread);
                            String readmessage = new String(dgpread.getData(),0,dgpread.getLength());
                            System.out.println(readmessage);
                            String[] splitted=readmessage.split("\\s");
                            decide.setT1(Integer.parseInt(splitted[0]));
                            System.out.println("spl1: "+splitted[0]);
                            System.out.println("spl2: "+splitted[1]);
                            System.out.println("-->filepath"+splitted[1]);
                            Image receivedCard = new Image(splitted[1]);
                            ImageView receivedCardView = new ImageView(receivedCard);
                            Button testButton = new Button("WEEEEEE!");
                            testButton.setPrefSize(20000,20000);
                            HBox hBox = new HBox();
                            hBox.getChildren().addAll(testButton,receivedCardView);
                            stackMejaLan.getChildren().addAll(hBox);
                            primaryStage.show();
                        }
                        catch(Exception e)
                        {
                            e.getStackTrace();
                        }
                    }
                };
                Timer timer = new Timer();
                timer.schedule(task, 0, 1000);
            });

        });

        primaryStage.setTitle("BlackJack!");
        primaryStage.show();
    }
//gitPushTest
    public static void main(String[] args) { launch(args); }
}