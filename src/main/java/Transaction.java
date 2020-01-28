public class Transaction {

    public String sender;
    public String recipient;
    public long amount;

    public String signature;

    public Transaction(String sender, String recipient, long amount, String signature) {
        this.sender = sender;
        this.recipient = recipient;
        this.amount = amount;
        this.signature = signature;
    }

    public String printTransaction(){
        String tstring = new String();
        tstring = tstring + "Sender: " + sender + '\n' +
                            "Recipient: " + recipient + '\n' +
                            "Amount: " + amount + '\n' +
                            "Signature: " + signature + '\n';
        return tstring;
    }
}
