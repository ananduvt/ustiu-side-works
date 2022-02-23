/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

/**
 *
 * @author u55369
 */
public class SoundTest {

   public static float SAMPLE_RATE = 8000f;

  public static void tone(int hz, int msecs) 
     throws LineUnavailableException 
  {
     tone(hz, msecs, 1.0);
  }

  public static void tone(int hz, int msecs, double vol)
      throws LineUnavailableException 
  {
    byte[] buf = new byte[1];
    AudioFormat af = 
        new AudioFormat(
            SAMPLE_RATE, // sampleRate
            8,           // sampleSizeInBits
            1,           // channels
            true,        // signed
            false);      // bigEndian
    SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
    sdl.open(af);
    sdl.start();
    for (int i=0; i < msecs*8; i++) {
      double angle = i / (SAMPLE_RATE / hz) * 2.0 * Math.PI;
      buf[0] = (byte)(Math.sin(angle) * 127.0 * vol);
      sdl.write(buf,0,1);
    }
    sdl.drain();
    sdl.stop();
    sdl.close();
  }

  public static void main(String[] args) throws Exception {
//    Test.tone(1000,100);
//    Thread.sleep(1000);
//    Test.tone(100,1000);
//    Thread.sleep(1000);
//    Test.tone(5000,100);
//    Thread.sleep(1000);
//    Test.tone(400,500);
   // Thread.sleep(1000);
   for(int i =0;i<50;i++){
    SoundTest.tone(500,100,1);
    SoundTest.tone(700,100,1);
    SoundTest.tone(600,100,1);
   }
  }
    private static boolean dateCheck(ArrayList<String> dateList, String checkDate) {
        boolean eligible = false;
        try {
            Date refDate = new SimpleDateFormat("yyyy-MM-dd").parse(checkDate);

            for (String s : dateList) {
                Date compDate = new SimpleDateFormat("yyyy-MM-dd").parse(s);
                if (compDate.after(refDate)) {
                    eligible = true;
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(SoundTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return eligible;
    }

}
