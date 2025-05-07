import java.util.*;
import java.io.*;

public class Main {
    
    public static class Room {
        int index;
        int level;
        List<Player> playerList = new ArrayList<>();
        
        public Room(int index, int level) {
            this.index = index;
            this.level = level;
        }
        
    }
    
    public static class Player implements Comparable<Player> {
        String name;
        int level;
        
        public Player(String name, int level) {
            this.name = name;
            this.level = level;
        }
        
        @Override
        public int compareTo(Player o) {
            return this.name.compareTo(o.name);
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        List<Room> roomList = new ArrayList<>();
        
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            
            if (i == 0) {
                roomList.add(new Room(i, level));
                Room room = roomList.get(i);
                room.playerList.add(new Player(name, level));
            } else {
                boolean flag = false;
                for (int j = 0; j < roomList.size(); j++) {
                    if (level <= roomList.get(j).level + 10 && roomList.get(j).level - 10 <= level && roomList.get(j).playerList.size() < m) {
                        roomList.get(j).playerList.add(new Player(name, level));
                        flag = true;
                        break;
                    }
                }
                
                if (!flag) {
                    Room room = new Room(i, level);
                    roomList.add(room);
                    room.playerList.add(new Player(name, level));
                }
            }
        }
        
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).playerList.size() == m) {
                System.out.println("Started!");
                Collections.sort(roomList.get(i).playerList);
                for (int j = 0; j < m; j++) {
                    System.out.println(roomList.get(i).playerList.get(j).level + " " + roomList.get(i).playerList.get(j).name);
                }
            } else {
                System.out.println("Waiting!");
                Collections.sort(roomList.get(i).playerList);
                for (int j = 0; j < roomList.get(i).playerList.size(); j++) {
                    System.out.println(roomList.get(i).playerList.get(j).level + " " + roomList.get(i).playerList.get(j).name);
                }
            }
        }
    }
}
