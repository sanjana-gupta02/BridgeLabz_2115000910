import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Policy {
    String policyNumber;
    String policyholderName;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    @Override
    public String toString() {
        return String.format("Policy[%s, %s, %s, %s, %.2f]", policyNumber, policyholderName, expiryDate, coverageType, premiumAmount);
    }
}

public class InsurancePolicyManagement {
    private Map<String, Policy> policyHashMap = new HashMap<>();
    private Map<String, Policy> policyLinkedHashMap = new LinkedHashMap<>();
    private TreeMap<LocalDate, Policy> policyTreeMap = new TreeMap<>();

    public void addPolicy(Policy policy) {
        policyHashMap.put(policy.policyNumber, policy);
        policyLinkedHashMap.put(policy.policyNumber, policy);
        policyTreeMap.put(policy.expiryDate, policy);
    }

    public Policy getPolicyByNumber(String policyNumber) {
        return policyHashMap.get(policyNumber);
    }

    public List<Policy> getExpiringPolicies() {
        List<Policy> expiringPolicies = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate threshold = today.plusDays(30);

        for (LocalDate date : policyTreeMap.keySet()) {
            if (!date.isAfter(threshold) && !date.isBefore(today)) {
                expiringPolicies.add(policyTreeMap.get(date));
            }
        }
        return expiringPolicies;
    }

    public List<Policy> getPoliciesByHolder(String policyholderName) {
        List<Policy> policies = new ArrayList<>();
        for (Policy policy : policyHashMap.values()) {
            if (policy.policyholderName.equalsIgnoreCase(policyholderName)) {
                policies.add(policy);
            }
        }
        return policies;
    }

    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        Iterator<Map.Entry<LocalDate, Policy>> iterator = policyTreeMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<LocalDate, Policy> entry = iterator.next();
            if (entry.getKey().isBefore(today)) {
                String policyNumber = entry.getValue().policyNumber;
                policyHashMap.remove(policyNumber);
                policyLinkedHashMap.remove(policyNumber);
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        InsurancePolicyManagement system = new InsurancePolicyManagement();

        system.addPolicy(new Policy("P001", "Alice", LocalDate.now().plusDays(10), "Health", 5000));
        system.addPolicy(new Policy("P002", "Bob", LocalDate.now().plusDays(25), "Auto", 3000));
        system.addPolicy(new Policy("P003", "Alice", LocalDate.now().minusDays(5), "Home", 7000));
        system.addPolicy(new Policy("P004", "Charlie", LocalDate.now().plusDays(40), "Health", 4500));

        System.out.println("Policy P002: " + system.getPolicyByNumber("P002"));
        System.out.println("Expiring Policies: " + system.getExpiringPolicies());
        System.out.println("Alice's Policies: " + system.getPoliciesByHolder("Alice"));

        system.removeExpiredPolicies();
        System.out.println("Policies after removing expired ones: " + system.policyHashMap.values());
    }
}
