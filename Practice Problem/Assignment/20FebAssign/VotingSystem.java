import java.util.*;

public class VotingSystem {
    private Map<String, Integer> voteMap = new HashMap<>();
    private Map<String, Integer> voteOrderMap = new LinkedHashMap<>();

    public void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        voteOrderMap.put(candidate, voteOrderMap.getOrDefault(candidate, 0) + 1);
    }

    public void displayVotesInOrder() {
        System.out.println("Votes in Order of Casting:");
        voteOrderMap.forEach((candidate, votes) ->
                System.out.println(candidate + ": " + votes));
    }

    public void displayVotesSorted() {
        System.out.println("Votes in Alphabetical Order:");
        TreeMap<String, Integer> sortedMap = new TreeMap<>(voteMap);
        sortedMap.forEach((candidate, votes) ->
                System.out.println(candidate + ": " + votes));
    }

    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();

        // Casting votes
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Charlie");
        votingSystem.castVote("Bob");

        votingSystem.displayVotesInOrder();

        votingSystem.displayVotesSorted();
    }
}
