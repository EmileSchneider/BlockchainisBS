import java.util.ArrayList;
import java.util.Date;
import java.security.MessageDigest;

public class Block {

    private String previousHash;
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    public String hash;
    private long timestamp;
    private int nonce;

    public Block(String previousHash){
        this.previousHash = previousHash;
        timestamp =  new Date().getTime();
    }

    public void addTransaction(String sender, String recipient, long amount, String signature){
        transactions.add(new Transaction(sender,recipient,amount,signature));
    }

    public void mine(){
        String transString = "";
        for(Transaction transaction : transactions){
            transString = transString + transaction.toString();
        }
        String timeString = Long.toString(timestamp);
        nonce = 0;

        String s = previousHash + transString + timeString + nonce;
        while (Utils.hash(s).charAt(0) != '0'){
            nonce++;
            s =  previousHash + transString + timeString + nonce;
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
