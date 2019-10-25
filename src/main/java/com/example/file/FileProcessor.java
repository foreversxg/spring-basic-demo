package com.example.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author shaoxiangen
 * Create in 2019/10/25
 */
public class FileProcessor {

    public static void main(String[] args) {
        File file = new File("E:/music-rep2-gyarados.log.2019-10-24");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null){
                if(line.contains("ElementBackendController update start")) {
                    String[] arrays = line.split("params:");
                    String time = arrays[0].substring(0,23);
                    Date date = parseDate(time);
                    String body = arrays[1];
                    if(body .length() <= 100) {
                        continue;
                    }
                    System.out.println(arrays[1]);

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static Date parseDate(String time) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.parse(time);
    }

    public static class LogMeta{
        private long id;
        private boolean confirm;
        private int score;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public boolean isConfirm() {
            return confirm;
        }

        public void setConfirm(boolean confirm) {
            this.confirm = confirm;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }
    }
    // ,"source":0,"id":1467553,"type":4}]
    public static class UpdateParams{
        private String value;
        private int source;
        private long id;
        private int type;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public int getSource() {
            return source;
        }

        public void setSource(int source) {
            this.source = source;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
