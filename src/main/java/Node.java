public class Node {

    private static Blockchain blockchain;

    public Node(){}

    public static void main(String[] args) {
        blockchain = new Blockchain();
        for(int i = 0;i < 12; i++){
            blockchain.currentBlock().addTransaction("emile", "hans", 20, "emile");
        }
        if(blockchain.currentBlock().isReady()){
            blockchain.currentBlock().mine();
        }
        System.out.println(blockchain.printBlockchain());
    }
}
