import java.util.*;

class FriendNode {
    int friendId;
    FriendNode next;

    FriendNode(int friendId) {
        this.friendId = friendId;
        this.next = null;
    }
}

class UserNode {
    int userId, age;
    String name;
    FriendNode friendList;
    UserNode next;

    UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendList = null;
        this.next = null;
    }
}

class SocialMedia {
    private UserNode head;

    void addUser(int userId, String name, int age) {
        UserNode newUser = new UserNode(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            UserNode temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newUser;
        }
    }

    UserNode searchUser(int userId) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == userId) return temp;
            temp = temp.next;
        }
        return null;
    }

    void addFriend(int userId1, int userId2) {
        UserNode user1 = searchUser(userId1);
        UserNode user2 = searchUser(userId2);
        if (user1 == null || user2 == null || userId1 == userId2) return;

        FriendNode newFriend1 = new FriendNode(userId2);
        newFriend1.next = user1.friendList;
        user1.friendList = newFriend1;

        FriendNode newFriend2 = new FriendNode(userId1);
        newFriend2.next = user2.friendList;
        user2.friendList = newFriend2;
    }

    void removeFriend(int userId1, int userId2) {
        UserNode user1 = searchUser(userId1);
        UserNode user2 = searchUser(userId2);
        if (user1 == null || user2 == null) return;

        user1.friendList = removeFriendHelper(user1.friendList, userId2);
        user2.friendList = removeFriendHelper(user2.friendList, userId1);
    }

    private FriendNode removeFriendHelper(FriendNode head, int friendId) {
        if (head == null) return null;
        if (head.friendId == friendId) return head.next;
        FriendNode temp = head;
        while (temp.next != null && temp.next.friendId != friendId) temp = temp.next;
        if (temp.next != null) temp.next = temp.next.next;
        return head;
    }

    void displayFriends(int userId) {
        UserNode user = searchUser(userId);
        if (user == null) return;
        System.out.print(user.name + "'s friends: ");
        FriendNode temp = user.friendList;
        while (temp != null) {
            System.out.print(temp.friendId + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    void findMutualFriends(int userId1, int userId2) {
        UserNode user1 = searchUser(userId1);
        UserNode user2 = searchUser(userId2);
        if (user1 == null || user2 == null) return;

        Set<Integer> set = new HashSet<>();
        FriendNode temp = user1.friendList;
        while (temp != null) {
            set.add(temp.friendId);
            temp = temp.next;
        }

        System.out.print("Mutual friends of " + user1.name + " and " + user2.name + ": ");
        temp = user2.friendList;
        while (temp != null) {
            if (set.contains(temp.friendId)) System.out.print(temp.friendId + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    void countFriends(int userId) {
        UserNode user = searchUser(userId);
        if (user == null) return;
        int count = 0;
        FriendNode temp = user.friendList;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println(user.name + " has " + count + " friends.");
    }
}

public class SocialMediaApp {
    public static void main(String[] args) {
        SocialMedia sm = new SocialMedia();
        sm.addUser(1, "Sanjana", 25);
        sm.addUser(2, "Khushi", 23);
        sm.addUser(3, "Kislay", 27);
        sm.addUser(4, "Aman", 22);

        sm.addFriend(1, 2);
        sm.addFriend(1, 3);
        sm.addFriend(2, 4);

        sm.displayFriends(1);
        sm.displayFriends(2);

        sm.findMutualFriends(1, 2);

        sm.countFriends(1);

        sm.removeFriend(1, 2);
        sm.displayFriends(1);
    }
}
