public class Node {

    private static Blockchain blockchain;

    public Node(){}

    public static void main(String[] args) {
        blockchain = new Blockchain();
        blockchain.currentBlock().addTransaction("emile", "hans", 20, "emile");
        System.out.println(blockchain.printBlockchain());
    }
}
