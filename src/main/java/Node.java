import java.security.*;

public class Node {

    private static Blockchain blockchain;

    public Node(){}

    public static void main(String[] args) throws NoSuchAlgorithmException {
        blockchain = new Blockchain();
        for(int i = 0;i < 12; i++){
            blockchain.currentBlock().addTransaction("emile", "hans", 20, "emile");
        }
        if(blockchain.currentBlock().isReady()){
            blockchain.currentBlock().mine();
        }
        System.out.println(blockchain.printBlockchain());


        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");

        keyPairGen.initialize(2048);
        KeyPair pair = keyPairGen.generateKeyPair();
        PrivateKey privKey = pair.getPrivate();
        PublicKey publicKey = pair.getPublic();
        System.out.println(privKey);
    }
}
