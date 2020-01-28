import java.util.ArrayList;
import java.util.Date;
import java.security.MessageDigest;

public class Block {

    public String previousHash;
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    public String hash;
    private long timestamp;
    private int nonce =0 ;
    public boolean ready = false;

    public Block(String previousHash){
        this.previousHash = previousHash;
        timestamp =  new Date().getTime();
    }

    public void addTransaction(String sender, String recipient, long amount, String signature){
        if(transactions.size() > 10){
            ready = true;
        } else {
            transactions.add(new Transaction(sender,recipient,amount,signature));
        }
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public boolean isReady(){
        return ready;
    }
    public String hashstring() {
        String transString = "";
        for(Transaction transaction : transactions){
            transString = transString + transaction.toString();
        }
        String timeString = Long.toString(timestamp);
        return previousHash + transString + timeString + nonce;
    }
    public void mine(){
        String s = hashstring();
        while (Utils.hash(s).charAt(0) != '0'){
            nonce++;
             s = hashstring();
        }
        hash = Utils.hash(s);
    }

    public String getHash() {
        return hash;
    }

    public String printBlock(){
        String bstring = new String();
        bstring = "Previous Hash: " + previousHash + '\n' +
                " = Transactions = " + '\n';
        for(Transaction t : transactions){
            bstring = bstring + t.printTransaction() + '\n';
        }
        bstring = bstring + "Nonce: " + nonce + '\n';
        bstring = bstring + "Hash: " + hash + '\n';
        bstring = bstring + "Timestamp: " + timestamp;
        return bstring;
     }
}
