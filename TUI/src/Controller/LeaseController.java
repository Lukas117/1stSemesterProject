package Controller;

import Model.LeaseContainer;
import Model.Lease;
import Model.Sale;
import Model.SaleContainer;

public class LeaseController {
    private LeaseContainer leaseContainer;

    public LeaseController() {
        leaseContainer = LeaseContainer.getInstance();
    }

    public LeaseContainer getLeaseContainer() {
        return leaseContainer;
    }

    public boolean createLease(Lease lease) {
        return leaseContainer.addLease(lease);
    }

    public Lease findLease(int ID) {
        return leaseContainer.findLease(ID);
    }

    public Lease updateLease(int ID) {
        return leaseContainer.updateLease(ID);
    }

    public boolean deleteLease(Lease lease) {
        return leaseContainer.deleteLease(lease);
    }
}
