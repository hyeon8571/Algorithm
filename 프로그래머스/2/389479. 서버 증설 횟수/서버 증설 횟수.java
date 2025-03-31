class Solution {
    public int solution(int[] players, int m, int k) {
        
        int[] serverArr = new int[24]; // 증설 횟수를 저장할 배열
        int[] borrowServer = new int[24]; // n시에 빌린 서버의 수
        int[] nowServer = new int[24]; // n시에 운영중인 서버의 수
        
        int zeroPeople = players[0];
        if (zeroPeople / m >= 1) {
            borrowServer[0] = zeroPeople / m;  // 0시에 빌린 서버의 수
            serverArr[0] = zeroPeople / m;
            
            for (int i = 0; i <= k; i++) {
                nowServer[i] = zeroPeople / m; // 0시부터 k시까지 운영중인 서버 수
            }
        }
            
        for (int i = 1; i < 24; i++) {
            
            // 매 시간 서버 반납
            if (i >= k) {
                int returnServer = borrowServer[i-k];
                nowServer[i] -= returnServer;
            }
            
            int nowPeople = players[i]; // 현재 게임 이용자 수
            
            if (nowPeople / m >= 1) {
                int canServer = nowServer[i]; // 현재 운영중인 서버의 수
                int needServer = nowPeople/m; // 필요한 서버의 수
                
                if (needServer - canServer > 0) { // 빌려야할 서버의 수
                    borrowServer[i] = needServer - canServer;
                    for (int j = i; j <= i+k; j++) {
                        if (j < 24) {
                            nowServer[j] += needServer - canServer;        
                        }
                        
                    }
                    
                    serverArr[i] += needServer - canServer;
                }
            }
            
        }
        
        
        int answer = 0;
        for (int i = 0; i < 24; i++) {
            answer += serverArr[i];
            System.out.println(serverArr[i]);
        }
        
        return answer;
    }
}