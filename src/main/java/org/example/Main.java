package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        List<String> list = Files.readAllLines(new File("/C:/Users/79195/Downloads/Telegram Desktop/schedule.txt").toPath(), Charset.defaultCharset());
        Map<String, List<Program>> map = new HashMap<>();
//        System.out.println(list.toString());

        int i = 0;
        int count = 0;
        String currentChannel = null;
        List<Program> programListMap = null; // 4. лист для map, обновляется каждый раз с новым каналом
        List<Program> allProgramList = new ArrayList<>(); // 5. лист со всеми программами независимо от канала
        while (i < list.size()){
            if (list.get(i).contains("#")){
                currentChannel = list.get(i);
                i++;
                count++;
                programListMap = new ArrayList<>();
            }
            else{
                programListMap.add(new Program(currentChannel,new BroadcastsTime(list.get(i)), list.get(i+1)));
                allProgramList.add(new Program(currentChannel,new BroadcastsTime(list.get(i)), list.get(i+1)));
                i = i + 2;
            }
            if (count != 0) map.put(currentChannel,programListMap);

        }
        //6
        Collections.sort(allProgramList, Comparator.comparing(program -> program.getTime()));
//        System.out.println(sortedTimeProgram.toString());
        //7
        BroadcastsTime currentTime = new BroadcastsTime("15:20");
        for (Program program : allProgramList) {
            if (program.getTime().equals(currentTime)) {
                System.out.println(program.getName());
            }
        };

        //8
        String str = "Квартирный вопрос";
        for (int k = 0; k < allProgramList.size()-1; k++){
            if (allProgramList.get(k).getName().contains(str)){
                System.out.println(list.get(k));
            }
        }


        //9
        BroadcastsTime currentTime1 = new BroadcastsTime("16:30");
        String channelName = "#Карусель";
        List<Program> channelPrograms = map.get(channelName);
        if (channelPrograms != null) {
            for (Program program : channelPrograms) {
                if (program.getTime().equals(currentTime)) {
                    System.out.println(program.getName());
                }
            }
        }
        //10
        BroadcastsTime startTime = new BroadcastsTime("3:34");
        BroadcastsTime endTime = new BroadcastsTime("7:01");
        for (Program program : channelPrograms) {
            if (program.getTime().between(startTime, endTime)) {
                System.out.println(program.getName());
            }
        }

    }
}