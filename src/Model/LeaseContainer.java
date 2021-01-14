package Model;

import java.util.ArrayList;

public class LeaseContainer{

    private static LeaseContainer instance;
    private ArrayList<Lease> leaseList;

    private LeaseContainer() {leaseList = new ArrayList<>();}

    public ArrayList<Lease> getLeases() {
        return leaseList;
    }

    public static LeaseContainer getInstance() {
        if(instance == null) {
            instance = new LeaseContainer();
        }
        return instance;
    }

    public boolean addLease(Lease newLease) {
        boolean foundLease = false;

        if (leaseList.isEmpty()) {
            foundLease = false;
        }
        for (Lease _lease: leaseList) {
            if (_lease.getId()==(newLease.getId())) {
                foundLease = true;
            }
        }
        if (!foundLease) {
            leaseList.add(newLease);
        }
        return foundLease;
    }

    public Lease findLease(int id) {
        for (Lease _lease : leaseList) {
            if (_lease.getId()==(id)) {
                return _lease;
            }
        }
        return null;
    }

    public Lease updateLease(int id) {
        return findLease(id);
    }

    public boolean deleteLease(Lease lease) {
        boolean deletedLease = false;
        Lease leaseToDelete = null;
        for (Lease _lease: leaseList) {
            if (_lease.getId()==(lease.getId())) {
                leaseToDelete = _lease;
                deletedLease = true;
            }
        }
        if (deletedLease) {
            leaseList.remove(leaseToDelete);
        }
        return deletedLease;
    }
}
