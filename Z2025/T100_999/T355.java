package Z2025.T100_999;

import java.util.*;

public class T355 {
    class Twitter {
        int timestamp;

        Map<Integer, Queue<Tweet>> tweetMap;
        Map<Integer, Set<Integer>> followMap;


        public Twitter() {
            timestamp = 0;
            tweetMap = new HashMap<>();
            followMap = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            timestamp++;

            Tweet Tweet = new Tweet(userId, tweetId, timestamp);
            Queue<Tweet> queue = tweetMap.getOrDefault(userId, new PriorityQueue<Tweet>((a, b) -> b.timestamp - a.timestamp));
            queue.offer(Tweet);
            tweetMap.put(userId, queue);
        }

        public List<Integer> getNewsFeed(int userId) {
            Set<Integer> followees = followMap.getOrDefault(userId, new HashSet<>());
            followees.add(userId);

            Queue<Tweet> queue = new PriorityQueue<Tweet>((a, b) -> a.timestamp - b.timestamp);

            for(int followeeId : followees){
                if(tweetMap.containsKey(followeeId)){
                    List<Tweet> temp = new ArrayList<>();

                    Queue<Tweet> followeeTweets = tweetMap.get(followeeId);
                    int size = Math.min(10, followeeTweets.size());
                    for(int i = 0; i < size; i++){
                        temp.add(followeeTweets.poll());
                    }

                    for(int i = 0; i < temp.size(); i++){
                        queue.offer(temp.get(i));
                        followeeTweets.offer(temp.get(i));

                        if(queue.size() > 10){
                            queue.poll();
                        }
                    }
                }
            }

            // followees.remove(userId);
            List<Integer> res = new LinkedList<>();

            int size = queue.size();
            for(int i = 0; i < Math.min(10, size); i++){
                res.add(0, queue.poll().tweetId);
            }
            return res;
        }

        public void follow(int followerId, int followeeId) {
            Set<Integer> followees = followMap.getOrDefault(followerId, new HashSet<>());
            followees.add(followeeId);
            followMap.put(followerId, followees);
        }

        public void unfollow(int followerId, int followeeId) {
            Set<Integer> followees = followMap.getOrDefault(followerId, new HashSet<>());
            followees.remove(followeeId);
            followMap.put(followerId, followees);
        }
    }

    class Tweet{
        int userId;
        int tweetId;
        int timestamp;

        public Tweet(int uid, int tid, int ts){
            userId = uid;
            tweetId = tid;
            timestamp = ts;
        }
    }

}
